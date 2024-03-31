package com.zhurzh.linksredirect.service;

import com.zhurzh.linksredirect.model.ClickStatistic;
import com.zhurzh.linksredirect.model.UrlMapping;
import com.zhurzh.linksredirect.repo.ClickStatisticRepository;
import com.zhurzh.linksredirect.repo.UrlMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UrlService {
    @Autowired
    private UrlMappingRepository urlMappingRepository;
    @Autowired
    private ClickStatisticRepository clickStatisticRepository;

    public String getUrlAndCountClick(String identifier) {
        UrlMapping mapping = urlMappingRepository.findByIdentifier(identifier).orElseThrow();

        var opt = clickStatisticRepository.findByIdentifierAndDate(identifier, LocalDate.now());
        ClickStatistic statistic;
        if (opt.isEmpty()) {
            statistic = new ClickStatistic();
            statistic.setIdentifier(identifier);
            statistic.setDate(LocalDate.now());
            statistic.setClicks(1L);
        } else {
            statistic = opt.get();
            statistic.setClicks(statistic.getClicks() + 1);
        }
        clickStatisticRepository.save(statistic);
        return mapping.getUrl();
    }
}

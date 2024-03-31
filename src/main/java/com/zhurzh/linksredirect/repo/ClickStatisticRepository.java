package com.zhurzh.linksredirect.repo;

import com.zhurzh.linksredirect.model.ClickStatistic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface ClickStatisticRepository extends JpaRepository<ClickStatistic, Long> {
    Optional<ClickStatistic> findByIdentifierAndDate(String identifier, LocalDate date);
}
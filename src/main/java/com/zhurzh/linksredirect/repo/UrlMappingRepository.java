package com.zhurzh.linksredirect.repo;

import com.zhurzh.linksredirect.model.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlMappingRepository extends JpaRepository<UrlMapping, Long> {
    Optional<UrlMapping> findByIdentifier(String identifier);
}

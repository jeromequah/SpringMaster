package com.example.SpringMaster.Usage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsageRepository
        extends JpaRepository<Usage, Long> {
}
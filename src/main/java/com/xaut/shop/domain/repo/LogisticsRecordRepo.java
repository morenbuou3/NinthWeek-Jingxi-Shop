package com.xaut.shop.domain.repo;

import com.xaut.shop.domain.entity.LogisticsRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogisticsRecordRepo extends JpaRepository<LogisticsRecord, Integer> {
    LogisticsRecord findByOrder_id(int id);
}

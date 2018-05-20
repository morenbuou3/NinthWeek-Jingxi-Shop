package com.xaut.shop.service.serviceImpl;

import com.xaut.shop.domain.entity.LogisticsRecord;
import com.xaut.shop.domain.repo.LogisticsRecordRepo;
import com.xaut.shop.service.LogisticsRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogisticsRecordServiceImpl implements LogisticsRecordService {
    @Autowired
    private LogisticsRecordRepo logisticsRecordRepo;

    @Override
    public LogisticsRecord getLogisticRecordByOrderId(int id) {
        return logisticsRecordRepo.findByOrder_id(id);
    }
}

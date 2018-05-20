package com.xaut.shop.service;

import com.xaut.shop.domain.entity.LogisticsRecord;

public interface LogisticsRecordService {
    LogisticsRecord getLogisticRecordByOrderId(int id);
}

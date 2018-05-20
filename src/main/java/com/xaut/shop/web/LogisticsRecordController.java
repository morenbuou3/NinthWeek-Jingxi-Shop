package com.xaut.shop.web;

import com.xaut.shop.domain.entity.LogisticsRecord;
import com.xaut.shop.service.LogisticsRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/logisticsRecords")
public class LogisticsRecordController {
    @Autowired
    private LogisticsRecordService logisticsRecordService;

    @GetMapping(value = "/{id}")
    public LogisticsRecord getLogisticRecordByOrderId(@PathVariable int id) {
        return logisticsRecordService.getLogisticRecordByOrderId(id);
    }

}

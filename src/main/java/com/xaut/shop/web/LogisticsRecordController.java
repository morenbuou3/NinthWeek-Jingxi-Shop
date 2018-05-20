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

    @PutMapping(value = "/{id}/orders/{orderId}")
    public LogisticsRecord shippingLogistics(@PathVariable int id, @PathVariable int orderId,
                                             @RequestParam String logisticsStatus) {
        if ("shipping".equals(logisticsStatus)) return logisticsRecordService.shippingLogistics(id, orderId);
        else return logisticsRecordService.signedLogistics(id, orderId);
    }

}

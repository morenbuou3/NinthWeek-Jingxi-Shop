package com.xaut.shop.web;

import com.xaut.shop.domain.entity.LogisticsRecord;
import com.xaut.shop.service.LogisticsRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/logisticsRecords")
public class LogisticsRecordController {
    @Autowired
    private LogisticsRecordService logisticsRecordService;

    @GetMapping(value = "/{id}")
    public LogisticsRecord getLogisticRecordByOrderId(@PathVariable int id) {
        return logisticsRecordService.getLogisticRecordById(id);
    }

    @PutMapping(value = "/{id}/orders/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void shippingLogistics(@PathVariable int id, @PathVariable int orderId,
                                  @RequestParam String logisticsStatus, HttpServletResponse response) {
        if ("shipping".equals(logisticsStatus)) {
            logisticsRecordService.shippingLogistics(id, orderId);
        }
        if ("signed".equals(logisticsStatus)){
            logisticsRecordService.signedLogistics(id, orderId);
        }
        response.setHeader("location", "/logisticsRecords/" + id);
    }

}

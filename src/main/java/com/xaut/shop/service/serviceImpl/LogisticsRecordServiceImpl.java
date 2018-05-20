package com.xaut.shop.service.serviceImpl;

import com.xaut.shop.domain.entity.LogisticsRecord;
import com.xaut.shop.domain.entity.Order;
import com.xaut.shop.domain.repo.LogisticsRecordRepo;
import com.xaut.shop.service.LogisticsRecordService;
import com.xaut.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class LogisticsRecordServiceImpl implements LogisticsRecordService {
    @Autowired
    private LogisticsRecordRepo logisticsRecordRepo;
    @Autowired
    private OrderService orderService;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public LogisticsRecord getLogisticRecordByOrderId(int id) {
        return logisticsRecordRepo.findByOrder_id(id);
    }

    @Override
    public LogisticsRecord shippingLogistics(int id, int orderId) {
        LogisticsRecord logisticsRecord = logisticsRecordRepo.findByIdAndOrder_id(id, orderId);
        logisticsRecord.setLogisticsStatus("shipping");
        try {
            logisticsRecord.setOutboundTime(dateFormat.parse(dateFormat.format(new Date())));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return logisticsRecordRepo.save(logisticsRecord);
    }

    @Override
    public LogisticsRecord signedLogistics(int id, int orderId) {
        LogisticsRecord logisticsRecord = logisticsRecordRepo.findByIdAndOrder_id(id, orderId);
        logisticsRecord.setLogisticsStatus("signed");
        try {
            logisticsRecord.setSignedTime(dateFormat.parse(dateFormat.format(new Date())));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        orderService.finishOrder(orderId);
        return logisticsRecordRepo.save(logisticsRecord);
    }
}

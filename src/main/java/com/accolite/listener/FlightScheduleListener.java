package com.accolite.listener;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import com.accolite.dao.FlightScheduleMethod;
import com.accolite.pojo.FlightSchedule;

@Service
public class FlightScheduleListener {

    @Autowired
    FlightScheduleMethod scheduleService;
    public final CountDownLatch countDownLatch1 = new CountDownLatch(1);
    private static final Logger log = LoggerFactory.getLogger(FlightScheduleListener.class);

    @KafkaListener(topics = "risk-flight_schedule")
    public void flightScheduleListner(FlightSchedule schedule, @Header(KafkaHeaders.OFFSET) Integer offset,
	    @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
	    @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
	log.info("Processing topic = {}, partition = {}, offset = {}, workUnit = {}", topic, partition, offset,
		schedule);
	scheduleService.addSchedule(schedule);
	System.out.println(schedule.toString());
	countDownLatch1.countDown();
    }

}

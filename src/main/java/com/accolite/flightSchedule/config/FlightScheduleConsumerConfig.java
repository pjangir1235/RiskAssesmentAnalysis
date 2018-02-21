package com.accolite.flightSchedule.config;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.accolite.pojo.FlightSchedule;

@Configuration
@EnableKafka
public class FlightScheduleConsumerConfig {

    @Autowired
    private KafkaConsumerProperties kafkaConsumerProperties;

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, FlightSchedule> kafkaListenerContainerFactory() {
	ConcurrentKafkaListenerContainerFactory<String, FlightSchedule> factory = new ConcurrentKafkaListenerContainerFactory<>();
	factory.setConcurrency(10);
	factory.setConsumerFactory(consumerFactory());
	// factory.setBatchListener(true);
	// factory.getContainerProperties().setIdleEventInterval(60000L);
	// factory.getContainerProperties().setPollTimeout(3000);
	return factory;
    }
    // KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String,
    // String>> kafkaListenerContainerFactory() {
    // System.out.println("piyush");
    // ConcurrentKafkaListenerContainerFactory<String, String> factory = new
    // ConcurrentKafkaListenerContainerFactory<>();
    // factory.setConsumerFactory(consumerFactory());
    // factory.setConcurrency(3);
    // factory.getContainerProperties().setPollTimeout(3000);
    // return factory;
    // }

    @Bean
    public ConsumerFactory<String, FlightSchedule> consumerFactory() {

	return new DefaultKafkaConsumerFactory<>(consumerConfigs(), stringKeyDeserializer(),
		FlightScheduleJsonValueDeserializer());
    }

    @Bean
    public Map<String, Object> consumerConfigs() {

	Map<String, Object> propsMap = new HashMap<>();
	propsMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConsumerProperties.getBootstrap());
	propsMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
	propsMap.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
	propsMap.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
	propsMap.put(ConsumerConfig.GROUP_ID_CONFIG, UUID.randomUUID().toString());
	propsMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
	return propsMap;
    }

    @Bean
    public Deserializer stringKeyDeserializer() {
	return new StringDeserializer();
    }

    @Bean
    public Deserializer FlightScheduleJsonValueDeserializer() {
	return new JsonDeserializer(FlightSchedule.class);
    }

}

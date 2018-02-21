package com.accolite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.accolite.flightSchedule.config.KafkaConsumerProperties;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@EnableConfigurationProperties(KafkaConsumerProperties.class)
public class MainAnalysisApplication {

    public static void main(String[] args) throws Exception {
	SpringApplication.run(MainAnalysisApplication.class, args);

    }
}

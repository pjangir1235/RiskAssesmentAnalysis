package com.accolite.flightSchedule.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "kafka.consumer")
public class KafkaConsumerProperties {
    private String bootstrap;

    public KafkaConsumerProperties() {
	super();
    }

    public KafkaConsumerProperties(String bootStrap) {
	super();
	this.bootstrap = bootStrap;
    }

    public String getBootstrap() {
	return bootstrap;
    }

    public void setBootstrap(String bootstrap) {
	this.bootstrap = bootstrap;
    }
}

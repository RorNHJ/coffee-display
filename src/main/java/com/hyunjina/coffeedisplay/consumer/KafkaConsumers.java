package com.hyunjina.coffeedisplay.consumer;

import java.io.IOException;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;

import com.hyunjina.coffeedisplay.event.AbstractEvent;
import com.hyunjina.coffeedisplay.service.OrderedMenuService;

@Configuration
public class KafkaConsumers {
	private static final Logger logger = LoggerFactory.getLogger(KafkaConsumers.class);
	private final Jackson2JsonObjectMapper mapper = new Jackson2JsonObjectMapper();
	
	
	@Autowired
	private OrderedMenuService orderedMenuService;
	
	@Bean
	public Consumer createdOrder() {
		return o -> {
		    try {
		        AbstractEvent event = mapper.fromJson(o, AbstractEvent.class);;
				logger.debug("kafka event 수신: [createdOrder] " + o.toString());
				orderedMenuService.saveOrderedMenu(event);
			} catch (IOException e) {
				logger.error(e.toString());
			}
		};
	}
}

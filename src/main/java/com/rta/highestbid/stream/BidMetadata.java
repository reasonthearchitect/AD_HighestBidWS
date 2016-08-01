package com.rta.highestbid.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface BidMetadata {
	
		@Input("newbid")
    	SubscribableChannel read();
	 
}
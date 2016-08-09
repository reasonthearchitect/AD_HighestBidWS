package com.rta.highestbid.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;

import com.rta.highestbid.dto.Bid;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EnableBinding(BidMetadata.class)
public class BidSinkSocket {

    private static final Logger log = LoggerFactory.getLogger(BidSinkSocket.class);

    @Autowired
    SimpMessageSendingOperations messagingTemplate;

    @Autowired
    ObjectMapper mapper;


    @StreamListener("newbid")
    public void sink(Bid bid) {
        sendToClients(bid);
    }

    public void sendToClients(Bid bid) {
        try {
            String json = this.mapper.writeValueAsString(bid);
            messagingTemplate.convertAndSend("/topic/newbid", json);
        } catch (Exception ex) {
            log.error("Error marshalling the JSON", ex);
        }
    }
}

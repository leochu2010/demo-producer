package com.example.demo.kafka;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;

@Service
public class CargoProducerService {

    private static final Logger logger = LoggerFactory.getLogger(CargoProducerService.class);

    private String localhost;

    @PostConstruct
    public void postConstructRoutine() throws UnknownHostException {
        // initialize parameters
        localhost = InetAddress.getLocalHost().toString();
    }


    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${kafka.topic.cargo}")
    String cargoTopic;

    @Scheduled(fixedRateString = "${random.int(${cargo.producer.delay})}")
    public void randomlyProduceCargo() {
        Cargo cargo = new Cargo();
        cargo.setProducerAddress(localhost);
        logger.info("Produce [CARGO:{}]", cargo);

        try {
            SendResult<String, Object> sendResult = kafkaTemplate.send(cargoTopic, cargo).get();
            if (sendResult.getRecordMetadata() != null) {
                logger.info("Deliver to topic {}->{}", sendResult.getProducerRecord().topic(), sendResult.getProducerRecord().value().toString());
            }
            Thread.sleep(5000);
        } catch (InterruptedException | ExecutionException e) {
            logger.error("Failed to deliver cargo",e);
        }
    }

}

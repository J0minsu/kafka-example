package com.kafka_sample.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConsumerService {

    @KafkaListener(groupId = "group_a", topics = "topic1")
    public void consumeFromGroupA(String message) {
        log.info("Group A consumed message from topic1: " + message);
    }

    // 동일한 토픽 || 다른 그룹 ID
    @KafkaListener(groupId = "group_b", topics = "topic1")
    public void consumeFromGroupB(String message) {
        log.info("Group B consumed message from topic1: " + message);
    }

    // 다른 토픽 || 다른 그룹 ID
    @KafkaListener(groupId = "group_c", topics = "topic2")
    public void consumeFromTopicC(String message) {
        log.info("Group C consumed message from topic2: " + message);
    }

    // 다른 토픽 || 다른 그룹 ID
    @KafkaListener(groupId = "group_c", topics = "topic3")
    public void consumeFromTopicD(String message) {
        log.info("Group C consumed message from topic3: " + message);
    }

    @KafkaListener(groupId = "group_d", topics = "topic4")
    public void consumeFromPartition0(String message) {
        log.info("Group D consumed message from topic4: " + message);
    }
}
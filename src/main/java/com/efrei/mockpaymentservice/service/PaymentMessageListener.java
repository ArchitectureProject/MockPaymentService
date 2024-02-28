package com.efrei.mockpaymentservice.service;

import com.efrei.mockpaymentservice.model.PaymentResult;
import com.efrei.mockpaymentservice.model.ProcessedPayment;
import com.efrei.mockpaymentservice.model.ReceivedPaymentAttempt;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PaymentMessageListener {

    MessagePublisherService messagePublisherService;

    public PaymentMessageListener(MessagePublisherService messagePublisherService) {
        this.messagePublisherService = messagePublisherService;
    }

    @RabbitListener(queues = "${app.queue.name}")
    public void receiveMessage(ReceivedPaymentAttempt receivedPaymentAttempt) {
        System.out.println("Received message from paymentProcessingQueue: " + receivedPaymentAttempt);
        ProcessedPayment processedPayment = new ProcessedPayment();
        processedPayment.setPaymentId(receivedPaymentAttempt.getPaymentId());
        Random rand = new Random();
        int randomNum = rand.nextInt(5);
        if(randomNum == 4){
            processedPayment.setPaymentResult(PaymentResult.REFUSED);
        }
        else {
            processedPayment.setPaymentResult(PaymentResult.ACCEPTED);
        }

        messagePublisherService.sendMessage(processedPayment);
    }
}
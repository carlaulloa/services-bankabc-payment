package com.app.abc.payment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.abc.payment.kafka.producer.PaymentEventProducer;
import com.app.abc.payment.model.entity.Payment;
import com.app.abc.payment.service.IPaymentService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class PaymentEventsController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentEventsController.class);
	private @Autowired IPaymentService paymentService;
	private @Autowired PaymentEventProducer paymentEventProducer;
	
	@PostMapping("/v1/payments")
	public ResponseEntity<Payment> savePayment(@RequestBody Payment payment) throws JsonProcessingException{
		LOGGER.info("antes sendPaymentEvent");
		Payment paymentEvent = this.paymentService.save(payment);
		this.paymentEventProducer.sendPaymentEvent(paymentEvent);
		LOGGER.info("despues sendPaymentEvent");
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(paymentEvent);
	}
}

package com.app.abc.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.abc.payment.model.entity.Payment;
import com.app.abc.payment.model.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements IPaymentService {

	private @Autowired PaymentRepository paymentRepository;

	@Override
	@Transactional
	public Payment save(Payment payment) {
		return this.paymentRepository.save(payment);
	}
	
}

package com.app.abc.payment.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.abc.payment.model.entity.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}

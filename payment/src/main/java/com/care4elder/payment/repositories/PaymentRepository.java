package com.care4elder.payment.repositories;

import com.care4elder.payment.entities.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {
}

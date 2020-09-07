package com.spring.service.impl;

import com.spring.database.dao.interfaces.PaymentDao;
import com.spring.database.domain.Payment;
import com.spring.service.interfaces.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    private final PaymentDao paymentDao;

    public PaymentServiceImpl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public void save(Payment payment) {
        paymentDao.save(payment);
    }
}

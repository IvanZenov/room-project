package com.spring.database.dao.impl;

import com.spring.database.dao.common.BaseDaoImpl;
import com.spring.database.dao.interfaces.PaymentDao;
import com.spring.database.domain.Payment;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentDaoImpl extends BaseDaoImpl<Payment> implements PaymentDao {
}

package com.spring.database.dao.impl;

import com.spring.database.dao.common.BaseDaoImpl;
import com.spring.database.dao.interfaces.PaymentDao;
import com.spring.database.domain.Payment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PaymentDaoImpl extends BaseDaoImpl<Payment> implements PaymentDao {
}

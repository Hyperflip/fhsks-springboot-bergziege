package com.fhtw.bergziege.payment

import org.springframework.data.repository.CrudRepository

interface PaymentRepository : CrudRepository<Payment, Long> {
}
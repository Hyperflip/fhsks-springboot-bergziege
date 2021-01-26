package com.fhtw.bergziege.payment

import com.fhtw.bergziege.author.Author
import com.fhtw.bergziege.author.AuthorRepository
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class PaymentService(
    val paymentRepository: PaymentRepository,
    val authorRepository: AuthorRepository
) {

    @KafkaListener(topics = ["payment"], groupId = "group_id")
    fun consumeMessage(authorId: Long) {
        println("pushing payment for author with id: $authorId")

        processPayment(authorId)
    }

    fun processPayment(authorId: Long) {

        var amount: Float = getPaymentAmount()
        val author: Author? = authorRepository.findById(authorId).get()

        val payment: Payment = Payment(
            amount,
            author
        )

        paymentRepository.save(payment)
    }

    fun getPaymentAmount(): Float {
        // current strategy: pay 1 cent per click on article
        return 0.01f
    }

}
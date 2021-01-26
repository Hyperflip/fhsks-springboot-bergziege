package com.fhtw.bergziege.payment

import com.fhtw.bergziege.author.Author
import com.fhtw.bergziege.landmark.Landmark
import javax.persistence.*

@Entity
data class Payment(

    val amount: Float,

    @ManyToOne
    @JoinColumn(name="author_id")
    val author: Author? = null,

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="payment_id")
    val id: Long? = null

) {
}
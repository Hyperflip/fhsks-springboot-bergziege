package com.fhtw.bergziege.article

import com.fhtw.bergziege.author.Author
import com.fhtw.bergziege.landmark.Landmark
import javax.persistence.*

@Entity
data class Article(
    val title: String,
    val content: String,

    @ManyToOne
    @JoinColumn(name="landmark_id")
    val landmark: Landmark? = null,

    @ManyToOne
    @JoinColumn(name="author_id")
    val author: Author? = null,

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="article_id")
    val id: Long? = null
)
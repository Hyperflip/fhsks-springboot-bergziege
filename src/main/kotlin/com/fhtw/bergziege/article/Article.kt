package com.fhtw.bergziege.article

import com.fhtw.bergziege.author.Author
import javax.persistence.*

@Entity
data class Article(
    private var title: String,
    private var content: String,

    @ManyToOne
    @JoinColumn(name="author_id")
    private var author: Author? = null,

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="article_id")
    private var id: Long? = null
)

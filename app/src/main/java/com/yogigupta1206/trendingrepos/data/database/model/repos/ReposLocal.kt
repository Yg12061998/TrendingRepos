package com.yogigupta1206.trendingrepos.data.database.model.repos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Repos(
    val author: String?,
    @PrimaryKey
    val name: String,
    val avatar: String?,
    val url: String?,
    val description: String?,
    val language: String?,
    val languageColor: String?,
    val stars: Int?,
    val forks: Int?,
    val currentPeriodStar: Int?,
    val builtBy: ArrayList<BuiltBy?>?
)

data class BuiltBy(
    val href: String?,
    val avatar: String?,
    val username: String?
)

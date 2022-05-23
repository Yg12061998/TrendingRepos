package com.yogigupta1206.trendingrepos.data.network.model.repos

import androidx.room.PrimaryKey
import com.yogigupta1206.trendingrepos.data.database.model.repos.BuiltBy

data class Repos(
    val author: String?,
    val name: String?,
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

package com.example.restapilab3.network

data class HeroStats(
    val `1_pick`: Int,
    val `1_win`: Int,
    val `2_pick`: Int,
    val `2_win`: Int,
    val `3_pick`: Int,
    val `3_win`: Int,
    val `4_pick`: Int,
    val `4_win`: Int,
    val `5_pick`: Int,
    val `5_win`: Int,
    val `6_pick`: Int,
    val `6_win`: Int,
    val `7_pick`: Int,
    val `7_win`: Int,
    val hero_id: Int,
    val icon: String,
    val id: Int,
    val img: String,
    val localized_name: String,
    val name: String,
    val pro_ban: Int,
    val pro_pick: Int,
    val pro_win: Int
)
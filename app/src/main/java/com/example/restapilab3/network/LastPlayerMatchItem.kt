package com.example.restapilab3.network

data class LastPlayerMatchItem(
    val assists: Int,
    val cluster: Int,
    val deaths: Int,
    val duration: Int,
    val game_mode: Int,
    val hero_id: Int,
    val is_roaming: Boolean,
    val kills: Int,
    val lane: Int,
    val lane_role: Int,
    val leaver_status: Int,
    val lobby_type: Int,
    val match_id: Int,
    val party_size: Int,
    val player_slot: Int,
    val radiant_win: Boolean,
    val skill: Int,
    val start_time: Int,
    val version: Int
) {
    override fun toString(): String {
        return "LastPlayerMatchItem(assists=$assists, cluster=$cluster, deaths=$deaths, duration=$duration, game_mode=$game_mode, hero_id=$hero_id, is_roaming=$is_roaming, kills=$kills, lane=$lane, lane_role=$lane_role, leaver_status=$leaver_status, lobby_type=$lobby_type, match_id=$match_id, party_size=$party_size, player_slot=$player_slot, radiant_win=$radiant_win, skill=$skill, start_time=$start_time, version=$version)"
    }
}
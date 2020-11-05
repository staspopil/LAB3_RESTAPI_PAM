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
    val pro_win: Int,
    //Chatacteristics
    val base_health: Int,
    val primary_attr:String,
    val attack_type:String,
    val base_health_regen:String,
    val base_mana :String,
    val base_mana_regen: String,
    val base_armor:String,
    val base_attack_min:String,
    val base_str :String,
    val base_agi :String,
    val base_int:String,
    val str_gain:String,
    val agi_gain:String,
    val int_gain:String,
    val attack_range:String,
    val move_speed:String
) {
    override fun toString(): String {
        return  "name=$localized_name" +
                "\nprimary_attr=$primary_attr, attack_type=$attack_type" +
                "\nbase_health=$base_health+$base_health_regen " +
                "\nbase_mana=$base_mana+$base_mana_regen," +
                "\nbase_armor=$base_armor, base_attack_min=$base_attack_min," +
                "\nbase_str=$base_str+$str_gain" +
                "\nbase_agi=$base_agi+$agi_gain" +
                "\nbase_int=$base_int+$int_gain" +
                "\nattack_range=$attack_range, move_speed=$move_speed"
    }
}
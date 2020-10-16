package com.example.restapilab3.network

data class Hero (
    val id :Int? = null,
    val name:String? = null,
    val localized_name:String? = null,
    val primary_attr:String? = null,
    val attack_type :String? = null,
    val roles : List<String>

)
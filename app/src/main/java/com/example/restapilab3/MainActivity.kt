package com.example.restapilab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.net.toUri
import com.example.restapilab3.network.DotaApi
import com.example.restapilab3.network.Hero
import com.example.restapilab3.network.HeroStats
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




fun getHeroes(){
       DotaApi.retrofitService.getHeroes().enqueue(object: Callback<List<Hero>> {
           override fun onFailure(call: Call<List<Hero>>, t: Throwable) {
            Toast.makeText(applicationContext,"Failed",Toast.LENGTH_SHORT).show()
           }

           override fun onResponse(call: Call<List<Hero>>, response: Response<List<Hero>>) {
              val l = response.body()
               //textView.text=l!![1].localized_name
           }

       })}

        fun getHeroesStats(){
            DotaApi.retrofitService.getHeroesStats().enqueue(object: Callback<List<HeroStats>> {
                override fun onFailure(call: Call<List<HeroStats>>, t: Throwable) {
                    Toast.makeText(applicationContext,"Failed",Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<List<HeroStats>>, response: Response<List<HeroStats>>) {
                    val l = response.body()
                  textView.text = l!![1].icon
                }

            })}

//getHeroes()
getHeroesStats()
    }
}
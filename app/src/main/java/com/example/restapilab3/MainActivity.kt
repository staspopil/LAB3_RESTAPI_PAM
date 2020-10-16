package com.example.restapilab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.restapilab3.network.DotaApi
import com.example.restapilab3.network.Hero
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



       DotaApi.retrofitService.getHeroes().enqueue(object: Callback<List<Hero>> {
           override fun onFailure(call: Call<List<Hero>>, t: Throwable) {
            Toast.makeText(applicationContext,"Failed",Toast.LENGTH_SHORT).show()
           }

           override fun onResponse(call: Call<List<Hero>>, response: Response<List<Hero>>) {
              val l = response.body()
               Toast.makeText(applicationContext, l!![2].name,Toast.LENGTH_SHORT).show()
           }

       })


    }
}
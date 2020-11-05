package com.example.restapilab3

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.restapilab3.network.*
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {



    private lateinit var heroImageUrl:String
    private lateinit var image1: ImageView
    private lateinit var herolist: List<HeroStats>
    private lateinit var playerId:EditText
    private lateinit var button: Button
    private lateinit var textView: TextView
    private var HeroId: Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        image1 = findViewById(R.id.HeroIcon)
        playerId = findViewById(R.id.PlayerId)
        button = findViewById(R.id.find_button)
        textView = findViewById(R.id.GameDescription)
        button.setOnClickListener {
            lifecycleScope.launch {
                getHeroesStats(playerId.text.toString())
            }
        }

    }




    fun getHeroesStats(name:String) {
        DotaApi.retrofitService.getHeroesStats().enqueue(object: Callback<List<HeroStats>> {
            override fun onFailure(call: Call<List<HeroStats>>, t: Throwable) {
                Toast.makeText(applicationContext,"Failed",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<HeroStats>>, response: Response<List<HeroStats>>) {
                val l = response.body()
                herolist = response.body()!!
                val id = getIdFromLocalizedName(name)
                val img = getHeroIconFromId(id+1)
                getImage(img,this@MainActivity)
                textView.text = herolist[id].toString()
            }
        })
    }

   suspend fun getMatchesOfPlayer(id:Long){
        DotaApi.retrofitService.getRecentMatches(id).enqueue(object:Callback<LastPlayerMatch>{
            override fun onFailure(call: Call<LastPlayerMatch>, t: Throwable) {
            }

            override fun onResponse(call: Call<LastPlayerMatch>, response: Response<LastPlayerMatch>) {
              val list = response.body()
                val gameDescription= list!![1].toString()
                textView.text = gameDescription
               // val heroImage :String =getHeroIconFromId(list!![1].hero_id)
                //Toast.makeText(applicationContext,herolist[1].name,Toast.LENGTH_LONG)
               // getImage(heroImage,this@MainActivity)
            }})}

    fun getImage(a: String, context:Context){
        val mContext = context
            Glide.with(mContext).load(a).into(image1)
        }

    fun getHeroIconFromId(id:Int):String{
        for(i:HeroStats in herolist){
        if (i.hero_id == id) {
             heroImageUrl = "https://api.opendota.com"+i.img
            break
        }}
       return heroImageUrl
}

    fun getIdFromLocalizedName(name:String):Int{
        for(i:HeroStats in herolist){
            if (i.localized_name == name) {
                HeroId = i.hero_id
                break
            }}
        return HeroId-1
    }

}
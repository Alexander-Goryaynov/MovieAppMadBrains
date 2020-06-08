package com.example.movieapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_list.*
import org.json.JSONArray

class ListActivity : AppCompatActivity() {

    private val url = "https://raw.githubusercontent.com/gumam/android_course/master/db.json"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        title = "Список"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val queue = Volley.newRequestQueue(this)
        initRealm()
        getCatsFromServer(queue)
        showListFromDatabase()
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
    private fun initRealm(){
        Realm.init(this)
        val config = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config)
    }
    private fun saveIntoDatabase(cats: List<Cat>){
        val realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        realm.copyToRealm(cats)
        realm.commitTransaction()
    }
    private fun loadFromDatabase(): List<Cat>{
        val realm = Realm.getDefaultInstance()
        return realm.where(Cat::class.java).findAll()
    }
    private fun showListFromDatabase(){
        val cats = loadFromDatabase()
        setList(cats)
    }
    fun getCatsFromServer(queue: RequestQueue){
        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            Response.Listener { response ->
                val catsList = parseResponse(response)
                saveIntoDatabase(catsList)
                showListFromDatabase()
            },
            Response.ErrorListener {
                Toast.makeText(this, "Ошибка запроса",
                    Toast.LENGTH_SHORT).show()
            }
        )
        queue.add(stringRequest)
    }
    private fun parseResponse(responseText: String) : List<Cat>{
        val catList: MutableList<Cat> = mutableListOf()
        val jsonArray = JSONArray(responseText)
        for (index in 0 until jsonArray.length()){
            val jsonObject = jsonArray.getJSONObject(index)
            val catText = jsonObject.getString("text")
            val catImage = jsonObject.getString("image")
            val cat = Cat()
            cat.text = catText
            cat.image = catImage
            catList.add(cat)
        }
        return catList
    }
    private fun setList(cats: List<Cat>){
        recyclerId.adapter = CatAdapter(cats)
        recyclerId.layoutManager = LinearLayoutManager(this)
    }
}

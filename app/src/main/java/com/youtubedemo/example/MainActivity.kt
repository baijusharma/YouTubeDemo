package com.youtubedemo.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView_main.layoutManager = LinearLayoutManager(this)

        fetchJson()
    }

    private fun fetchJson() {

        val body = resources.openRawResource(R.raw.youtube)
            .bufferedReader().use { it.readText() }

        val gson = GsonBuilder().create()
        val homeFeed = gson.fromJson(body, HomeFeed::class.java)
        recyclerView_main.adapter = MainAdapter(homeFeed)
    }
}

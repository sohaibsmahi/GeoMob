package com.example.geomob

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_wikipedia.*

class WikipediaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wikipedia)

        val url = "https://fr.wikipedia.org/wiki/"+ intent.getStringExtra("search")
        web_view.loadUrl(url)
    }
}

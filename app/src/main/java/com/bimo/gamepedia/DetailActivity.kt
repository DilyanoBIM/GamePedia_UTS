package com.bimo.gamepedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val komik = intent.getParcelableExtra<Game>(HomeFragment.INTENT_PARCELABLE)

        val image = findViewById<ImageView>(R.id.ivImage)
        val name = findViewById<TextView>(R.id.tvName)
        val desc = findViewById<TextView>(R.id.tvDesc)


        image.setImageResource(komik?.imgGame!!)
        name.text = komik.nameGame
        desc.text = komik.descGame
        }
}
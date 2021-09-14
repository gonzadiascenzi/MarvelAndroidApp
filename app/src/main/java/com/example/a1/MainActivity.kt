package com.example.a1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a1.Utils.constansts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        constansts.APIKEY
    }
}
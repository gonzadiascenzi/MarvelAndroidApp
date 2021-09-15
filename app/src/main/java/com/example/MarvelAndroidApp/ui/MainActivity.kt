package com.example.MarvelAndroidApp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.MarvelAndroidApp.R
import com.example.MarvelAndroidApp.adapters.CharactersAdapter
import com.example.MarvelAndroidApp.api.APIService
import com.example.MarvelAndroidApp.databinding.ActivityMainBinding
import com.example.MarvelAndroidApp.models.characters.characters
import com.example.MarvelAndroidApp.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ejecutarAPI()

    }

    private fun ejecutarAPI() {
        binding.progressBar.visibility = View.VISIBLE
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        APIService.instance.getData(Constants.ts, Constants.APIKEY, Constants.hash)
            .enqueue(object : Callback<characters> {
                override fun onFailure(call: Call<characters>, t: Throwable) {
                    binding.progressBar.visibility = View.GONE
                }

                override fun onResponse(call: Call<characters>, response: Response<characters>) {

                    binding.recyclerView.adapter =
                        CharactersAdapter(response.body()!!.data.results, this@MainActivity)
                    binding.progressBar.visibility = View.GONE
                }

            })
    }
}
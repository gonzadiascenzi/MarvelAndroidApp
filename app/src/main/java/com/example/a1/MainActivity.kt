
package com.example.a1

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a1.utils.constansts
import com.example.a1.adapters.CharactersAdapter
import com.example.a1.api.APIService
import com.example.a1.databinding.ActivityMainBinding
import com.example.a1.models.characters
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
  


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ejecutarAPI()


    }

    private fun ejecutarAPI() {
        binding.progressBar.visibility = View.VISIBLE
        binding.recyclerView.layoutManager = LinearLayoutManager(this)


        binding.progressBar.visibility = View.VISIBLE
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        APIService.instance.getCharacter(constansts.ts, constansts.APIKEY, constansts.hash)
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




package com.example.disasterapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.disasterapp.databinding.ActivityMainBinding
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapterDisaster = DisasterAdapter(generateDummy()) { disaster ->

            Toast.makeText(
                this@MainActivity,
                "You clicked on ${disaster.nameDisaster}",
                Toast.LENGTH_SHORT
            ).show()

        }

        with(binding) {
            rvDisaster.apply {
                adapter = adapterDisaster
                layoutManager = GridLayoutManager(this@MainActivity, 2)
            }
        }
    }

    private fun generateDummy(): List<Disaster> {
        return listOf(
            Disaster(
                nameDisaster = "Tsunami",
                disasterType = "Natural",
                disasterImage = R.drawable.tsunami
            ),
            Disaster(
                nameDisaster = "Volcanic Eruption",
                disasterType = "Natural",
                disasterImage = R.drawable.volcano
            ),
            Disaster(
                nameDisaster = "Earthquake",
                disasterType = "Natural",
                disasterImage = R.drawable.earthquake
            ),
            Disaster(
                nameDisaster = "Flood",
                disasterType = "Natural",
                disasterImage = R.drawable.flood
            ),
            Disaster(
                nameDisaster = "Fire",
                disasterType = "Natural",
                disasterImage = R.drawable.fire
            ),
            Disaster(
                nameDisaster = "Nuclear Accident",
                disasterType = "Man-made",
                disasterImage = R.drawable.nuclear
            ),
            Disaster(
                nameDisaster = "Terrorist Attack",
                disasterType = "Man-made",
                disasterImage = R.drawable.terrorist
            ),
            Disaster(
                nameDisaster = "War",
                disasterType = "Man-made",
                disasterImage = R.drawable.war
            )
        )
    }
}
package com.example.besafe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.besafe.databinding.ActivityAddrBinding
import com.example.besafe.databinding.ActivityMainBinding
import net.daum.mf.map.api.MapView
import android.R


class addrActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddrBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.besafe.R.layout.activity_addr)

        /*val binding = ActivityAddrBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val mapView = MapView(this)
        binding.kakaomap.addView(mapView)*/

        val mapView = MapView(this)

        val mapViewContainer = findViewById<View>(com.example.besafe.R.id.map_view) as ViewGroup
        mapViewContainer.addView(mapView)




    }
}
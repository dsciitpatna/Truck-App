package com.example.truck_app.Home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.truck_app.Home.contract.IHomePresenter
import com.example.truck_app.Home.contract.IHomeView
import com.example.truck_app.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class HomeActivity : AppCompatActivity(), IHomeView, OnMapReadyCallback {


    private lateinit var homePresenter: IHomePresenter
    private lateinit var map: GoogleMap
    private lateinit var mapFragment: SupportMapFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        homePresenter = HomePresenter(this)
        homePresenter.onAttach(this)

       // val mapReadyCallback = MapReadyCallback()

        //mapFragment = supportFragmentManager.findFragmentById(R.id.show_map) as SupportMapFragment
        //mapFragment.getMapAsync(mapReadyCallback)

       val  mapFragment=(supportFragmentManager.findFragmentById(R.id.show_map) as SupportMapFragment?)?.let {
            it.getMapAsync(this)
        }
    }

//    internal inner class MapReadyCallback: OnMapReadyCallback{
//        override fun onMapReady(googleMap: GoogleMap?) {
//            map = googleMap as GoogleMap
//
//            // Add a marker in Sydney and move the camera
//            val sydney = LatLng(-34.0, 151.0)
//            map.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
//            map.moveCamera(CameraUpdateFactory.newLatLng(sydney))
//        }
//
//    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        val sydney = LatLng(-34.0, 151.0)
        map.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        map.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

}

package com.example.truck_app.Home.contract

import android.location.Address
import com.google.android.gms.maps.GoogleMap

interface IHomeView {

    fun setUp()

    fun getLocation()

    fun setMapLocation(map : GoogleMap)

    fun setPickUpLocation(place: String?)
}
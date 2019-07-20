package com.example.truck_app.Home.contract

import com.google.android.gms.maps.GoogleMap

interface IHomePresenter {

    fun onAttach(homeView: IHomeView)

    fun getPlaceName(lat: Double, lng: Double): String?
}
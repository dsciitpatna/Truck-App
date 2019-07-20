package com.example.truck_app.Home

import android.content.Context
import android.location.Address
import com.example.truck_app.Home.contract.IHomePresenter
import com.example.truck_app.Home.contract.IHomeView
import android.location.Geocoder
import java.io.IOException
import java.util.*


class HomePresenter(val context: Context) : IHomePresenter {
    private lateinit var homeView: IHomeView

    override fun onAttach(homeView: IHomeView) {
        this.homeView = homeView
    }

    override fun getPlaceName(lat: Double, lng: Double): String? {
        val geocoder = Geocoder(context, Locale.getDefault())
        var result: String? = null
        try {
            val addressList: List<Address> = geocoder.getFromLocation(lat, lng, 1);
            if (addressList != null && addressList.size > 0) {
                val address = addressList.get(0)
                if (address.premises != null) {
                    result += address.premises + ", "
                }
                result = address.subLocality + ", " + address.locality
                return result
            }
        } catch (e: IOException) {
            e.printStackTrace();
        }
        return result
    }
}
package com.example.truck_app.Home

import android.content.Context
import com.example.truck_app.Home.contract.IHomePresenter
import com.example.truck_app.Home.contract.IHomeView

class HomePresenter(context: Context): IHomePresenter {
    private lateinit var homeView: IHomeView

    override fun onAttach(homeView: IHomeView) {
        this.homeView = homeView
    }
}
package com.example.truck_app.Home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.truck_app.Home.contract.IHomePresenter
import com.example.truck_app.Home.contract.IHomeView
import com.example.truck_app.R

class HomeActivity : AppCompatActivity(), IHomeView {
    private lateinit var homePresenter: IHomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        homePresenter = HomePresenter(this)
        homePresenter.onAttach(this)

    }

}

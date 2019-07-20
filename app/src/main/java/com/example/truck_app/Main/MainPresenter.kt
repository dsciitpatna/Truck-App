package com.example.truck_app.Main

import android.content.Context
import com.example.truck_app.Main.contract.IMainPresenter
import com.example.truck_app.Main.contract.IMainView

class MainPresenter(context: Context):IMainPresenter  {
    private lateinit var mainView: IMainView

    override fun onAttach(mainView: IMainView) {
        this.mainView = mainView
    }
}
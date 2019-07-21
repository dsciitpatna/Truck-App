package com.example.truck_app.LoginSignup

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.truck_app.Main.MainActivity

import com.example.truck_app.R

class LoginFragment : Fragment() {

    lateinit var openSignupTextview: TextView
    lateinit var loginButton: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_login, container, false)
        openSignupTextview = rootView.findViewById(R.id.open_signup_from_login)
        loginButton = rootView.findViewById(R.id.login_button)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        openSignupTextview.setOnClickListener {
            val transaction = fragmentManager!!.beginTransaction()
            transaction.replace(R.id.fragment_container_login_signup, SignupFragment())
            transaction.commit()
        }
        loginButton.setOnClickListener {
            startActivity(Intent(context, MainActivity::class.java))
        }
    }
}

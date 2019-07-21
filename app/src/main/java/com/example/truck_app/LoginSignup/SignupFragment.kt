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

class SignupFragment : Fragment() {

    lateinit var openLoginTextview: TextView
    lateinit var signupButton: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_signup, container, false)
        openLoginTextview = rootView.findViewById(R.id.open_login_from_signup)
        signupButton = rootView.findViewById(R.id.signup_button)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        openLoginTextview.setOnClickListener {

            val transaction = fragmentManager!!.beginTransaction()
            transaction.replace(R.id.fragment_container_login_signup, LoginFragment())
            transaction.commit()
        }

        signupButton.setOnClickListener {
            startActivity(Intent(context, MainActivity::class.java))
        }
    }
}

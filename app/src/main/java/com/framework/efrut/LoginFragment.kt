package com.framework.efrut

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.content.res.AppCompatResources

class LoginFragment : Fragment() {
    private lateinit var username: EditText
    private lateinit var password: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        username = view.findViewById(R.id.login_username)
        password = view.findViewById(R.id.login_password)

        view.findViewById<Button>(R.id.btn_login).setOnClickListener {
            validateForm()
        }

        return view
    }

    private fun validateForm(){
        val icon = AppCompatResources.getDrawable(requireContext(), R.drawable.ic_warning)

        icon?.setBounds(0,0,icon.intrinsicWidth,icon.intrinsicHeight)
        when{
            TextUtils.isEmpty(username.text.toString().trim())->{
                username.setError("Por favor insira um usuário", icon)
            }
            TextUtils.isEmpty(password.text.toString().trim())->{
                username.setError("Por favor insira uma senha", icon)
            }

            username.text.toString().isNotEmpty() &&
                    password.text.toString().isNotEmpty()->
            {
                if (username.text.toString() == "adminframework") {
                    if(password.text.toString() == "admin123"){

                    } else {
                        password.setError("Senha incorreta, tente novamente", icon)
                    }
                } else {
                    username.setError("Usuário incorreto, tente novamente", icon)
                }
            }
        }

    }

}
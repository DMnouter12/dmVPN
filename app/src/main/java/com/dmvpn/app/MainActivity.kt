package com.dmvpn.app

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

    private lateinit var statusText: TextView
    private var connected = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(32, 32, 32, 32)
            setBackgroundColor(Color.rgb(12, 18, 35))
        }

        val title = TextView(this).apply {
            text = "dmVPN"
            textSize = 38f
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
        }

        statusText = TextView(this).apply {
            text = "Не подключено"
            textSize = 20f
            setTextColor(Color.LTGRAY)
            gravity = Gravity.CENTER
        }

        val connectButton = Button(this).apply {
            text = "ПОДКЛЮЧИТЬСЯ"
            textSize = 18f
            setOnClickListener {
                connected = !connected
                statusText.text = if (connected) {
                    "Демо-режим: VPN не подключён"
                } else {
                    "Не подключено"
                }
                text = if (connected) "ОТКЛЮЧИТЬСЯ" else "ПОДКЛЮЧИТЬСЯ"
            }
        }

        val info = TextView(this).apply {
            text = "Бесплатный VPN\nWireGuard • dmVPN"
            textSize = 15f
            setTextColor(Color.LTGRAY)
            gravity = Gravity.CENTER
        }

        layout.addView(title)
        layout.addView(statusText)
        layout.addView(connectButton)
        layout.addView(info)

        setContentView(layout)
    }
}
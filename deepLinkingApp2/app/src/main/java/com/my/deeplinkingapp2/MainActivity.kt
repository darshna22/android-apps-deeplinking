package com.my.deeplinkingapp2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSharedDataOfApp1()
    }

    private fun getSharedDataOfApp1() {
        // Deep Linking - IN-COMING
        // Get intent, action and MIME type
        val intent = intent
        val action = intent.action
        val type = intent.type

        // check if activity opened from deep linking call
        if (action == Constants.DEEP_LINKING_DESTINATION_ACTION && type != null && type == Constants.DEEP_LINKING_DATA_TYPE) {

            // receive parameters
            val parameter1 = intent.getStringExtra(Constants.PARAMETER1_NAME)
            val parameter2 = intent.getStringExtra(Constants.PARAMETER2_NAME)

            // use parameters
            text1.text = parameter1
            text2.text = parameter2
        }
    }
}
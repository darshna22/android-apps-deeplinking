package com.my.deeplinkingapp1

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Build.VERSION_CODES.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.my.deeplinkingapp1.helper.Constants
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigate_btn.setOnClickListener {
            openApplication2PassingValues()
        }

    }

    private fun openApplication2PassingValues() {

        // -------------------------------------------------
        // Deep Linking - OUT-COMING
        // open/start other Activity/App
        val action: String = Constants.DEEP_LINKING_DESTINATION_ACTION
        val sendIntent = Intent(action)

        // set flags
        sendIntent.flags =
            Intent.FLAG_ACTIVITY_NEW_TASK or  // make another app open in external new task (not embedded internal)
                    Intent.FLAG_ACTIVITY_CLEAR_TASK

        // set data map (key / value) of parameters
        sendIntent.putExtra(PARAMETER1_NAME, "darshna")
        sendIntent.putExtra(PARAMETER2_NAME, "kumari")

        // set type of data
        sendIntent.type = Constants.DEEP_LINKING_DATA_TYPE

        // try to open/start other Activity/App
        try {
            startActivity(sendIntent)
        } catch (e: Exception) {
            // DESTINATION Application: NOT installed
            // DESTINATION Application: can NOT handle passed parameter
            // show corresponding info msg into AlertDialog
            val msg = "open app two"
            val builder1: AlertDialog.Builder = AlertDialog.Builder(this)
            builder1.setMessage(msg)
            builder1.setCancelable(true)
            builder1.setPositiveButton(
                "ok",
                DialogInterface.OnClickListener { dialog, id -> dialog.cancel() })
            val alert11: AlertDialog = builder1.create()
            alert11.show()

        }

    }

    companion object{
        const val PARAMETER1_NAME="PARAMETER_1"
        const val PARAMETER2_NAME="PARAMETER_2"

    }

}
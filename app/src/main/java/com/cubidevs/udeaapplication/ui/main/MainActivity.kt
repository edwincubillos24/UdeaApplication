package com.cubidevs.udeaapplication.ui.main

import android.app.Activity
import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.cubidevs.udeaapplication.R
import com.cubidevs.udeaapplication.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private var bornDate = ""
    private val calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        Log.d("Método:","onCreate()")

        val dateSetListener = DatePickerDialog.OnDateSetListener{ _, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val format = "dd/MM/yyyy"
            val sdf = SimpleDateFormat(format)
            bornDate = sdf.format(calendar.time).toString()
            mainBinding.bornDateButton.text = bornDate
        }

        with(mainBinding) {

            bornDateButton.setOnClickListener {
                DatePickerDialog(
                    this@MainActivity,
                    dateSetListener,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                ).show()
            }

            registerButton.setOnClickListener {
                if (nameEditText.text.toString().isEmpty())
                    Toast.makeText(this@MainActivity,getString(R.string.msg_name),Toast.LENGTH_SHORT).show()

                val name = nameEditText.text.toString()
                val lastName = lastNameEditText.text.toString()
                val email = emailEditText.text.toString()
                val genre = if (femaleRadioButton.isChecked) getString(R.string.female)
                else getString(R.string.male)

                var hobbies = ""
                if (cookCheckBox.isChecked) hobbies += getString(R.string.cook) + " "
                if (gymCheckBox.isChecked) hobbies += getString(R.string.gym) + " "
                if (readCheckBox.isChecked) hobbies += getString(R.string.read) + " "

                val bornCity = bornCitySpinner.selectedItem.toString()

                infoTextView.text = getString(R.string.info, name, lastName, email, genre, hobbies, bornCity, bornDate) + getString(R.string.info, name, lastName, email, genre, hobbies, bornCity, bornDate) + getString(R.string.info, name, lastName, email, genre, hobbies, bornCity, bornDate)
            }
        }
    }

    override fun onStart() {
        Log.d("Método:","onStart()")
        super.onStart()
    }

    override fun onResume() {
        Log.d("Método:","onResume()")
        super.onResume()
    }

    override fun onPause() {
        Log.d("Método:","onPause()")
        super.onPause()
    }

    override fun onStop() {
        Log.d("Método:","oStop()")
        super.onStop()
    }

    override fun onRestart() {
        Log.d("Método:","onRestart()")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d("Método:","onDestroy()")
        super.onDestroy()
    }

}
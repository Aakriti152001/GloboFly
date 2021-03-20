package com.aakriti.globofly.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.aakriti.globofly.R
import com.aakriti.globofly.helpers.SampleData
import com.aakriti.globofly.models.Destination

class DestinationCreateActivity : AppCompatActivity() {
	val btn_add=findViewById<Button>(R.id.btn_add)
	val toolbar=findViewById<Toolbar>(R.id.toolbar)
	val et_city=findViewById<EditText>(R.id.et_city)
	val et_description=findViewById<EditText>(R.id.et_description)
	val et_country=findViewById<EditText>(R.id.et_country)
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_destiny_create)

		setSupportActionBar(toolbar)
		// Show the Up button in the action bar.
		supportActionBar?.setDisplayHomeAsUpEnabled(true)

		btn_add.setOnClickListener {
			val newDestination = Destination()
			newDestination.city = et_city.text.toString()
			newDestination.description = et_description.text.toString()
			newDestination.country = et_country.text.toString()

			// To be replaced by retrofit code
			SampleData.addDestination(newDestination)
            finish() // Move back to DestinationListActivity
		}
	}
}

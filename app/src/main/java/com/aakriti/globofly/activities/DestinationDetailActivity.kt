package com.aakriti.globofly.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.Toolbar
import com.aakriti.globofly.R
import com.aakriti.globofly.helpers.SampleData
import com.aakriti.globofly.models.Destination
import com.google.android.material.appbar.CollapsingToolbarLayout


class DestinationDetailActivity : AppCompatActivity() {
	val btn_update=findViewById<Button>(R.id.btn_update)
	val btn_delete=findViewById<Button>(R.id.btn_delete)
	val et_city=findViewById<EditText>(R.id.et_city)
	val et_description=findViewById<EditText>(R.id.et_description)
	val et_country=findViewById<EditText>(R.id.et_country)
	val detail_toolbar=findViewById<Toolbar>(R.id.detail_toolbar)
	val collapsing_toolbar=findViewById<CollapsingToolbarLayout>(R.id.collapsing_toolbar)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_destiny_detail)

		setSupportActionBar(detail_toolbar)
		// Show the Up button in the action bar.
		supportActionBar?.setDisplayHomeAsUpEnabled(true)

		val bundle: Bundle? = intent.extras

		if (bundle?.containsKey(ARG_ITEM_ID)!!) {

			val id = intent.getIntExtra(ARG_ITEM_ID, 0)

			loadDetails(id)

			initUpdateButton(id)

			initDeleteButton(id)
		}
	}

	private fun loadDetails(id: Int) {

		// To be replaced by retrofit code
		val destination = SampleData.getDestinationById(id)

		destination?.let {
			et_city.setText(destination.city)
			et_description.setText(destination.description)
			et_country.setText(destination.country)

			collapsing_toolbar.title = destination.city
		}
	}

	private fun initUpdateButton(id: Int) {

		btn_update.setOnClickListener {

			 val city = et_city.text.toString()
			val description = et_description.text.toString()
			val country = et_country.text.toString()

            // To be replaced by retrofit code
            val destination = Destination()
            destination.id = id
            destination.city = city
            destination.description = description
            destination.country = country

            SampleData.updateDestination(destination);
            finish() // Move back to DestinationListActivity
		}
	}

	private fun initDeleteButton(id: Int) {

		btn_delete.setOnClickListener {

            // To be replaced by retrofit code
            SampleData.deleteDestination(id)
            finish() // Move back to DestinationListActivity
		}
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		val id = item.itemId
		if (id == android.R.id.home) {
			navigateUpTo(Intent(this, DestinationListActivity::class.java))
			return true
		}
		return super.onOptionsItemSelected(item)
	}

	companion object {

		const val ARG_ITEM_ID = "item_id"
	}
}

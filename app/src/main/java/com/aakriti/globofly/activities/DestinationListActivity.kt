package com.aakriti.globofly.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.aakriti.globofly.R
import com.aakriti.globofly.helpers.DestinationAdapter
import com.aakriti.globofly.helpers.SampleData
import com.google.android.material.floatingactionbutton.FloatingActionButton


class DestinationListActivity : AppCompatActivity() {
	val toolbar=findViewById<Toolbar>(R.id.toolbar)
	val fab=findViewById<FloatingActionButton>(R.id.fab)
	val destiny_recycler_view=findViewById<RecyclerView>(R.id.destiny_recycler_view)
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_destiny_list)

		setSupportActionBar(toolbar)
		toolbar.title = title

		fab.setOnClickListener {
			val intent = Intent(this@DestinationListActivity, DestinationCreateActivity::class.java)
			startActivity(intent)
		}
	}

	override fun onResume() {
		super.onResume()

		loadDestinations()
	}

	private fun loadDestinations() {

        // To be replaced by retrofit code
		destiny_recycler_view.adapter = DestinationAdapter(SampleData.DESTINATIONS)
    }
}

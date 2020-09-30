package com.example.mvvmtutorial.view

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmtutorial.R
import com.example.mvvmtutorial.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    val countryAdapter = CountryAdapter(arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.refresh()
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = countryAdapter
        }
        observeViewModel()
        swipe_refresh.setOnRefreshListener {
            swipe_refresh.isRefreshing =false
            viewModel.refresh()

        }
    }

    fun observeViewModel() {
        viewModel.countries.observe(this, Observer { countries ->
            countries?.let {
                recyclerView.visibility = View.VISIBLE
                countryAdapter.updateCountries(it) }

        })

        viewModel.countryLoadError.observe(this, Observer {
            if (it) error.visibility = View.VISIBLE
            else error.visibility = View.GONE
        })

        viewModel.loading.observe(this, Observer {loading ->
            loading?. let { if (it) {
                progress_bar.visibility = View.VISIBLE
                error.visibility = View.GONE
                recyclerView.visibility=View.GONE
            }
            else {
                progress_bar.visibility = View.GONE
            } }

        })
    }
}

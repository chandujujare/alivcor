package com.alivcor.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.alivcor.R
import com.alivcor.viewmodel.HomeActivityViewModel
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(){
    private lateinit var viewModel: HomeActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        viewModel = ViewModelProviders.of(this)[HomeActivityViewModel::class.java]
        val datafragment = DataFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, datafragment)
            .commit()
        viewModel.age.observe(this, {
            val fragment = AgeCalculationFragment()
            supportFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(R.id.container, fragment)
                .commit()
        })
    }



}
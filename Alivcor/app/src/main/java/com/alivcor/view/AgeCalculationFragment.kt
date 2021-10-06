package com.alivcor.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.alivcor.R
import com.alivcor.viewmodel.HomeActivityViewModel
import kotlinx.android.synthetic.main.age_cal_frament.*

class AgeCalculationFragment : Fragment() {
    private val model: HomeActivityViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.age_cal_frament, container, false)
        model.age.observe(viewLifecycleOwner, { item ->
            run {
                show_age.text = "Hi! ${item.firstName} ${item.lastName},\n Your age is ${item.age}"
            }
        })
        return v
    }

}
package com.alivcor.view

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.alivcor.R
import com.alivcor.viewmodel.HomeActivityViewModel
import kotlinx.android.synthetic.main.data_frament.*
import java.util.*


class DataFragment : Fragment(), View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private val model: HomeActivityViewModel by activityViewModels()
    private val date = Date()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.data_frament, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        submit.setOnClickListener(this)
        calender.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.submit) {
            if(first_name.text.isEmpty()){
                first_name.error = getString(R.string.fname)
                return
            }
            if(last_name.text.isEmpty()){
                last_name.error = getString(R.string.lname)
                return
            }
            if(dob.text.isEmpty()){
                dob.error = getString(R.string.error_dob)
                return
            }

            dob.error = null
            model.setUser(first_name.text.toString(), last_name.text.toString(), date)
        } else {
            showCalender()
        }
    }

    private fun showCalender() {
        val calender = Calendar.getInstance()
        DatePickerDialog(
            requireContext(),
            this,
            calender.get(Calendar.YEAR),
            calender.get(Calendar.MONTH),
            calender.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    @SuppressLint("SetTextI18n")
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        dob.setText("$dayOfMonth/$month/$year")
        date.date = dayOfMonth
        date.year = year
        date.month = month
    }

}
package com.azimzada.quranapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView.OnDateChangeListener
import androidx.fragment.app.Fragment
import com.azimzada.quranapplication.databinding.FragmentPrayerBinding


class PrayerFragment : Fragment(R.layout.fragment_prayer) {

    lateinit var binding: FragmentPrayerBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPrayerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val calendarView = binding.calendarView

        calendarView.setOnDateChangeListener(OnDateChangeListener { _, year, month, day ->
            val date = "$day - $month - $year"
        })

        binding.toolbar.toolbarTextIV.setText("Prayer")
    }
}
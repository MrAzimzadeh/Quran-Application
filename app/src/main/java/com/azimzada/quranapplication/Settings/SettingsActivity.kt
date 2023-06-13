package com.azimzada.quranapplication.Settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.azimzada.quranapplication.R
import com.azimzada.quranapplication.databinding.ActivityMainBinding
import com.azimzada.quranapplication.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {
    lateinit var binding: ActivitySettingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.profileIconIV.setImageResource(R.drawable.settingsicon)
        binding.toolbar.toolbarTextIV.setText("Settings")
    }
}
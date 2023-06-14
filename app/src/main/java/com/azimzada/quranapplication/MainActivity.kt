package com.azimzada.quranapplication

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageButton
import com.azimzada.quranapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()

        setUpNavButtons()
    }

    fun setUpNavButtons() {
        val button1: AppCompatImageButton = binding.bookBtn
        val button2: AppCompatImageButton = binding.quranBtn
        val button3: AppCompatImageButton = binding.mosqueBtn

        val prayerFragment = PrayerFragment()
        button1.setOnClickListener {
            scaleUpButton(button1)
            resetButtonScale(button2)
            resetButtonScale(button3)

            button1.setImageResource(R.drawable.book_button_unselected)
            button2.setImageResource(R.drawable.quran_button_unselected)
            button3.setImageResource(R.drawable.mosque_button_unselected)
        }

        button2.setOnClickListener {
            resetButtonScale(button1)
            scaleUpButton(button2)
            resetButtonScale(button3)

            button1.setImageResource(R.drawable.book_button_unselected)
            button2.setImageResource(R.drawable.quran_button_selected)
            button3.setImageResource(R.drawable.mosque_button_unselected)
        }

        button3.setOnClickListener {
            resetButtonScale(button1)
            resetButtonScale(button2)
            scaleUpButton(button3)

            button1.setImageResource(R.drawable.book_button_unselected)
            button2.setImageResource(R.drawable.quran_button_unselected)
            button3.setImageResource(R.drawable.mosque_button_selected)

            supportFragmentManager.beginTransaction().apply {
                replace(binding.frameLayout.id, prayerFragment)
                commit()
            }
        }
    }

    fun scaleUpButton(button: AppCompatImageButton) {
        val scaleX = ObjectAnimator.ofFloat(button, "scaleX", 1.0f, 1.5f)
        val scaleY = ObjectAnimator.ofFloat(button, "scaleY", 1.0f, 1.5f)
        val animatorSet = AnimatorSet().apply {
            duration = 500
            interpolator = AccelerateDecelerateInterpolator()
            playTogether(scaleX, scaleY)
        }
        animatorSet.start()
    }

    fun resetButtonScale(button: AppCompatImageButton) {
        val scaleX = ObjectAnimator.ofFloat(button, "scaleX", 1.5f, 1.0f)
        val scaleY = ObjectAnimator.ofFloat(button, "scaleY", 1.5f, 1.0f)
        val animatorSet = AnimatorSet().apply {
            duration = 500
            interpolator = AccelerateDecelerateInterpolator()
            playTogether(scaleX, scaleY)
        }
        animatorSet.start()
    }
}
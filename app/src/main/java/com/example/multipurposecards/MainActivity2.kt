package com.example.multipurposecards

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import com.example.multipurposecards.Utils.ANIMATION_DURATION
import com.example.multipurposecards.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.labelTitleBottom.setOnClickListener {
            binding.apply {
                textTitle.fadeInAndMoveRight()
                textSubtitle.fadeInAndMoveRight()
                textTitleBottom.fadeInAndMoveRight()
                textSubtitleBottom.fadeInAndMoveRight()
                constraintProgressBar.fadeInAndMoveDown()
                constraintToolbar.fadeInAndMoveDown()
                constraintBottom.fadeInAndMoveDown()

                progressBarBig.animatedProgress(60)
                progressBarSmall.animatedProgress(80)

                textIndicator.animatedValue(12)
            }
        }
    }

    override fun onResume() {
        binding.apply {
            textTitle.fadeInAndMoveRight()
            textSubtitle.fadeInAndMoveRight()
            textTitleBottom.fadeInAndMoveRight()
            textSubtitleBottom.fadeInAndMoveRight()
            constraintProgressBar.fadeInAndMoveDown()
            constraintToolbar.fadeInAndMoveDown()
            constraintBottom.fadeInAndMoveDown()

            progressBarBig.animatedProgress(60)
            progressBarSmall.animatedProgress(80)

            textIndicator.animatedValue(3)
        }
        super.onResume()
    }
    private fun TextView.fadeInAndMoveRight() {
        alpha = 0f
        translationY = 0f

        val fadeInAnimator = ObjectAnimator.ofFloat(this, "alpha", 0f, 1f)
        fadeInAnimator.duration = ANIMATION_DURATION

        val moveUpAnimator = ObjectAnimator.ofFloat(this, "translationX", -30f, 10f)
        moveUpAnimator.duration = ANIMATION_DURATION


        val animatorSet = AnimatorSet()
        animatorSet.playTogether(fadeInAnimator, moveUpAnimator)
        animatorSet.start()
    }

    private fun View.fadeInAndMoveDown() {
        alpha = 0f
        translationY = 0f

        val fadeInAnimator = ObjectAnimator.ofFloat(this, "alpha", 0f, 1f)
        fadeInAnimator.duration = ANIMATION_DURATION

        val moveUpAnimator = ObjectAnimator.ofFloat(this, "translationY", -30f, 10f)
        moveUpAnimator.duration = ANIMATION_DURATION


        val animatorSet = AnimatorSet()
        animatorSet.playTogether(fadeInAnimator)
        animatorSet.start()
    }
    private fun TextView.animatedValue(progress: Int) {
        val valueAnimator = ValueAnimator.ofInt(0, progress)
        valueAnimator.duration = ANIMATION_DURATION
        valueAnimator.addUpdateListener {
            val animatedValue = it.animatedValue as Int
            this.text = "$animatedValue/20"
        }
        valueAnimator.start()
    }
    private fun ProgressBar.animatedProgress(progress: Int) {
        val progressAnimator = ObjectAnimator.ofInt(this, "progress", 0, progress)
        progressAnimator.duration = ANIMATION_DURATION
        progressAnimator.start()
    }

}
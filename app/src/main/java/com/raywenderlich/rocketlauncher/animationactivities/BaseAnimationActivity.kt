package com.raywenderlich.rocketlauncher.animationactivities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import android.view.View

import com.raywenderlich.rocketlauncher.R

abstract class BaseAnimationActivity : AppCompatActivity() {
  protected lateinit var rocket: View // lateinit values since they will be set before they are used
  protected lateinit var doge: View
  protected lateinit var frameLayout: View
  protected var screenHeight = 0f

  override fun onCreate(savedInstanceState: Bundle?) {
    // Call onCreate() on the superclass and then setContentView(...) with the layout file.
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_base_animation)
    // Find all of the views in the currently set XML layout and bind FrameLayout, rocket and doge to their corresponding variables.
    rocket = findViewById(R.id.rocket)
    doge = findViewById(R.id.doge)
    frameLayout = findViewById(R.id.container)
    // Set a onClickListener on FrameLayout.
    frameLayout.setOnClickListener {
    // Call onStartAnimation() whenever the user taps the screen.
      onStartAnimation() // This is an abstract method defined by each of the activities that extend BaseAnimationActivity
    }
  }

  override fun onResume() {
    super.onResume()

    val displayMetrics = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(displayMetrics)
    screenHeight = displayMetrics.heightPixels.toFloat()
  }

  protected abstract fun onStartAnimation()

  companion object {
    val DEFAULT_ANIMATION_DURATION = 2500L
  }
}

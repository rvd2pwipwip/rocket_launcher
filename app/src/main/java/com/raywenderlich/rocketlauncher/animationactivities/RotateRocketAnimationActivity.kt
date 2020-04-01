package com.raywenderlich.rocketlauncher.animationactivities

import android.animation.ValueAnimator
import android.view.animation.LinearInterpolator

class RotateRocketAnimationActivity : BaseAnimationActivity() {
  override fun onStartAnimation() {
    // 1 Changing the valueAnimator values to go from 0f to 360f causes the rocket to make a full turn
    val valueAnimator = ValueAnimator.ofFloat(0f, 360f)

    valueAnimator.addUpdateListener {
      val value = it.animatedValue as Float
      // 2 Instead of setting translationY, you set the rocket’s rotation because that’s what needs to change
      rocket.rotation = value
    }

    valueAnimator.interpolator = LinearInterpolator()
    valueAnimator.duration = DEFAULT_ANIMATION_DURATION
    valueAnimator.start()

  }
}

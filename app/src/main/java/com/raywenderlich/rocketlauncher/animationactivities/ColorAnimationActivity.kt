package com.raywenderlich.rocketlauncher.animationactivities

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.support.v4.content.ContextCompat
import com.raywenderlich.rocketlauncher.R

class ColorAnimationActivity : BaseAnimationActivity() {
  override fun onStartAnimation() {

    //1 Call ObjectAnimator.ofObject() and give it the following arguments:
    //  frameLayout — the object with the property to be animated.
    //  "backgroundColor" — the property you want to animate.
    //  ArgbEvaluator() — an additional argument that specifies how to interpolate between two different ARGB (alpha, red, green, blue) color values.
    //  Start and end color values — here you make use of ContextCompat.getColor() to get the color resource id of a custom color specified in your colors.xml.
    val objectAnimator = ObjectAnimator.ofObject(
            frameLayout,
            "backgroundColor",
            ArgbEvaluator(),
            ContextCompat.getColor(this, R.color.background_from),
            ContextCompat.getColor(this, R.color.background_to)
    )

// 2
    objectAnimator.repeatCount = 1
    objectAnimator.repeatMode = ValueAnimator.REVERSE

// 3
    objectAnimator.duration = DEFAULT_ANIMATION_DURATION
    objectAnimator.start()


  }
}

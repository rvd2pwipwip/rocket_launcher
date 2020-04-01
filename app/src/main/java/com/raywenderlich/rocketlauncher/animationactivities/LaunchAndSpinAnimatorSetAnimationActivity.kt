package com.raywenderlich.rocketlauncher.animationactivities

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator

class LaunchAndSpinAnimatorSetAnimationActivity : BaseAnimationActivity() {
  override fun onStartAnimation() {

    // 1 Create a new ValueAnimator
    val positionAnimator = ValueAnimator.ofFloat(0f, -screenHeight)

    // 2 Attach an AnimatorUpdateListener to the ValueAnimator that updates the rocket’s position
    positionAnimator.addUpdateListener {
      val value = it.animatedValue as Float
      rocket.translationY = value
    }

    // 3 Create an ObjectAnimator, a second animator that updates the rocket’s rotation
    val rotationAnimator = ObjectAnimator.ofFloat(rocket, "rotation", 0f, 180f)

    // 4 Create a new instance of AnimatorSet
    val animatorSet = AnimatorSet()

    // 5 Specify that you’d like to execute positionAnimator together with rotationAnimator
    animatorSet.play(positionAnimator).with(rotationAnimator)

    // 6 Just as with a typical animator, you set a duration and call start()
    animatorSet.duration = DEFAULT_ANIMATION_DURATION
    animatorSet.start()

  }
}

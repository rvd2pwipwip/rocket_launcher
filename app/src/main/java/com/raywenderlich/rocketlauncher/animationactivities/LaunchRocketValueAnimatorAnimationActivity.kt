package com.raywenderlich.rocketlauncher.animationactivities

import android.animation.ValueAnimator
import android.view.animation.LinearInterpolator

class LaunchRocketValueAnimatorAnimationActivity : BaseAnimationActivity() {
  override fun onStartAnimation() {

    //1 Create an instance of ValueAnimator by calling the static method ofFloat
    //  and give it the starting and ending values for the property that you want to animate,
    //  along with the duration of the animation (default = 300ms)
    val valueAnimator = ValueAnimator.ofFloat(0f, -screenHeight)

    //2 Call addUpdateListener() and pass in a listener
    //  ValueAnimator calls this listener with every update to the animated value — remember the default delay of 10 ms.
    valueAnimator.addUpdateListener {
      // 3 Get the current value from the animator and cast it to a float;
      //   the current value type is float because you created the ValueAnimator with ofFloat
      val value = it.animatedValue as Float
      // 4 Change the rocket’s position by setting its translationY value.
      rocket.translationY = value
    }

    //5 Set up the animator’s duration and interpolator.
    valueAnimator.interpolator = LinearInterpolator()
    valueAnimator.duration = DEFAULT_ANIMATION_DURATION

    //6 Start the animation.
    valueAnimator.start()

  }
}
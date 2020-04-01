package com.raywenderlich.rocketlauncher.animationactivities

import android.animation.ObjectAnimator

class LaunchRocketObjectAnimatorAnimationActivity : BaseAnimationActivity() {
    override fun onStartAnimation() {

        // 1 Creating an instance of ObjectAnimator
        //  and, like the ValueAnimator, give it the starting and ending values for the property that you want to animate,
        //  along with the duration of the animation (default = 300ms)
        //  BUT ALSO the object to animate (rocket) and its animated property (translationY)
        val objectAnimator = ObjectAnimator.ofFloat(rocket, "translationY", 0f, -screenHeight)

        // 2 set the duration for the animation and start it.
        objectAnimator.duration = DEFAULT_ANIMATION_DURATION
        objectAnimator.start()


    }
}

/*
Note: There’s a limitation to ObjectAnimator — it can’t animate two objects simultaneously.
To work around it, you create two instances of ObjectAnimator.

Consider your use cases and the amount of coding required when you decide to use ObjectAnimator or ValueAnimator.
 */
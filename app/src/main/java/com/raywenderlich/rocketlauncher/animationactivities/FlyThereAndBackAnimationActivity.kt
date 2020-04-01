package com.raywenderlich.rocketlauncher.animationactivities

import android.animation.ValueAnimator

class FlyThereAndBackAnimationActivity : BaseAnimationActivity() {
    override fun onStartAnimation() {

        // 1 Create an animator, as usual.
        val animator = ValueAnimator.ofFloat(0f, -screenHeight)

        animator.addUpdateListener {
            val value = it.animatedValue as Float
            rocket.translationY = value
            doge.translationY = value
        }

        // 2 You can set the repeatMode to either of the following:
        //  RESTART — restarts the animation from the beginning.
        //  REVERSE — reverses the animation’s direction with every iteration.
        //  In this case, you set it to REVERSE because you want the rocket to take off and then go back to the same position where it started. Just like SpaceX! :]
        animator.repeatMode = ValueAnimator.REVERSE

        // 3 …Except you’ll do it twice.
        animator.repeatCount = 3

        // 4 Set a duration and start the animation, as usual.
        animator.duration = 500L
        animator.start()


    }
}

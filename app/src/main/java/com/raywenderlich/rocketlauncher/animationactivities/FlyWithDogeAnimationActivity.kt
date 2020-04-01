package com.raywenderlich.rocketlauncher.animationactivities

import android.animation.AnimatorSet
import android.animation.ValueAnimator

class FlyWithDogeAnimationActivity : BaseAnimationActivity() {
    override fun onStartAnimation() {

        //1 positionAnimator — for changing positions of both rocket and doge
        val positionAnimator = ValueAnimator.ofFloat(0f, -screenHeight)
        positionAnimator.addUpdateListener {
            val value = it.animatedValue as Float
            rocket.translationY = value
            doge.translationY = value
        }

        //2 rotationAnimator — for rotating Doge
        val rotationAnimator = ValueAnimator.ofFloat(0f, 360f)
        rotationAnimator.addUpdateListener {
            val value = it.animatedValue as Float
            doge.rotation = value
        }

        //3 animatorSet — to combine the first two animators
        val animatorSet = AnimatorSet()
        animatorSet.play(positionAnimator).with(rotationAnimator)
        animatorSet.duration = DEFAULT_ANIMATION_DURATION
        animatorSet.start()


    }
}

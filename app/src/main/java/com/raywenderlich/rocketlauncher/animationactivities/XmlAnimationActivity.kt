package com.raywenderlich.rocketlauncher.animationactivities

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import com.raywenderlich.rocketlauncher.R

class XmlAnimationActivity : BaseAnimationActivity() {
    override fun onStartAnimation() {

        // 1 First, you load AnimatorSet from R.animator.jump_and_blink file, just like you normally would to inflate a view layout.
        val rocketAnimatorSet = AnimatorInflater.loadAnimator(this, R.animator.jump_and_blink) as AnimatorSet
        // 2 Then you set rocket as the target for just-loaded animator.
        rocketAnimatorSet.setTarget(rocket)

        // 3 Load the animator from the same file once again.
        val dogeAnimatorSet = AnimatorInflater.loadAnimator(this, R.animator.jump_and_blink) as AnimatorSet
        // 4 Rinse and repeat for doge object.
        dogeAnimatorSet.setTarget(doge)

        // 5 Now you create a third AnimatorSet and set it up to play the first two simultaneously.
        val bothAnimatorSet = AnimatorSet()
        bothAnimatorSet.playTogether(rocketAnimatorSet, dogeAnimatorSet)
        // 6 Set the duration for the root animator and start.
        bothAnimatorSet.duration = DEFAULT_ANIMATION_DURATION
        bothAnimatorSet.start()


    }
}

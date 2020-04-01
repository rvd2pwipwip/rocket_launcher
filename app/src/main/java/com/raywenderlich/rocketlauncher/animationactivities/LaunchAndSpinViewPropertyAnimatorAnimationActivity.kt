package com.raywenderlich.rocketlauncher.animationactivities

class LaunchAndSpinViewPropertyAnimatorAnimationActivity : BaseAnimationActivity() {
    override fun onStartAnimation() {

        rocket.animate()
                .translationY(-screenHeight)
                .rotationBy(360f)
                .setDuration(DEFAULT_ANIMATION_DURATION)
                .start()
    }
}

/*
Note: ViewPropertyAnimator may provide better performance for multiple simultaneous animations.
It optimizes invalidated calls, so they only take place once for several properties
— in contrast to each animated property causing its own invalidation independently.
 */
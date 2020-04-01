package com.raywenderlich.rocketlauncher.animationactivities

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.view.animation.AccelerateInterpolator
import android.widget.Toast

class WithListenerAnimationActivity : BaseAnimationActivity() {
    override fun onStartAnimation() {

        //1 Create and set up an animator. You use ValueAnimator to change the position of two objects simultaneously — you can’t do the same thing with a single ObjectAnimator
        val animator = ValueAnimator.ofFloat(0f, -screenHeight)

        animator.addUpdateListener {
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

        // 3 Add the AnimatorListener.
        animator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                // 4 Show a toast message when the animation starts.
                Toast.makeText(applicationContext, "Doge took off", Toast.LENGTH_SHORT)
                        .show()
            }

            override fun onAnimationEnd(animation: Animator) {
                // 5 And another toast when it ends.
                Toast.makeText(applicationContext, "Doge is on the moon", Toast.LENGTH_SHORT)
                        .show()
//                finish() // ends the activity and returns to MainListActivity
            }

            override fun onAnimationCancel(animation: Animator) {}

            override fun onAnimationRepeat(animation: Animator) {}
        })

        // 6 animatorSet — to combine the first two animators
        val animatorSet = AnimatorSet()
        animatorSet.play(animator).with(rotationAnimator)
        animatorSet.interpolator = AccelerateInterpolator(3f)
        animatorSet.duration = 5000L

        // 7 Start the animation as usual.
        animatorSet.start()


    }
}

/*

Note: You can also add a listener to ViewPropertyAnimator by adding a setListener to a call chain before calling start():
rocket.animate().setListener(object : Animator.AnimatorListener {
  // Your action
})

Alternatively, you can set start and end actions on your View by calling withStartAction(Runnable) and withEndAction(Runnable) after animate().
It’s the equivalent to an AnimatorListener with these actions.

 */
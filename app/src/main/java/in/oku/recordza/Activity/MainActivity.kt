package `in`.oku.recordza.Activity

import `in`.oku.recordza.R
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.inflate_card_view.*


class MainActivity : AppCompatActivity(), Animation.AnimationListener {

    var mAnimation: Animation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inflate_card_view)
        mAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom_out)
        mAnimation?.setAnimationListener(this)
        mBackgroundIV.startAnimation(mAnimation)
    }

    override fun onAnimationRepeat(animation: Animation?) {
    }

    override fun onAnimationEnd(animation: Animation?) {
    }

    override fun onAnimationStart(animation: Animation?) {

        val aniSlide = AnimationUtils.loadAnimation(this, R.anim.zoom_in)
        findViewById<ImageView>(R.id.mBackgroundIV).startAnimation(aniSlide)

        val aniText = AnimationUtils.loadAnimation(this, R.anim.flipin)
        findViewById<TextView>(R.id.mTextView).startAnimation(aniText)

    }

}

package `in`.oku.recordza.Activity

import `in`.oku.recordza.Adaptor.DemoAdaptor
import `in`.oku.recordza.R
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.PagerSnapHelper
import android.support.v7.widget.SnapHelper




class MainActivity : AppCompatActivity(), Animation.AnimationListener {

    var mAnimation: Animation? = null
    var mList: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in 0..10) {
            mList.add("ABHILASH CHIKARA")
        }

        val mAdaptor = DemoAdaptor(this, mList)
        mRecyclerView.adapter = mAdaptor
        mAdaptor.notifyDataSetChanged()

        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(mRecyclerView)

//        mAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom_out)
//        mAnimation?.setAnimationListener(this)
//        mBackgroundIV.startAnimation(mAnimation)
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

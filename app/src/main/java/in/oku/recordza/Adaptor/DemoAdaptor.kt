package `in`.oku.recordza.Adaptor

import `in`.oku.recordza.R
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.inflate_card_view.view.*

class DemoAdaptor(mContext: Context, mList: ArrayList<String>) :
        RecyclerView.Adapter<DemoAdaptor.ViewHolderClass>() {

    private var mContext: Context? = null
    private var mList: ArrayList<String>? = null

    init {
        this.mContext = mContext
        this.mList = mList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass =
            ViewHolderClass(LayoutInflater.from(mContext)
                    .inflate(R.layout.inflate_card_view, parent,
                            false))

    override fun getItemCount(): Int = mList!!.size

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        holder.bindView()

    }

    inner class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView),
            Animation.AnimationListener {

        var mBackgroundIV: ImageView? = null
        var mTextView: TextView? = null

        init {
            this.mBackgroundIV = itemView.mBackgroundIV
            this.mTextView = itemView.mTextView
        }

        fun bindView() {
            val mAnimation = AnimationUtils.loadAnimation(mContext, R.anim.zoom_out)
            mAnimation?.setAnimationListener(this)
            mBackgroundIV!!.startAnimation(mAnimation)
        }

        override fun onAnimationRepeat(animation: Animation?) {
        }

        override fun onAnimationEnd(animation: Animation?) {
        }

        override fun onAnimationStart(animation: Animation?) {
            val aniSlide = AnimationUtils.loadAnimation(mContext, R.anim.zoom_in)
            itemView.mBackgroundIV?.startAnimation(aniSlide)

            val aniText = AnimationUtils.loadAnimation(mContext, R.anim.flipin)
            itemView.mTextView.startAnimation(aniText)

        }

    }

}
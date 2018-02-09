package com.example.mansigoel.gesturesandtouches

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.github.chrisbanes.photoview.OnViewTapListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_main.view.*

class MainActivity : AppCompatActivity(), OnViewTapListener {
    override fun onViewTap(view: View?, x: Float, y: Float) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private var view: View? = null

    private lateinit var alert: AlertDialog.Builder

    private lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iv_original.setOnClickListener {
            alert = AlertDialog.Builder(this)

            view = LayoutInflater.from(baseContext).inflate(R.layout.view_main, null)
            alert.setView(view)
            dialog = alert.show()

            view?.iv_photoview?.animation = AnimationUtils.loadAnimation(baseContext, R.anim.zoom_enter)
           // iv.isZ
           swipeAndTranslate(view?.iv_photoview)
        }
    }

    fun swipeAndTranslate(view: TouchImageView?) {
            view?.setOnTouchListener(object : OnSwipeTouchListener(baseContext) {

            override fun onSwipeTop() {
                if (!view.isZoomed)
                {
                  //  Toast.makeText(baseContext, "Top", Toast.LENGTH_SHORT).show()
                    //setting and starting animation
                    val animation = AnimationUtils.loadAnimation(baseContext, R.anim.top_swipe)
                    view.iv_photoview.startAnimation(animation)
                    //dismissing alert box after animation is completed
                    Handler().postDelayed({
                        view!!.clearAnimation()
                        dialog.dismiss()
                    }, 500)
                }
            }

            override fun onSwipeRight() {
                if (!view.isZoomed) {
                 //   Toast.makeText(baseContext, "Right", Toast.LENGTH_SHORT).show()
                    val animation = AnimationUtils.loadAnimation(baseContext, R.anim.right_swipe)
                    view!!.startAnimation(animation)
                    //dismissing alert box after animation is completed
                    Handler().postDelayed({
                        dialog.dismiss()
                    }, 500)
                }
            }

            override fun onSwipeLeft() {
                if (!view.isZoomed) {
                 //   Toast.makeText(baseContext, "Left", Toast.LENGTH_SHORT).show()
                    val animation = AnimationUtils.loadAnimation(baseContext, R.anim.left_swipe)
                    view!!.startAnimation(animation)
                    //dismissing alert box after animation is completed
                    Handler().postDelayed({
                        dialog.dismiss()
                    }, 500)
                }
            }

            override fun onSwipeBottom() {
                if (!view.isZoomed) {
                   // Toast.makeText(baseContext, "Bottom", Toast.LENGTH_SHORT).show()
                    val animation = AnimationUtils.loadAnimation(baseContext, R.anim.bottom_swipe)
                    view!!.startAnimation(animation)
                    //dismissing alert box after animation is completed
                    Handler().postDelayed({
                        view.clearAnimation()
                        dialog.dismiss()
                    }, 500)
                }
            }
        })
    }
}

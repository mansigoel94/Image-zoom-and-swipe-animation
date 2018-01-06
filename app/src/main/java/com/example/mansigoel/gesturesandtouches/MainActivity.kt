package com.example.mansigoel.gesturesandtouches

import android.app.Dialog
import android.os.Bundle
import android.os.Handler
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import com.github.chrisbanes.photoview.PhotoView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_main.view.*

class MainActivity : AppCompatActivity() {

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
//            view?.iv_photoview?.setImageResource(R.drawable.wallpaper)
            view?.iv_photoview?.animation = AnimationUtils.loadAnimation(baseContext, R.anim.zoom_enter)
            swipeAndTranslate(view?.iv_xyz)
        }
    }

    fun swipeAndTranslate(view: View?) {

        view?.setOnTouchListener(object : OnSwipeTouchListener(baseContext) {
            override fun onSwipeTop() {
                Toast.makeText(baseContext,"Right",Toast.LENGTH_SHORT).show()
                //setting and starting animation
                val animation = AnimationUtils.loadAnimation(baseContext, R.anim.top_swipe)
                view.startAnimation(animation)
                //dismissing alert box after animation is completed
                Handler().postDelayed({
                    view.clearAnimation()
                    dialog.dismiss()
                }, 1000)
            }

            override fun onSwipeRight() {
                Toast.makeText(baseContext,"Right",Toast.LENGTH_SHORT).show()
                val animation = AnimationUtils.loadAnimation(baseContext, R.anim.right_swipe)
                view.startAnimation(animation)
                //dismissing alert box after animation is completed
                Handler().postDelayed({
                    dialog.dismiss()
                }, 1000)
            }

            override fun onSwipeLeft() {
                Toast.makeText(baseContext,"Right",Toast.LENGTH_SHORT).show()
                val animation = AnimationUtils.loadAnimation(baseContext, R.anim.left_swipe)
                view.startAnimation(animation)
                //dismissing alert box after animation is completed
                Handler().postDelayed({
                    dialog.dismiss()
                }, 1000)

            }

            override fun onSwipeBottom() {
                Toast.makeText(baseContext,"Right",Toast.LENGTH_SHORT).show()
                val animation = AnimationUtils.loadAnimation(baseContext, R.anim.bottom_swipe)
                view.startAnimation(animation)
                //dismissing alert box after animation is completed
                Handler().postDelayed({
                    view.clearAnimation()
                    dialog.dismiss()
                }, 1000)
            }

        })
    }
}

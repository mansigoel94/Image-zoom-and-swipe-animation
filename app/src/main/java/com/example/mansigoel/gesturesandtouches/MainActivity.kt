package com.example.mansigoel.gesturesandtouches

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.widget.Toast
import android.view.GestureDetector.OnDoubleTapListener


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Touch listeners tap to zoom
/*        image.setOnTouchListener(object : OnDoubleTapListener, OnTouchListener {
            override fun onDoubleTap(p0: MotionEvent?): Boolean {
                //TODO double tap to zoom
                return true
            }

            override fun onDoubleTapEvent(p0: MotionEvent?): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onSingleTapConfirmed(p0: MotionEvent?): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
                //TODO single tap to set image
                return true
            }
        })*/

        iv_original.setOnClickListener{
            iv_photoview.bringToFront()
            iv_photoview.visibility=View.VISIBLE
        }
    }
}

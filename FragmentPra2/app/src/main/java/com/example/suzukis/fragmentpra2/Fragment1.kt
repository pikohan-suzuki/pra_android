package com.example.suzukis.fragmentpra2

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

public class Fragment1 : Fragment() {

    companion object {
        fun newInstance() : Fragment1{
            val fragment= Fragment1()
            return fragment
        }
    }
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment1, container, false)
    }

}
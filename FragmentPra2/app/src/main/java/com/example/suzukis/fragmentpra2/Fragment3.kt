package com.example.suzukis.fragmentpra2

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

public class Fragment3 : Fragment() {

    companion object {
        fun newInstance(): Fragment3 {
            val fragment = Fragment3()
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment3, container, false)
    }
}
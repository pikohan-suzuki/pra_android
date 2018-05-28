package com.example.suzukis.fragmentpra2

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

public class Fragment2 : Fragment() {

    companion object {
        fun getInstance(): Fragment2 {
            return Fragment2()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment2, container, false)
    }
}
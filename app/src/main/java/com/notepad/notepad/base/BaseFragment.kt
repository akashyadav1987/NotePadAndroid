package com.notepad.notepad.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View

/**
 * Created by akashyadav on 7/18/18.
 * Base fragment which will contain all the required common functions for fragments
 */

open class BaseFragment: Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
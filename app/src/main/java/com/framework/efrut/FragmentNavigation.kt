package com.framework.efrut

import androidx.fragment.app.Fragment
import java.util.*

interface FragmentNavigation {
    fun navigateFragment(fragment: Fragment, addToStack: Boolean)
}
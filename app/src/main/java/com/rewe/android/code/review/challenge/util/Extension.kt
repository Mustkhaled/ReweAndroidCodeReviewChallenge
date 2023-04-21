package com.rewe.android.code.review.challenge.util

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
//Unused function
inline fun <reified T : Fragment> T.withArguments(vararg params: Pair<String, Any>): T {
    arguments = bundleOf(*params)
    return this
}

val <T> T.exhaustive: T
    get() = this

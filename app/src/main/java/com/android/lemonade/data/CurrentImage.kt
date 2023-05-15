package com.android.lemonade.data

import androidx.annotation.DrawableRes
import com.android.lemonade.R

sealed interface CurrentImage {

	val index: Int

	@get:DrawableRes
	val imageRes: Int

	object LemonTree : CurrentImage {
		override val index: Int
			get() = 0
		override val imageRes: Int
			get() = R.drawable.lemon_tree
	}

	object Lemon : CurrentImage {
		override val imageRes: Int
			get() = R.drawable.lemon_squeeze
		override val index: Int
			get() = 1
		var taps: Int = 0
		var random = (2..4).random()
	}

	object Lemonade : CurrentImage {
		override val index: Int
			get() = 2
		override val imageRes: Int
			get() = R.drawable.lemon_drink
	}

	object Glass : CurrentImage {
		override val index: Int
			get() = 3
		override val imageRes: Int
			get() = R.drawable.lemon_restart
	}
}
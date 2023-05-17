package com.android.lemonade.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.android.lemonade.R

sealed interface CurrentImage {

	@get: StringRes
	val stringResourceId: Int

	@get: StringRes
	val contentDescriptionImage: Int

	@get:DrawableRes
	val imageRes: Int

	data object LemonTree : CurrentImage {
		override val stringResourceId: Int
			get() = R.string.lemon_tree
		override val contentDescriptionImage: Int
			get() = R.string.lemon_tree_description
		override val imageRes: Int
			get() = R.drawable.lemon_tree
	}

	data object Lemon : CurrentImage {
		override val stringResourceId: Int
			get() = R.string.lemon
		override val contentDescriptionImage: Int
			get() = R.string.lemon_description
		override val imageRes: Int
			get() = R.drawable.lemon_squeeze
		var taps: Int = 0
		var random = (2..4).random()
	}

	data object Lemonade : CurrentImage {
		override val stringResourceId: Int
			get() = R.string.lemonade
		override val contentDescriptionImage: Int
			get() = R.string.lemonade_description
		override val imageRes: Int
			get() = R.drawable.lemon_drink
	}

	data object Glass : CurrentImage {
		override val stringResourceId: Int
			get() = R.string.glass
		override val contentDescriptionImage: Int
			get() = R.string.glass_description
		override val imageRes: Int
			get() = R.drawable.lemon_restart
	}
}
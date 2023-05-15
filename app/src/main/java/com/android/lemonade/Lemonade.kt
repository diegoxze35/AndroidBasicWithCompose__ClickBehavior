package com.android.lemonade

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Lemonade(
	text: String,
	@DrawableRes imageRes: Int,
	contentDescription: String,
	modifier: Modifier = Modifier,
	onClickImage: () -> Unit
) {
	Column(
		modifier = modifier.fillMaxSize(),
		verticalArrangement = Arrangement.Center,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Text(text = text, fontSize = 18.sp)
		Spacer(modifier = modifier.padding(vertical = 16.dp))
		Image(
			painter = painterResource(id = imageRes),
			contentDescription = contentDescription,
			modifier = Modifier
				.border(
					width = 2.dp,
					color = Color(red = 105, green = 205, blue = 216),
					shape = ShapeDefaults.Small
				)
				.clickable { onClickImage() }
		)
	}
}
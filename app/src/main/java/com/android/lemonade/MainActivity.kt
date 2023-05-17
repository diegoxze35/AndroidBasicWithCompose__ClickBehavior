package com.android.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.android.lemonade.data.CurrentImage
import com.android.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			LemonadeTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colorScheme.background
				) {
					var current: CurrentImage by remember {
						mutableStateOf(CurrentImage.LemonTree)
					}
					Lemonade(
						current.stringResourceId,
						current.imageRes,
						current.contentDescriptionImage
					) {
						current = when (current) {
							CurrentImage.LemonTree -> CurrentImage.Lemon
							CurrentImage.Lemon -> {
								with(current as CurrentImage.Lemon) {
									if (++taps < random)
										this
									else {
										random = (2..4).random()
										taps = 0
										CurrentImage.Lemonade
									}
								}
							}
							CurrentImage.Lemonade -> CurrentImage.Glass
							CurrentImage.Glass -> CurrentImage.LemonTree
						}
					}

				}
			}
		}
	}
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
	LemonadeTheme {
		Lemonade(
			R.string.lemon_tree,
			R.drawable.lemon_tree,
			R.string.lemon_tree_description
		) {}
	}
}
package com.chhavi.snake.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.chhavi.snake.R
import com.chhavi.snake.presentation.activity.GameActivity
import com.chhavi.snake.presentation.component.AppBar
import com.chhavi.snake.presentation.component.AppButton
import com.chhavi.snake.presentation.component.DisplayLarge
import com.chhavi.snake.presentation.component.TitleLarge
import com.chhavi.snake.presentation.theme.padding8dp

@Composable
fun EndScreen(score: Int, onTryAgain: () -> Unit) {
    val activity = LocalContext.current as GameActivity
    AppBar(title = "", onBackClicked = { activity.finish() }) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            DisplayLarge(
                modifier = Modifier.padding(padding8dp),
                text = stringResource(R.string.game_over),
                textAlign = TextAlign.Center
            )
            TitleLarge(
                modifier = Modifier.padding(padding8dp),
                text = stringResource(id = R.string.your_score, score),
            )
            AppButton(text = stringResource(R.string.try_again)) { onTryAgain.invoke() }
        }
    }
}
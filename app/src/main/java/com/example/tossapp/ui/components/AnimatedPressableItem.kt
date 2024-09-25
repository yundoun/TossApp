package com.example.tossapp.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
@Composable
fun AnimatedPressableItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    content: @Composable () -> Unit
) {
    var isPressed by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(if (isPressed) 0.95f else 1f, label = "")
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(8.dp))
            .background(Color.Transparent)
            .pointerInput(Unit) {
                detectTapGestures( // 터치 이벤트 감지
                    onPress = {
                        isPressed = true // 터치 했을 때
                        val press = PressInteraction.Press(it)
                        interactionSource.emit(press)
                        try {
                            awaitRelease()
                        } finally {
                            isPressed = false // 터치 해제 했을 때
                            interactionSource.emit(PressInteraction.Release(press))
                        }
                    },
                    onTap = { onClick() }
                )
            }
            .scale(scale) // isPressed 값에 따라 크기 조절
            .indication( // 리플 애니메이션 추가
                interactionSource,
                rememberRipple(bounded = true, color = Color.Gray)
            )
    ) {
        content() // 전달된 컨텐츠 호출
    }
}


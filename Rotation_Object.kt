
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MusicKnob(
    modifier: Modifier,
    imageSrc:Int = R.drawable.topicon,
    limitingAngle: Float = 25f,
    onValueChange: (Float) -> Unit,

) {
    var rotation by remember{
        mutableStateOf(limitingAngle)
    }

    var centerX by remember {
        mutableStateOf(0f)
    }
    var centerY by remember {
        mutableStateOf(0f)
    }

    var touchX by remember {
        mutableStateOf(0f)
    }

    var touchY by remember {
        mutableStateOf(0f)
    }




    Image(painter = painterResource(id =imageSrc), contentDescription ="Knob"
    , modifier = Modifier
            .onGloballyPositioned {
                val windowSize = it.boundsInWindow()
                centerX = windowSize.size.width / 2f
                centerY = windowSize.size.height / 2f
            }
            .size(80.dp)
            .pointerInteropFilter { event ->
                touchX = event.x
                touchY = event.y

                val angle = -atan2(centerX - touchX, centerY - touchY) * (180f / PI).toFloat()

                when (event.action) {
                    MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> {
                        if (angle !in -limitingAngle..limitingAngle) {
                            val fixedAngle =
                                if (angle in -180f..limitingAngle) 360f + angle else angle
                            rotation = fixedAngle

                            val percent = (fixedAngle - limitingAngle) / (360f - 2 * limitingAngle)
                            onValueChange(percent)
                            true
                        } else false
                    }
                    else -> false
                }


            }
            .rotate(rotation)

    )


}

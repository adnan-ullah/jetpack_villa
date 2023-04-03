@Composable
fun CircularProgressBar(
    number: Int,
    percentage: Float,
    fontSize: TextUnit = 28.sp,
    strokeWidth: Dp = 10.dp,
    radius: Dp = 80.dp,
    color: Color = Color(0xFFC71351),
    animDuration: Int = 2000,
    animDelay: Int = 10

) {
    var animationPlayed by remember {
        mutableStateOf(false)
    }

    val currentPercentage by animateFloatAsState(
        targetValue = if (animationPlayed) percentage else 0f,

        animationSpec = tween(durationMillis = animDuration, delayMillis = animDelay, LinearEasing)

    )

    LaunchedEffect(key1 = true)
    {
        animationPlayed = true
    }



    Box(
        modifier = Modifier.size(radius * 2f),
        contentAlignment = Alignment.Center
    )
    {
        Canvas(
            modifier = Modifier.size(radius * 2f),
        )
        {
            drawArc(
                color = color,
                -90f,
                sweepAngle = 360 * currentPercentage,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)

            )


        }
        Text(
            text = (currentPercentage * number).toInt().toString() + "%",
            color = color,
            fontSize = fontSize
        )

    }


}

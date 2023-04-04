
@Composable
fun HeadBar(modifier: Modifier) {
    Box(modifier = Modifier.fillMaxWidth())
    {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Icon(imageVector = Icons.Default.LocationOn, contentDescription = "AlarmList")
            Icon(imageVector = Icons.Default.Email, contentDescription = "AlarmList")
            Icon(imageVector = Icons.Default.Close, contentDescription = "AlarmList")
            Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "AlarmList")

        }
    }

}

@Composable
fun AlarmBody(
    modifier: Modifier,
    time: String
) {
    Card(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth(),
        elevation = 8.dp, backgroundColor = Color(0xFFFEFFF3)
    ) {


        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {


            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            )
            {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "$time", style = TextStyle(
                            fontSize = 28.sp,
                            color = Color(0xF146474B), fontFamily = FontFamily.SansSerif
                        )
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "am", style = TextStyle(
                            fontSize = 16.sp,
                            color = Color(0xF146474B), fontFamily = FontFamily.SansSerif
                        )
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Office Time!", style = TextStyle(
                            fontSize = 16.sp,
                            color = Color(0xF16F6F6F), fontFamily = FontFamily.SansSerif
                        )
                    )

                }
                Text(
                    text = "Brac IT is calling me.", style = TextStyle(
                        fontSize = 16.sp,
                        color = Color(0xF1911010), fontFamily = FontFamily.SansSerif
                    )
                )


            }
            var switched = remember {
                mutableStateOf(false)
            }
            Switch(
                checked = switched.value, onCheckedChange = { switched.value = !switched.value },

                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color(0xFF84C7C1),
                    checkedTrackColor = Color(0xFFFFE186),
                    uncheckedThumbColor = Color(0xFF6D6563),
                    uncheckedTrackColor = Color(0xFF191E1F),

                    )
            )

//
        }


    }
}

@Composable
fun BottomBar(modifier: Modifier) {

    val infiniteTranistion = rememberInfiniteTransition()
    val animateCOlor by infiniteTranistion.animateColor(
        initialValue = Color.Black,
        targetValue = Color.White,

        animationSpec = infiniteRepeatable(
            tween(delayMillis = 5000, durationMillis = 3000, easing = LinearOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    Button(
        modifier = Modifier
            .size(60.dp)
            .clip(CircleShape),

        colors = ButtonDefaults.buttonColors(backgroundColor = animateCOlor),

        onClick = { /*TODO*/ }) {

        Text(
            text = "+", style = TextStyle(
                fontSize = 28.sp,
                color = Color(0xF1911010), fontFamily = FontFamily.SansSerif
            )
        )
    }
}

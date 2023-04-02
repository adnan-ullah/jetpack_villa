    var btnColor by remember {
                mutableStateOf(Color.Yellow)
            }
            val scaffoldState = rememberScaffoldState()
            var textFieldState by remember {
                mutableStateOf("")
            }
            var coroutineScope = rememberCoroutineScope()
            var stringRemember by remember {
                mutableStateOf("0")

            }

            val constraints = ConstraintSet(){

                val box1 = createRefFor("up-box")
                val box2 = createRefFor("down-box")
                val guideline1 = createGuidelineFromTop(50.dp)
                val guideline2 = createGuidelineFromStart(50.dp)
                val guideline3 = createGuidelineFromEnd(50.dp)

                constrain(box1){
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(guideline3)
                    width= Dimension.fillToConstraints
                    height = Dimension.value(50.dp)
                }
                constrain(box2){
                    top.linkTo(guideline1)
                    start.linkTo(guideline2)
                    width=Dimension.value(300.dp)
                    height = Dimension.value(550.dp)
                }

                //createHorizontalChain(box1, box2, chainStyle = ChainStyle.Packed)
            }

            var sizeState by remember {
                mutableStateOf(120.dp)
            }

            val animatedSize by animateDpAsState(targetValue = sizeState ,
                spring(Spring.DampingRatioNoBouncy)
            )

          val infiniteTransition = rememberInfiniteTransition()
            val colors by infiniteTransition.animateColor(
                initialValue = Color.Black,
                targetValue = Color.White,
                animationSpec = infiniteRepeatable(
                    tween(durationMillis = 2000),
                    repeatMode = RepeatMode.Reverse
                )
            )


            Scaffold(
                modifier = Modifier.fillMaxSize(),
                scaffoldState = scaffoldState,
            ) { innerPadding ->

                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                        , horizontalAlignment = Alignment.CenterHorizontally
                , verticalArrangement = Arrangement.Center
                ) {


                    Box(modifier = Modifier
                        .size(animatedSize)
                        .fillMaxSize()
                        .background(colors),
                    contentAlignment = Alignment.Center
                        )
                    {
                        Button(onClick = { sizeState+=80.dp }) {
                            Text(text = "Clicked")
                        }
                    }


                }


            }


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

            Scaffold(
                modifier = Modifier.fillMaxSize(),
                scaffoldState = scaffoldState,
            ) { innerPadding ->

                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                ) {

                    ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
                        Box(modifier = Modifier
                            .background(Color(0xFF8CC7C2))
                            .layoutId("up-box")) {

                        }
                        Box(modifier = Modifier
                            .background(Color(0xFFFFECB3))
                            .layoutId("down-box")) {
                            Column(modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center

                            ) {
                                Text(text = "Login", style = TextStyle(color = Color.White,
                                fontSize = 32.sp
                                    ))


                                TextField(
                                    value = textFieldState,
                                    onValueChange = { newText ->
                                        textFieldState = newText
                                    },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp)
                                        .background(Color(0xFFFFFAF2)),
                                    label = { Text(text = "Email") },
                                    singleLine = true


                                )
                                TextField(
                                    value = textFieldState,
                                    onValueChange = { newText ->
                                        textFieldState = newText
                                    },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp)
                                        .background(Color(0xFFF2FFD4)),
                                    label = { Text(text = "Password") },
                                    singleLine = true


                                )
                            }
                        }

                    }


                }


            }


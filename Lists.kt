  Scaffold(
                modifier = Modifier.fillMaxSize(),
                scaffoldState = scaffoldState,
                ) {
                    innerPadding ->

                LazyColumn(

                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Color(0xFFF0F0EE)
                        )
                        .padding(paddingValues = innerPadding),


                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,

                    )
                {
                   itemsIndexed(listOf("ABC","!@#","123","<>?","/*-",))
                   {index, string->

                        Row() {
                            Text(text = "Items $index is $string" , style = TextStyle(color = Color.Red, fontSize = 25.sp, fontFamily = FontFamily.Monospace))
                            Button(onClick = {},

                                shape = CircleShape
                                ) {
                                Text(text = "Click")
                            }
                        }
                   }
}

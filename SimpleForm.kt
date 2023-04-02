   TextField(
                       value = textFieldState,
                       onValueChange = { newText ->
                           textFieldState = newText
                       },
                       modifier = Modifier
                           .fillMaxWidth()
                           .padding(10.dp),
                       label = { Text(text = "Enter your Name") },
                       singleLine = true


                   )
                   TextField(
                       value = textFieldState,
                       onValueChange = { newText ->
                           textFieldState = newText
                       },
                       modifier = Modifier
                           .fillMaxWidth()
                           .padding(10.dp),
                       label = { Text(text = "Enter your Age") },
                       singleLine = true


                   )

                   Spacer(modifier = Modifier.height(10.dp))

                   Button(

                       shape = CircleShape,
                       onClick = {
                           if(   btnColor == Color.Red)
                               btnColor = Color.Yellow
                           else
                               btnColor = Color.Red
                           coroutineScope.launch {
                               scaffoldState.snackbarHostState.showSnackbar("Hello $textFieldState")

                           }
                       },
                       colors = ButtonDefaults.buttonColors(backgroundColor =btnColor),

                       )
                   {
                       Text(text = "Click to Greet!", color = Color.White)
                   }

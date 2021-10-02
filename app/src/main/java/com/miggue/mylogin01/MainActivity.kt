package com.miggue.mylogin01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.LockOpen
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miggue.mylogin01.ui.theme.MyLogin01Theme

class MainActivity : ComponentActivity() {
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyLogin01Theme {
                SigInScreen()
            }
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun SigInScreen() {
    var username by remember{ mutableStateOf("")}
    var password by remember{ mutableStateOf("")}
    val (focusUsername,focusPassword) = remember {FocusRequester.createRefs()}
    val keyboardController =  LocalSoftwareKeyboardController.current
    var isPasswordVisible by remember{mutableStateOf(false)}

    Scaffold() {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.30f),
                Alignment.TopEnd,
            ){
                Image(painter = painterResource(id = R.drawable.ic_shape), contentDescription = "",
                    modifier = Modifier.fillMaxSize(),contentScale = ContentScale.FillBounds
                    )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(horizontal = 20.dp, vertical = 50.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painter = painterResource(id = R.drawable.ic_flower), contentDescription = "Logo App",
                        modifier = Modifier
                            .weight(1f)
                            .size(100.dp),
                        colorFilter = ColorFilter.tint(Color.White)
                        )
                    Text(text = "Welcome",fontSize = 20.sp,color = Color.White)
                }

            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)) {
                Text(text = "Log in", style = MaterialTheme.typography.h1)
                OutlinedTextField(value = username, onValueChange = {username = it},
                    modifier = Modifier
                        .fillMaxWidth()
                        .focusRequester(focusUsername),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(onNext = {focusPassword.requestFocus()}),
                    singleLine = true,
                    label = {Text(text = "Username")}
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .focusRequester(focusPassword),
                    value = password,
                    onValueChange ={password = it},
                    label = { Text(text = "Password")},
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password,imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions (onDone = {keyboardController?.hide()}),
                    visualTransformation = if(isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = {isPasswordVisible = !isPasswordVisible}) {
                            Icon(imageVector = if(isPasswordVisible)Icons.Default.LockOpen else Icons.Default.Lock,
                                contentDescription ="Password Toggle" )

                        }
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),Arrangement.SpaceBetween
                ){
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(checked = true, onCheckedChange = {})
                        Text(text = "Remember me",fontSize = 12.sp)
                    }
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "Forgot Password",fontSize = 12.sp)
                    }

                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { /*TODO*/ },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(text = "Log in")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),Arrangement.Center
                ){
                    Text(text = "Or log in with", fontSize =14.sp)
                }
                Row(modifier = Modifier.fillMaxWidth(),Arrangement.SpaceAround){
                    Button(onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(50),
                        modifier = Modifier
                            .height(45.dp)
                            .width(45.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                    ) {
                        Image(painter = painterResource(id = R.drawable.ic_fb), contentDescription = "Facebook logo",
                            modifier = Modifier
                                .weight(1f)
                                .size(40.dp),
                            colorFilter = ColorFilter.tint(MaterialTheme.colors.secondary)
                            )
                    }
                    Button(onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(50),
                        modifier = Modifier
                            .height(45.dp)
                            .width(45.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                    ) {
                        Image(painter = painterResource(id = R.drawable.ic_google), contentDescription = "Google logo",
                            modifier = Modifier
                                .weight(1f)
                                .size(40.dp),
                            colorFilter = ColorFilter.tint(MaterialTheme.colors.secondary)
                        )
                    }
                    Button(onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(50),
                        modifier = Modifier
                            .height(45.dp)
                            .width(45.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                    ) {
                        Image(painter = painterResource(id = R.drawable.ic_twitter), contentDescription = "Twitter logo",
                            modifier = Modifier
                                .weight(1f)
                                .size(40.dp),
                            colorFilter = ColorFilter.tint(MaterialTheme.colors.secondary)
                        )
                    }

                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(modifier = Modifier.fillMaxWidth(),Arrangement.Center,verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Don't have account?",fontSize = 14.sp)
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "Register")
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }


    }
}

@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyLogin01Theme {
        SigInScreen()
    }
}
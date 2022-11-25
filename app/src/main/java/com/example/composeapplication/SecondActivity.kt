package com.example.composeapplication

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeapplication.ui.theme.ComposeApplicationTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val bundle: Bundle? = intent.extras
                    val message = bundle!!.getString("value")
                    Greeting2(message!!)
                }
            }
        }
    }
}

fun Context.findActivity(): Activity? = when (this) {
    is Activity -> this
    is ContextWrapper -> baseContext.findActivity()
    else -> null
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Message received: $name", color = Color.White)
}

@Preview(showBackground = false)
@Composable
fun DefaultPreview2() {
    ComposeApplicationTheme {

        val context = LocalContext.current
        val activity = context.findActivity()
        val intent = activity?.intent

        val bundle: Bundle? = intent!!.extras
        val message = bundle!!.getString("value")
        Greeting2(message!!)
    }
}
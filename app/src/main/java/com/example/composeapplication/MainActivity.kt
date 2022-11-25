package com.example.composeapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.startActivity
import com.example.composeapplication.ui.theme.ComposeApplicationTheme

class MainActivity : ComponentActivity() {
    var msg: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background)
                {
                    UIBox()
                }
            }
        }
    }
}

@Composable
fun UIBox() {
    val context = LocalContext.current
    val intent = Intent(context, SecondActivity::class.java)
    intent.putExtra("value", "\"This is static message coming from screen\"")
    Button(onClick = {
        context.startActivity(intent)
    }) {
        Text(text = "Next Screen")
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeApplicationTheme {
        UIBox()
    }
}
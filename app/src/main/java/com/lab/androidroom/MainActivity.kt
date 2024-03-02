package com.lab.androidroom

import android.os.Bundle
import android.provider.BaseColumns
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lab.androidroom.ui.theme.AndroidRoomLabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidRoomLabTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }

        val databaseHelper = DatabaseHelper(this)
        databaseHelper.execRawQuery(CREATE_QUERY)
        databaseHelper.execSelectQuery(SELECT_QUERY)
    }

    companion object {
        private const val CREATE_QUERY = "CREATE TABLE TEST (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NAME TEXT, PHONE_NUM TEXT)"
        private const val SELECT_QUERY = "SELECT * FROM NAME"
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidRoomLabTheme {
        Greeting("Android")
    }
}
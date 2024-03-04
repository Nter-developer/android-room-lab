package com.lab.androidroom

import android.os.Bundle
import android.provider.BaseColumns
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
                    SimpleFilledTextFieldSample()
                }
            }
        }

        val databaseHelper = DatabaseHelper(this)
        databaseHelper.execRawQuery(SAMPLE_QUERY_CREATE)
        databaseHelper.execRawQuery(SAMPLE_QUERY_INSERT)
        databaseHelper.execSelectQuery(SAMPLE_QUERY_SELECT)
    }

    companion object {
        private const val SAMPLE_QUERY_CREATE =
            "CREATE TABLE SAMPLE (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, LAST_NAME TEXT)"
        private const val SAMPLE_QUERY_INSERT = "INSERT INTO SAMPLE (NAME, LAST_NAME) VALUES ('James', 'King')"
        private const val SAMPLE_QUERY_SELECT = "SELECT * FROM SAMPLE"
    }
}

@Composable
fun SimpleFilledTextFieldSample() {
    var text by remember { mutableStateOf("Hello") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") }
    )
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
package ac.id.utdi.allfinemaulinaro.artspace

import android.os.Bundle
import androidx.compose.foundation.layout.Spacer
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.width
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ac.id.utdi.allfinemaulinaro.artspace.ui.theme.ArtSpaceTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpace("Android")
                }
            }
        }
    }
}

@Composable
fun ArtSpace(name: String, modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    val imageResource = when (result) {
        1 -> R.drawable.candi_borobudur
        2 -> R.drawable.candi_prambanan
        3 -> R.drawable.heha_view_sky
        4 -> R.drawable.tugu_jogja
        else -> R.drawable.malioboro
    }

    val titleTextResource = when(result){
        1 -> R.string.title_candi_borobudur
        2 -> R.string.title_candi_prambanan
        3 -> R.string.title_heha_view_sky
        4 -> R.string.title_tugu_jogja
        else -> R.string.title_malioboro
    }

    val bodyTextResource = when(result){
        1 -> R.string.body_candi_borobudur
        2 -> R.string.body_candi_prambanan
        3 -> R.string.body_heha_view_sky
        4 -> R.string.body_tugu_jogja
        else -> R.string.body_malioboro
    }

    Column{
        Box {
            Text(
                text = "List Tempat Wisata Jogja",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(imageResource),
                contentDescription = result.toString(),
                modifier = Modifier
                    .width(500.dp)
                    .height(400.dp)
            )
        }
        Text(
            text = stringResource(titleTextResource),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = stringResource(bodyTextResource))
//        Spacer(modifier = Modifier.width(8.dp))
        Row{
            Box {
                Button(onClick = {
                    result = when (result) {
                        5 -> 4
                        4 -> 3
                        3 -> 2
                        2 -> 1
                        else -> 5
                    }
                }) {
                    Text(text = "Perv")
                }
            }
            Box {
                Button(onClick = {
                    result = when (result) {
                        1 -> 2
                        2 -> 3
                        3 -> 4
                        4 -> 5
                        else -> 1
                    }
                }) {
                    Text(text = "Next")
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpace("Android")
    }
}
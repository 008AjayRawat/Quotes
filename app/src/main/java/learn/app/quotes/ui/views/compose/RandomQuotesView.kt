package learn.app.quotes.ui.views.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import learn.app.quotes.R
import learn.app.quotes.ui.theme.Blue_322C80
import learn.app.quotes.ui.theme.Grey_212121
import learn.app.quotes.ui.theme.Pink_9F356F
import learn.app.quotes.ui.theme.Poppins
import learn.app.quotes.ui.viewmodel.QuoteViewModel
import java.util.*

@Composable
fun RandomQuotesView(
    quoteViewModel: QuoteViewModel
) {
    //State
    val quoteData = quoteViewModel.randomQuote.observeAsState()

    //Launched Effect for re-composition
    //API Call
    LaunchedEffect(key1 = Unit) {
        quoteViewModel.getRandomQuote()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(colors = listOf(Blue_322C80, Pink_9F356F))),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.padding(top = 30.dp))

        Text(
            text = stringResource(R.string.quotes),
            color = Color.White,
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.padding(top = 100.dp))

//        QuotesCard(
//            "Genius is one percent inspiration and ninety-nine percent perspiration",
//            "Thomas Edison"
//        )

        QuotesCard(
            quoteData.value?.data?.content ?: "",
            quoteData.value?.data?.author ?: ""
        )

        Spacer(modifier = Modifier.padding(top = 30.dp))

        Button(
            onClick = { quoteViewModel.getRandomQuote() },
            colors = ButtonDefaults.buttonColors(containerColor = Grey_212121),
            modifier = Modifier.fillMaxWidth(0.6F),
            shape = RoundedCornerShape(8.dp),
        ) {
            Text(
                text = stringResource(R.string.refresh).toUpperCase(Locale.getDefault()),
                color = Color.White,
                fontFamily = Poppins,
                fontWeight = FontWeight.Medium,
                fontSize = 21.sp
            )
        }

    }
}


@Composable
fun QuotesCard(
    quote: String,
    author: String,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.padding(20.dp)) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 200.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(4.dp),
            shape = RoundedCornerShape(16.dp)
        ) {

            Column(modifier = Modifier.padding(15.dp)) {

                Icon(
                    painter = painterResource(id = R.drawable.ic_quote_left_96x96),
                    contentDescription = null
                )

                Text(
                    text = quote,
                    style = MaterialTheme.typography.displayMedium,
                    color = Grey_212121,
                    modifier = Modifier.padding(
                        top = 20.dp, bottom = 20.dp
                    )
                )

                Text(
                    text = author,
                    style = MaterialTheme.typography.displaySmall,
                    color = Grey_212121,
                    modifier = Modifier.padding(
                        top = 10.dp, bottom = 10.dp
                    )
                )

            }
        }

    }

}



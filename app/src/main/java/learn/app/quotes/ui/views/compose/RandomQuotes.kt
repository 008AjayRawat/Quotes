package learn.app.quotes.ui.views.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import learn.app.quotes.R
import learn.app.quotes.data.models.domain.QuoteDomain
import learn.app.quotes.ui.theme.Grey_212121
import learn.app.quotes.ui.viewmodel.QuoteViewModel
import learn.app.quotes.utils.network.Loading
import learn.app.quotes.utils.network.Success
import learn.app.quotes.utils.network.Error

@Composable
fun RandomQuotesView(
    quoteViewModel: QuoteViewModel,
    onClick: () -> Unit
) {

    var quoteData: QuoteDomain? by remember { mutableStateOf(null) }
    when (val quoteDataStatus = quoteViewModel.randomQuote.observeAsState().value) {
        is Error -> {}
        is Success -> {
            quoteData = quoteDataStatus.data
        }
        is Loading -> {}
        else -> {}
    }

    //UI Elements
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier.padding(
                top = 20.dp,
                start = 20.dp,
                end = 20.dp
            )
        )


        RandomQuotesText(
            quote = quoteData?.content ?: "",
            onClick = onClick
        )
    }
}


@Composable
fun RandomQuotesText(
    quote: String,
    onClick: () -> Unit
) {
    Text(
        text = quote,
        fontSize = 21.sp,
        fontFamily = FontFamily.Cursive,
        color = Grey_212121,
        modifier = Modifier.clickable {
            onClick.invoke()
        }
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
//        QuotesTheme {
//            RandomQuotesView(
//                quoteDomain =
//                QuoteDomain(
//                    "",
//                    "Ui using Jetpack Compose!!",
//                    "",
//                    "",
//                    listOf("")
//                )
//            ) {}
//        }
    }
}
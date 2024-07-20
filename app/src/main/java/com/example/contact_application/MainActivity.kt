package com.example.contact_app

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contact_application.ui.theme.Contact_ApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Contact_ApplicationTheme {
                Scaffold (modifier = Modifier.fillMaxSize()
                    ,topBar = {MyTopBar()}
                ){
                        innerPadding->
                    Box(modifier = Modifier.padding(innerPadding)){
                        DataList(data = DataSource().getDataItems())
                    }
                }
            }
        }
    }
}

@Composable
fun DataList(data:List<Data>){
    LazyVerticalGrid(columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxSize()
    ){
        items(data){item->
            PhoneCall(data = item)
        }
    }
}



@Composable
fun PhoneCall( data:Data ,modifier: Modifier=Modifier) {

    val context= LocalContext.current

    Column(horizontalAlignment = Alignment.CenterHorizontally
        , verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier.clickable {
                var intet= Intent(Intent.ACTION_DIAL)
                intet.setData(Uri.parse("tel:${data.number}"))
                context.startActivity(intet)
            }

            ,painter = painterResource(id = data.image)
            , contentDescription = null
        )


        Text(text = stringResource(id = data.name)
            , textAlign = TextAlign.Center
            , fontFamily = FontFamily.Serif
            , fontWeight = FontWeight.ExtraBold
            , fontSize = 20.sp
            ,modifier = Modifier
                .padding(top = 8.dp)
        )


        SelectionContainer(
            modifier = Modifier.align(Alignment.CenterHorizontally))
        {
            Text(textAlign = TextAlign.Center
                , fontWeight = FontWeight.Light
                ,modifier = Modifier
                    .padding(top = 8.dp)
                ,text = stringResource(id = data.number)
                , fontSize = 20.sp)
        }
    }
}




@Preview(showBackground = true)
@Composable
fun PhoneCallPreview() {
    PhoneCall(data = DataSource().getDataItems()[0])
}
package com.example.contact_app

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.contact_application.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    TopAppBar(
        modifier = modifier,
        title = { Text(text = "Contacts App") },
        actions = {
            Icon(
                painter = painterResource(id = R.drawable.icon_home),
                contentDescription = "Home",
                modifier = Modifier
                    .padding(end = 10.dp)
                    .size(30.dp)
                    .clickable {
                        val phoneNumber = "123548"
                        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                        context.startActivity(intent)
                    }
            )
        }
    )
}

@Preview
@Composable
private fun TopBarPreview() {
    MyTopBar()
}

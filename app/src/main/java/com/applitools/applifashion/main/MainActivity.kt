package com.applitools.applifashion.main


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.applitools.applifashion.main.ui.theme.MyApplicationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}




@Preview(showSystemUi = true)
@Composable
fun MainContent(){
    val result = remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(

                title = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_launcher_applifashion_logo),
                        contentDescription = null // decorative element
                    )
                },
                Modifier.padding(10.dp),

                actions = {
                    IconButton(onClick = {
                        result.value = "Search icon clicked"
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search_icon),
                            contentDescription = null // decorative element
                        )
                    }
                    IconButton(onClick = {
                        result.value = "Profile icon clicked"
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_user_profile_icon),
                            contentDescription = null // decorative element
                        )
                    }
                    IconButton(onClick = {
                        result.value = "Shopping bag icon clicked"
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_shopping_bag),
                            contentDescription = null // decorative element
                        )
                    }
                },

                backgroundColor = Color(0xFFFFFFFF),
                elevation = AppBarDefaults.TopAppBarElevation

            )
        },

        content = {

            Box(
                Modifier
//                    .background(Color(0XFFE3DAC9))
//                    .padding(16.dp)
                    .fillMaxSize(),
            ) {

                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    Column(modifier = Modifier
                        .verticalScroll(rememberScrollState())
                    ) {
                        PopulateData()
                        Footer()
                    }

                }
            }

        },
    )
}

@Composable
fun Footer() {
    Row(
        Modifier
                    .background(Color(0XFF192133))
                    .padding(10.dp)
    ) {
        Column(
            ) {
            Text(
                text = "Quick Links",

                color = Color.White,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(start = 20.dp, bottom = 5.dp)
                       .clickable(enabled = true) {}
            )
            Text(
                text = "About us",
                color = Color.White,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(start = 20.dp, bottom = 5.dp)
                    .clickable(enabled = true) {}
            )
            Text(
                text = "Faq",
                color = Color.White,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(start = 20.dp, bottom = 5.dp)
                    .clickable(enabled = true) {}

            )
            Text(
                text = "My account",
                color = Color.White,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(start = 20.dp, bottom = 5.dp)
                    .clickable(enabled = true) {}

            )
            Text(
                text = "Blog",
                color = Color.White,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(start = 20.dp, bottom = 5.dp)
                    .clickable(enabled = true) {}

            )
            Text(
                text = "Contacts",
            color = Color.White,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(start = 20.dp, bottom = 5.dp)
                .clickable(enabled = true) {}
            )
        }
        Column( modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Contacts",
                color = Color.White,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(start = 20.dp)
            )
            Row() {
                Icon(
                    Icons.Outlined.Home,
                    tint = Color.White,
                    contentDescription = null, // decorative element,
                    modifier = Modifier.padding(start = 10.dp, top = 5.dp)
                )
                Text(
                    text = "155 Bovet Rd #600\n" +
                            "San Mateo, CA 94402",
                    color = Color.White,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(start = 20.dp, bottom = 5.dp)
                )
            }
            Row() {
                Icon(
                    Icons.Outlined.MailOutline,
                    tint = Color.White,
                    contentDescription = null, // decorative element,

                )
                Text(

                    text = "srd@applitools.com",
                    color = Color.White,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(start = 20.dp)
                )
            }

            }
        }

}


@Composable
fun PopulateData() {



    Row(
    ) {
        CustomColumn(
            name = "Appli Air x Night",
            painter = painterResource(id = R.drawable.dress_shoes),
            "$33.00",
            "$48.00"
        )

        CustomColumn(
            name = "Appli ACG React",
            painter = painterResource(id = R.drawable.yellow_shoes),
            "$110.00",

        )
    }
//    Row(
//    ) {
//        CustomColumn(
//            name = "Appli Air Zoom",
//            painter = painterResource(id = R.drawable.orange_shoes),
//            "$140.00",
//        )
//
//        CustomColumn(
//            name = "Appli Air Wild",
//            painter = painterResource(id = R.drawable.blue_shoes),
//            "$52.00",
//            oldCost = "75.00"
//        )
//    }
//        Row(
//        ) {
//            CustomColumn(
//                name = "Appli Air Alpha",
//                painter = painterResource(id = R.drawable.green_shoes),
//                "$170.00",
//            )
//
//            CustomColumn(
//                name = "Appli Air 98",
//                painter = painterResource(id = R.drawable.purple_shoes),
//                "$190.00",
//            )
//        }
//        Row(
//        ) {
//            CustomColumn(
//                name = "Appli Air 720",
//                painter = painterResource(id = R.drawable.black_shoes),
//                "$200.00",
//            )
//
//            CustomColumn(
//                name = "Appli Okwahn II",
//                painter = painterResource(id = R.drawable.white_shoes),
//                "$62.00",
//                "$90.00"
//            )
//        }

}

@Composable
fun CustomColumn(
    name:String,
    painter: Painter,
    currentCost: String,
    oldCost: String = "",
){
    Column(
        modifier = Modifier
            .padding(12.dp)
            .background(MaterialTheme.colors.surface)
    ) {
        Box(
            modifier = Modifier
                .padding(start = 20.dp)
        ) {
            if (oldCost != "") {
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.discount),
                        contentDescription = "",
                    )
                    Image(
//                        modifier = Modifier.fillMaxSize(1f),
                        painter = painter, contentDescription = "",
                    )
                    Image(
                        painter = painterResource(id = R.drawable.one_day_left),
                        contentDescription = "",
                        Modifier.align(Alignment.CenterHorizontally)
                    )
                }
            } else {

                Image(
                    painter = painter, contentDescription = "" ,
                    modifier = Modifier.padding(0.dp, 22.dp)
                )
            }

//            Image(
//                modifier = Modifier.size(20.dp).align(Alignment.BottomEnd),
//                painter = icon, contentDescription = "icon"
//            )
        }
        Column {
            Text(
                text = name,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(start = 20.dp)
            )
            Row (Modifier.align(Alignment.CenterHorizontally)){
                Text(
                    text = currentCost,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(start = 20.dp)
                )
                if (oldCost != "") {
                    Text(
                        text = oldCost,
                        style = (MaterialTheme.typography).h6
                            .merge(TextStyle(textDecoration = TextDecoration.LineThrough)),
                        color = Color.Gray,
                        modifier = Modifier.padding(start = 20.dp)
                    )
                }
            }
            Row(Modifier.align(Alignment.CenterHorizontally)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_like_icon),
                    contentDescription = null, // decorative element,
                    modifier = Modifier
                        .padding(5.dp)
                        .size(30.dp)
//                    modifier = Modifier.padding(start = 20.dp)

                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_random_icon),
                    contentDescription = null, // decorative element
                    modifier = Modifier
                        .padding(5.dp)
                        .size(30.dp)
//                            modifier = Modifier.padding(start = 40.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_shopping_cart_icon),
                    contentDescription = null, // decorative element
                            modifier = Modifier
                                .padding(5.dp)
                                .size(30.dp)
                )
            }

        }
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

//@Composable
//fun DefaultPreview() {
//    MyApplicationTheme {
//        Greeting("Android")
//    }
//}
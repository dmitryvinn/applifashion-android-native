package com.applitools.applifashion.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true)
@Composable
fun ProductPage() {
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
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search_icon),
                            contentDescription = null // decorative element
                        )
                    }
                    IconButton(onClick = {
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_user_profile_icon),
                            contentDescription = null // decorative element
                        )
                    }
                    IconButton(onClick = {
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



                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    Column(modifier = Modifier
                        .verticalScroll(rememberScrollState())
                    ) {
                        ProductData(            name = "Appli Air x Night",
                            painter = painterResource(id = R.drawable.dress_shoes),
                            "$33.00",
                            "$48.00")
                    }

                }


        },
    )
}

@Composable
fun ProductData(name:String,
                painter: Painter,
                currentCost: String,
                oldCost: String = "") {
    Column(
        modifier = Modifier
            .padding(12.dp)
            .background(MaterialTheme.colors.surface)
    ) {

//            modifier = Modifier
//                .padding(start = 20.dp)
//                .fillMaxSize()
//        ) {
//            if (oldCost != "") {
//                Column {
//                    Image(
//                        painter = painterResource(id = R.drawable.discount),
//                        contentDescription = "",
//                    )
//                    Image(
////                        modifier = Modifier.fillMaxSize(1f),
//                        painter = painter, contentDescription = "",
//                    )
//                    Image(
//                        painter = painterResource(id = R.drawable.one_day_left),
//                        contentDescription = "",
//                        Modifier.align(Alignment.CenterHorizontally)
//                    )
//                }
//            } else {
                Text(
                    text = name,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(start = 20.dp)
                )
                Image(
                    painter = painter, contentDescription = "" ,
                    modifier = Modifier.padding(start=0.dp, top = 40.dp).scale(2f).fillMaxWidth()
                )
//            }

//            Image(
//                modifier = Modifier.size(20.dp).align(Alignment.BottomEnd),
//                painter = icon, contentDescription = "icon"
//            )

        Column (Modifier.fillMaxSize()){

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
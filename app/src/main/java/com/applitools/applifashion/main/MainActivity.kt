package com.applitools.applifashion.main


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.SimpleAdapter
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
import androidx.core.content.ContextCompat.startActivity
import com.applitools.applifashion.main.data.model.Shoe
import com.applitools.applifashion.main.ui.theme.MyApplicationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    // Main List
                    ShopView()
//
//                    // Product Page
//                    ProductPage(shoe = Shoe(
//                        "Appli ACG React",
//                        painterResource(id = R.drawable.yellow_shoes),
//                        "$110.00"))
//
//                    ProductPage(shoe = Shoe(
//                        "Appli Air Wild",
//                        painterResource(id = R.drawable.blue_shoes),
//                        "$52.00",
//                        "$75.00"))
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ShopView(){
//    var intent = ProductActivity.newIntent(activity, Shoe("Appli Air x Night",
//        painterResource(id = R.drawable.dress_shoes),
//        "$33.00",
//        "$48.00"));
////
////            intent.putExtra("Name", "Rinky")
////
////            intent.putExtra("Age", 12)
////
////            intent.putExtra("IsMale", true)
//
//    activity.startActivity(intent)

    Scaffold(
        topBar = { NavigationMenu() },

        content = {
            Box(
                Modifier
                    .fillMaxSize(),
            ) {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    Column(modifier = Modifier
                        .verticalScroll(rememberScrollState())
                    ) {
                        PopulateShowData()
                        Footer()
                    }
                }
            }
        },
    )
}

@Composable
fun PopulateShowData() {
    Row(
    ) {
        CustomColumn(Shoe("Appli Air x Night",
            painterResource(id = R.drawable.dress_shoes),
            "$33.00",
            "$48.00")
        )

        CustomColumn(Shoe(
            "Appli ACG React",
            painterResource(id = R.drawable.yellow_shoes),
            "$110.00")
        )
    }
    Row(
    ) {
        CustomColumn(Shoe(
            "Appli Air Zoom",
            painterResource(id = R.drawable.orange_shoes),
            "$140.00")
        )

        CustomColumn(Shoe(
            "Appli Air Wild",
            painterResource(id = R.drawable.blue_shoes),
            "$52.00",
            "$75.00")
        )
    }
        Row(
        ) {
            CustomColumn(Shoe(
                "Appli Air Alpha",
                painterResource(id = R.drawable.green_shoes),
                "$170.00")
            )

            CustomColumn(Shoe(
                "Appli Air 98",
                painterResource(id = R.drawable.purple_shoes),
                "$190.00")
            )
        }
        Row(
        ) {
            CustomColumn(Shoe(
                "Appli Air 720",
                painterResource(id = R.drawable.black_shoes),
                "$200.00")
            )

            CustomColumn(Shoe(
                "Appli Okwahn II",
                painterResource(id = R.drawable.white_shoes),
                "$62.00",
                "$90.00")
            )
        }

}

@Composable
fun CustomColumn(shoe: Shoe){
    Column(
        modifier = Modifier
            .padding(12.dp)
            .background(MaterialTheme.colors.surface)
    ) {
        Box(
            modifier = Modifier
                .padding(start = 20.dp)

        ) {
            if (shoe.oldPrice.isNotEmpty()) {
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.discount),
                        contentDescription = "",
                    )
                    Image(
//                        modifier = Modifier.clickable(onClick = {
//                            ProductPage(name = name, painter = painter, currentCost = currentCost,
//                                oldCost = oldCost)
//                        }),
                        painter = shoe.imageResource, contentDescription = "",
                    )
                    Image(
                        painter = painterResource(id = R.drawable.one_day_left),
                        contentDescription = "",
                        Modifier.align(Alignment.CenterHorizontally)
                    )
                }
            } else {
                Image(
                    painter = shoe.imageResource, contentDescription = "",
                    modifier = Modifier.padding(0.dp, 22.dp)
                )
            }

        }
        Column {
            Text(
                text = shoe.name,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(start = 20.dp)
            )
            Row (Modifier.align(Alignment.CenterHorizontally)){
                Text(
                    text = shoe.currentPrice,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(start = 20.dp)
                )
                if (shoe.oldPrice.isNotEmpty()) {
                    Text(
                        text = shoe.oldPrice,
                        style = (MaterialTheme.typography).h6
                            .merge(TextStyle(textDecoration = TextDecoration.LineThrough)),
                        color = Color.Gray,
                        modifier = Modifier.padding(start = 20.dp)
                    )
                }
            }
            Row(Modifier.align(Alignment.CenterHorizontally)) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_like_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(5.dp)
                        .size(30.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_random_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(5.dp)
                        .size(30.dp)
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
fun NavigationMenu () {
    return TopAppBar(
        title = {
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_applifashion_logo),
                contentDescription = null
            )
        },
        Modifier.padding(10.dp),
        actions = {
            IconButton(onClick = {
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search_icon),
                    contentDescription = null
                )
            }
            IconButton(onClick = {
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_user_profile_icon),
                    contentDescription = null
                )
            }
            IconButton(onClick = {
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_shopping_bag),
                    contentDescription = null
                )
            }
        },
        backgroundColor = Color(0xFFFFFFFF),
        elevation = AppBarDefaults.TopAppBarElevation
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
                modifier = Modifier
                    .padding(start = 20.dp, bottom = 5.dp)
                    .clickable(enabled = true) {}
            )
            Text(
                text = "About us",
                color = Color.White,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(start = 20.dp, bottom = 5.dp)
                    .clickable(enabled = true) {}
            )
            Text(
                text = "Faq",
                color = Color.White,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(start = 20.dp, bottom = 5.dp)
                    .clickable(enabled = true) {}

            )
            Text(
                text = "My account",
                color = Color.White,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(start = 20.dp, bottom = 5.dp)
                    .clickable(enabled = true) {}

            )
            Text(
                text = "Blog",
                color = Color.White,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(start = 20.dp, bottom = 5.dp)
                    .clickable(enabled = true) {}

            )
            Text(
                text = "Contacts",
                color = Color.White,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(start = 20.dp, bottom = 5.dp)
                    .clickable(enabled = true) {}
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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
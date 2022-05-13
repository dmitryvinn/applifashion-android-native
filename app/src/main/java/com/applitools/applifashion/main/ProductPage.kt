package com.applitools.applifashion.main

import android.content.res.Resources
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.applitools.applifashion.main.data.model.Shoe


var review: String = "These boots are comfortable enough to wear all day. Well made. I love the “look”. Best Used For Casual Everyday Walk fearlessly into the cooler months in the Sorel Joan Of Arctic Wedge II Chelsea Boot. Boasting the iconic wedge platform that\'s as comfortable as it is stylish, this boot features a waterproof upper.";
val sizes = mutableListOf<String>("Small (S)", "M", "L", "XL")

@Composable
fun SizeSelection() {

    Row(Modifier
        .padding(start = 20.dp, top = 20.dp, end = 20.dp)) {
        Column(Modifier.align(Alignment.CenterVertically)) {
            Text(text = "Size", modifier = Modifier.padding(23.dp))
        }

        Box(modifier = Modifier.width(150.dp)) {

            // State variables
            var sizeState: String by remember { mutableStateOf(sizes[0]) }
            var expanded by remember { mutableStateOf(false)}
            val icon = if (expanded) Icons.Filled.ArrowDropDown else Icons.Filled.ArrowDropDown
            val focusManager = LocalFocusManager.current

            Column {
                OutlinedTextField(
                    value = sizeState,
                    readOnly = true,
                    onValueChange = {},
                    trailingIcon = {
                        Icon(icon, null)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .onFocusChanged {
                            expanded = it.isFocused
                        }
                )

                DropdownMenu(expanded = expanded, onDismissRequest = {
                    expanded = false
                }) {
                    sizes.forEach { shoeSize ->
                        DropdownMenuItem(onClick = {
                            expanded = false
                            sizeState = shoeSize
                        }) {
                            Text(text = shoeSize)
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun QuantitySelection() {
    Row(Modifier
                .padding(start = 20.dp)) {
        Column(Modifier.align(Alignment.CenterVertically)) {
            Text(text = "Quantity", modifier = Modifier.padding(start = 10.dp, top = 10.dp,
                end=10.dp, bottom = 10.dp))
        }

        Row(modifier = Modifier.width(150.dp)) {
            var text by remember { mutableStateOf("1") }
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }
    }


}

@Composable
fun ProductPage(shoe: Shoe) {
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
                        ProductData(            shoe.name,
                            shoe.imageResource,
                            shoe.currentPrice,
                            shoe.oldPrice)
//                        name = "Appli Air x Night",
//                        painter = painterResource(id = R.drawable.dress_shoes),
//                        "$33.00",
//                        "$48.00")
                    }

                }


        },
    )
}

@Composable
fun ShowPrice(currentCost: String,
              oldCost: String = "") {
    Row (Modifier.padding(top = 20.dp)) {
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




            Button(
                // below line is use to add onclick
                // parameter for our button onclick
                onClick = {
                    // when user is clicking the button
                    // we are displaying a toast message.
                },
                // in below line we are using modifier
                // which is use to add padding to our button
            modifier = Modifier.padding(start = 30.dp, top = 10.dp),

                // below line is use to set or
                // button as enable or disable.
                enabled = true,

                // below line is use to
                // add border to our button.
                border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Blue)),

                // below line is use to add shape for our button.
                shape = MaterialTheme.shapes.medium,
            )
            // below line is use to
            // add text on our button
            {
                Text(text = "Add to Cart", color = Color.White)
            }



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
                    modifier = Modifier.padding(start = 20.dp, bottom=40.dp)
                )
                Image(
                    painter = painter, contentDescription = "" ,
                    modifier = Modifier
                        .padding(start = 0.dp, top = 40.dp)
                        .scale(2f)
                        .fillMaxWidth()
                )
//            }

//            Image(
//                modifier = Modifier.size(20.dp).align(Alignment.BottomEnd),
//                painter = icon, contentDescription = "icon"
//            )

        Column (Modifier.fillMaxSize()){

            Row() {
                Image(
                    painter = painterResource(id = R.drawable.review_rating),
                    contentDescription = "",
                )
                Text(

                    text = "4 reviews",
                    color = Color.Gray,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(start = 20.dp)
                )
            }
            Text(
                text = "SKU: MTKRY-001",
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(start = 20.dp)
            )
            Text(
                text = review,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(start = 20.dp, end = 20.dp)
            )
            Column(Modifier.align(Alignment.End)) {
                SizeSelection()
                QuantitySelection()
            }

            Row {
                ShowPrice(currentCost, oldCost)
            }
//            Row (Modifier.align(Alignment.CenterHorizontally)){
//                Text(
//                    text = currentCost,
//                    style = MaterialTheme.typography.h6,
//                    modifier = Modifier.padding(start = 20.dp)
//                )
//                if (oldCost != "") {
//                    Text(
//                        text = oldCost,
//                        style = (MaterialTheme.typography).h6
//                            .merge(TextStyle(textDecoration = TextDecoration.LineThrough)),
//                        color = Color.Gray,
//                        modifier = Modifier.padding(start = 20.dp)
//                    )
//                }
//            }
//            Row(Modifier.align(Alignment.CenterHorizontally)
//            ) {
//
//            }

        }
    }



}
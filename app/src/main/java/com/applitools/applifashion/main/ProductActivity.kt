package com.applitools.applifashion.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.applitools.applifashion.main.data.model.Shoe
import com.applitools.applifashion.main.ui.theme.MyApplicationTheme

class ProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {

                    ProductPage(shoe = Shoe(
                        "Appli ACG React",
                        painterResource(id = R.drawable.yellow_shoes),
                        "$110.00"))
                }
            }
        }
    }


    private val shoe: Shoe by lazy {
        intent?.getSerializableExtra(SHOE_ID) as Shoe
    }

    companion object {
        private const val SHOE_ID = "shoe_id"
        fun newIntent(context: Context, shoe: Shoe) =
            Intent(context, ProductActivity::class.java).apply {
                putExtra(SHOE_ID, shoe)
            }
    }
}
package com.ditsdev.ngopi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ditsdev.ngopi.model.Menu
import com.ditsdev.ngopi.model.dummyBestSellerMenu
import com.ditsdev.ngopi.model.dummyCategory
import com.ditsdev.ngopi.model.dummyMenu
import com.ditsdev.ngopi.ui.theme.NgopiTheme
import com.ditsdev.ngopi.ui.theme.components.CardMenuItem
import com.ditsdev.ngopi.ui.theme.components.CategoryItem
import com.ditsdev.ngopi.ui.theme.components.HomeSection
import com.ditsdev.ngopi.ui.theme.components.Search

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NgopiTheme {
                NgopiApp()
            }
        }
    }
}

@Composable
fun NgopiApp() {
    Column {
        Banner()
        HomeSection(
            title = stringResource(R.string.section_category),
            content = { CategoryRow() }
        )
        HomeSection(
            title = stringResource(R.string.section_favorite_menu),
            content = { MenuRow(dummyMenu) }
        )
        HomeSection(
            title = stringResource(R.string.section_best_seller_menu),
            content = { MenuRow(dummyBestSellerMenu) }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NgopiTheme {
        NgopiApp()
    }
}

@Composable
fun Banner(modifier: Modifier = Modifier) {
    Box(modifier = modifier.padding(top = 20.dp)) {
        Image(
            painter = painterResource(R.drawable.banner),
            contentDescription = "Banner Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(160.dp)
        )
        Search()
    }
}

@Composable
fun CategoryRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(dummyCategory, key = { it.textCategory }) { category ->
            CategoryItem(category)
        }
    }
}

@Composable
fun MenuRow(
    menu: List<Menu>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(menu, key = { it.title }) { menu ->
            CardMenuItem(menu)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CategoryRowPreview() {
    NgopiTheme {
        CategoryRow()
    }
}
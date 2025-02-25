package com.ditsdev.ngopi.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ditsdev.ngopi.R
import com.ditsdev.ngopi.model.Menu
import com.ditsdev.ngopi.ui.theme.NgopiTheme

@Composable
fun CardMenuItem(
    menu: Menu,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.width(140.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    ) {
        Column {
            Image(
                painter = painterResource(menu.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .height(120.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth(),
            )

            Column(
                modifier = modifier.padding(8.dp)
            ) {
                Text(
                    text = menu.title,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = menu.price,
                    style = MaterialTheme.typography.titleSmall
                )
            }

        }
    }
}

@Composable
@Preview(showBackground = true)
fun CardMenuPreview() {
    NgopiTheme {
        CardMenuItem(
            menu = Menu(
                R.drawable.menu1,
                "Soto Goreng",
                "12333"
            ),
            modifier = Modifier.padding(8.dp)
        )
    }
}
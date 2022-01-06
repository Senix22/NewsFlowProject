package com.example.newsflowproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.newsflowproject.domain.NewsDomainModel

@Composable
fun NewsListItem(news: NewsDomainModel) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = Color.Black,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row {
            NewsImage(news = news)
            Column(

                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = news.author.orEmpty(),
                    style = MaterialTheme.typography.h6,
                    color = Color.White
                )

                Text(
                    text = news.description.orEmpty(),
                    style = MaterialTheme.typography.h6,
                    color = Color.White
                )
                Text(
                    text = news.title.orEmpty(),
                    style = MaterialTheme.typography.h6,
                    color = Color.White
                )
                Text(
                    text = news.publishedAt.orEmpty(),
                    style = MaterialTheme.typography.h6,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
private fun NewsImage(news: NewsDomainModel) {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}

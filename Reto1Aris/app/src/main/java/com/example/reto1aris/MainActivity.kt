package com.example.reto1aris

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reto1aris.ui.theme.Reto1ArisTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Reto1ArisTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier.fillMaxSize().background(Color(0xff161d26))
                ) {
                    TwitterCard()
                    TweetDivider()
                }
            }
        }
    }
}

@Preview
@Composable
fun TwitterCard() {
    var chat by rememberSaveable { mutableStateOf(false) }
    var retweet by rememberSaveable { mutableStateOf(false) }
    var like by rememberSaveable { mutableStateOf(false) }
    Row(
        Modifier
            .fillMaxWidth()
            .background(Color(0xff161d26))
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.kitten_38),
            contentDescription = "kitten avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(55.dp)
        )
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(Modifier.fillMaxWidth()) {
                TextTitle(title = "Aris", Modifier.padding(8.dp))
                DefaultText(title = "@AristiDevs", Modifier.padding(8.dp))
                DefaultText(title = "4h", Modifier.padding(8.dp))
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    painterResource(id = R.drawable.baseline_menu_24),
                    contentDescription = "icon menu",
                    tint = Color.White
                )
            }
            TextBody(
                "Esta es una frase larga jaja jiji" +
                        "Esta es una frase larga jaja jiji" +
                        "Esta es una frase larga jaja jiji" +
                        "Esta es una frase larga jaja jiji" +
                        "Esta es una frase larga jaja jiji",
                Modifier.padding(bottom = 8.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.bon_jovi),
                contentDescription = "image of Bon Jovi",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(10)),
                contentScale = ContentScale.Fit
            )
            Row(Modifier.padding(top = 16.dp)) {
                SocialIcon(
                    modifier = Modifier.weight(1f),
                    unselectedIcon = {
                        Icon(
                            painterResource(id = R.drawable.outline_chat_bubble_outline_24),
                            contentDescription = "icon Replay",
                            tint = Color(0xff7e8b98)
                        )
                    },
                    selectedIcon = {
                        Icon(
                            painterResource(id = R.drawable.baseline_chat_bubble_24),
                            contentDescription = "icon Replay",
                            tint = Color(0xff7e8b98)
                        )
                    },
                    isSelected = chat
                ) {
                    chat = !chat
                }

                SocialIcon(
                    modifier = Modifier.weight(1f),
                    unselectedIcon = {
                        Icon(
                            painterResource(id = R.drawable.retweet_24),
                            contentDescription = "icon Replay",
                            tint = Color(0xff7e8b98)
                        )
                    },
                    selectedIcon = {
                        Icon(
                            painterResource(id = R.drawable.retweet_24),
                            contentDescription = "icon Replay",
                            tint = Color(0xff00ff27)
                        )
                    },
                    isSelected = retweet
                ) {
                    retweet = !retweet
                }

                SocialIcon(
                    modifier = Modifier.weight(1f),
                    unselectedIcon = {
                        Icon(
                            painterResource(id = R.drawable.like_24),
                            contentDescription = "icon Replay",
                            tint = Color(0xff7e8b98)
                        )
                    },
                    selectedIcon = {
                        Icon(
                            painterResource(id = R.drawable.baseline_favorite_24),
                            contentDescription = "icon Replay",
                            tint = Color(0xffff0000)
                        )
                    },
                    isSelected = like
                ) {
                    like = !like
                }
            }
        }
    }
}

@Composable
fun TextTitle(title: String, modifier: Modifier = Modifier) {
    Text(text = title, color = Color.White, fontWeight = FontWeight.ExtraBold, modifier = modifier)
}

@Composable
fun DefaultText(title: String, modifier: Modifier = Modifier) {
    Text(text = title, color = Color.Gray, modifier = modifier)
}

@Composable
fun TextBody(text: String, modifier: Modifier = Modifier) {
    Text(text = text, color = Color.White, modifier = modifier)
}

@Composable
fun SocialIcon(
    modifier: Modifier,
    unselectedIcon: @Composable () -> Unit,
    selectedIcon: @Composable () -> Unit,
    isSelected: Boolean,
    onItemSelected: () -> Unit
) {
    val defaultValue = 1

    Row(
        modifier = modifier.clickable { onItemSelected() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isSelected) {
            selectedIcon()
        } else {
            unselectedIcon()
        }

        Text(
            text = if (isSelected) (defaultValue + 1).toString() else defaultValue.toString(),
            color = Color(0xff7e8b98),
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}

@Composable
fun TweetDivider() {
    Divider(
        Modifier
            .padding(top = 4.dp)
            .height(0.5.dp)
            .fillMaxWidth(),
        color = Color(0xff7e8b98)
    )
}
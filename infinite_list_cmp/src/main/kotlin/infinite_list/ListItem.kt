package infinite_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ListItem(post: Post) {
    Card (
        modifier = Modifier
            .padding(start=4.dp, end=4.dp, top=4.dp, bottom=8.dp)
            .clip(RoundedCornerShape(20.dp)).background(Color.Gray),
        elevation = 8.dp
    ) {
        Row (modifier=Modifier.background(Color.Gray).padding(all=10.dp)){
            Column {
                Text(post.id.toString(), fontWeight = FontWeight.Bold)
            }
            Column {
                Row {
                    Text(post.title)
                }
                Row {
                    Text(post.body)
                }
            }
        }
    }
}

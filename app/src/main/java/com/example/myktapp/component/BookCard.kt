package com.example.myktapp.component
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myktapp.R

@Composable
fun BookCard (book: BookInfo,onDeleteClick:(BookInfo)-> Unit) {//ON CLICK ON DELETE BUTTON onDeleteClick parameter gets reference from BookInfo class
    Box(modifier=Modifier.padding(1.dp)
        .fillMaxSize()
        .background(color=book.bookType.backgroundColor.copy(alpha=0.9f))//based on book being nonfiction or fiction bookType background will be same color as border
    )//backgroundcolor will be tranparant
    {
        Column(
            modifier=Modifier.padding(10.dp)
        ){
        Row(//title and read properties are mentioned and they are in a row
            modifier = Modifier.fillMaxSize()
                .padding(0.dp,2.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {

            Text(
                " ${book.title}",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = book.bookType.foreGroundColor
                ),
                overflow = TextOverflow.Visible

            )
            if (book.read) {//this v sign signifies that book is read or not
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = stringResource(id = R.string.delete)
                )
            }
            var count by rememberSaveable { mutableIntStateOf(0) }//count is state that will change. Remember keeps
//state from restarting and updates accordingly till we stop running the app. MutableintState declares starting point for rerunning
            Column(modifier=Modifier.fillMaxSize(0.9f),
                horizontalAlignment = Alignment.End) {
                Text("Book Read: $count")
                Button(onClick = { count++ },
                ) {
                    Text("Add")

                }



            }
        }
        Text(
            "YAZAR: ${book.author}",
            style = TextStyle(color = book.bookType.foreGroundColor)

        )
            var bookPublisher by remember { mutableStateOf(book.publisher)}

        Text(
            "NESRİYYAT: $bookPublisher",//this shows changed value in outlinedtexfield
            style = TextStyle(color = book.bookType.foreGroundColor)

        )
            Box(
                modifier=Modifier.fillMaxWidth()
                    .padding(0.dp,5.dp)
            ){

                OutlinedTextField(

                    value=bookPublisher,
                    onValueChange={bookPublisher=it},//here upgrade publisher name
                    textStyle=TextStyle(fontSize = 20.sp,color=book.bookType.foreGroundColor),

                    )
                IconButton(onClick = {onDeleteClick(book)},//On clicking delete button mentioned in Icon composable takes onDeleteClick parameter and includes books list books
                            modifier=Modifier.align (Alignment.BottomEnd )//i can call align only in Box element
                ){

                        Icon(
                            imageVector= Icons.Default.Delete,
                            contentDescription=stringResource(id=R.string.delete),
                            tint=Color.Cyan
                        )




                }

            }




    }


    }}













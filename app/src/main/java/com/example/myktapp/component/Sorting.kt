package com.example.myktapp.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

enum class SortOrder{
                    NONE,
    BYTITLE,
    BYAUTHOR,
    BYREAD,
    BYPUBLISHER


}


@Composable
fun SortOptions(currentOrder:SortOrder,onOrderChange:(SortOrder)->Unit){
    Column(modifier=Modifier.padding(10.dp,3.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Row(){
            Button(onClick={onOrderChange(SortOrder.NONE)}) {
                Text("Default")}
            Button(onClick={onOrderChange(SortOrder.BYTITLE)}) {
                Text("Title")}
            Button(onClick={onOrderChange(SortOrder.BYAUTHOR)}) {
                Text("Author")}}
        Row {
            Button(onClick = { onOrderChange(SortOrder.BYREAD) }) {
                Text("Read")
            }
            Button(onClick = { onOrderChange(SortOrder.BYPUBLISHER) }) {
                Text("Booktype")
            }

        }
    }
   }



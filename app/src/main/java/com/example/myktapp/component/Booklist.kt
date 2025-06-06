package com.example.myktapp.component
//import com.example.myktapp.BookListViewModel
import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@SuppressLint("RememberReturnType")
@Composable
fun BookList (innerPadding: PaddingValues) {
    var localBooks = remember{ mutableStateOf(books) }//calls recomposition to exert changes
    var sortOrder by remember{mutableStateOf(SortOrder.NONE)}
    val sortedBooks =remember(sortOrder) {
        when(sortOrder){
            SortOrder.NONE -> books
            SortOrder.BYTITLE -> books.sortedBy { it.title }
            SortOrder.BYAUTHOR -> books.sortedBy { it.author }
            SortOrder.BYREAD ->books.sortedBy {it.read}
            SortOrder.BYPUBLISHER ->books.sortedBy {it.publisher}

        }
    }
    Column(modifier=Modifier.padding(innerPadding)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,

    ){
        SortOptions (currentOrder = sortOrder){selectedOrder->
            sortOrder=selectedOrder
            println("basildi")
        }




        LazyColumn (modifier=Modifier
            .padding(2.dp, 2.dp)
            .border(
                3.dp,
                color = Color.Black,
                shape = RoundedCornerShape(10.dp)

            )
            .fillMaxSize()
            ,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            items(sortedBooks) {book->//takes localBooks list and converts it as a book in lazy column
                BookCard(book){////tells compiler to do things in Bookcard and add remove item in books
                    println("Book deleted")//on each click on delete button shows this string in log cat
                    localBooks.value=
                        localBooks.value.filter{it!=book} as MutableList<BookInfo>//on click delete button removes same book in which clicked

                }
//            Spacer(modifier = Modifier.height(10.dp))







            }}

    }




  }





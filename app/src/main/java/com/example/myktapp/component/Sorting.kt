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

enum class SortOrder{//sorting of books by different topics
                    NONE,
    BYTITLE,
    BYAUTHOR,
    BYREAD,
    BYPUBLISHER


}


@Composable
fun SortOptions(currentOrder:SortOrder,onOrderChange:(SortOrder)->Unit){//to get sorting with UI interaction tool clicks you click title it gives you sorted books by title
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
fun getBooks(orderWith: SortOrder):List<BookInfo>{//raw data with sorted order gives to viewmodel
    val books = mutableListOf(//to change content we converted it from listof to mutablelistof
        BookInfo("1984", "George Orwell", "Secker & Warburg", true, Fiction),
        BookInfo("Brave New World", "Aldous Huxley", "Chatto & Windus", false, NonFiction),
        BookInfo("The Catcher in the Rye", "J.D. Salinger", "Little, Brown and Company", true,Fiction),
        BookInfo("To Kill a Mockingbird", "Harper Lee", "J.B. Lippincott & Co.", false,Fiction),
        BookInfo("The Great Gatsby", "F. Scott Fitzgerald", "Charles Scribner's Sons", true, Biography),
        BookInfo("Moby Dick", "Herman Melville", "Harper & Brothers", false),
        BookInfo("The Catcher in the Rye", "J.D. Salinger", "Little, Brown and Company", true),
        BookInfo("Crime and Punishment", "Fyodor Dostoevsky", "The Russian Messenger", false),
        BookInfo("The Lord of the Rings", "J.R.R. Tolkien", "George Allen & Unwin", true),
        BookInfo("Jane Eyre", "Charlotte Brontë", "Smith, Elder & Co.", true),
        BookInfo("The Alchemist", "Paulo Coelho", "HarperTorch", true),
        BookInfo("The Book Thief", "Markus Zusak", "Picador", false),
        BookInfo("Life of Pi", "Yann Martel", "Knopf Canada", false),
        BookInfo("Crime and Punishment", "Fyodor Dostoevsky", "The Russian Messenger", false),
        BookInfo("The Lord of the Rings", "J.R.R. Tolkien", "George Allen & Unwin", true),
        BookInfo("Jane Eyre", "Charlotte Brontë", "Smith, Elder & Co.", true),
        BookInfo("The Alchemist", "Paulo Coelho", "HarperTorch", true),
        BookInfo("The Book Thief", "Markus Zusak", "Picador", false),
        BookInfo("Life of Pi", "Yann Martel", "Knopf Canada", false)

    )

    return when (orderWith){
        SortOrder.NONE -> books
        SortOrder.BYTITLE -> books.sortedBy { it.title }
        SortOrder.BYAUTHOR -> books.sortedBy { it.author }
        SortOrder.BYREAD ->books.sortedBy {it.read}
        SortOrder.BYPUBLISHER ->books.sortedBy {it.publisher}

    }
}


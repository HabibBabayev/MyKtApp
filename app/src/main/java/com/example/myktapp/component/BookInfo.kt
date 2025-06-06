package com.example.myktapp.component

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import com.example.myktapp.ui.theme.Purple80

data class BookInfo (
    val title: String="",
    val author: String="",
    val publisher: String="",
    val read: Boolean= false,
    val bookType: BookType= NonFiction//we created Booktype class and as a type we gave it two values which returns us two different colors for each value

    )
//to change color of column due to its type whether is fiction or nonfiction
sealed class BookType(val backgroundColor:Color, val foreGroundColor:Color)
data object Fiction: BookType(Red,Blue)
data object Biography: BookType(Green,Blue)
data object NonFiction: BookType(Purple80,Blue)

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

//SORTING THINGS








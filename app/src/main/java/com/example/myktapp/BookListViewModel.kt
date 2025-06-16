package com.example.myktapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.myktapp.component.BookInfo
import com.example.myktapp.component.SortOrder
import com.example.myktapp.component.getBooks

class BookListViewModel:ViewModel(){
private val _books=mutableStateOf<List<BookInfo>>(emptyList())//this holds list of BookInfo and are recomposed due to mutablestateof
    val books:State<List<BookInfo>> get()=_books// we use change _books data and show it in UI with read only state called books
//MUTABLESTATEOF ensures recomposition when sort or books data changed
private var _sortOrder=mutableStateOf(SortOrder.BYAUTHOR)//this takes and recomposes(mutablestate) SortOrder option and BYAUTHOR starting point changes when you click on UI
    val sortOrder:State<SortOrder> get()=_sortOrder// gives to UI readonly sortOrder which changed in _sortOrder
          init{//initializes and shows _books BookInfo emptyList and adds loadBooks which adds predetermined BookInfo list from getBooks fun with sortOrder choices when run
              _books.value=loadBooks(sortOrder.value)//this helps to get book collection with sorted version
          }
    //In ViewModel we updated states of _books and use them in UI with books readonly state. UI cant directly update collection or data
    //To update collection UI must interact with following viewModel events


    private fun loadBooks(sortOrder: SortOrder):List<BookInfo>{//gets data from getBooks which returns sorted list of BookInfo
        return getBooks(sortOrder)
    }
}
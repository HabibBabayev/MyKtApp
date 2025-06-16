package com.example.myktapp


//import androidx.compose.foundation.layout.size
//import androidx.compose.material3.DividerDefaults.color
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.myktapp.component.BookList

//import androidx.compose.ui.unit.color
class MainActivity : ComponentActivity() {
    override fun onStart(){
        super.onStart()
        Log.d("MainActivity","app is onStart")
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.d("MainActivity","app is Closed")

    }
    override fun onRestart(){
        super.onRestart()
        Log.d("MainActivity","app is restarted")

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            val ad="Habib"
//            Log.d("MainActivity","Bu $ad dir")
//            MyKtAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize())
                { innerPadding ->
                    val books=viewModels<BookListViewModel>()
                    BookList(books.value,innerPadding)

            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//
//       Box(
//           modifier=Modifier.fillMaxSize(),
//           contentAlignment =Alignment.Center
//       ){Column(horizontalAlignment = Alignment.CenterHorizontally){
//
//           Text(
//               text =stringResource(id=R.string.greeting),
//               style= TextStyle(fontSize = 35.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Cursive ),
//               modifier = Modifier,
////                   .padding(10.dp,10.dp),
//               color=colorResource(id=R.color.red)
//           )
//
//           Image(painter = painterResource(id = R.drawable.book),
//               contentDescription = null,
//               modifier=Modifier
////                   .padding(50.dp, 10.dp)
//                   .size(200.dp, 200.dp))
//
//
//       }
//
//    }
//
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    MyKtAppTheme {
//        Greeting("Android")
//    }
//}
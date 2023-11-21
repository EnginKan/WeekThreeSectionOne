package weekeight

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class BookViewModel(): ViewModel() {
    private var _booklist= MutableStateFlow(BookDataProvider.getBookList())

    val booklist= _booklist.asStateFlow()

    fun getBookByID(id : Int):Book{
        return _booklist.value.filter { it.id==id }.get(0)
    }
}
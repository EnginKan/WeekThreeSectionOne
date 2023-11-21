package weekeight

object BookDataProvider {
    private var bookList= mutableListOf<Book>()

    init{
        for(i in 0..20)
            bookList.add(Book(id=i,
                author = "Author"+i,
            title = "Title"+i,
            type="Type"+i))
    }

    fun getBookList(): MutableList<Book>{
        return bookList
    }
}
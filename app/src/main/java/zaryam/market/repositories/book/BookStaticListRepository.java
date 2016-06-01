package zaryam.market.repositories.book;

import java.util.ArrayList;

import zaryam.market.Book;

/**
 * Created by 92525252 on 6/1/2016.
 */
public class BookStaticListRepository implements IBookRepository {

    private static ArrayList<Book> books = new ArrayList<>();

    public boolean add(Book book) {
        books.add(book);
        return true;
    }

    public boolean remove(Book book) {
        return remove(book.getId());
    }

    public boolean remove(int id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Book> get() {
        return books;
    }
}

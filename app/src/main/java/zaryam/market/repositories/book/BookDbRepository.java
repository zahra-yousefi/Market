package zaryam.market.repositories.book;

import java.util.ArrayList;

import zaryam.market.Book;

/**
 * Created by 92525252 on 6/1/2016.
 */
public class BookDbRepository implements IBookRepository {

    @Override
    public boolean add(Book book) {
        return false;
    }

    @Override
    public boolean remove(Book book) {
        return false;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public ArrayList<Book> get() {
        return new ArrayList<>();
    }
    public Book getId(int id){
        return null;
    }

    public boolean update(int id, String bookName, String bookType) {
        return  true;
    }
}

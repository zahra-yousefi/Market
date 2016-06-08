package zaryam.market.repositories.book;

import java.util.ArrayList;

import zaryam.market.Book;

/**
 * Created by 92525252 on 6/1/2016.
 */
public interface IBookRepository {

    boolean add(Book book);

    boolean remove(Book book);

    boolean remove(int id);

    ArrayList<Book> get();

    Book getId(int id);

    boolean update(int id, String bookName, String bookType);
}

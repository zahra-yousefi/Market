package zaryam.market;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import zaryam.market.repositories.book.BookStaticListRepository;
import zaryam.market.repositories.book.IBookRepository;

public class BooksListActivity extends AppCompatActivity {

    IBookRepository bookRepository;
    BookListAddapter adapter;
    ListView bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);

        bookList = (ListView)findViewById(R.id.bookList);
        Button btnAdd = (Button)findViewById(R.id.btnAdd);
        Button btnEdit = (Button)findViewById(R.id.btnEdit);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BooksListActivity.this, AddBookActivity.class);
                startActivity(intent);
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        bookRepository = new BookStaticListRepository();
        bookRepository.add(new Book(1, "Book1", "Story"));
        bookRepository.add(new Book(2, "Book2", "Romantic"));
        bookRepository.add(new Book(3, "Book3", "Violance"));

        adapter = new BookListAddapter(this, bookRepository, bookRepository.get());
        bookList.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        adapter = new BookListAddapter(this, bookRepository, bookRepository.get());
        bookList.setAdapter(adapter);
    }
}

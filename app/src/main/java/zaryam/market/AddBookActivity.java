package zaryam.market;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import zaryam.market.repositories.book.BookStaticListRepository;
import zaryam.market.repositories.book.IBookRepository;
import zaryam.market.repositories.book.RepositoryBuilder;

public class AddBookActivity extends AppCompatActivity {

    private int bookId;
    private IBookRepository bookRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        final EditText txtName  = (EditText) findViewById(R.id.txtBookName);
        final EditText txtType = (EditText) findViewById(R.id.txtBookType);
        Button btnSave = (Button) findViewById(R.id.btnSave);
        bookId = getIntent().getIntExtra("ID", 0);

        bookRepository = RepositoryBuilder.getBookRepository();
        if (bookId!=0){
            Book book = bookRepository.getId(bookId);

            txtName.setText(book.getName());
            txtType.setText(book.getType());
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = txtName.getText().toString();
                String type = txtType.getText().toString();

                if (bookId==0){
                    bookRepository.add(new Book(4,name,type));
                    finish();
                }else{
                    bookRepository.update(bookId,name,type);
                    finish();
                }
            }
        });
    }
}

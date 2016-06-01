package zaryam.market;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import zaryam.market.repositories.book.BookStaticListRepository;

public class AddBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        final EditText txtName  = (EditText) findViewById(R.id.txtBookName);
        final EditText txtType = (EditText) findViewById(R.id.txtBookType);
        Button btnSave = (Button) findViewById(R.id.btnSave);

        int id = getIntent().getIntExtra("ID", 0);
        // get id

        /// repo. get by id >> book


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString();
                String type = txtType.getText().toString();
                BookStaticListRepository bookStaticListRepository = new BookStaticListRepository();
                bookStaticListRepository.add(new Book(4,name,type));
                finish();
            }
        });
    }
}

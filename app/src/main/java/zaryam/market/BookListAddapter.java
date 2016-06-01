package zaryam.market;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import zaryam.market.repositories.book.IBookRepository;

/**
 * Created by 92525252 on 5/31/2016.
 */
public class BookListAddapter extends ArrayAdapter {

    private ArrayList<Book> books;
    private Context context;
    private IBookRepository bookRepository;

    public BookListAddapter(Context context, IBookRepository bookRepository, ArrayList<Book> books) {
        super(context, android.R.layout.simple_list_item_1, books);

        this.books = books;
        this.bookRepository = bookRepository;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflator =  (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View panel = inflator.inflate(R.layout.list_item_book, parent, false);
        final Book book = books.get(position);

        TextView txtBookName = (TextView)panel.findViewById(R.id.txtBookName);

        TextView txtQuantity = (TextView)panel.findViewById(R.id.txtQuantity);

        Button btnShowMessage = (Button)panel.findViewById(R.id.btnShowMessage);
        btnShowMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (bookRepository.remove(book)) {
                    notifyDataSetChanged();
                    Toast.makeText(context, book.getName() + " has been removed", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(context, "Could n't remove",Toast.LENGTH_SHORT).show();
            }
        });

        txtBookName.setText(book.getName());
        txtQuantity.setText(book.getType());
        return panel;
    }
}

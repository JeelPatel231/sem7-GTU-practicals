package tel.jeelpa.gtusem7;

import static androidx.core.content.ContentProviderCompat.requireContext;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import javax.xml.namespace.QName;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText name = findViewById(R.id.name);
        EditText number = findViewById(R.id.number);
        Button saveButton = findViewById(R.id.save_button);

        SqliteHelper db = new SqliteHelper(this);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contact contact = new Contact(name.getText().toString(), number.getText().toString());
                db.addContact(contact);
                Toast.makeText(MainActivity.this, "Contact Added to Database", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

class Contact {
    String name;
    String number;

    public Contact(String name, String number){
        this.name = name;
        this.number = number;
    }
}

class SqliteHelper extends SQLiteOpenHelper {
    private static final String NAME_KEY = "name";
    private static final String NUMBER_KEY = "number";
    private static final String DB_NAME = "contacts";

    public SqliteHelper(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS " + DB_NAME + "( name TEXT, number VARCHAR(10) )";
        sqLiteDatabase.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String dropDB = "DROP TABLE IF EXISTS "+DB_NAME;
        sqLiteDatabase.execSQL(dropDB);
        onCreate(sqLiteDatabase);
    }

    public void addContact(Contact contact){
        ContentValues cv = new ContentValues();
        SQLiteDatabase db = this.getWritableDatabase();

        cv.put(NAME_KEY, contact.name);
        cv.put(NUMBER_KEY, contact.number);

        db.insert(DB_NAME,null, cv);
        db.close();
    }

}
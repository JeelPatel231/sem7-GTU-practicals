package tel.jeelpa.gtusem7;

import static androidx.core.content.ContentProviderCompat.requireContext;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private final static String SHARED_PREF_NAME = "myprefs";
    private final static String USERNAME_KEY = "username";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sp = getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        EditText username = findViewById(R.id.username);
        Button saveBtn = findViewById(R.id.save);
        Button loadBtn = findViewById(R.id.load);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameStr = username.getText().toString();
                sp.edit().putString(USERNAME_KEY, usernameStr).apply();
                Toast.makeText(MainActivity.this, "Username Saved", Toast.LENGTH_SHORT).show();
            }
        });

        loadBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String usernameStr = sp.getString(USERNAME_KEY, null);
                if(usernameStr == null){
                    Toast.makeText(MainActivity.this, "Username is unset", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Username : "+usernameStr, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

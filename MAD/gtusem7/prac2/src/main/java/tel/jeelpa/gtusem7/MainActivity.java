package tel.jeelpa.gtusem7;

import static androidx.core.content.ContentProviderCompat.requireContext;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button implicit = findViewById(R.id.implicit);
        Button explicit = findViewById(R.id.explicit);
        Button activity = findViewById(R.id.activity);


        implicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://google.com";
                Intent implicit_intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(implicit_intent);
            }
        });


        explicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent explicit_intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(explicit_intent);
            }
        });

        activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent explicit_intent = new Intent(MainActivity.this, SecondActivity.class);
                explicit_intent.putExtra("data", true);
                startActivityForResult(explicit_intent, 10);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 & resultCode == RESULT_OK) {
                String returnedResult = data.getDataString();
                Toast.makeText(this, "Data returned from activity : "+returnedResult, Toast.LENGTH_SHORT).show();
            }
        }

}

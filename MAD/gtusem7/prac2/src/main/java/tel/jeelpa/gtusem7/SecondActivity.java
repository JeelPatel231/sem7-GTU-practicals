package tel.jeelpa.gtusem7;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView text = findViewById(R.id.hero_label);
        Button returnBtn = findViewById(R.id.return_btn);
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data = new Intent();
                data.setData(Uri.parse("Data: Hello World"));
                setResult(RESULT_OK, data);
                finish();
            }
        });

        if(getIntent().getBooleanExtra("data", false)){
            text.setText("Data Added for Returning");
        } else {
            returnBtn.setVisibility(View.GONE);
        }

    }
}
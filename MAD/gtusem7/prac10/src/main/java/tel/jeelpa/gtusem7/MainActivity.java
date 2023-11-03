package tel.jeelpa.gtusem7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Boolean visible = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.text);
        Button toggleBtn = findViewById(R.id.toggle);

        toggleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.animate()
                        .alpha(visible ? 0F : 1F)
                        .translationY(visible ? -100 : 0)
                        .setDuration(300)
                        .setListener(null);

                visible = !visible;
            }
        });

    }
}

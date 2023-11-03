package tel.jeelpa.gtusem7;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    private ImageView imgView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button imageClickBtn = findViewById(R.id.image_click);
        imgView = findViewById(R.id.image_view);

        imageClickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Clicc", Toast.LENGTH_SHORT).show();
                if (!checkcamPermission()){
                    askPermission();
                } else {
                    captureImage();
                }
            }
        });
    }

    private void captureImage() {
        Intent camIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camIntent,100);
    }

    private void askPermission() {
        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CAMERA}, 100);
    }

    private boolean checkcamPermission() {
        return ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (data != null && requestCode==100 && resultCode==RESULT_OK){
            Bitmap image=(Bitmap) data.getExtras().get("data");
            imgView.setImageBitmap(image);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


}

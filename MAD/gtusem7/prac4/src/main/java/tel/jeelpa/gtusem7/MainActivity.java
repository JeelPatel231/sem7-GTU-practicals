package tel.jeelpa.gtusem7;

import static androidx.core.content.ContentProviderCompat.requireContext;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView studentView = findViewById(R.id.student_recycler);
        Student[] students = {
                new Student("Daniel", "69420, This Street, That State", "dummy"),
                new Student("Robby", "69421, This Street, That State", "dummy"),
                new Student("Emma", "69422, This Street, That State", "dummy"),
        };

        StudentRecyclerAdapter adapter = new StudentRecyclerAdapter(students);

        studentView.setAdapter(adapter);
        studentView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }
}

package tel.jeelpa.gtusem7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

class Student {
    String name;
    String address;
    String photo;

    public Student(String name, String address, String photo){
        this.name = name;
        this.address = address;
        this.photo = photo;
    }
}

public class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentRecyclerAdapter.ViewHolder> {
    private final Student[] localDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameHolder;
        final TextView addressHolder;
        final Button deleteButton;

        public ViewHolder(View view) {
            super(view);
            nameHolder = view.findViewById(R.id.name_holder);
            addressHolder = view.findViewById(R.id.address_holder);
            deleteButton = view.findViewById(R.id.delete_button);


            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "Not Implemented", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public StudentRecyclerAdapter(Student[] dataSet) {
        localDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.student_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.nameHolder.setText(localDataSet[position].name);
        viewHolder.addressHolder.setText(localDataSet[position].address);
    }

    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}


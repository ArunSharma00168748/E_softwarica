package com.arun.e_softwarica.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.arun.e_softwarica.R;
import com.arun.e_softwarica.fragment.DisplayFragment;
import com.arun.e_softwarica.model.Student;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.DisplayViewHolder> {

    DisplayFragment context;
    List<Student> studentList;
    int imageid;

    public StudentAdapter(DisplayFragment context, List<Student> studentList) {
        this.context =  context;
        this.studentList = studentList;
    }


    @NonNull
    @Override
    public DisplayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.displayview,parent,false);
        return new DisplayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DisplayViewHolder holder, final int position) {
        final Student details = studentList.get(position);

        String gender=details.getGender();
        if(gender.equals("Female")){
            imageid=R.drawable.avatarfemale;
        }
        else if(gender.equals("Male"))
        {
            imageid=R.drawable.avatarmale;
        }

        holder.imgProfile.setImageResource(imageid);

        holder.tvName.setText(details.getName());
        holder.tvAge.setText(details.getAge());
        holder.tvAddress.setText(details.getAddress());
        holder.tvGender.setText(details.getGender());
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                studentList.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class DisplayViewHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvAge,tvGender,tvAddress;
        ImageView imgProfile;
        ImageButton btnDelete;
        public DisplayViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProfile = itemView.findViewById(R.id.imgProfile);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            tvName = itemView.findViewById(R.id.tvName);
            tvGender = itemView.findViewById(R.id.tvGender);
            tvAge = itemView.findViewById(R.id.tvAge);
            btnDelete=itemView.findViewById(R.id.btnDelete);
        }
    }
}

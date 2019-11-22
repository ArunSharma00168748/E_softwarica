package com.arun.e_softwarica.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.arun.e_softwarica.Adapter.StudentAdapter;
import com.arun.e_softwarica.R;
import com.arun.e_softwarica.model.Student;

/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayFragment extends Fragment {

    RecyclerView recyclerView;

    List<Student> studentList = new ArrayList<>();

    public DisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_display, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);

        Student student = new Student("Arun", "20", "Ktm", "male");
        studentList = student.getStudentList();

        if(studentList.isEmpty()) {
            studentList.add(new Student("Arun", "22", "Ktm", "Male"));
            student.setStudentList(studentList);
        }

        StudentAdapter studentAdapter = new StudentAdapter(this, studentList);
        recyclerView.setAdapter(studentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        return view;
    }

}

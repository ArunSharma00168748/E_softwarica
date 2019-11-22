package com.arun.e_softwarica.fragment;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import com.arun.e_softwarica.R;
import com.arun.e_softwarica.model.Student;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddFragment extends Fragment implements View.OnClickListener {

    TextView txtname, txtage, txtaddress;
    Button btnadd;
    RadioGroup rg;
    RadioButton rbMale, rbFemale, rbOthers;
    private String Name, Age, Address, Gender;

    static List<Student> studentList = new ArrayList<>();

    public AddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        txtname = view.findViewById(R.id.txtname);
        txtage = view.findViewById(R.id.txtage);
        txtaddress = view.findViewById(R.id.txtaddress);
        rg = view.findViewById(R.id.rg);
        rbMale = view.findViewById(R.id.rbMale);
        rbFemale = view.findViewById(R.id.rbFemale);
        rbOthers = view.findViewById(R.id.rbOthers);
        btnadd = view.findViewById(R.id.btnadd);


        btnadd.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View v) {


        Name = txtname.getText().toString().trim();
        Age = txtage.getText().toString().trim();
        Address = txtaddress.getText().toString().trim();
        if (rbMale.isChecked()) {
            Gender = "Male";
        }
        if (rbFemale.isChecked()) {
            Gender = "Female";
        }
        if (rbOthers.isChecked()) {
            Gender = "Others";
        }

        if (!TextUtils.isEmpty(Name) && !TextUtils.isEmpty(Age) && !TextUtils.isEmpty(Address)) {

            Student student = new Student(Name, Age, Address, Gender);
            studentList = student.getStudentList();
            studentList.add(student);
            student.setStudentList(studentList);

//            for (int i = 0; i < check.getStudentlist().size(); i++) {
//                final Student userdetail = check.getStudentlist().get(i);
//                Toast.makeText(getActivity(), "" + userdetail.getName(), Toast.LENGTH_SHORT).show();
//            }


            Toast.makeText(getActivity(), "Sucessfully added : " + Name, Toast.LENGTH_LONG).show();
            txtname.setText("");
            txtage.setText("");
            txtaddress.setText("");
            rbMale.isChecked();


        } else {
            if (TextUtils.isEmpty(Name)) {
                txtname.setError("Enter Name");
            }
            if (TextUtils.isEmpty(Age)) {
                txtage.setError("Enter Age");
            }
            if (TextUtils.isEmpty(Address)) {
                txtaddress.setError("Enter Address");
            }
            return;
        }

    }


}

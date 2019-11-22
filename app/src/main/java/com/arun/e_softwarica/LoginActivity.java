package com.arun.e_softwarica;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtname, txtpassword;
    Button login;
    String Name, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtname = findViewById(R.id.txtname);
        txtpassword = findViewById(R.id.txtpassword);

        login = findViewById(R.id.btnlogin);

        login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Name = txtname.getText().toString();
        Password = txtpassword.getText().toString();
        if (!TextUtils.isEmpty(Name) && !TextUtils.isEmpty(Password)) {


            if (Name.equals("admin") && Password.equals("admin")) {
                Intent intent = new Intent(LoginActivity.this, DashBoard.class);
                startActivity(intent);
                Toast.makeText(LoginActivity.this, "Login Sucessful" , Toast.LENGTH_LONG).show();


            } else {
                Toast.makeText(LoginActivity.this, "Incorrect Username Or Password" + Name + Password, Toast.LENGTH_LONG).show();

            }
        } else {
            if(Name.isEmpty()){
                txtname.setError("Enter Name");
            }
            if(Password.isEmpty()){
                txtpassword.setError("Enter Password");
            }
        }

    }
}

package com.example.student_resgistration_form;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AdminSignUP extends AppCompatActivity {
    private EditText myemail;
    private EditText mypassword;
    private Button LoginA;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sign_u_p);
        myemail=(EditText)findViewById(R.id.edemailID);
        mypassword=(EditText)findViewById(R.id.edpassID);
        LoginA=(Button)findViewById(R.id.loginID);
        //mAuth= FirebaseAuth.getInstance();
        LoginA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email= myemail.getText().toString().trim();
                String password= mypassword.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    myemail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mypassword.setError("Password required");
                    return;
                }
                if(password.length() <6){
                    mypassword.setError("The password must be more than 6 characters ");
                }
                if(email.equals("admin1")&&(password.equals("12345"))){
                    startActivity(new Intent(getApplicationContext(),TemplateAdmin.class));
                }else
                    if(email.equals("admin2")&&(password.equals("678910"))){
                        startActivity(new Intent(getApplicationContext(),TemplateAdmin.class));
                }

            }
        });

    }
}
package com.example.student_resgistration_form;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    private Button takeUstosignInPage;
    private Button takeUsToProgrames;
    private TextView movingText;
    private EditText studemail;
    private EditText studPassword;
    private Button studLOgin;
    private Button studCreateAcc;
    private FirebaseAuth FAuth;
    private ProgressBar myprogressBar;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        takeUstosignInPage=(Button)findViewById(R.id.btnAdmin1ID) ;
        takeUsToProgrames=(Button)findViewById(R.id.btnProgram1ID) ;
        movingText=(TextView)findViewById(R.id.movingtextID);
        studemail=(EditText)findViewById(R.id.edStudentemailID);
        studPassword=(EditText)findViewById(R.id.etstudentPasswdID);
        studLOgin=(Button)findViewById(R.id.btnLoginstud);
        myprogressBar=(ProgressBar)findViewById(R.id.progrssBarID1);
        studCreateAcc=(Button)findViewById(R.id.btnCreateAcStudiD);
        movingText.setSelected(true);
        FAuth= FirebaseAuth.getInstance();

        takeUstosignInPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, AdminSignUP.class);
                startActivity(intent);

            }
        });
        takeUsToProgrames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, ProgrammesOfered.class);
                startActivity(intent);

            }
        });
        studLOgin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email= studemail.getText().toString().trim();
                String password= studPassword.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    studemail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    studPassword.setError("Password required");
                    return;
                }
                if(password.length() <6){
                    studPassword.setError("The password must be more than 6 characters ");
                }
                myprogressBar.setVisibility(View.VISIBLE);
                FAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){

                            Toast.makeText(MainActivity.this,"login success",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(),myForm.class));
                            myprogressBar.setVisibility(View.INVISIBLE);
                        }else {

                            Toast.makeText(MainActivity.this,"Error"+ task.getException().getMessage(),Toast.LENGTH_LONG).show();
                            myprogressBar.setVisibility(View.INVISIBLE);

                    }
                    }
                });



    }


        });
        studCreateAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String userEmail=studemail.getText().toString();
                String userpassword= studPassword.getText().toString();
                if(TextUtils.isEmpty(userEmail)){
                    studemail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(userpassword)){
                    studPassword.setError("Password required");
                    return;
                }
                if(userpassword.length() <6){
                    studPassword.setError("The password must be more than 6 characters ");
                }
                myprogressBar.setVisibility(View.VISIBLE);
                if(!userEmail.equals("") && (!userpassword.equals(""))){
                    FAuth.createUserWithEmailAndPassword(userEmail,userpassword).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {


                            if(!task.isSuccessful()){
                                Toast.makeText(MainActivity.this,"Error"+ task.getException().getMessage(),Toast.LENGTH_LONG).show();
                                myprogressBar.setVisibility(View.INVISIBLE);
                            }else{
                                Toast.makeText(MainActivity.this,"Account Created!",Toast.LENGTH_LONG).show();
                                myprogressBar.setVisibility(View.INVISIBLE);
                            }
                        }
                    });
                }

            }
        });

    }
}
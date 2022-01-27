package com.example.student_resgistration_form;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class myForm extends AppCompatActivity {
    private Button submitBTn;
    private EditText firstname;
    private EditText middleName;
    private EditText Lastname;
    private EditText Age;
    private EditText dateOfBirth;
    private EditText maritalStatus;
    private EditText Nationalty;
    private EditText Religion;
    private EditText StudentAddress;
    private EditText studentPhoneNUm;
    private EditText studentEmail;
    private EditText Tribe;
    private EditText SponserName;
    private EditText ParrentOrGuardian;
    private EditText SponserAddress;
    private EditText SponsorPnoneNum;
    private EditText SponsorEmail;
    private EditText firstPriority;
    private EditText secondPriority;
    private EditText thirdPriority;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_form);
        submitBTn=(Button)findViewById(R.id.btnSubmitID);
        firstname=(EditText)findViewById(R.id.EdfirstnameID);
        middleName=(EditText)findViewById(R.id.EDmidlenameID);
        Lastname=(EditText)findViewById(R.id.EDlastnameID);
        Age=(EditText)findViewById(R.id.edageiD);
        dateOfBirth=(EditText)findViewById(R.id.edDoBID);
        maritalStatus=(EditText)findViewById(R.id.maritalID);
        Nationalty=(EditText)findViewById(R.id.EDnationalityID);
        Religion=(EditText)findViewById(R.id.EDreligionID);
        StudentAddress=(EditText)findViewById(R.id.EDadressFocommunicationID);
        studentPhoneNUm=(EditText)findViewById(R.id.EDphonnumID);
        studentEmail=(EditText)findViewById(R.id.EDemailforStudentID);
        Tribe=(EditText)findViewById(R.id.EDtribID);
        SponserName=(EditText)findViewById(R.id.EDsponsorNameComID);
        ParrentOrGuardian=(EditText)findViewById(R.id.EDparentornComID);
        SponserAddress=(EditText)findViewById(R.id.EDsponserAddresComID);
        SponsorPnoneNum=(EditText)findViewById(R.id.EDsponsorPhoneID);
        SponsorEmail=(EditText)findViewById(R.id.EDsponsorEmailID);
        firstPriority=(EditText)findViewById(R.id.EDfirstID);
        secondPriority=(EditText)findViewById(R.id.EDsencondID);
        thirdPriority=(EditText)findViewById(R.id.EDthirdID);



        submitBTn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitBTn.setEnabled(false);
                String Fname1= firstname.getText().toString();
                String Mname1 = middleName.getText().toString();
                String Lname1 =Lastname.getText().toString();
                String Age1= Age.getText().toString();
                String dateOfBirth1= dateOfBirth.getText().toString();
                String maritalStatus1= maritalStatus.getText().toString();
                String Nationalty1= Nationalty.getText().toString();
                String  Religion1= Religion.getText().toString();
                String StudentAddress1= StudentAddress.getText().toString();
                String studentPhoneNUm1= studentPhoneNUm.getText().toString();
                String  studentEmail1= studentEmail.getText().toString();
                String Tribe1= Tribe.getText().toString();
                String SponserName1= SponserName.getText().toString();
                String ParrentOrGuardian1= ParrentOrGuardian.getText().toString();
                String  SponserAddress1= SponserAddress.getText().toString();
                String SponsorPnoneNum1= SponsorEmail.getText().toString();
                String SponsorEmail1= SponsorEmail.getText().toString();
                String firstPriority1= firstPriority.getText().toString();
                String secondPriority1= secondPriority.getText().toString();
                String thirdPriority1= thirdPriority.getText().toString();

                CollectionReference noteBookRef = FirebaseFirestore.getInstance().collection("USER_INFO");
                noteBookRef.add(new Student(
                        "",
                        Fname1,
                        Mname1,
                        Lname1,
                        Age1,
                        dateOfBirth1,
                        maritalStatus1,
                        Nationalty1,
                        Religion1,
                        StudentAddress1,
                        studentPhoneNUm1,
                        studentEmail1,
                        Tribe1,
                        SponserName1,
                        ParrentOrGuardian1,
                        SponserAddress1,
                        SponsorPnoneNum1,
                        SponsorEmail1,
                        firstPriority1,
                        secondPriority1,
                        thirdPriority1)).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if(task.isSuccessful()){

                            String uid =  task.getResult().getId();
                            Map data  =  new HashMap<Student,String>();
                            data.put("id",uid);
                            noteBookRef.document(uid).update(data).addOnCompleteListener(new OnCompleteListener() {
                                @Override
                                public void onComplete(@NonNull Task task) {
                                    if(task.isSuccessful())
                                    {
                                        Toast.makeText(myForm.this, "data sent", Toast.LENGTH_SHORT).show();
                                        try {
                                            Thread.sleep(5000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }

                                        finish();
                                    }else
                                    {
                                        Toast.makeText(myForm.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                    submitBTn.setEnabled(true);

                                }
                            });

                        }else{
                            Toast.makeText(myForm.this, "data not sent "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            submitBTn.setEnabled(true);
                        }
                    }
                });
            }
        });

    }
}
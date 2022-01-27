package com.example.student_resgistration_form;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.student_resgistration_form.item.StudentItem;

public class SingleDocument extends AppCompatActivity {

    private static final String TAG = "SingleDocument";

    private TextView tvFirstNameFromSingle;
    private TextView tvMiddlename;
    private TextView tvLastName;
    private TextView tvAge;
    private TextView tvDateOfBirth;
    private TextView tvmaritalStatus;
    private  TextView tvNationality;
    private  TextView tvReligion;
    private TextView tvAddressForComm;
    private TextView tvPhoneNumber;
    private TextView tvEmail;
    private TextView tvTribe;
    private TextView tvSponsorName;
    private TextView tvParentOrGuadian;
    private TextView tvSponsorAddress;
    private TextView tvSponsorPhoneNumber;
    private TextView tvSponsorEmail;
    private TextView tvFirstPriority;
    private TextView tvSecondPriority;
    private TextView tvThirdPriority;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_document);
        tvFirstNameFromSingle=(TextView)findViewById(R.id.tvFirstName);
        tvMiddlename=(TextView)findViewById(R.id.tvMiddleName);
        tvLastName=(TextView)findViewById(R.id.tvLastName);
        tvAge=(TextView)findViewById(R.id.tvAge);
        tvDateOfBirth=(TextView)findViewById(R.id.tvDateOfBirth);
        tvmaritalStatus=(TextView)findViewById(R.id.tvMaritalStutas);
        tvNationality=(TextView)findViewById(R.id.tvNationality);
        tvReligion=(TextView)findViewById(R.id.tvReligionId);
        tvAddressForComm= findViewById(R.id.tvAddressForCom);
        tvPhoneNumber= findViewById(R.id.tvPhoneNumber);
        tvEmail=findViewById(R.id.tvEmail);
        tvTribe= findViewById(R.id.tvTribe);
        tvSponsorName= findViewById(R.id.tvSponsorName);
        tvParentOrGuadian= findViewById(R.id.tvParentOrGuadian);
        tvSponsorAddress= findViewById(R.id.tvSponsorAddress);
        tvSponsorPhoneNumber= findViewById(R.id.tvSponsorPhoneNumber);
        tvSponsorEmail= findViewById(R.id.tvSponsorEmail);
        tvFirstPriority= findViewById(R.id.tvFirstPririty);
        tvSecondPriority= findViewById(R.id.tvSecondPriority);
        tvThirdPriority= findViewById(R.id.tvThirdPriority);

        Student student = getIntent().getParcelableExtra("student");

        tvFirstNameFromSingle.setText(student.getFirstName());
        tvMiddlename.setText(student.getMiddleName());
        tvLastName.setText(student.getLastName());
        tvAge.setText(student.getAge());
        tvDateOfBirth.setText(student.getDateOfBirth());
        tvmaritalStatus.setText(student.getMaritalStatus());
        tvNationality.setText(student.getNationality());
        tvReligion.setText(student.getReligion());
        tvAddressForComm.setText(student.getStudentAddress());
        tvPhoneNumber.setText(student.getStudentPhoneNUm());
        tvEmail.setText(student.getStudentEmail());
        tvTribe.setText(student.getTribe());
        tvSponsorName.setText(student.getSponsorName());
        tvParentOrGuadian.setText(student.getParentOrGuardian());
        tvSponsorAddress.setText(student.getSponsorAddress());
        tvSponsorPhoneNumber.setText(student.getSponsorPhoneNumber());
        tvSponsorEmail.setText(student.getSponsorEmail());
        tvFirstPriority.setText(student.getFirstPriority());
        tvSecondPriority.setText(student.getSecondPriority());
        tvThirdPriority.setText(student.getThirdPriority());


    }
}


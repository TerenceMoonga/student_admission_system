package com.example.student_resgistration_form.item;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.solver.widgets.Snapshot;

import com.example.student_resgistration_form.Student;
import com.example.student_resgistration_form.R;
import com.xwray.groupie.GroupieViewHolder;
import com.xwray.groupie.Item;

public class StudentItem extends Item {
    private Student student;


    public Student getStudent() {
        return student;
    }

    public StudentItem( Student student){
        this.student = student;
    }

    @Override
    public void bind(@NonNull GroupieViewHolder viewHolder, int position) {

        TextView name1 =  viewHolder.itemView.findViewById(R.id.textView4);
        TextView name2= viewHolder.itemView.findViewById(R.id.Mname2);
        TextView emailForStudent= viewHolder.itemView.findViewById(R.id.emailForStudent);
        name1.setText(student.getFirstName());
        name2.setText(student.getMiddleName());
        emailForStudent.setText(student.getStudentEmail());
    }


    @Override
    public int getLayout() {
        return R.layout.item_templete;
    }
}

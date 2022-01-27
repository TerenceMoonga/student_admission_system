  package com.example.student_resgistration_form;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.example.student_resgistration_form.item.StudentItem;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.xwray.groupie.Group;
import com.xwray.groupie.GroupAdapter;
import com.xwray.groupie.GroupieViewHolder;
import com.xwray.groupie.Item;
import com.xwray.groupie.OnItemClickListener;
import com.xwray.groupie.Section;

import java.util.ArrayList;
import java.util.List;

public class TemplateAdmin extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Section section;
    public static final String STUDENT_COLLECTION = "USER_INFO";
    private FirebaseFirestore DB;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template_admin);
        recyclerView = findViewById(R.id.RV_students);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseFirestore.getInstance().collection(STUDENT_COLLECTION).addSnapshotListener((value, error) -> {
            ArrayList<Item> list = new ArrayList<>();

            if (error != null) {

                error.printStackTrace();
            }
            if (!value.isEmpty()) {
//                value.forEach( queryDocumentSnapshot -> {
//
//                    Student student =  queryDocumentSnapshot.toObject(Student.class);
//                    list.add(new StudentItem(student));
//                });


                List<Student> studentList = value.toObjects(Student.class);

                studentList.forEach(student -> {
                    list.add(new StudentItem(student));
                });

                //my deleting code


                DB = FirebaseFirestore.getInstance();




                initRecyclerView(list);

            } else {
                Toast.makeText(this, "no data", Toast.LENGTH_SHORT).show();
            }


        });
    }


    private void initRecyclerView(List<Item> items) {
        GroupAdapter<GroupieViewHolder> adapter = new GroupAdapter<>();
        section = new Section(items);


        adapter.add(section);
        adapter.setOnItemClickListener((item, view) -> {
            if (item instanceof StudentItem) {
                Intent intent = new Intent(TemplateAdmin.this, SingleDocument.class);
                intent.putExtra("student", ((StudentItem) item).getStudent());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);

        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                StudentItem  studentItem = (StudentItem) adapter.getItem(viewHolder.getAdapterPosition());
                DB.collection(STUDENT_COLLECTION).document(studentItem.getStudent().id).delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "document deleted ", Toast.LENGTH_LONG).show();
                        }
                        else
                            Toast.makeText(getApplicationContext(), "document failed to delete ", Toast.LENGTH_LONG).show();
                    }
                });
                adapter.notifyDataSetChanged();

            }
        };
ItemTouchHelper itemTouch= new ItemTouchHelper(itemTouchHelperCallback );
itemTouch.attachToRecyclerView(recyclerView);
    }

}
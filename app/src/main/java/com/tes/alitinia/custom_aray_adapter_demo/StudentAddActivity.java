package com.tes.alitinia.custom_aray_adapter_demo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by Alitinia on 10/14/2016.
 */
public class StudentAddActivity extends AppCompatActivity {

    private EditText edit_id, edit_nim, edit_nama, edit_email, edit_phone; //bisa dipanggil disemua fungsi
    private FloatingActionButton button_Done, button_Cancel;
    private boolean isEdit = false;
    ArrayList<Student> studentList;
    private int position;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);
        studentList = StudentActivity.studentList;

        edit_id = (EditText) findViewById(R.id.edit_id);
        edit_nim = (EditText) findViewById(R.id.edit_nim);
        edit_nama = (EditText) findViewById(R.id.edit_nama);
        edit_email = (EditText) findViewById(R.id.edit_email);
        edit_phone = (EditText) findViewById(R.id.edit_phone);

        Intent i = getIntent();
        if(i.getBooleanExtra("isEdit", true)) {
            isEdit = true;
            Student student = (Student) i.getSerializableExtra("student");
            edit_id.setText(String.valueOf(student.getId()));
            edit_nim.setText(student.getNoreg());
            edit_nama.setText(student.getName());
            edit_email.setText(student.getMail());
            edit_phone.setText(student.getPhone());
            position = i.getIntExtra("position", 0);
        } else {
            edit_id.setText(String.valueOf(studentList.size()));
        }

        button_Done = (FloatingActionButton) findViewById(R.id.button_Done);
        button_Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveStudent();
            }
        });

        button_Cancel = (FloatingActionButton) findViewById(R.id.button_Cancel);
        button_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void saveStudent(){

        if (isEdit){
            Student tmpStudent = new Student(Integer.parseInt(edit_id.getText().toString()), edit_nim.getText().toString(), edit_nama.getText().toString(), edit_email.getText().toString(), edit_phone.getText().toString());
            studentList.set(position, tmpStudent);
            finish();
        } else {
            Student tmpStudent = new Student(Integer.parseInt(edit_id.getText().toString()), edit_nim.getText().toString(), edit_nama.getText().toString(), edit_email.getText().toString(), edit_phone.getText().toString());
            studentList.add(tmpStudent);
            finish();
        }
    }

}

package com.tes.alitinia.custom_aray_adapter_demo;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by Alitinia on 10/14/2016.
 */
public class AddStudentActivity extends AppCompatActivity {

    private EditText edit_id, edit_nim, edit_nama, edit_email, edit_phone; //bisa dipanggil disemua fungsi
    private FloatingActionButton btnDone, btnCancel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        edit_id = (EditText) findViewById(R.id.edit_id);
        edit_nim = (EditText) findViewById(R.id.edit_nim);
        edit_nama = (EditText) findViewById(R.id.edit_nama);
        edit_email = (EditText) findViewById(R.id.edit_email);
        edit_phone = (EditText) findViewById(R.id.edit_phone);

        Intent i = getIntent();
        if(i.getBooleanExtra("isEdit", true)) {
            Student student = (Student) i.getSerializableExtra("student");
            edit_id.setText(String.valueOf(student.getId()));
            edit_nim.setText(student.getNoreg());
            edit_nama.setText(student.getName());
            edit_email.setText(student.getMail());
            edit_phone.setText(student.getPhone());
        } else {

        }


    }
}

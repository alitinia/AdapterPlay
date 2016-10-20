package com.tes.alitinia.custom_aray_adapter_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Alitinia on 10/7/2016.
 */
public class StudentActivity extends AppCompatActivity {
    private StudentArrayAdapter studentArrayAdapter;
    private ListView listView;
    private TextView emptyTextView;
    static ArrayList<Student> studentList;
    private FloatingActionButton button_add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        if (studentList == null) studentList = new ArrayList<Student>();
        studentArrayAdapter = new StudentArrayAdapter(this, studentList);
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student studentItem = studentList.get(position);
                Intent i = new Intent(StudentActivity.this, AddStudentActivity.class);
                i.putExtra("student", studentItem); // ini passing object
                i.putExtra("isEdit", true);
                i.putExtra("position", position);
                startActivity(i);
            }
        });
        button_add = (FloatingActionButton) findViewById(R.id.button_add);
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StudentActivity.this, AddStudentActivity.class);
                i.putExtra("isEdit", false);
                startActivity(i);
            }
        });


    }

    private void populateStudentDummies() {
        int i = studentList.size();
        studentList.add(new Student(i, "Alitinia", "3145136208", "alitinia@yahoo.com", "081291429749"));
        studentList.add(new Student(i+1, "Prastiantari", "3145136209", "prastian@yahoo.com", "081291459285"));
    }

    public void createDummy(){
        populateStudentDummies();
        studentArrayAdapter = new StudentArrayAdapter(this, studentList);
        listView.setAdapter(studentArrayAdapter);
    }

    public void clearData(){
        studentList.clear();
        studentArrayAdapter = new StudentArrayAdapter(this, studentList);
        listView.setAdapter(studentArrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_student_list, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        emptyTextView = (TextView) findViewById(R.id.emptyTextView);
        if(studentList.size() == 0) {
            studentArrayAdapter = new StudentArrayAdapter(this, new ArrayList<Student>());
            listView.setEmptyView(emptyTextView);
            emptyTextView.setText("Student Not Found");
        } else {
            studentArrayAdapter = new StudentArrayAdapter(this, studentList);
            emptyTextView.setText("");
        }
        listView.setAdapter(studentArrayAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.create_dummy:
                createDummy();
                return true;
            case R.id.clear_list:
                clearData();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

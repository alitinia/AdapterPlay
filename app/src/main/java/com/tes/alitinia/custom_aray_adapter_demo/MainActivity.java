package com.tes.alitinia.custom_aray_adapter_demo;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Alitinia on 10/16/2016.
 */

public class MainActivity extends AppCompatActivity {
    private TextView showStudent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showStudent = (TextView) findViewById(R.id.showStudent);

        showStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, StudentActivity.class);
                startActivity(i);
            }
        });

    }
}

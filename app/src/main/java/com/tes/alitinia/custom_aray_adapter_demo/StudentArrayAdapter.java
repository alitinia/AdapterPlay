package com.tes.alitinia.custom_aray_adapter_demo;

/**
 * Created by Alitinia on 10/7/2016.
 */
import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


    public class StudentArrayAdapter extends ArrayAdapter <Student> {
        public StudentArrayAdapter(Context context, ArrayList<Student> student){
            super(context, 0, student);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            Student student = getItem(position);
            if (convertView ==null){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.student_instance, parent, false);
            }
            TextView id = (TextView) convertView.findViewById(R.id.no);
            TextView noreg = (TextView) convertView.findViewById(R.id.noreg);
            TextView name = (TextView) convertView.findViewById(R.id.name);
            TextView email = (TextView) convertView.findViewById(R.id.email);
            TextView phone = (TextView) convertView.findViewById(R.id.phone);
            // Populate the data into the template view using the data object

            id.setText(student.getId()+"");
            noreg.setText(student.getNoreg());
            name.setText(student.getName());
            email.setText(student.getMail());
            phone.setText(student.getPhone());
            // Return the completed view to render on screen
            return convertView;
        }

    }
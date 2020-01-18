package com.example.customlistadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewPersonForm extends AppCompatActivity {

    Button btn_okay,btn_cancel;
    EditText et_name, et_age, et_picNum;

    int positionToEdit = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_person_form);

        et_name = (EditText)findViewById(R.id.et_name);
        et_age = (EditText)findViewById(R.id.et_age);
        et_picNum = (EditText)findViewById(R.id.et_picNum);

        //listen for incoming intent
        Bundle incomeingMes = getIntent().getExtras();

        if(incomeingMes != null){
            String name = incomeingMes.getString("name");
            int age = incomeingMes.getInt("age");
            int picNum = incomeingMes.getInt("picNum");

            positionToEdit = incomeingMes.getInt("edited");

            //Auto fill in form
            et_name.setText(name);
            et_age.setText(Integer.toString(age));
            et_picNum.setText(Integer.toString(picNum));
        }

        btn_okay = (Button)findViewById(R.id.btn_okay);
        btn_okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
                //get string from editText views
                String newName = et_name.getText().toString();
                String newAge = et_age.getText().toString();
                String newPicNum = et_picNum.getText().toString();

                //Formulate message to send to main active
                i.putExtra("edited", positionToEdit);
                i.putExtra("name", newName );
                i.putExtra("age", newAge );
                i.putExtra("picNum", newPicNum );

                //Start Main Activity Again



                startActivity(i);
            }
        });


        btn_cancel = (Button)findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
                startActivity(i);
            }
        });


    }
}

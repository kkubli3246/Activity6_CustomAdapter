package com.example.customlistadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    Button btn_add;
    Button btn_sortABC;
    Button btn_sortAge;

    ListView lv_friends;

    myFriends myFriends;

    PersonAdapter personAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_friends = (ListView) findViewById(R.id.lv_friends);


        btn_add = (Button) findViewById(R.id.btn_add);
        btn_sortABC = (Button) findViewById(R.id.btn_sortABC);
        btn_sortAge = (Button) findViewById(R.id.btn_sort123);

        myFriends = ((MyApplication) this.getApplication()).getMyFriends();

        personAdapter = new PersonAdapter(MainActivity.this, myFriends);

        lv_friends.setAdapter(personAdapter);

        //Listen to incoming Messages from other Activiteies
        Bundle incomeingMes = getIntent().getExtras();

        if (incomeingMes != null) {
            //Capture data is incoming

            String name = incomeingMes.getString("name");
            int age = Integer.parseInt(incomeingMes.getString("age"));
            int picNum = Integer.parseInt((incomeingMes.getString("picNum")));
            int positionEdited = incomeingMes.getInt("edited");


            //create new persons object
            Person p = new Person(name,age,picNum);

            //Add person to list and update adapter
            if(positionEdited > -1){
                myFriends.getMyFriends().remove(positionEdited);
            }
            myFriends.getMyFriends().add(p);
            personAdapter.notifyDataSetChanged();

        }



        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), NewPersonForm.class);
                startActivity(i);
            }
        });

        btn_sortAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(myFriends.getMyFriends(), new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return o1.getAge() - o2.getAge();
                    }
                });
                personAdapter.notifyDataSetChanged();
            }
        });

        btn_sortABC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(myFriends.getMyFriends());
                personAdapter.notifyDataSetChanged();
            }
        });

        lv_friends.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                editPerson(position);
            }
        });



    }
    public void editPerson(int position){
        Intent i = new Intent(getApplicationContext(), NewPersonForm.class);

        //get person info at position
        Person p = myFriends.getMyFriends().get(position);

        i.putExtra("name", p.getName());
        i.putExtra("age", p.getAge());
        i.putExtra("picNum", p.getPicNum());
        i.putExtra("edited", position);


        startActivity(i);
    }
}

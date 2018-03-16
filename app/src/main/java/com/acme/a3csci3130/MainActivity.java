package com.acme.a3csci3130;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Button;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends Activity {


    private ListView businessListView;
    private FirebaseListAdapter<Business> firebaseAdapter;
    Button submit = (Button) findViewById(R.id.submitButton);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyApplicationData appData = (MyApplicationData)getApplication();

        appData.firebaseDBInstance = FirebaseDatabase.getInstance();
        appData.firebaseReference = appData.firebaseDBInstance.getReference("assignment3");

        businessListView = (ListView) findViewById(R.id.listView);

        firebaseAdapter = new FirebaseListAdapter<Business>(this, Business.class,
                android.R.layout.simple_list_item_1, appData.firebaseReference) {
            @Override
            protected void populateView(View v, Business model, int position) {
                TextView contactName = (TextView)v.findViewById(android.R.id.text1);
                contactName.setText(model.name);
            }
        };


        businessListView.setAdapter(firebaseAdapter);
        businessListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Business business = (Business) firebaseAdapter.getItem(position);
                showDetailView(business);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                startActivity(new Intent(MainActivity.this, CreateBusinessActivity.class));
            }
        });
    }

    private void showDetailView(Business business)
    {
        Intent intent = new Intent(this, DetailViewActivity.class);
        intent.putExtra("Business", business);
        startActivity(intent);
    }
}

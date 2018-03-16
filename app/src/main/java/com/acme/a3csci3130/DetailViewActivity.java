package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailViewActivity extends Activity {

    private EditText nameField, addressField, provinceField, primaryField, numberField;

    Business businessInfo;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        businessInfo = (Business)getIntent().getSerializableExtra("Business");

        appState = ((MyApplicationData) getApplicationContext());

        nameField = (EditText) findViewById(R.id.name);
        numberField= (EditText) findViewById(R.id.number);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);
        primaryField = (EditText) findViewById(R.id.primary);

        if(businessInfo != null){
            nameField.setText(businessInfo.name);
            numberField.setText(businessInfo.number);
            provinceField.setText(businessInfo.province);
            addressField.setText(businessInfo.address);
            primaryField.setText(businessInfo.primary);
        }
    }

    //Update a business
    public void updateBusiness(View v){
        String businessID = businessInfo.busId;
        String name = nameField.getText().toString();
        String number = numberField.getText().toString();
        String province = provinceField.getText().toString();
        String address = addressField.getText().toString();
        String primary = primaryField.getText().toString();
        Business business = new Business(businessID, name,number,province,address,primary);
        appState.firebaseReference.child(businessInfo.busId).setValue(business);

        finish();
    }

    //delete a business
    public void deleteBusiness(View v)
    {
        appState.firebaseReference.child(businessInfo.busId).removeValue();
        finish();
    }
}
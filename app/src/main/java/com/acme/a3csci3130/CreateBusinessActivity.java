package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by brandonhussey on 2018-03-15.
 */

public class CreateBusinessActivity extends Activity {

        private Button submitButton;
        private EditText nameField, addressField, numberField, provinceField, primayField;
        private MyApplicationData appState;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_create_contact_acitivity);
            appState = ((MyApplicationData) getApplicationContext());

            Button submitButton = (Button) findViewById(R.id.submitButton);
            EditText nameField = (EditText) findViewById(R.id.name);
            EditText addressField = (EditText) findViewById(R.id.address);
            EditText numberField = (EditText) findViewById(R.id.number);
            EditText provinceField = (EditText) findViewById(R.id.province);
            EditText primaryField = (EditText) findViewById(R.id.primary);

        }

        public void submitInfoButton(View v) {

            String businessID = appState.firebaseReference.push().getKey();
            String number = numberField.getText().toString();
            String name = nameField.getText().toString();
            String address = addressField.getText().toString();
            String province = provinceField.getText().toString();
            String primary_business = primayField.getText().toString();
            Business newBusiness = new Business(businessID, name, number, province, address, primary_business);

            appState.firebaseReference.child(businessID).setValue(newBusiness);

            finish();

        }
}

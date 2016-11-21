package com.example.wangjing.myapplication;

import android.app.Activity;
//import android.app.AlertDialog;
//import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
//import android.provider.ContactsContract;
//import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends Activity implements View.OnClickListener{
    //create objects
    private Button buttonLogin;
    private EditText editTextLogin;
    private EditText editTextPassword;
    private RadioButton radioButtonSettings;
    private RadioButton radioButtonProfiles;
    private RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get selected radio button from radioGroup
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //find which radio button is selected
                if(checkedId == R.id.activity_settings){
                    Toast.makeText(getApplicationContext(),"choice:Settings",Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(getApplicationContext(),"choice:Profiles",Toast.LENGTH_SHORT).show();

                }
            }
        });

        //link java objects to widgets in UI
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        editTextLogin = (EditText) findViewById(R.id.editTextLogin);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        radioButtonProfiles = (RadioButton) findViewById(R.id.radioButtonProfile);
        radioButtonSettings = (RadioButton) findViewById(R.id.radioButtonSettings);



        buttonLogin.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        //event handle
        if(editTextLogin.getText().toString().equals("user")
            & editTextPassword.getText().toString().equals("1234")) {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
            int selectedId = radioGroup.getCheckedRadioButtonId();
            //find which radioButton is checked by id
            if(selectedId == radioButtonSettings.getId()) {
                Intent intent = new Intent(MainActivity.this, Settings.class);
                startActivity(intent);
            }else{
                Intent intent = new Intent(MainActivity.this,Profiles.class);
                startActivity(intent);

            }

        }else{
            Toast.makeText(this,"Login Denied", Toast.LENGTH_SHORT).show();
            Toast.makeText(this,"",Toast.LENGTH_SHORT).show();
        }
        }

    }


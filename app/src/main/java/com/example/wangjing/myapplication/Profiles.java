package com.example.wangjing.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Profiles extends Activity implements View.OnClickListener {
    private Button buttonProfileLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiles);
        //step2:Link to UI
        buttonProfileLogout = (Button) findViewById(R.id.buttonSettingLogout);
        //step3:start a listener
        buttonProfileLogout.setOnClickListener(this);

        @Override
        public void onClick(View v) {

            //start a DialogBox
            new AlertDialog.Builder(this)
                    .setMessage("Logout")
                    .setPositiveButton("Yes",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(Profiles.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            })
                    .setNegativeButton("No",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(Profiles.this, "Stay here", Toast.LENGTH_SHORT).show();
                                }
                            }).show();

        }
}

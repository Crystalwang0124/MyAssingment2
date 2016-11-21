package com.example.wangjing.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Settings extends Activity implements View.OnClickListener {
    //step1:declare objects
    private Button buttonSettingLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //step2:Link to UI
        buttonSettingLogout = (Button) findViewById(R.id.buttonSettingLogout);
        //step3:start a listener
        buttonSettingLogout.setOnClickListener(this);

        @Override
        public void onClick(View v) {

            //start a DialogBox
            new AlertDialog.Builder(this)
                    .setMessage("Logout")
                    .setPositiveButton("Yes",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(Settings.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            })
                    .setNegativeButton("No",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(Settings.this, "Stay here", Toast.LENGTH_SHORT).show();
                                }
                            }).show();

    }
}

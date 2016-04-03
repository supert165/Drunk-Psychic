package com.example.android.drunkness_tester;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.telephony.SmsManager;
import java.util.Random;

public class DrunkActivity extends AppCompatActivity {


    private TextView mPrevSavingsAccount;
    private TextView mCurSavingsAccount;
    private TextView mPrevCheckingtAccount;
    private TextView mCurCheckingAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drunk);

        mPrevCheckingtAccount=(TextView)findViewById(R.id.oldChecking);
        mCurCheckingAccount=(TextView)findViewById(R.id.newChecking);
        mPrevSavingsAccount=(TextView)findViewById(R.id.oldSavings);
        mCurSavingsAccount=(TextView)findViewById(R.id.newSavings);


        Random random = new Random();

        //mPrevCheckingtAccount.setText("$" + random.nextInt(600));

        sendSMS("7607925644", "Help! I'm drunk and I need you to pick me up!");


    }




    public void sendSMS(String phoneNo, String msg){
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, msg, null, null);
            Toast.makeText(getApplicationContext(), "Message Sent",
                    Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(),ex.getMessage().toString(),
                    Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }




}

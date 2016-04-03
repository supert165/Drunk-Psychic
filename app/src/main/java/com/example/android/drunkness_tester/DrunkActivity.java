package com.example.android.drunkness_tester;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DrunkActivity extends AppCompatActivity {


    private TextView mPrevSavingsAccount;
    private TextView mCurSavingsAccount;
    private TextView mPrevCheckingtAccount;
    private TextView mCurCheckingAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drunk);

        mPrevCheckingtAccount=(TextView)findViewById(R.id.prevCheckAcc);
        mCurCheckingAccount=(TextView)findViewById(R.id.curCheckAcc);
        mPrevSavingsAccount=(TextView)findViewById(R.id.prevSavAcc);
        mCurSavingsAccount=(TextView)findViewById(R.id.curSavAcc);

        sendText();


    }


    //using email code
    public void sendText() {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        String uriText = "mailto:" + Uri.encode("6156187905") +
                "?subject=" + Uri.encode("I'm drunk, pick me up") +
                "&body=" + Uri.encode("I'm drunk. Can you pick me up?");
        Uri uri = Uri.parse(uriText);

        intent.setData(uri);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(intent, "Send text..."));
        }
    }




}

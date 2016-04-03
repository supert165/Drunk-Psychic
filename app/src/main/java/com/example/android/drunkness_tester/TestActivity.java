package com.example.android.drunkness_tester;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.getpebble.android.kit.PebbleKit;
import com.getpebble.android.kit.util.PebbleDictionary;

import java.util.UUID;

public class TestActivity extends AppCompatActivity {

    private static final UUID APP_UUID = UUID.fromString("736efa9e-548f-4966-8de8-0725563ff310");
    private PebbleKit.PebbleDataReceiver mDataReceiver;
    private ImageButton mStartButton;
    private TextView mInstructions;
    private Boolean mClicked = false;
    private Long result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mStartButton = (ImageButton) findViewById(R.id.imageButtonTest);
        mInstructions = (TextView) findViewById(R.id.instructions);


        //anonymous inner class as parameter
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toPebblePage();
            }
        });
    }

    private void toPebblePage() {
        Intent intent= new Intent(this, pebbleTestActivity.class);
        startActivity(intent);
    }

/*
    public void onResume(Bundle savedInstanceState) {
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mClicked == true) {
                    Context context = getApplicationContext();
                    CharSequence text = "Test in progress";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    mClicked = true;

                    PebbleKit.startAppOnPebble(getApplicationContext(), APP_UUID);

                    if (mDataReceiver == null) {
                        mDataReceiver = new PebbleKit.PebbleDataReceiver(APP_UUID) {

                            @Override
                            public void receiveData(Context context, int transactionId, PebbleDictionary dict) {
                                PebbleKit.sendAckToPebble(context, transactionId);

                                //Up received?
                                result = dict.getInteger(0);

                            }
                        };
                    }

                    PebbleKit.registerReceivedDataHandler(getApplicationContext(), mDataReceiver);


                    mClicked = false;
                }


            }
        });
    }
    */
}





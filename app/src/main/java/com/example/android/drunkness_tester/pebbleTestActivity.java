package com.example.android.drunkness_tester;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.android.drunkness_tester.R;
import com.getpebble.android.kit.PebbleKit;
import com.getpebble.android.kit.util.PebbleDictionary;

import java.util.UUID;

public class pebbleTestActivity extends AppCompatActivity {

    private static final UUID APP_UUID = UUID.fromString("0e35dbe1-01f6-445d-a319-488e0047b083");

    private PebbleKit.PebbleDataReceiver mDataReceiver;

    private TextView mInstructions;
    private Boolean mClicked = false;
    private Long result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pebble_test);
        PebbleKit.startAppOnPebble(getApplicationContext(), APP_UUID);
    }

    @Override
    protected void onResume() {
        super.onResume();



        if (mDataReceiver == null) {
            mDataReceiver = new PebbleKit.PebbleDataReceiver(APP_UUID) {

                @Override
                public void receiveData(Context context, int transactionId, PebbleDictionary dict) {
                    PebbleKit.sendAckToPebble(context, transactionId);

                    //Up received?
                    result = dict.getInteger(0);

                    if (result == 0) {
                        notDrunk();
                    }

                    else {
                        drunk();
                    }



                }
            };
            PebbleKit.registerReceivedDataHandler(getApplicationContext(), mDataReceiver);
        }

    }

    private void notDrunk() {
        Intent intent = new Intent(this, NotDrunkActivity.class);
        startActivity(intent);
    }

    private void drunk() {
        Intent intent = new Intent(this, DrunkActivity.class);
        startActivity(intent);
    }

}

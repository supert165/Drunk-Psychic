package com.example.android.drunkness_tester;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MathTest extends AppCompatActivity{

    public static final String TAG = MathTest.class.getSimpleName();

    private String mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent= this.getIntent();
       // mName= intent.getStringExtra(getString(name));

        //if name is null, set it to default value
        if(mName == null || mName==""){
            mName="Friend";
        }

        Log.d(TAG, mName);
    }

}

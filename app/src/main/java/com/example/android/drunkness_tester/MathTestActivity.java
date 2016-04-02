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
import android.widget.TextView;


public class MathTestActivity extends AppCompatActivity{

    public static final String TAG = MathTestActivity.class.getSimpleName();

    private String mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_test);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                mName = null;
            } else {
                mName = extras.getString("name");
            }
        } else {
            mName = (String) savedInstanceState.getSerializable("name");
        }

        writeMyName(mName);
    }

    public void writeMyName(String name){
        TextView mText=(TextView) findViewById(R.id.nameTextView);
        mText.setText(name);

    }

}

package com.example.android.drunkness_tester;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class InformationDataActivity extends AppCompatActivity{

    public static final String TAG = InformationDataActivity.class.getSimpleName();

    private String mName;
    private EditText mNumberDrinks;
    private EditText mGender;
    private ImageButton mTestButton;
    private EditText mTimeInHours;
    private EditText mWeightText;



    ArrayAdapter<CharSequence> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_test);

        mNumberDrinks=(EditText)findViewById(R.id.numberDrinks);
        mGender =(EditText) findViewById(R.id.genderTextView);
        mTestButton=(ImageButton)findViewById(R.id.imageButton);
        mTimeInHours=(EditText)findViewById(R.id.timeHours);
        mWeightText=(EditText)findViewById(R.id.weightText);


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

        mTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mGender.getText() == null || mNumberDrinks.getText() == null || mTimeInHours.getText() == null ||
                        mWeightText.getText() == null) {
                    Context context = getApplicationContext();
                    CharSequence text = "Please write something!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    int numDrinks = Integer.parseInt(mNumberDrinks.getText().toString());
                    double timeHours = Double.valueOf(mTimeInHours.getText().toString());
                    int weight = Integer.parseInt(mWeightText.getText().toString());
                    Log.d(TAG, "time in hours is " + timeHours);
                    String gender = mGender.getText().toString().toLowerCase();

                    if (gender.charAt(0) != 'm' && gender.charAt(0) != 'f' && gender.charAt(0) != 'o') {

                        Context context = getApplicationContext();
                        CharSequence text = "You chose " + gender.charAt(0);
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    } else if (timeHours >= 23) {
                        Context context = getApplicationContext();
                        CharSequence text = "You're not dead yet! Fix the drinking time!";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    } else if (numDrinks >= 15 && (numDrinks / timeHours) >= 4) {

                        Context context = getApplicationContext();
                        CharSequence text = "You're not dead yet! Fix the number of drinks!";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();

                    } else if (weight >= 999 || weight <= 50) {
                        Context context = getApplicationContext();
                        CharSequence text = "You're either a very precocious baby or a large tree. Either way, good luck drinking!";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    } else if ((gender.charAt(0) == 'm' || gender.charAt(0) == 'o')
                            && ((numDrinks * 1.0) / timeHours >= 1.5)) {
                        startTest();
                    } else if (gender.charAt(0) == 'f' &&
                            (numDrinks * 1.0) / timeHours >= 1.2) {
                        startTest();
                    } else {
                        startNotDrunkActivity();
                    }


                }
            }
        });

    }

    public void writeMyName(String name){
        TextView mText=(TextView) findViewById(R.id.welcomeTextView);
        String welcomeText= "Hey "+ name+".Looks like you're looking to for a little fun. Let us be the grown up for tonight. ";
        mText.setText(welcomeText);
    }

    public void startTest(){
        Intent intent= new Intent(this,TestActivity.class);
        startActivity(intent);
    }

    public void startNotDrunkActivity(){
        Intent intent= new Intent(this,NotDrunkActivity.class);
        startActivity(intent);
    }




}

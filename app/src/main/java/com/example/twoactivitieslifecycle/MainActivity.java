
package com.example.twoactivitieslifecycle;

import static java.lang.Integer.parseInt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //private int mCount
    private int mCount = 0;
    private TextView mShowCount,text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getting show count by id i.e.textview
        mShowCount = (TextView) findViewById(R.id.show_count);
        if (savedInstanceState != null) {
           mCount=savedInstanceState.getInt("count");
           mShowCount.setText(""+mCount);
        }
    }
    public void countUp(View view) {
        //increased mCount
        mCount++;
        //if mShowCount is not null
        if (mShowCount != null)
            //set the value of textview
            mShowCount.setText(Integer.toString(mCount));
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState);
        EditText text=findViewById(R.id.editTextTextPersonName);
        CharSequence data=text.getText();
        outState.putCharSequence("data",data);
         outState.putInt("count",mCount);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        CharSequence data=savedInstanceState.getCharSequence("data");
        EditText text=findViewById(R.id.editTextTextPersonName);
        text.setText(data);
    }

}
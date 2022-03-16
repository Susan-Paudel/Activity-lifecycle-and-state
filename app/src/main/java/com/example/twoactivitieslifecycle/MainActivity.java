
package com.example.twoactivitieslifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TEXT_VIEW_KEY = "hello";
    //private int mCount
    private int mCount = 0;
    private TextView mShowCount,text;
    String gameState;
    static final String GAME_STATE_KEY = "user";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getting show count by id i.e.textview
        mShowCount = (TextView) findViewById(R.id.show_count);
        text=findViewById(R.id.editTextTextPersonName);
        if (savedInstanceState != null) {
            gameState = savedInstanceState.getString(GAME_STATE_KEY);
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
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        mShowCount.setText(savedInstanceState.getString(TEXT_VIEW_KEY));
        text.setText(savedInstanceState.getString(TEXT_VIEW_KEY));
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(GAME_STATE_KEY, gameState);
        outState.putString(TEXT_VIEW_KEY, mShowCount.getText().toString());
        outState.putString(TEXT_VIEW_KEY, text.getText().toString());

        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState);
    }
}
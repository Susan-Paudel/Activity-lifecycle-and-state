package com.example.twoactivitieslifecycle;
//import required library
import static java.lang.Integer.parseInt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
//MinActivity child class inherit all the property of AppCompatActivity i.e. parent
public class MainActivity extends AppCompatActivity {
    //private int mCount
    private int mCount = 0;
    //private TextView
    private TextView mShowCount;
    /**
     * Initializes the activity.
     *
     * @param savedInstanceState The current state data.
     * Activities have the ability,to restore themselves to a previous state using the data stored in this bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //super keyword is used to refer parent class object
        super.onCreate(savedInstanceState);
        //it set the XML file as your main layout when the app starts
        setContentView(R.layout.activity_main);
        //getting show count by id i.e.textview
        mShowCount = (TextView) findViewById(R.id.show_count);
        //if savedInstanceState is not null
        if (savedInstanceState != null) {
            //set mCount value from count
           mCount=savedInstanceState.getInt("count");
           //setText
           mShowCount.setText(""+mCount);
        }
    }
    /**
     *  @param view The view (Button) that was clicked.
     *  when the button is clicked count value will increase
     */
    public void countUp(View view) {
        //increased mCount
        mCount++;
        //if mShowCount is not null
        if (mShowCount != null)
            //set the value of textview
            mShowCount.setText(Integer.toString(mCount));
    }
    /**
     * Initializes the activity.
     *
     * @param outState  the state going out (being saved, not read)
     * Activities have the ability,to save a previous state using the data stored in this bundle
     */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState);
        //find view by id for Edittext
        EditText text=findViewById(R.id.editTextTextPersonName);
        //get the text from editText
        CharSequence data=text.getText();
        //put the data into outState
        outState.putCharSequence("data",data);
        outState.putInt("count",mCount);
    }
    /**
     * Initializes the activity.
     *
     * @param savedInstanceState The current state data.
     * Activities have the ability,to restore themselves to a previous state using the data stored in this bundle
     */
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //save the data into data CharSequence variable
        CharSequence data=savedInstanceState.getCharSequence("data");
        //get text view by id
        EditText text=findViewById(R.id.editTextTextPersonName);
        //set the data into text
        text.setText(data);
    }

}
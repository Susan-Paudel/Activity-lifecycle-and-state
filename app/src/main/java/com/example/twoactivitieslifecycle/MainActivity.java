package com.example.twoactivitieslifecycle;
//import required library
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
/**
 * Display one Buttons and ten hidden TextView
 * -Clicking the shop button that will redirect two next page to add product
 */
//MinActivity child class inherit all the property of AppCompatActivity i.e. parent
public class MainActivity extends AppCompatActivity {
    // Unique tag for the intent reply
    public static final int TEXT_REQUEST = 1;
    //creating object for ShopList
    private ShopList items = new ShopList();
    public MainActivity() {
    }
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

        Intent intent = getIntent();
        //check if savedInstanceState and array list is not null
        if ((savedInstanceState != null)&& (savedInstanceState.getSerializable("list")!= null)){
            /**
             * It is generally denoted as HashMap <key, value> or HashMap <K,V>
             * creating the object of hashmap
             */
            HashMap<String, Integer> l = (HashMap<String, Integer>)savedInstanceState.getSerializable("list");
            //choosing the textview id
            TextView tv = findViewById(R.id.textView);
            //set text to null for initial phase
            tv.setText("");
            //foreach
            for (String k : l.keySet()) {
                //storing the value to s with values
                String s = l.get(k).toString() + " " + k + "\n";
                //set text
                tv.setText(tv.getText() + s);
                //for loop
                for(int i = 0; i<l.get(k); i++){
                    //add items
                    items.addItem(k);}
            }
        }
    }

    /**
     *  @param view The view (Button) that was clicked.
     *  The TwoActivities app contains two activities and sends messages
     *  (intents) between them.
     */
    public void launchSecondActivity(View view) {
        /**
         * creating object of Intent class
         * @param this focus on MainActivity class and secondActivity class
         * Intent help to link two activity or pages
         */
        Intent intent = new Intent(this, SecondActivity.class);
        //it take some data in it
        startActivityForResult(intent, TEXT_REQUEST);
    }
    /**
     * Initializes the activity.
     *
     * @param savedInstanceState The current state data.
     * Activities have the ability,to restore themselves to a previous state using the data stored in this bundle
     */
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        //super keyword is used to refer parent class object
        super.onSaveInstanceState(savedInstanceState);
        //set the items
        savedInstanceState.putSerializable("list", items.getItems());
    }
    /**
     * Handles the data in the return intent from SecondActivity.
     *
     * @param requestCode Code for the SecondActivity request.
     * @param resultCode Code that comes back from SecondActivity.
     * @param data Intent data sent back from SecondActivity.
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Test for the right intent reply.
        if (requestCode == TEXT_REQUEST) {
            // Test to make sure the intent reply result was good.
            if (resultCode == RESULT_OK) {
                //set the items in new variable
                String item = data.getStringExtra(SecondActivity.EXTRA_MESSAGE);
                //add to items array
                items.addItem(item);
            }
            //allows the user to create drawings
            drawView();
        }
    }
    //function drawView
    public void drawView() {
        //creating object of HashMap Class
        HashMap<String, Integer> l = items.getItems();
        //find the textview with id
        TextView tv = findViewById(R.id.textView);
        //set text
        tv.setText("");
        //for each
        for (String k : l.keySet()) {
            //store value to s with is value
            String s = l.get(k).toString() + " " + k + "\n";
            //set text
            tv.setText(tv.getText() + s);
        }
    }
}
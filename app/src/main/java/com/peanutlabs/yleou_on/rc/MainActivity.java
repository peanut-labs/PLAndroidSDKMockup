package com.peanutlabs.yleou_on.rc;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.peanutlabs.plsdk.*;

import static android.support.v7.appcompat.R.styleable.MenuItem;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = (Button) findViewById(R.id.submit); //Setting up a Button to take you to the Rewards Center
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText inputTxt = (EditText) findViewById(R.id.userName); // Get EditText
                final String enduser = inputTxt.getText().toString(); // Turn EditText and Store as String enduser
                PeanutLabsManager plman = PeanutLabsManager.getInstance();
                plman.setApplicationId(9145); //Your Publisher ID
                plman.setApplicationKey("54dbf08d625158c6d7b055928d6ac0cc");
                plman.setProgramId("kudos");
                plman.setEndUserId(enduser);
                //Alternatively you can give the PL UID like so : plman.setUserId("SDKTest-9145-ffa3df99fe");
                plman.openRewardsCenter(MainActivity.this);
            }
        });
    }
}


/*
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
    }
*/
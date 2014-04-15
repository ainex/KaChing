package com.ulyanova.kaching;

import java.util.Date;

import database.KaChingDbAdapter;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        KaChingDbAdapter dbAdapter = new KaChingDbAdapter(getBaseContext());
        dbAdapter.open();
        Date date = new Date();
        dbAdapter.createRecord(date, "1", 100.0, "Горожанка", "ainex");
        dbAdapter.close();
        Log.w("start", "i did it!");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

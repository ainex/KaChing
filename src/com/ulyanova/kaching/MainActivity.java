package com.ulyanova.kaching;

import java.util.Date;

import database.KaChingDbAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	private final String TAG = this.getClass().getName();
	Button btnAddNewRecord;
	Button btnOpenRecordBook;
	Button btnSettings;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		KaChingDbAdapter dbAdapter = new KaChingDbAdapter(getBaseContext());
		dbAdapter.open();
		Date date = new Date();
		dbAdapter.createRecord(date, "1", 100.0, "Горожанка", "ainex");
		dbAdapter.close();

		btnAddNewRecord = (Button) findViewById(R.id.btnAddNewRecord);
		btnOpenRecordBook = (Button) findViewById(R.id.btnOpenRecordBook);
		btnSettings = (Button) findViewById(R.id.btnSettings);
		btnAddNewRecord.setOnClickListener(this);
		btnOpenRecordBook.setOnClickListener(this);
		btnSettings.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnAddNewRecord:
			Log.d(TAG, "Clicked: " + ((Button) v).getText());
			break;
		case R.id.btnOpenRecordBook:
			Log.d(TAG, "Clicked: " + ((Button) v).getText());
			Intent intent = new Intent(this, CategoryActivity.class);
			startActivity(intent);
			break;
		case R.id.btnSettings:
			Log.d(TAG, "Clicked: " + ((Button) v).getText());
			break;
		}

	}

}

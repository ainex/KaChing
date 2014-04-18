package com.ulyanova.kaching;

import java.util.Date;

import com.ulyanova.kaching.model.Type;

import database.KaChingDbAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CategoryAddActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_category_add);
		Button btnAddNewCategory = (Button) findViewById(R.id.btnAddNewCategory);
		btnAddNewCategory.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnAddNewCategory:
			RadioGroup radiogroup = (RadioGroup) findViewById(R.id.radioGroupType);
			int checkedRadioButtonId = radiogroup.getCheckedRadioButtonId();
			Type type;
			if (checkedRadioButtonId == R.id.radioInc) {
				type = Type.INCOME;
			} else {
				type = Type.EXPENSE; 
			}
			EditText description = (EditText) findViewById(R.id.editTextCategoryName);
			
			KaChingDbAdapter dbAdapter = new KaChingDbAdapter(getBaseContext());
			dbAdapter.open();
			long createdID = dbAdapter.createCategory(type, description.getText().toString());
			dbAdapter.close();
			Toast.makeText(this, "added with code: " + createdID, Toast.LENGTH_SHORT).show();
			// save new category
			// go back to Category List
			Intent intent = new Intent(this, CategoryActivity.class);
			startActivity(intent);
			break;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.category_add, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}

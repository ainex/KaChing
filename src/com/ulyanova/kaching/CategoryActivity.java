package com.ulyanova.kaching;

import database.KaChingDbAdapter;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SimpleCursorAdapter;

public class CategoryActivity extends  ListActivity  {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_category_list);
		KaChingDbAdapter dbAdapter = new KaChingDbAdapter(getBaseContext());
		dbAdapter.open();
		Cursor cursor =  dbAdapter.fetchAllCategories();
		SimpleCursorAdapter notes = new SimpleCursorAdapter(this,
				                R.layout.category_item, cursor, new String[] { "name" }, 
				                new int[] { R.id.tvName});
		setListAdapter(notes);

		dbAdapter.close();
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.category_list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_add_category:
			Intent intent = new Intent(this, CategoryAddActivity.class);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}

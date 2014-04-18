package database;

import java.util.Date;

import com.ulyanova.kaching.model.Type;

import database.KaChingContract.CategoryEntry;
import database.KaChingContract.RecordEntry;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * 
 * CRUD operation implementation
 * 
 */
public class KaChingDbAdapter {

	private Context context;
	private SQLiteDatabase database;
	private KaChingDbHelper dbHelper;

	public KaChingDbAdapter(Context context) {
		this.context = context;
	}

	public KaChingDbAdapter open() throws SQLException {
		dbHelper = new KaChingDbHelper(context);
		database = dbHelper.getWritableDatabase();

		return this;
	}

	public void close() {
		dbHelper.close();
	}

	public long createRecord(Date date, String type, double value,
			String description, String user) {
		ContentValues values = new ContentValues();

		values.put(RecordEntry.COLUMN_NAME_DATETIME, date.getTime());
		// values.put(RecordEntry.COLUMN_NAME_DATETIME, "datetime()" );
		values.put(RecordEntry.COLUMN_NAME_TYPE, type);
		values.put(RecordEntry.COLUMN_NAME_VALUE, value);
		values.put(RecordEntry.COLUMN_NAME_DESCRIPTION, description);
		values.put(RecordEntry.COLUMN_NAME_USER, user);

		/*
		 * The first argument for insert() is simply the table name. The second
		 * argument provides the name of a column in which the framework can
		 * insert NULL in the event that the ContentValues is empty (if you
		 * instead set this to "null", then the framework will not insert a row
		 * when there are no values).
		 */
		return database.insert(RecordEntry.TABLE_NAME, null, values);
	}

	public boolean updateRecord(long rowId, Date date, String type,
			Double value, String description, String user) {
		/*
		 * It will check is there a row with date = '15/03/2013 if there is no
		 * row, then no rows will effect, and the update method will return 0 If
		 * I understand your question, Where clause is optional, it may be null,
		 * if you don't provide where clause it will update all the rows in a
		 * table. It is just a sql thing, like if you don't supply where
		 * condition it will update all rows. documentation clearly says that,
		 * Parameters whereClause the optional WHERE clause to apply when
		 * updating. Passing null will update all rows. SqlliteData Update
		 */
		ContentValues values = new ContentValues();
		values.put(RecordEntry.COLUMN_NAME_DATETIME, date.getTime());
		values.put(RecordEntry.COLUMN_NAME_TYPE, type);
		values.put(RecordEntry.COLUMN_NAME_VALUE, value);
		values.put(RecordEntry.COLUMN_NAME_DESCRIPTION, description);
		values.put(RecordEntry.COLUMN_NAME_USER, user);
		return database.update(RecordEntry.TABLE_NAME, values,
				RecordEntry.COLUMN_NAME_ID + "=" + rowId, null) > 0;

	}

	public boolean deleteRecord(long rowId) {
		return database.delete(RecordEntry.TABLE_NAME,
				RecordEntry.COLUMN_NAME_ID + "=" + rowId, null) > 0;
	}

	public long createCategory(Type type, String name) {
		ContentValues values = new ContentValues();

		values.put(CategoryEntry.COLUMN_NAME_TYPE, type.ordinal());
		values.put(CategoryEntry.COLUMN_NAME_NAME, name);

		return database.insert(CategoryEntry.TABLE_NAME, null, values);
	}

	public boolean updateCategory(long rowId, Type type, String name) {
		ContentValues values = new ContentValues();
		values.put(CategoryEntry.COLUMN_NAME_TYPE, type.ordinal());
		values.put(CategoryEntry.COLUMN_NAME_NAME, name);
		return database.update(CategoryEntry.TABLE_NAME, values,
				CategoryEntry.COLUMN_NAME_ID + "=" + rowId, null) > 0;

	}

	public boolean deleteCategory(long rowId) {
		return database.delete(CategoryEntry.TABLE_NAME,
				CategoryEntry.COLUMN_NAME_ID + "=" + rowId, null) > 0;
	}
	
	public Cursor fetchAllCategories() {
		        return database.query(CategoryEntry.TABLE_NAME, null, null, null, null, null, null);
		    }


	
}

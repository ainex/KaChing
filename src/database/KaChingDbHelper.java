package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import database.KaChingContract.CategoryEntry;
import database.KaChingContract.RecordEntry;
import database.KaChingContract.UserEntry;

public class KaChingDbHelper extends SQLiteOpenHelper {
	// If you change the database schema, you must increment the database
	// version.
	public static final int DATABASE_VERSION = 6;
	public static final String DATABASE_NAME = "KaChing.bd";

	public KaChingDbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(RecordEntry.SQL_CREATE_ENTRIES);
		db.execSQL(CategoryEntry.SQL_CREATE_ENTRIES);
		db.execSQL(UserEntry.SQL_CREATE_ENTRIES);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// This database is only a cache for online data, so its upgrade policy
		// is
		// to simply to discard the data and start over
		db.execSQL(RecordEntry.SQL_DELETE_ENTRIES);
		db.execSQL(CategoryEntry.SQL_DELETE_ENTRIES);
		db.execSQL(UserEntry.SQL_DELETE_ENTRIES);
		onCreate(db);

	}

	@Override
	public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		onUpgrade(db, oldVersion, newVersion);
	}

}

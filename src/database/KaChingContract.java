package database;

public final class KaChingContract {
	 /* To prevent someone from accidentally instantiating the contract class,
	  * give it an empty constructor */
	public KaChingContract() {}
	
	/* Inner class that defines the table contents */
	public static abstract class RecordEntry {
	
		public static final String TABLE_NAME = "Record";
		public static final String COLUMN_NAME_ID = "_id";
		public static final String COLUMN_NAME_DATETIME = "date";
		public static final String COLUMN_NAME_TYPE = "type";
		public static final String COLUMN_NAME_VALUE = "value";
		public static final String COLUMN_NAME_DESCRIPTION = "description";
		public static final String COLUMN_NAME_USER = "user";
		
		
		private static final String TEXT_TYPE = " TEXT";
		private static final String INTEGER_TYPE = " INTEGER"; 
		private static final String REAL_TYPE = " REAL"; 
		private static final String COMMA_SEP = ",";
		public static final String SQL_CREATE_ENTRIES =
		    "CREATE TABLE " + TABLE_NAME + " (" +
		    COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
		    COLUMN_NAME_DATETIME + INTEGER_TYPE + COMMA_SEP +
		    COLUMN_NAME_TYPE + TEXT_TYPE + COMMA_SEP +
		    COLUMN_NAME_VALUE + REAL_TYPE + COMMA_SEP +
		    COLUMN_NAME_DESCRIPTION + TEXT_TYPE + COMMA_SEP +
		    COLUMN_NAME_USER + TEXT_TYPE +
		    // Any other options for the CREATE command
		    " )";

		public static final String SQL_DELETE_ENTRIES =
		    "DROP TABLE IF EXISTS " + RecordEntry.TABLE_NAME;
	} 

}

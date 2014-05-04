package com.ulyanova.kaching;

import java.util.Calendar;
import java.util.Date;

import com.ulyanova.kaching.model.Type;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.TextView;

public class AddNewRecordActivity extends Activity implements OnClickListener {
	private final int DATE_DIALOG_ID = 1;
	private int year;
	private int month;
	private int day;

	TextView tvDate = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_new_record);
		setCurrentDateOnView();
		tvDate = (TextView) findViewById(R.id.editTextDate);
	}

	// display current date
	public void setCurrentDateOnView() {

		tvDate = (TextView) findViewById(R.id.editTextDate);

		final Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);

		// set current date into TextView
		tvDate.setText(new StringBuilder().append(day).append("/")
				.append(month + 1).append("/").append(year));

		// set current date into datepicker
		// dpResult.init(year, month, day, null);

	}

	public void onDateClick(View view) {
		showDialog(DATE_DIALOG_ID);
	}

	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DATE_DIALOG_ID:
			// set date picker as current date
			return new DatePickerDialog(this, datePickerCallBack, year, month,
					day);
		}
		return null;

	}

	private DatePickerDialog.OnDateSetListener datePickerCallBack = new DatePickerDialog.OnDateSetListener() {

		// when dialog box is closed, below method will be called.
		public void onDateSet(DatePicker view, int selectedYear,
				int selectedMonth, int selectedDay) {
			year = selectedYear;
			month = selectedMonth;
			day = selectedDay;

			// set selected date into textview
			tvDate.setText(new StringBuilder().append(day).append("/")
					.append(month + 1).append("/").append(year));

		}
	};

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnSave:
			RadioGroup radiogroup = (RadioGroup) findViewById(R.id.radioGroupType);
			int checkedRadioButtonId = radiogroup.getCheckedRadioButtonId();
			Type type;
			if (checkedRadioButtonId == R.id.rBtnInc) {
				type = Type.INCOME;
			} else {
				type = Type.EXPENSE;
			}
			break;

		default:
			break;
		}

	}

}

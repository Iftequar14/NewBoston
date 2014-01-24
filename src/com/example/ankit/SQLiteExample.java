package com.example.ankit;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract.Colors;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SQLiteExample extends Activity implements OnClickListener {
	TextView tvSQLName, tvSQLHoteness, tvEnterRowId;
	EditText etSQLName, etSQLHoteness, etEnterRowId;
	Button bSQLUpdate, bSQLOpenView, bGetInfo, bEditEntry, bDeleteEntry;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqliteexample);
		tvSQLName = (TextView) findViewById(R.id.tvSQLName);
		tvSQLHoteness = (TextView) findViewById(R.id.tvSQLHoteness);
		etSQLName = (EditText) findViewById(R.id.etSQLName);
		etSQLHoteness = (EditText) findViewById(R.id.etSQLHoteness);
		bSQLUpdate = (Button) findViewById(R.id.bSQLUpdate);
		bSQLOpenView = (Button) findViewById(R.id.bSQLOpenView);
		bSQLUpdate.setOnClickListener(this);
		bSQLOpenView.setOnClickListener(this);

		tvEnterRowId = (TextView) findViewById(R.id.tvEnterRowId);
		etEnterRowId = (EditText) findViewById(R.id.etEnterRowId);
		bGetInfo = (Button) findViewById(R.id.bgetInformation);
		bEditEntry = (Button) findViewById(R.id.bEdit_Entry);
		bDeleteEntry = (Button) findViewById(R.id.bDelete_Entry);
		bGetInfo.setOnClickListener(this);
		bEditEntry.setOnClickListener(this);
		bDeleteEntry.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bSQLOpenView:
			Intent i = new Intent("com.example.ankit.SQLVIEW");
			startActivity(i);
			break;
		case R.id.bSQLUpdate:
			boolean didItWork = true;
			try {
				String name = etSQLName.getText().toString();
				String hotness = etSQLHoteness.getText().toString();
				HotOrNot entry = new HotOrNot(SQLiteExample.this);
				entry.open();
				entry.createEntry(name, hotness);
				entry.close();
			} catch (Exception e) {
				didItWork = false;
				String error = e.toString();
				Dialog d = new Dialog(this);
				d.setTitle("Dang it!");
				TextView tv = new TextView(this);
				tv.setText(error);
				tv.setTextColor(Color.WHITE);
				d.setContentView(tv);
				d.show();
			} finally {
				if (didItWork) {
					Dialog d = new Dialog(this);
					d.setTitle("Heak yea!!");
					TextView tv = new TextView(this);
					tv.setText("Success!");
					tv.setTextColor(Color.WHITE);
					d.setContentView(tv);
					d.show();
				}
			}
			break;

		case R.id.bgetInformation:
			try {
				String s = etEnterRowId.getText().toString();
				long l = Long.parseLong(s);
				HotOrNot hon = new HotOrNot(this);
				hon.open();
				String returnedName = hon.getName(l);
				String returnedHotness = hon.getHotness(l);
				hon.close();
				etSQLName.setText(returnedName);
				etSQLHoteness.setText(returnedHotness);
			} catch (Exception e) {

				String error = e.toString();
				Dialog d = new Dialog(this);
				d.setTitle("Dang it!");
				TextView tv = new TextView(this);
				tv.setText(error);
				tv.setTextColor(Color.WHITE);
				d.setContentView(tv);
				d.show();
			}
			break;
		case R.id.bEdit_Entry:
			try {
				String mName = etSQLName.getText().toString();
				String mHotness = etSQLHoteness.getText().toString();
				String sRow = etEnterRowId.getText().toString();
				long lRow = Long.parseLong(sRow);
				HotOrNot ex = new HotOrNot(this);
				ex.open();
				ex.UpdateEntry(lRow, mName, mHotness);
				ex.close();
			} catch (Exception e) {
				String error = e.toString();
				Dialog d = new Dialog(this);
				d.setTitle("Dang it!");
				TextView tv = new TextView(this);
				tv.setText(error);
				tv.setTextColor(Color.WHITE);
				d.setContentView(tv);
				d.show();
			}
			break;
		case R.id.bDelete_Entry:
			try{
			String sRow1 = etEnterRowId.getText().toString();
			long lRow1 = Long.parseLong(sRow1);
			HotOrNot ex1 = new HotOrNot(this);
			ex1.open();
			ex1.deleteEntry(lRow1);
			ex1.close();
			}catch(Exception e){
				String error=e.toString();
				Dialog d=new Dialog(this);
				d.setTitle("Dang it!");
				TextView tv=new TextView(this);
				tv.setText(error);
				tv.setTextColor(Color.WHITE);
				d.setContentView(tv);
				d.show();
			}
			break;
		}
	}

}

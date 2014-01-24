package com.example.ankit;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SQLView extends Activity{
	TextView tvSQLInfo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqlview);
		tvSQLInfo=(TextView)findViewById(R.id.tvSQLInfo);
		HotOrNot info=new HotOrNot(this);
		info.open();
		String data=info.getData();
		info.close();
		tvSQLInfo.setText(data);
	}

}

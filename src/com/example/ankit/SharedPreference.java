package com.example.ankit;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPreference extends Activity implements OnClickListener{
	EditText sharedData;
	Button save, load;
	TextView dataResult;
	SharedPreferences someData;
	public static String filename="MySharedString";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sharedpreference);
		setUpVariable();
		someData=getSharedPreferences(filename,0);
		
		
	}
	private void setUpVariable() {
		// TODO Auto-generated method stub
		sharedData=(EditText)findViewById(R.id.etSP);
		dataResult=(TextView)findViewById(R.id.tLoadData);
		save=(Button)findViewById(R.id.bSave);
		load=(Button)findViewById(R.id.bLoad);
		save.setOnClickListener(this);
		load.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.bSave:
			String stringData=sharedData.getText().toString();
			SharedPreferences.Editor editor=someData.edit();
			editor.putString("sharedString",stringData);
			editor.commit();
			break;
		case R.id.bLoad:
			someData=getSharedPreferences(filename,0);
			String dataReturned=someData.getString("sharedString","couldn't load data");
			dataResult.setText(dataReturned);
			break;
		}
	}

}

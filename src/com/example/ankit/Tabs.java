package com.example.ankit;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class Tabs extends Activity implements OnClickListener{
	TabHost th;
	TabSpec spec;
	Button newTab,bStart,bStop;
	TextView text,showResult;
	long start,stop,result;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabs);
		th=(TabHost)findViewById(R.id.tabhost);
		newTab=(Button)findViewById(R.id.bAddTab);
		bStart=(Button)findViewById(R.id.bStartWatch);
		bStop=(Button)findViewById(R.id.bStopWatch);
		showResult=(TextView)findViewById(R.id.tvShowResults);
		newTab.setOnClickListener(this);
		bStart.setOnClickListener(this);
		bStop.setOnClickListener(this);
		th.setup();
		 spec=th.newTabSpec("tag1");
		spec.setContent(R.id.tab1);
		spec.setIndicator("StopWatch");
		th.addTab(spec);
		
		spec=th.newTabSpec("tag2");
		spec.setContent(R.id.tab2);
		spec.setIndicator("Tag 2");
		th.addTab(spec);
		
		spec=th.newTabSpec("tag3");
		spec.setContent(R.id.tab3);
		spec.setIndicator("Add a Tab");
		th.addTab(spec);
		start=0;
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.bAddTab:
			TabSpec ourSpec=th.newTabSpec("tah1");
			ourSpec.setContent(new TabHost.TabContentFactory() {
				
				@Override
				public View createTabContent(String arg0) {
					// TODO Auto-generated method stub
					text=new TextView(Tabs.this);
					text.setText("you've created a new tab");
					return (text);
				}
			});
			ourSpec.setIndicator("New");
			th.addTab(ourSpec);
			break;
		case R.id.bStartWatch:
			start=System.currentTimeMillis();
			break;
		case R.id.bStopWatch:
			stop=System.currentTimeMillis();
			if(start!=0){
				result=stop-start;
				int milis=(int) result;
				int second=(int)result/1000;
				int minute=(int)second/60;
				int hours=(int)minute/60;
				milis=milis%100;
				second=second%60;
				
				showResult.setText(String.format("%d:%02d:%02d", minute,second,milis));
			}
			break;
		}
	}

}

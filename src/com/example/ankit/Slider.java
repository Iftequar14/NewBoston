package com.example.ankit;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerOpenListener;

public class Slider extends Activity implements OnClickListener,
		OnCheckedChangeListener, OnDrawerOpenListener {
	Button handle1, handle2, handle3, handle4;
	CheckBox checkbox;
	SlidingDrawer slidingDrawer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sliding);
		handle1 = (Button) findViewById(R.id.handle1);
		handle2 = (Button) findViewById(R.id.handle2);
		handle3 = (Button) findViewById(R.id.handle3);
		handle4 = (Button) findViewById(R.id.handle4);
		checkbox = (CheckBox) findViewById(R.id.cbSlide);
		slidingDrawer=(SlidingDrawer)findViewById(R.id.slidingD);
		slidingDrawer.setOnDrawerOpenListener(this);
		
		checkbox.setOnCheckedChangeListener(this);
		handle1.setOnClickListener(this);
		handle2.setOnClickListener(this);
		handle3.setOnClickListener(this);
		handle4.setOnClickListener(this);
	}

	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
		// TODO Auto-generated method stub
		if(arg0.isChecked()){
			slidingDrawer.lock();
		}else{
			slidingDrawer.unlock();
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.handle1:
			slidingDrawer.open();
			break;
		case R.id.handle2:
			
			break;
		case R.id.handle3:
			slidingDrawer.toggle();
			break;
		case R.id.handle4:
			slidingDrawer.close();
			break;
		}
	}

	@Override
	public void onDrawerOpened() {
		// TODO Auto-generated method stub
	MediaPlayer mp=new MediaPlayer();
	mp.create(this, R.raw.explosion);
	mp.start();
	}

}

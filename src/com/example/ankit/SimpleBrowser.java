package com.example.ankit;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class SimpleBrowser extends Activity implements OnClickListener {
	WebView ourBrowser;
	EditText url;
	Button go, goBack, goFrwd, refreshPage, clrHistory;
	InputMethodManager imm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.simplebrowser);
		ourBrowser = (WebView) findViewById(R.id.wvBrowser);
		ourBrowser.getSettings().setJavaScriptEnabled(true);
		ourBrowser.getSettings().setLoadWithOverviewMode(true);
		ourBrowser.getSettings().setUseWideViewPort(true);
		
		ourBrowser.loadUrl("http://www.google.com");
		try{
		ourBrowser.setWebViewClient(new ourViewClient());
		}catch(Exception e){
			e.printStackTrace();
		}
		go = (Button) findViewById(R.id.bGo);
		goBack = (Button) findViewById(R.id.bBack);
		goFrwd = (Button) findViewById(R.id.bforward);
		refreshPage = (Button) findViewById(R.id.bRefresh);
		clrHistory = (Button) findViewById(R.id.bhistory);
		url = (EditText) findViewById(R.id.etUrl);
		go.setOnClickListener(this);
		goBack.setOnClickListener(this);
		goFrwd.setOnClickListener(this);
		refreshPage.setOnClickListener(this);
		clrHistory.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bGo:
			String website=url.getText().toString();
			ourBrowser.loadUrl(website);
			//hiding the keyboard after using the keyboard
			imm=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(url.getWindowToken(), 0);
			break;
		case R.id.bBack:
			if(ourBrowser.canGoBack()){
				ourBrowser.goBack();
			}
			break;
		case R.id.bforward:
			if(ourBrowser.canGoForward()){
				ourBrowser.goForward();
			}
			break;
		case R.id.bRefresh:
			ourBrowser.reload();
			break;
		case R.id.bhistory:
			ourBrowser.clearHistory();
			break;
		}
	}

}

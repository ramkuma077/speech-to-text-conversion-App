package com.example.spechtotextconversion;

import java.util.ArrayList;

import android.speech.RecognizerIntent;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity {
	ImageButton i;
	TextView t;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		t=(TextView)findViewById(R.id.t1);
		i=(ImageButton)findViewById(R.id.b1);
		i.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
				i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-us");
				startActivityForResult(i,5432);
			
				
			}
		});
	}
@Override
protected void onActivityResult(int requestCode, int resultcode, Intent data) {
	// TODO Auto-generated method stub
	super.onActivityResult(requestCode, resultcode, data);
	if(requestCode==5432 && data!=null)
	{
	ArrayList<String>arrayList=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
	t.setText(arrayList.get(0));
	}
}
}


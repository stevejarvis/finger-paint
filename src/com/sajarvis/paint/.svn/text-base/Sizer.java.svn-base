//Return a brush size.

package com.sajarvis.paint;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ToggleButton;
import com.sajarvis.fingerpaint.R;

public class Sizer extends Activity{
	private ToggleButton small, medium, large, huge;
	private int sizeSmall, sizeMed, sizeLarge, sizeHuge;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sizer);
		//Initialize sizes
		sizeSmall = 3;
		sizeMed = 12;
		sizeLarge = 28;
		sizeHuge = 64;
		//Buttons
		small = (ToggleButton) findViewById(R.id.small);
		medium = (ToggleButton) findViewById(R.id.med);
		large = (ToggleButton) findViewById(R.id.large);
		huge = (ToggleButton) findViewById(R.id.huge);
		//Set buttons
		Bundle extras = getIntent().getExtras();
		int brushSize = extras.getInt("brushSize");
		if(brushSize == sizeSmall){
			small.setChecked(true);
		}
		else if(brushSize == sizeMed){
			medium.setChecked(true);
		}
		else if(brushSize == sizeLarge){
			large.setChecked(true);
		}
		else if(brushSize == sizeHuge){
			huge.setChecked(true);
		}
		//Set click listeners.
		small.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent();
				intent.putExtra("returnKey", sizeSmall);
				setResult(RESULT_OK,intent);
				//Close by finish
				finish();
			}
		});
		medium.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent();
				intent.putExtra("returnKey", sizeMed);
				setResult(RESULT_OK,intent);
				//Close by finish
				finish();
			}
		});
		large.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent();
				intent.putExtra("returnKey", sizeLarge);
				setResult(RESULT_OK,intent);
				//Close by finish
				finish();
			}
		});
		huge.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent();
				intent.putExtra("returnKey", sizeHuge);
				setResult(RESULT_OK,intent);
				//Close by finish
				finish();
			}
		});
	}
}

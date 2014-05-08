/*
 * GNU GENERAL PUBLIC LICENSE
 *
 * Android Paint is a Drawing Application for Android.
 * Copyright (C) 2014 Steve Jarvis
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * A brush selector. Returns the choice to caller.
 */

package com.sajarvis.paint;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ToggleButton;
import com.sajarvis.fingerpaint.R;

public class Brushes extends Activity{
	private ToggleButton round,dash,emboss,blur,blendy,stroke;
	private Button done;
	Intent intent;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.brushes);
		intent = new Intent();
		//Set the buttons
		round = (ToggleButton) findViewById(R.id.round);
		dash = (ToggleButton) findViewById(R.id.dash);
		emboss = (ToggleButton) findViewById(R.id.emboss);
		blur = (ToggleButton) findViewById(R.id.blur);
		blendy = (ToggleButton) findViewById(R.id.src_atop);
		stroke = (ToggleButton) findViewById(R.id.stroke);
		done = (Button) findViewById(R.id.doneBrush);
		//Set on or off.
		Bundle extras = getIntent().getExtras();
		setButtons(extras);

		//Click listeners.
		round.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				if(round.isChecked()){
					dash.setChecked(false);
					stroke.setChecked(false);
				}
			}
		});
		emboss.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				if(emboss.isChecked()){
					blur.setChecked(false);
				}
			}
		});
		dash.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				if(dash.isChecked()){
					round.setChecked(false);
					stroke.setChecked(false);
				}else{
					round.setChecked(true);
				}
			}
		});
		blur.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				if(blur.isChecked()){
					emboss.setChecked(false);
				}
			}
		});
		blendy.setOnClickListener(new OnClickListener(){
			public void onClick(View v){

				}
		});
		stroke.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				if(stroke.isChecked()){
					dash.setChecked(false);
					round.setChecked(false);
				}
				if(!stroke.isChecked()){
					round.setChecked(true);
				}
			}
		});
		done.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				if(round.isChecked()){
					intent.putExtra("returnRound", true);
				}
				if(dash.isChecked()){
					intent.putExtra("returnDash", true);
				}
				if(emboss.isChecked()){
					intent.putExtra("returnEmboss", true);
				}
				if(blur.isChecked()){
					intent.putExtra("returnBlur", true);
				}
				if(stroke.isChecked()){
					intent.putExtra("returnStroke", true);
				}
				if(blendy.isChecked()){
					intent.putExtra("returnBlendy", true);
				}
				setResult(RESULT_OK,intent);
				//Close by finish
				finish();
			}

		});
	}
	//Update all the click statuses of the buttons
	public void setButtons(Bundle extras){
		round.setChecked(extras.getBoolean("round"));
		dash.setChecked(extras.getBoolean("dash"));
		emboss.setChecked(extras.getBoolean("emboss"));
		blur.setChecked(extras.getBoolean("blur"));
		blendy.setChecked(extras.getBoolean("blendy"));
		stroke.setChecked(extras.getBoolean("crazyfill"));
	}
}

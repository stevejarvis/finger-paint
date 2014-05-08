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

package com.sajarvis.paint;

import com.flurry.android.FlurryAgent;
import com.sajarvis.fingerpaint.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class Prompt extends Activity{
	private Button toMarket, noThanks, more;
	private CheckBox notAgain;
	private Intent returnIntent;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.prompt);

		toMarket = (Button) findViewById(R.id.to_market);
		noThanks = (Button) findViewById(R.id.no_thanks);
		notAgain = (CheckBox) findViewById(R.id.no_show);
		more = (Button) findViewById(R.id.more);
		notAgain.setChecked(false);

		//We're always showing it, so hide the checkbox
		LinearLayout checkbox = (LinearLayout) findViewById(R.id.checkbox);
		checkbox.setVisibility(View.GONE);

		//Declare the intent
		returnIntent = new Intent();

		//If they look, great. Don't prompt again.
		toMarket.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				//Launch the market link
				Intent goToMarket = null;
				goToMarket = new Intent(Intent.ACTION_VIEW,Uri.parse(
						"market://details?id=com.sajarvis.paint"));
				startActivity(goToMarket);

				if(notAgain.isChecked()){
					//Then don't show again
					returnIntent.putExtra("showAgain", false);
					FlurryAgent.onEvent("To Market! Not Again");
				}else{
					returnIntent.putExtra("showAgain", true);
					FlurryAgent.onEvent("To Market! Show Again.");
				}
				setResult(RESULT_OK, returnIntent);
				//Close by finish
				finish();
			}
		});

		//More on web
		more.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				//Launch the site intent
				Intent site = null;
				site = new Intent(Intent.ACTION_VIEW,Uri.parse(
						"http://www.sajarvis.com/pro-paint/"));
				startActivity(site);
				FlurryAgent.onEvent("To site");
			}
		});

		//If they don't wanna, don't. See if they're up for another prompt.
		noThanks.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				if(notAgain.isChecked()){
					//Then don't show again
					returnIntent.putExtra("showAgain", false);
					FlurryAgent.onEvent("No thanks. Not Again");
				}else{
					returnIntent.putExtra("showAgain", true);
					FlurryAgent.onEvent("No thanks. Show again");
				}
				setResult(RESULT_OK, returnIntent);
				//Close by finish
				finish();
			}
		});
	}

	/*
	 * Flurry
	 */
	public void onStart(){
	   super.onStart();
	   FlurryAgent.onStartSession(this, "KQX33XAVQ6BR91LXXSI4");
	}

	@Override
	protected void onStop() {
		super.onStop();
		FlurryAgent.onEndSession(this);
  	}
}

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

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.sajarvis.fingerpaint.R;

public class Clear extends Activity{
	private Button importedPic, drawing, everything,cancel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.clear);

		importedPic = (Button) findViewById(R.id.picture);
		drawing = (Button) findViewById(R.id.drawing);
		everything = (Button) findViewById(R.id.all);
		cancel = (Button) findViewById(R.id.cancel);

		//Picture only
		importedPic.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.putExtra("clear", "picture");
				setResult(RESULT_OK,intent);
				finish();
			}
		});
		//Drawing only
		drawing.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.putExtra("clear", "drawing");
				setResult(RESULT_OK,intent);
				finish();
			}
		});
		//All of it
		everything.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.putExtra("clear", "all");
				setResult(RESULT_OK,intent);
				finish();
			}
		});
		//None of it
		cancel.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.putExtra("clear", "cancel");
				setResult(RESULT_OK,intent);
				finish();
			}
		});
	}
}

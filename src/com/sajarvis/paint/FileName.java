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

import java.io.File;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.sajarvis.fingerpaint.R;

public class FileName extends Activity{
	private EditText text;
	private Button save, cancel;
	private Intent intent;
	private File completeDir;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.filename);
		intent = new Intent();
		//Set the text
		text = (EditText) findViewById(R.id.sure);
		save = (Button) findViewById(R.id.save);
		cancel = (Button) findViewById(R.id.cancel);

		//Get the app dir name
		Bundle extras = getIntent().getExtras();

		//Get external file path to check if file exists.
		//Gets the directory of local storage.
		String dir = Environment.getExternalStorageDirectory().toString();
		//Add my folder to the directory and create it.
		completeDir = new File(dir+File.separator+extras.getString("dirName"));
		//Click listener.
		save.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				String name = text.getText().toString();
				if(!name.equals("")){
					File file = new File(completeDir,name.concat(".jpeg"));
					if(!file.exists()){
						intent.putExtra("FileName", text.getText().toString());
						setResult(RESULT_OK,intent);
						finish();
					}else{
						makeToast("File name already exists.");
					}
				}else{
					makeToast("Enter a file name.");
				}
			}
		});
		cancel.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				intent.putExtra("FileName", "blank");
				setResult(RESULT_OK,intent);
				finish();
			}
		});
	}

	//Make a toast noti. Just pass the message.
	public void makeToast(String msg){
		Context context = getApplicationContext();
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, msg, duration);
		toast.show();
	}
}

package com.sajarvis.paint;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.sajarvis.fingerpaint.R;

public class Prefs {
	private SharedPreferences prefs;
	private Editor editor;

	//Initialize
	public Prefs(Context context){
		prefs = context.getSharedPreferences("prefs",0);	//0 = private
		editor = prefs.edit();
	}
	
	//Preferences to store the state of shaking. On/Off.
    public void shakeOn(boolean on){
    	editor.putBoolean("shakeOn", on);
    	editor.commit();
    }
    //Returns true if shake is on. Default on.
    public boolean shakeIsOn(){
    	return prefs.getBoolean("shakeOn", true);
    }
	//Handle saving state across sessions.
    //Color
    public int getLastColor(){
    	return prefs.getInt("color", 0xFFFF0000);
    }
    public void setColor(int color){
    	editor.putInt("color", color);
    	editor.commit();
    }
    //Brush size
    public float getLastSize(){
    	return prefs.getFloat("size", 20.0f);
    }
    public void setSize(float size){
    	editor.putFloat("size", size);
    	editor.commit();
    }
    //Brush Styles
    public String getLastStyle(){
    	return prefs.getString("style", "round");
    }
    public void setStyle(String style){
    	editor.putString("style", style);
    	editor.commit();
    }
    //Filter for the paint.
    public String getLastFilter(){
    	return prefs.getString("filter","null");
    }
    public void setFilter(String filter){
    	editor.putString("filter", filter);
    	editor.commit();
    }
    //Paint effects
    public String getLastEffect(){
    	return prefs.getString("effect", "null");
    }
    public void setEffect(String effect){
    	editor.putString("effect", effect);
    	editor.commit();
    }
    //Prompt
    //Preference on whether to launch the prompt
  	public void promptState(boolean show){
  		editor.putBoolean("showPrompt", show);
  		editor.commit();
  	}
  	
  	//Return whether to show
  	public boolean showPrompt(){
  		return prefs.getBoolean("showPrompt", true);
  	}
  	
  	//Save state
  	public void savePps(Pp pp){
  	}
}

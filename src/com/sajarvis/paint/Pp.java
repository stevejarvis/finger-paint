/*
 * Pp is a clever acronym for path paint, which is what this class will be storing.
 * The history will be a stack of these guys.
 */

package com.sajarvis.paint;

import android.graphics.Paint;
import android.graphics.Path;
import com.sajarvis.fingerpaint.R;

public class Pp {
	private Paint paint;
	private Path path;
	
	//Constructor
	public Pp(Path pth, Paint pnt){
		path = pth;
		paint = pnt;
	}
	
	//Get the paint
	public Paint getPaint(){
		return paint;
	}
	
	//Get the path
	public Path getPath(){
		return path;
	}
}

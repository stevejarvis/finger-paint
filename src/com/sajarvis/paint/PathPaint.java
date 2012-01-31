package com.sajarvis.paint;

import android.graphics.Paint;
import android.graphics.Path;
import com.sajarvis.fingerpaint.R;

public class PathPaint {
	private Paint paint;
	private Path path;
	
	public PathPaint(Path pth, Paint pnt){
		paint = pnt;
		path = pth;
	}
	
	//Get the path
	public Path getPath(){
		return path;
	}
	
	//Get paint
	public Paint getPaint(){
		return paint;
	}
}

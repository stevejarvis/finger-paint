/*
 * This is gonna be used for maintaining the history stack. It's a stack of paths and paints.
 * But things are never actually popped off the stack, just referenced, that way a redo
 * can be done as well.
 * 
 */

package com.sajarvis.paint;

import java.util.ArrayList;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.sajarvis.fingerpaint.R;

public class Stack {
	private ArrayList<Pp> stack;
	//Arbitrary size. I tested >100 marks and it didn't crash. Seems safe.
	private final int SIZE = 20;
	
	//The base, so the stack doesn't need to grow forever. Shows old paths
	private Bitmap base;
	
	//To mark the base
	private Canvas bCanvas;
	
	//To make a new base
	private int width, height;	//For base bitmap size
	
	public Stack(Context context, int w, int h){
		stack = new ArrayList<Pp>(SIZE);
		base = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
		bCanvas = new Canvas(base);
		width = w; height = h;
	}
	
	//Adds a bitmap to the top of the stack. Returns true for success, false for out of
	//bounds.
	public boolean add(int index, Pp pp){
		//Comparing stack.size prevents index out of bounds. comparing index prevents
		//Drawing when we shouldn't be drawing.
		if(stack.size() > SIZE && index > SIZE-1){	//Delete the first one and shift the rest down
			//Save the paths by drawing to base canvas before we delete them.
			bCanvas.drawPath(stack.get(0).getPath(), stack.get(0).getPaint());
			stack.remove(0);	//Rest will shift automatically
		}
		
		//Add it
		try{
			//Add will shift the rest down (if they're there), but we want more of an
			//overwrite feature, so delete from the spot down.
			int s = stack.size()-1;
			for(int n=s; n>=index; n--){
				stack.remove(n);
			}
			
			//Add it!
			stack.add(index, pp);
			
			return true;
		}catch(IndexOutOfBoundsException e){
			//Cause if they go too fast we can get out of order.
			return false;
		}
	}
	
	//Get the max size of our history
	public int getDepth(){
		return SIZE;
	}
	
	//returns the bitmap at the id. id is kept track of by main.
	public Pp get(int id){
		return stack.get(id);
	}
	
	//Return number of elements currently in list
	public int getSize(){
		return stack.size();
	}
	
	//Start over
	public void clear(){
		stack.clear();
		base = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);//Erase that bmap
		bCanvas = new Canvas(base);
	}
	
	//Get the bitmap with old paths on it
	public Bitmap getBase(){
		return base;
	}
}

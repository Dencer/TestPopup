package hiSpark2014.puzzle.pop;

import com.example.testpopup.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class TestPopupActivity extends Activity{
	//The "x" and "y" position of the "Show Button" on screen.
	Point p;
	 
	@Override
	public void onCreate(Bundle savedInstanceState) {
	   super.onCreate(savedInstanceState);
	   setContentView(R.layout.main);
	 
	   Button btn_show = (Button) findViewById(R.id.show_popup);
	   btn_show.setOnClickListener(new OnClickListener() {
	     @Override
	     public void onClick(View arg0) {
	 
	       //Open popup window
	       if (p != null)
	       showPopup(TestPopupActivity.this, p);
	       
	     }
	   });
	}
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
	 
	   int[] location = new int[2];
	   Button button = (Button) findViewById(R.id.show_popup);
	 
	   // Get the x, y location and store it in the location[] array
	   // location[0] = x, location[1] = y.
	   button.getLocationOnScreen(location);
	 
	   //Initialize the Point with x, and y positions
	   p = new Point();
	   p.x = location[0];
	   p.y = location[1];
	}
	// The method that displays the popup.
	@SuppressWarnings("deprecation")
	private void showPopup(final Activity context, Point p) {
	   int popupWidth = 1000;
	   int popupHeight = 1000;
	 
	   // Inflate the popup_layout.xml
	   LinearLayout viewGroup = (LinearLayout) context.findViewById(R.id.popup);
	   LayoutInflater layoutInflater = (LayoutInflater) context
	     .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	   View layout = layoutInflater.inflate(R.layout.popup_layout, viewGroup);
	 
	   // Creating the PopupWindow
	   final PopupWindow popup = new PopupWindow(context);
	   popup.setContentView(layout);
	   popup.setWidth(popupWidth);
	   popup.setHeight(popupHeight);
	   popup.setFocusable(true);
	 
	   // Some offset to align the popup a bit to the right, and a bit down, relative to button's position.
	   int OFFSET_X = 300;
	   int OFFSET_Y = 100;
	 
	   // Clear the default translucent background
	   popup.setBackgroundDrawable(new BitmapDrawable());
	 
	   // Displaying the popup at the specified location, + offsets.
	  popup.showAtLocation(layout, Gravity.NO_GRAVITY, p.x + OFFSET_X, p.y + OFFSET_Y);
	  Handler handler = new Handler();
	  handler.postDelayed(new Runnable(){
		  public void run(){
			  popup.dismiss();
		  }
	  }, 2000);
//	  if(popup.isShowing())
//	  {
//		 popup.setOnDismissListener(onDismissListener)
//		 
//	  }
	   // Getting a reference to Close button, and close the popup when clicked.
	 /*  Button close = (Button) layout.findViewById(R.id.close);
	   close.setOnClickListener(new OnClickListener() {
	 
	     @Override
	     public void onClick(View v) {
	       popup.dismiss();
	     }
	   }); */
	
}


}

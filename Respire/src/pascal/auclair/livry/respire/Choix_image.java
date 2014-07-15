package pascal.auclair.livry.respire;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class Choix_image extends BaseActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choix_image);
        addListenerOn_Image1();
        addListenerOn_Image2();
        addListenerOn_Image3();
    }
    
    
	public void addListenerOn_Image1() {
    	View image = (View) findViewById(R.id.imageView1);
    	image.setClickable(true);
    	image.setOnClickListener(new OnClickListener() {
    		@Override
    		public void onClick(View v) {
    			Log.d("Pascal Log", "Click Image 1" );
    			set_image_name(R.drawable.galaxie1);
    			finish(); 
    		}
    	});

    }
    public void addListenerOn_Image2() {
      	 View image = (View) findViewById(R.id.imageView2);
      	image.setOnClickListener(new OnClickListener() {
   			@Override
   			public void onClick(View v) {
   				Log.d("Pascal Log", "Click Image 2" );
   				set_image_name(R.drawable.galaxie2);
   				finish();
   			}
      	});

      }
    public void addListenerOn_Image3() {
      	 View image = (View) findViewById(R.id.imageView3);
      	image.setOnClickListener(new OnClickListener() {
   			@Override
   			public void onClick(View v) {
   				Log.d("Pascal Log", "Click Image 3" );
   				set_image_name(R.drawable.galaxie3);
   				finish();
   			}
      	});

      }

}

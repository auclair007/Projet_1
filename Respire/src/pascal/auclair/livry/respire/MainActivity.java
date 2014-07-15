package pascal.auclair.livry.respire;

import java.io.IOException;

import org.joda.time.DateTime;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends BaseActivity implements Callback  , Runnable {


	Bitmap Bille;
	private Bitmap back0;
	private Bitmap back;
	//private Canvas c;
	private SurfaceHolder hh;
	private TextView tv;
	Thread t = null;
	private boolean isItOk = false;
	private String de;
	private String ex;
	private String in;
	private String ti;
	private String up;
	private String dw;
	private Paint mPaintBlue;
	private Paint mPaintRed;
	private Paint mPaintWhite;
	
	private String str_startTime ="";
	private String str_endTime = "";
	private String str_finFree;
	private DateTime dt_fin;
	private DateTime dt_startTime;
	private DateTime dt_finFree;
	private Float rayonDyn;
	private DateTime dt_startTime2;
	private Float duree;
	private DateTime dt_1;
	private DateTime dt_2;
	private long sleep_thread=50;


	/**
	 * @param tv the tv to set
	 */
	public void setTv(TextView tv,String mess) {
		this.tv = tv;
		tv.setText(mess);
	}


	
	//SurfaceHolder holder;
	@Override
	public void surfaceCreated(SurfaceHolder holder ) {
		// TODO Auto-generated method stub
		Log.d("Pascal Log", "surfaceCreated" );
		
		Canvas c0 = holder.lockCanvas();
		back = Bitmap.createScaledBitmap(back0, c0.getWidth(), c0.getHeight(), false);
		c0.drawBitmap(back, 0, 0, null);
		
		mPaintWhite = new Paint(Paint.ANTI_ALIAS_FLAG);
		mPaintWhite.setTextSize(100);
		mPaintWhite.setTypeface(Typeface.DEFAULT_BOLD); 
		mPaintWhite.setColor( Color.argb(255,255, 255, 255) );

		mPaintRed = new Paint(Paint.ANTI_ALIAS_FLAG);
		mPaintRed.setTextSize(30);
		mPaintRed.setColor( Color.argb(255,255, 0, 0) );
		
		mPaintBlue = new Paint(Paint.ANTI_ALIAS_FLAG);
		mPaintBlue.setTextSize(30);
		mPaintBlue.setColor( Color.argb(255,0, 0, 255) );
		holder.unlockCanvasAndPost(c0);
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		Log.d("Pascal Log", "surfaceDestroyed" );
		isItOk = false ;
	}



	/* (non-Javadoc)
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		int xx = get_image_name();
		Log.d("Pascal Log", "onResume -->"+xx );
		
		back0 = BitmapFactory.decodeResource(getResources(),get_image_name());
	}
	
	public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bille = BitmapFactory.decodeResource(getResources(),R.drawable.bille);
        set_image_name(R.drawable.galaxie1);
        
    	Util_pa.addItemsOn_delay(this);
    	Util_pa.addItemsOn_timer(this);
    	Util_pa.addItemsOn_inhale(this);
    	Util_pa.addItemsOn_exhale(this);
    	Util_pa.addItemsOn_hold1(this);
    	Util_pa.addItemsOn_hold2(this);
    	Util_pa.addListenerOnSpinner_delay(this);
    	Util_pa.addListenerOnSpinner_timer(this);
    	Util_pa.addListenerOnSpinner_inhale(this);
    	Util_pa.addListenerOnSpinner_exhale(this);
    	Util_pa.addListenerOnSpinner_hold1(this);
    	Util_pa.addListenerOnSpinner_hold2(this);
    	addListenerOnButton_Start();
    	addListenerOnButton_Stop();
    	addListenerOnButton_Musique();
    	addListenerOn_Image();
		SurfaceView sv = (SurfaceView) findViewById(R.id.surfaceView1);
		hh = sv.getHolder();
		hh.addCallback(this);
		t = new Thread(this); //-- This appele ici la method run() de la class
		t.start();
		music = MediaPlayer.create(getApplicationContext(), R.raw.over_the_horizon);
		Log.d("Pascal Log", "Music prepare "+ this.getLocalClassName() );
		try {
			music.prepare();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
 
	public void start_appli() {
		Log.d("Pascal Log", "Start Appli" );
		Spinner delay = (Spinner) findViewById(R.id.spinner_delay) ;
		de = delay.getSelectedItem().toString() ;
		Spinner timer = (Spinner) findViewById(R.id.spinner_timer) ;
		ti = timer.getSelectedItem().toString() ;
		Spinner exhale = (Spinner) findViewById(R.id.spinner_exhale) ;
		ex = exhale.getSelectedItem().toString() ;
		Spinner inhale = (Spinner) findViewById(R.id.spinner_inhale) ;
		in = inhale.getSelectedItem().toString() ;
		Spinner holdup = (Spinner) findViewById(R.id.spinner_hold1) ;
		up = holdup.getSelectedItem().toString() ;
		Spinner holddown = (Spinner) findViewById(R.id.spinner_hold2) ;
		dw = holddown.getSelectedItem().toString() ;
		tv = (TextView) findViewById(R.id.tvgraph) ;
		getdateFinFree();
		isItOk = true ;
		
	}
	
    public void addListenerOnButton_Start() {
    	Button start = (Button) findViewById(R.id.start);
    	start.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				start_appli();
			}
    	});

    }
    
    void getdateFinFree(){
		dt_startTime = new DateTime();
		Integer xx = Integer.parseInt(ti); 
		dt_fin = dt_startTime.plusMinutes(xx);
		xx = Integer.parseInt(de);
		dt_finFree = dt_fin.plusSeconds(xx);
		str_startTime = dt_startTime.toString();
		str_endTime = dt_fin.toString();
		str_finFree = dt_finFree.toString();
		Log.d("Pascal Log", "Start    "+str_startTime +"\nFIN      "+str_endTime+"\nFin FREE "+str_finFree  );
    }
    
    public void addListenerOnButton_Stop() {
    	Button stop = (Button) findViewById(R.id.Stop);
    	stop.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d("Pascal Log", "Click Stop" );
				isItOk = false ;
			}
    	});

    }
    public void addListenerOnButton_Musique() {
    	Button musique = (Button) findViewById(R.id.bp_musique);
    	musique.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d("Pascal Log", "Click BP Music" );
				music_on(music);
			}
    	});

    }
    public void addListenerOn_Image() {
    	 View musique = (View) findViewById(R.id.surfaceView1);
    	musique.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d("Pascal Log", "Click Image" );
				start_appli();
			}
    	});

    }



	
	/* (non-Javadoc)
	 * @see android.app.Activity#onRestart()
	 */
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		t = new Thread(this); //-- This appele ici la method run() de la class
		t.start();
		music = MediaPlayer.create(getApplicationContext(), R.raw.over_the_horizon);
		int xx = get_image_name();
		Log.d("Pascal Log", "onRestart -->"+xx );
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d("Pascal Log", "onPause" );
		isItOk = false ;
	}
	@Override
	public void startActivityForResult(Intent intent, int requestCode) {
		// TODO Auto-generated method stub
		super.startActivityForResult(intent, requestCode);
		Log.d("Pascal Log", "startActivityForResult" );
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		Log.d("Pascal Log", "onSaveInstanceState t.interrupt" );
		t.interrupt();
		if ( music != null ) {
			music_off(music);
			Log.d("Pascal Log", "music.release" );
			music.release();
		}
		
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d("Pascal Log", "onDestroy" );
		t.interrupt();
		if ( music != null ) {
			music_off(music);
			Log.d("Pascal Log", "music.release" );
			music.release();
		}
	}
	
	
	void inspire (){
		Canvas c1 = hh.lockCanvas();
		c1.drawBitmap(back, 0, 0, null);
		rayonDyn = (float) Math.round(rayonDyn +((((c1.getWidth()/2) * 1.5) - rayonDyn)* duree / (Integer.parseInt(in) * 1000))); 
		c1.drawCircle((c1.getWidth()/2), (c1.getHeight()/2), rayonDyn, mPaintRed);
		hh.unlockCanvasAndPost(c1); 
		try {
			Thread.sleep(sleep_thread);
		} catch (InterruptedException e) {e.printStackTrace();	}
	}

	void expire (){
		Canvas c2 = hh.lockCanvas(); 
		c2.drawBitmap(back, 0, 0, null);
		rayonDyn = (float) Math.round(rayonDyn -((((c2.getWidth()/2) * 1.5) - rayonDyn)* duree / (Integer.parseInt(ex) * 1000))); 
		c2.drawCircle((c2.getWidth()/2), (c2.getHeight()/2), rayonDyn, mPaintBlue);
		hh.unlockCanvasAndPost(c2); 
		try {
			Thread.sleep(sleep_thread);
		} catch (InterruptedException e) {e.printStackTrace();	}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub  y = 0 to 620
		rayonDyn = (float) 10 ;
		while (true) {
			try {
				Thread.sleep(sleep_thread);
			} catch (InterruptedException e) {e.printStackTrace();	}

			if (!hh.getSurface().isValid())
				continue;
			

			if (isItOk ){
				Canvas c;
				while ( isItOk && dt_fin.isAfterNow()){
					duree = (float) 70.0;
					rayonDyn = (float) 10;
					dt_startTime2 = new DateTime();
					Integer xx = Integer.parseInt(in); 
					DateTime dt_finInhale = dt_startTime2.plusSeconds(xx);
					dt_1 = new DateTime();
					dt_2 = new DateTime();
					
					while ( isItOk && dt_finInhale.isAfterNow()){
						dt_1 = DateTime.now();
						inspire ();
						dt_2 = DateTime.now();
						duree = (float) (dt_2.getMillis() - dt_1.getMillis()) ;
						//Log.d("Pascal Log", "duree inspire "+duree );
					}
//////////////////////////////////////////////////////////////////////////////////////
					c = hh.lockCanvas(); 
					c.drawBitmap(back, 0, 0, null);
					rayonDyn = (float) Math.round(rayonDyn +((((c.getWidth()/2) * 1.5) - rayonDyn)* duree / (Integer.parseInt(in) * 1000))); 
					c.drawCircle((c.getWidth()/2), (c.getHeight()/2), rayonDyn, mPaintRed);
					float ll = mPaintWhite.measureText("BLOCK");
					int posx = (int) ((c.getWidth() - ll) / 2) ;
					c.drawText("BLOCK", posx , 30 + (c.getHeight()/2) , mPaintWhite);
					hh.unlockCanvasAndPost(c); 
//////////////////////////////////////////////////////////////////////////////////////					
					xx = Integer.parseInt(up);
					DateTime dt_finHoldUp = dt_finInhale.plusSeconds(xx);
					while ( isItOk && dt_finHoldUp.isAfterNow()){
						//tv.setText("BLOCK UP");
						try {
							Thread.sleep(sleep_thread);
						} catch (InterruptedException e) {e.printStackTrace();	}
					}
					
					
					duree = (float) 70.0;
					xx = Integer.parseInt(ex); 
					DateTime dt_finExhale = dt_finHoldUp.plusSeconds(xx);
					while ( isItOk && dt_finExhale.isAfterNow()){
						dt_1 = DateTime.now();
						expire ();
						dt_2 = DateTime.now();
						duree = (float) (dt_2.getMillis() - dt_1.getMillis()) ;
						//Log.d("Pascal Log", "duree expire "+duree );
					}
/////////////////////////////////////////////////////////////////////////////////////////////
					c = hh.lockCanvas(); 
					c.drawBitmap(back, 0, 0, null);
					rayonDyn = (float) Math.round(rayonDyn -((((c.getWidth()/2) * 1.5) - rayonDyn)* duree / (Integer.parseInt(ex) * 1000))); 
					c.drawCircle((c.getWidth()/2), (c.getHeight()/2), rayonDyn, mPaintBlue);
					float ll2 = mPaintWhite. measureText("BLOCK");
					int posx2 = (int) ((c.getWidth()- ll2)/2) ;
					c.drawText("BLOCK", posx2, 30 + (c.getHeight()/2) , mPaintWhite);
					hh.unlockCanvasAndPost(c);
					/*int x1 = c.getWidth();
					String x11 = Integer.toString(x1) ;
					float x2 = c.getWidth()/2;
					String x22 = Float.toString(x2);
					String x33 = Float.toString(rayonDyn);
					Log.d("Pascal Log", "c.getWidth() "+x11 );
					Log.d("Pascal Log", "c.getWidth() "+x22 );
					Log.d("Pascal Log", "rayonDyn     "+x33 );*/
/////////////////////////////////////////////////////////////////////////////////////////////					
					
					xx = Integer.parseInt(dw);
					DateTime dt_finHoldDown = dt_finExhale.plusSeconds(xx);
					while ( isItOk && dt_finHoldDown.isAfterNow()){
						try {
							Thread.sleep(sleep_thread);
						} catch (InterruptedException e) {e.printStackTrace();	}
					}
					
					duree = (float) 70.0;
				}// Fin timer
				while ( isItOk && dt_finFree.isAfterNow() &&  dt_fin.isBeforeNow() ){
					//Log.d("Pascal Log", "DRAW FREE TIME" );
					Canvas c3 = hh.lockCanvas(); 
					c3.drawBitmap(back, 0, 0, null);
					
					float lg = mPaintWhite.measureText("FREE");
					int posx = (int) ((c3.getWidth()- lg)/2) ;
					c3.drawText("FREE", posx, 30 + c3.getHeight()/3 , mPaintWhite);
					
					lg = mPaintWhite.measureText("TIME");
					posx = (int) ((c3.getWidth()- lg)/2) ;
					c3.drawText("TIME", posx, 30 + 2 * c3.getHeight()/3 , mPaintWhite);
					hh.unlockCanvasAndPost(c3);
					try {
						Thread.sleep(sleep_thread);
					} catch (InterruptedException e) {e.printStackTrace();	}

				} // fin free time
				getdateFinFree();
			} //if isitOK
		} //while true
	} // run()

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		Log.d("Pascal surface", "surfaceChanged "+format+" "+width+" "+height );
	}
}



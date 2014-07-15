package pascal.auclair.livry.respire;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public abstract class BaseActivity extends Activity {
	



	public MediaPlayer music;
	public static int image_name;

	public int get_image_name(){
			return image_name;
	}
	
	public void set_image_name(int arg){
		image_name = arg;
	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onSaveInstanceState(android.os.Bundle)
	 */
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		Log.d("Pascal Log", "BASE Activity onSaveInstanceState" );
		if ( music != null &&  this.getLocalClassName() == "MainActivity" ) {
			music_off(music);
			Log.d("Pascal Log", "BASE Activity Music Release" );
			music.release();
		}
	}

	public void music_on( MediaPlayer music){
		if ( music != null && music.isPlaying()){
			Log.d("Pascal Log", "BASE Activity Music Pause" );
			music.pause();
		} else {
			if (music != null && ! music.isPlaying())
			Log.d("Pascal Log", "BASE Activity Music Start" );
			music.start();
		}
	}
	public void music_off( MediaPlayer music){
		if ( music != null && music.isPlaying()){
			Log.d("Pascal Log", "BASE Activity Music Stop" );
			music.stop();
		}
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("Pascal Log", "BASE Activity onCreate" );
	}


	
	public boolean onCreateOptionsMenu(Menu menu) {
		//((TextView)findViewById(R.id.texte)).setText(“Menu”);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_main, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.choix_image:
			Intent intent = new Intent(this, Choix_image.class);
			startActivity(intent);
			return true;

		case R.id.apropos:
			Intent intent2 = new Intent(this, About.class);
			startActivity(intent2);
			return true;

		case R.id.quitter:
			finish();
			return true;

		}
		return super.onOptionsItemSelected(item);
		//return true;
	}
}


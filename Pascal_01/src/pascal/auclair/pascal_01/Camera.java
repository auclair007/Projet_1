package pascal.auclair.pascal_01;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.os.Build;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View.OnClickListener;

public class Camera extends ActionBarActivity {
	ImageView imgFavorite;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_camera);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		imgFavorite = (ImageView)findViewById(R.id.imageView1);
	      imgFavorite.setOnClickListener(new OnClickListener() {
	         @Override
	         public void onClick(View v) {
	            open();
	         }
	      });
	}
	public void open(){
	      Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
	      startActivityForResult(intent, 0);
	   }

	   @Override
	   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	      // TODO Auto-generated method stub
	      super.onActivityResult(requestCode, resultCode, data);
	      Bitmap bp = (Bitmap) data.getExtras().get("data");
	      imgFavorite.setImageBitmap(bp);
	   }
	   

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		/*int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		} */
		
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			Log.d("Pascal Log", "R.id.action_settings)-->"+ item.getTitle() );
			return true;
		}		
		if (id == R.id.apropos ) {
			Log.d("Pascal Log", "R.id.action_settings)-->"+ item.getTitle() );
			Intent intent = new Intent(Camera.this, Apropos.class);
			startActivity(intent);
			return true;
		}
		if (id == R.id.horloges ) {
			Log.d("Pascal Log", "R.id.action_settings)-->"+ item.getTitle() );
			Intent intent = new Intent(Camera.this, Horloges.class);
			startActivity(intent);
			return true;
		}
		if (id == R.id.calendrier ) {
			Log.d("Pascal Log", "R.id.action_settings)-->"+ item.getTitle() );
			Intent intent = new Intent(Camera.this, Calendrier.class);
			startActivity(intent);
			return true;
		}
	/*	if (id == R.id.camera ) {
			Log.d("Pascal Log", "R.id.action_settings)-->"+ item.getTitle() );
			Intent intent = new Intent(Camera.this, Camera.class);
			startActivity(intent);
			return true;
		}*/

		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_camera,
					container, false);
			return rootView;
		}
	}

}

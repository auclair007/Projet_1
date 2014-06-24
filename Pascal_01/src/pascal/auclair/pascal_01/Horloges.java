package pascal.auclair.pascal_01;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.os.Build;

public class Horloges extends ActionBarActivity {

	private Button btnenregistrer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_horloges);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main , menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.

		int id = item.getItemId();
		if (id == R.id.action_settings) {
			Log.d("Pascal Log", "R.id.action_settings)-->"+ item.getTitle() );
			return true;
		}		
		if (id == R.id.apropos ) {
			Log.d("Pascal Log", "R.id.action_settings)-->"+ item.getTitle() );
			Intent intent = new Intent(Horloges.this, Apropos.class);
			startActivity(intent);
			return true;
		}
		/*if (id == R.id.horloges ) {
			Log.d("Pascal Log", "R.id.action_settings)-->"+ item.getTitle() );
			Intent intent = new Intent(Horloges.this, Horloges.class);
			startActivity(intent);
			return true;
		}*/
		if (id == R.id.calendrier ) {
			Log.d("Pascal Log", "R.id.action_settings)-->"+ item.getTitle() );
			Intent intent = new Intent(Horloges.this, Calendrier.class);
			startActivity(intent);
			return true;
		}
		if (id == R.id.camera ) {
			Log.d("Pascal Log", "R.id.action_settings)-->"+ item.getTitle() );
			Intent intent = new Intent(Horloges.this, Camera.class);
			startActivity(intent);
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
	
	
	
	
	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
			Log.d("Pascal Log", "PlaceholderFragment");
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_horloges,
					container, false);
			Log.d("Pascal Log", "onCreateView");
			
			return rootView;
		}
	}

	public void addListenerOnButton() {
		 
		btnenregistrer = (Button) findViewById(R.id.enregistrer);
 
		btnenregistrer.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View View) {
 
				Log.d("Pascal Log", "onClick(View v)");
 
			}
 
		});
 
	}

}



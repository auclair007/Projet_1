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
import android.os.Build;

public class Calendrier extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendrier);

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
			Intent intent = new Intent(Calendrier.this, Apropos.class);
			startActivity(intent);
			return true;
		}
		if (id == R.id.horloges ) {
			Log.d("Pascal Log", "R.id.action_settings)-->"+ item.getTitle() );
			Intent intent = new Intent(Calendrier.this, Horloges.class);
			startActivity(intent);
			return true;
		}
		/*if (id == R.id.calendrier ) {
			Log.d("Pascal Log", "R.id.action_settings)-->"+ item.getTitle() );
			Intent intent = new Intent(Calendrier.this, Calendrier.class);
			startActivity(intent);
			return true;
		}*/
		if (id == R.id.camera ) {
			Log.d("Pascal Log", "R.id.action_settings)-->"+ item.getTitle() );
			Intent intent = new Intent(Calendrier.this, Camera.class);
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
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_calendrier,
					container, false);
			return rootView;
		}
	}

}

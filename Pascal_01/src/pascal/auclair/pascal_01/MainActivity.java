package pascal.auclair.pascal_01;

import java.util.Locale;

import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.LayoutParams;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends ActionBarActivity {

	/**
	 * @return the mSectionsPagerAdapter
	 */
	public SectionsPagerAdapter getmSectionsPagerAdapter() {
		return mSectionsPagerAdapter;
	}

	/**
	 * @return the mViewPager
	 */
	public ViewPager getmViewPager() {
		return mViewPager;
	}

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a {@link FragmentPagerAdapter}
	 * derivative, which will keep every loaded fragment in memory. If this
	 * becomes too memory intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("Pascal Log", "1 onCreate(Bundle savedInstanceState)");
		setContentView(R.layout.activity_main);
	
		// Create the adapter that will return a fragment for each of the three
		// primary sections of the activity.
		mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		Log.d("Pascal Log", "6 onCreateOptionsMenu(Menu menu)"+ menu.toString() );
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		//Log.d("Pascal Log", "onOptionsItemSelected(MenuItem item)-->"+ item.getTitle() );
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			Log.d("Pascal Log", "MainActivity.Java R.id.action_settings)-->"+ item.getTitle() );
			return true;
		}		
		if (id == R.id.apropos ) {
			Log.d("Pascal Log", "MainActivity.Java R.id.action_settings)-->"+ item.getTitle() );
			Intent intent = new Intent(MainActivity.this, Apropos.class);
			startActivity(intent);
			return true;
		}
		if (id == R.id.horloges ) {
			Log.d("Pascal Log", "MainActivity.Java R.id.action_settings)-->"+ item.getTitle() );
			Intent intent = new Intent(MainActivity.this, Horloges.class);
			startActivity(intent);
			return true;
		}
		if (id == R.id.calendrier ) {
			Log.d("Pascal Log", "MainActivity.Java R.id.action_settings)-->"+ item.getTitle() );
			Intent intent = new Intent(MainActivity.this, Calendrier.class);
			startActivity(intent);
			return true;
		}
		if (id == R.id.camera ) {
			Log.d("Pascal Log", "MainActivity.Java R.id.action_settings)-->"+ item.getTitle() );
			Intent intent = new Intent(MainActivity.this, Camera.class);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {
		
		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
			Log.d("Pascal Log", "2 SectionsPagerAdapter(FragmentManager fm)");
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a PlaceholderFragment (defined as a static inner class
			// below).
			Log.d("Pascal Log", "3 Fragment getItem(int position)");
			return PlaceholderFragment.newInstance(position + 1);
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			//System.out.println("getCount()");
			return 3;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				Log.d("Pascal Log", "case 0");
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				Log.d("Pascal Log", "case 1");
				return getString(R.string.title_section2).toUpperCase(l);
			case 2:
				Log.d("Pascal Log", "case 2");
				return getString(R.string.title_section3).toUpperCase(l);
			}
			Log.d("Pascal Log", "case null");
			return null;
		}
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static PlaceholderFragment newInstance(int sectionNumber) {
			Log.d("Pascal Log", "4 PlaceholderFragment newInstance(int sectionNumber) -->"+sectionNumber);
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
			Log.d("Pascal Log", "5 onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)");
			View rootView = inflater.inflate(R.layout.fragment_main, container,false);
			TextView textView = (TextView) rootView.findViewById(R.id.mess1);
			textView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
			return rootView;
		}
	}
	
	public void sendMessage(View view) {
	    // Do something in response to button
		Log.d("Pascal Log", "coucou");
		//Intent intent = new Intent(this, DisplayMessageActivity.class);
		
		/*Intent intent = new Intent(this, getmViewPager() );
	    EditText editText = (EditText) findViewById(R.id.mess1);
	    String message = editText.getText().toString();
	    intent.putExtra(EXTRA_MESSAGE, message);
	    startActivity(intent);*/

	}
		
}



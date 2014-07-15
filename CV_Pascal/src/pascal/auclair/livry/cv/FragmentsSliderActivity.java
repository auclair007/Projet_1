package pascal.auclair.livry.cv;

import java.util.List;
import java.util.Vector;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.telephony.SmsManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FragmentsSliderActivity extends FragmentActivity {


	/* (non-Javadoc)
	 * @see android.support.v4.app.FragmentActivity#onCreateView(java.lang.String, android.content.Context, android.util.AttributeSet)
	 */
	@Override
	public View onCreateView(String name, Context context, AttributeSet attrs) {
		// TODO Auto-generated method stub
		//Log.d("Pascal Log", "FragmentsSliderActivity.onCreateView --> "+name+" "+ context +" "+attrs);
		return super.onCreateView(name, context, attrs);
	}
	
	public PagerAdapter mPagerAdapter2;
	public ViewPager pager2;
	private String tel;
	private String mess;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.viewpager);

		// Création de la liste de Fragments que fera défiler le PagerAdapter
		List<Fragment> fragments = new Vector<Fragment>();

		// Ajout des Fragments dans la liste
		fragments.add(Fragment.instantiate(this,PageAccueilFragment.class.getName()));
		fragments.add(Fragment.instantiate(this,PageCompetenceFragment.class.getName()));
		fragments.add(Fragment.instantiate(this,PageBDDFragment.class.getName()));
		fragments.add(Fragment.instantiate(this,PageVmwareFragment.class.getName()));
		fragments.add(Fragment.instantiate(this,PageVeeamBRFragment.class.getName()));
		fragments.add(Fragment.instantiate(this,PageBestRealFragment.class.getName()));
		fragments.add(Fragment.instantiate(this,PageSms.class.getName()));

		// Création de l'adapter qui s'occupera de l'affichage de la liste de
		// Fragments
		this.mPagerAdapter2 = new MyPagerAdapter(super.getSupportFragmentManager(), fragments);

		pager2 = (ViewPager) super.findViewById(R.id.viewpager);
		// Affectation de l'adapter au ViewPager
		pager2.setAdapter(this.mPagerAdapter2);
		
	}
	
	
	public void sendsms_api (View v){

		Log.d("Pascal Log", "Appui Envoyer sms" );

		EditText te = (EditText) findViewById(R.id.message);
		mess = te.getText().toString();
		EditText ph = (EditText) findViewById(R.id.phonenumber);
		tel = ph.getText().toString();
			
			try {
				// Get the default instance of the SmsManager
				Signature_sms signature_sms = new Signature_sms ();
				SmsManager smsManager = SmsManager.getDefault();

				mess = mess + signature_sms.get_text() ; 
				Log.d("Pascal Log", "tel -->"+tel );
				Log.d("Pascal Log", "mes -->"+mess ); 

				smsManager.sendTextMessage(	tel,null,mess,null,null);
				
				Toast.makeText(getApplicationContext(), "Votre sms a été envoyé!",
						Toast.LENGTH_LONG).show();
			} catch (Exception ex) {
				Log.d("Pascal Log", "tel -->"+tel );
				Log.d("Pascal Log", "mes -->"+mess );

				Toast.makeText(getApplicationContext(),"Votre sms a des erreurs...",
						Toast.LENGTH_LONG).show();
				ex.printStackTrace();
			}
		}
	
	public void sendsms (View v){

		Log.d("Pascal Log", "Appui Envoyer sms" );
		
		/*EditText te = (EditText) findViewById(R.id.message);
		mess = te.getText().toString();*/
		mess="";
		EditText ph = (EditText) findViewById(R.id.phonenumber);
		tel = ph.getText().toString();
		
		Intent smsVIntent = new Intent(Intent.ACTION_VIEW);
		// prompts only sms-mms clients
		smsVIntent.setType("vnd.android-dir/mms-sms");
		
		// extra fields for number and message respectively
		smsVIntent.putExtra("address", tel );
		smsVIntent.putExtra("sms_body", mess );

		try{
			startActivity(smsVIntent);
			pager2.arrowScroll(View.FOCUS_LEFT);
			//pager2.getScrollX();
		} catch (Exception ex) {
			Toast.makeText( this, "Votre sms a des erreurs...",
					Toast.LENGTH_LONG).show();
			ex.printStackTrace();
		}
		
	}
	
}

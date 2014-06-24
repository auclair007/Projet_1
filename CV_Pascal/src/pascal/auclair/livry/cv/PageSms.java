package pascal.auclair.livry.cv;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class PageSms extends Fragment  {

	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#getView()
	 */
	@Override
	public  View getView() {
		// TODO Auto-generated method stub
		//Log.d("Pascal Pagesms", "PageSms getView" );
		return super.getView();
	}

	/* (non-Javadoc) 
	 * @see android.support.v4.app.Fragment#onStart()
	 */
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		EditText zz = (EditText) getView().findViewById(R.id.phonenumber);
		zz.setText(R.string.tel);
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.page_sms, container, false);
	}
}
package pascal.auclair.livry.cv;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class PageBestRealFragment extends Fragment {

	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onStart()
	 */
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		BestReal BestReal = new BestReal();
		TextView textView = (TextView) getView().findViewById(R.id.bestreal );
	    String cc = BestReal.get_text();
	    textView.setText(cc);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.page_bestreal,container, false);
	}
	
	
}

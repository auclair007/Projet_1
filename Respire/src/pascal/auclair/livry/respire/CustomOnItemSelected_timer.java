package pascal.auclair.livry.respire;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class CustomOnItemSelected_timer implements OnItemSelectedListener {

	  public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
			Toast.makeText(parent.getContext(), 
				"Timer : " + parent.getItemAtPosition(pos).toString(),
				Toast.LENGTH_SHORT).show();
		  }
		 
		  public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
		  }
}

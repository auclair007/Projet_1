package pascal.auclair.livry.respire;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Util_pa {
	
	private static Spinner spinner_delay ;
	private static Spinner spinner_timer;
	private static Spinner spinner_inhale;
	private static Spinner spinner_exhale;
	private static Spinner spinner_hold1;
	private static Spinner spinner_hold2;
	
	public static void addItemsOn_delay(MainActivity mainActivity) {
	   	spinner_delay = (Spinner) mainActivity.findViewById(R.id.spinner_delay);
    	List<String> list = new ArrayList<String>();
    	
    	for ( int ii = 0;ii <= 60 ; ii = ii + 5){
   		    DecimalFormat df = new DecimalFormat("#.##");
    		list.add(df.format(ii));
    	}

    	ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(mainActivity,
    		android.R.layout.simple_spinner_item, list);
    	dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	spinner_delay.setAdapter(dataAdapter);
    	spinner_delay.setSelection(3);
      }
    public static void addItemsOn_timer(MainActivity mainActivity) {
	   	   	 
    	spinner_timer = (Spinner) mainActivity.findViewById(R.id.spinner_timer);
    	List<String> list = new ArrayList<String>();

    	for ( int ii = 1 ;ii <= 10 ; ii = ii + 1){
   		    DecimalFormat df = new DecimalFormat("##.##");
    		list.add(df.format(ii));
    	}
    	
    	ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(mainActivity,
    		android.R.layout.simple_spinner_item, list);
    	dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	spinner_timer.setAdapter(dataAdapter);
    	spinner_timer.setSelection(0);
      }
    public static void addItemsOn_inhale(MainActivity mainActivity) {
      	 
    	spinner_inhale = (Spinner) mainActivity.findViewById(R.id.spinner_inhale);
    	List<String> list = new ArrayList<String>();

    	for ( int ii = 0 ;ii < 60 ; ii = ii + 1){
   		    DecimalFormat df = new DecimalFormat("##.##");
    		list.add(df.format(ii));
    	}
    	
    	ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(mainActivity,
    		android.R.layout.simple_spinner_item, list);
    	dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	spinner_inhale.setAdapter(dataAdapter);
    	spinner_inhale.setSelection(2);
      }
    public static void addItemsOn_exhale(MainActivity mainActivity) {
     	 
    	spinner_exhale = (Spinner) mainActivity.findViewById(R.id.spinner_exhale);
    	List<String> list = new ArrayList<String>();

    	for ( int ii = 0 ;ii < 60 ; ii = ii + 1){
   		    DecimalFormat df = new DecimalFormat("##.##");
    		list.add(df.format(ii));
    	}
    	
    	ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(mainActivity,
    		android.R.layout.simple_spinner_item, list);
    	dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	spinner_exhale.setAdapter(dataAdapter);
    	spinner_exhale.setSelection(3);
      }    
    public static void addItemsOn_hold1(MainActivity mainActivity) {
     	 
    	spinner_hold1 = (Spinner) mainActivity.findViewById(R.id.spinner_hold1);
    	List<String> list = new ArrayList<String>();

    	for ( int ii = 0 ;ii < 60 ; ii = ii + 1){
   		    DecimalFormat df = new DecimalFormat("##.##");
    		list.add(df.format(ii));
    	}
    	
    	ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(mainActivity,
    		android.R.layout.simple_spinner_item, list);
    	dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	spinner_hold1.setAdapter(dataAdapter);
    	spinner_hold1.setSelection(1);
      }
    public static void addItemsOn_hold2(MainActivity mainActivity) {
    	 
    	spinner_hold2 = (Spinner) mainActivity.findViewById(R.id.spinner_hold2);
    	List<String> list = new ArrayList<String>();

    	for ( int ii = 0 ;ii < 60 ; ii = ii + 1){
   		    DecimalFormat df = new DecimalFormat("##.##");
    		list.add(df.format(ii));
    	}
    	
    	ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(mainActivity,
    		android.R.layout.simple_spinner_item, list);
    	dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	spinner_hold2.setAdapter(dataAdapter);
    	spinner_hold2.setSelection(1);
      }
    
    public static void addListenerOnSpinner_delay(MainActivity mainActivity) {
    	spinner_delay = (Spinner) mainActivity.findViewById(R.id.spinner_delay);
    	spinner_delay.setOnItemSelectedListener(new CustomOnItemSelected_delay());
      }
    public static void addListenerOnSpinner_timer(MainActivity mainActivity) {
    	spinner_timer = (Spinner) mainActivity.findViewById(R.id.spinner_timer);
    	spinner_timer.setOnItemSelectedListener(new CustomOnItemSelected_timer());
      }
    public static void addListenerOnSpinner_inhale(MainActivity mainActivity) {
    	spinner_inhale = (Spinner) mainActivity.findViewById(R.id.spinner_inhale);
    	spinner_inhale.setOnItemSelectedListener(new CustomOnItemSelected_inhale());
    }
    public static void addListenerOnSpinner_exhale(MainActivity mainActivity) {
    	spinner_inhale = (Spinner) mainActivity.findViewById(R.id.spinner_exhale);
    	spinner_inhale.setOnItemSelectedListener(new CustomOnItemSelected_exhale());
    }
    public static void addListenerOnSpinner_hold1(MainActivity mainActivity) {
    	spinner_inhale = (Spinner) mainActivity.findViewById(R.id.spinner_hold1);
    	spinner_inhale.setOnItemSelectedListener(new CustomOnItemSelected_hold1());
    }
    public static void addListenerOnSpinner_hold2(MainActivity mainActivity) {
    	spinner_inhale = (Spinner) mainActivity.findViewById(R.id.spinner_hold2);
    	spinner_inhale.setOnItemSelectedListener(new CustomOnItemSelected_hold2());
    }

}

package paUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SpoolPostgres {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	try {
		System.out.println("---------Arguments");
		for ( int ii=0 ; ii < args.length ; ii++) {
			System.out.println(args[ii]);
		}
		System.out.println("------------------");
		
		String l1 = "\\pset tuples_only"; 
		String l2 = "\\pset footer off";
		String l3 = "SELECT vir_treso || occasionnel || rpad(reference, 16) || transaction ||"+
		      " rpad(payeur, 8) || rpad(tiers, 10) || rpad(' ', 8) || rpad(devise, 3)"+
		      " || to_char(montant, '9999999999999999.99') || to_char(date_ope,"+
		      " 'ddmmyyyy') || mode_maj || rpad(' ', 3) || rpad(compte_debiter, 10) ||"+
		      " rpad(' ', 8) || code_budget || rpad(motif, 35) || rpad(' ', 105) ||"+
		      " rpad(texte_libre, 70) || rpad(' ', 678) || rpad(donneur_ordre, 8) ||"+
		      " rpad(' ', 39) || '000' || mode_regl"+
		    " FROM decla_02"+
		    " WHERE date_ope = to_date('"+args[4]+"', 'ddmmyyyy') and montant > 0 "+
		    " ORDER BY texte_libre" ;
		           
		PrintWriter writer1 = new PrintWriter(args[1], args[3]);
		writer1.println(l1);
		writer1.println(l2);
		writer1.println(l3);
		writer1.close();
		
		
		PrintWriter writer = new PrintWriter(args[2], args[3]);
		String line="",line2="";
		Process p = Runtime.getRuntime().exec ( args[0] + args[1] );
		BufferedReader input = new BufferedReader (new InputStreamReader(p.getInputStream()));
		while ((line = input.readLine()) != null) {
			//System.out.println(line );
			if ( line.length() > 10 ) {
				line2 = line.trim();
				writer.println(line2);
			}
		}
		writer.close();
		input.close();
		System.out.println(line2);// derniere ligne dans la console Java
	    }
	    catch (Exception err) {
	      err.printStackTrace();
	    }
	}
}

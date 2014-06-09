package paUtils;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Fileini {

	/**
	 * @param args
	 */
	public static int writeUrssafCfg(String[] args) {
		PrintWriter writer1 = null;
		try {
			writer1 = new PrintWriter(args[0], "UTF-8");
			writer1.println("fichier_excel="+args[1]);
			writer1.println("fichier_xrt="+args[2]);
			writer1.println("onglet="+args[3]);
			writer1.println("premiere_ligne="+args[4]);
			writer1.println("derniere_ligne="+args[5]);
			writer1.println("colonne_magasin="+args[6]);
			writer1.println("colonne_montant="+args[7]);
			writer1.println("colonne_yyyytm="+args[8]);
			writer1.println("colonne_tiers="+args[9]);
			writer1.println("colonne_ref1="+args[10]);
			writer1.println("colonne_ref2="+args[11]);
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			writer1.close();			
		}
		
		return 0;
	}

}

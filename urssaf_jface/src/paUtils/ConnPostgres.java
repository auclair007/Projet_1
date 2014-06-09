package paUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnPostgres {
	private static Connection conn;

	/**
	 * @param args
	 * @return 
	 */
	public Connection main(String [] args ) {
        try {
			System.out.println("---------Arguments");
    		for ( int ii=0 ; ii < args.length ; ii++) {
    			System.out.println(args[ii]);
    		}
			System.out.println("------------------");
        	conn = null;
        	conn = (Connection) DriverManager.getConnection(args[0], args[1], args[2]);
        	System.out.println("OK connexion à la base");
        	return conn;
        } catch (SQLException ex)
        {
            System.out.println("Erreur lors de la connexion à la base");
            return null;
        }
	}
	
	public static int check_conn(String [] args ) {
        try {
			System.out.println("---------Arguments");
    		for ( int ii=0 ; ii < args.length ; ii++) {
    			System.out.println(args[ii]);
    		}
			System.out.println("------------------");
        	//Connection conn2 = null;
			Class.forName("org.postgresql.Driver");
        	DriverManager.getConnection(args[0], args[1], args[2]);
        	System.out.println("OK Check connexion");
        	return 0;
        } catch (SQLException | ClassNotFoundException ex)
        {
            System.out.println("Erreur Check connexion");
            return 1;
        }
	}
	public String[] getSelectDistinct( Connection conn, String table, String colonne){
        String[] liste = new String[150];
		try {
			String sql="select distinct "+colonne+" from "+table;
			Statement st1;
			int ii=0;

			st1 = conn.createStatement();
			ResultSet rs1 = st1.executeQuery(sql);
			while (rs1.next())
			{
				liste[ii]=rs1.getString(1);
				ii++;
			}
			st1.close(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}
	
	public String[][] getCodeCompta( Connection conn){
		String[][] liste = new String[150][4];
		try {
			String sql="select texte_libre ,payeur , compte_debiter , donneur_ordre from modele_02 order by 1";
			Statement st1;
			int ii=0;

			st1 = conn.createStatement();
			ResultSet rs1 = st1.executeQuery(sql);
			while (rs1.next())
			{
				liste[ii][0]=rs1.getString(1);
				liste[ii][1]=rs1.getString(2);
				liste[ii][2]=rs1.getString(3);
				liste[ii][3]=rs1.getString(4);
				ii++;
			}
			st1.close(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}
	
	public void update_decla_02( Connection conn, String magasin, long montant, String date_paie){
		try {
			String sql="UPDATE decla_02 "+
						"SET montant='" + montant + "'"+
						" WHERE texte_libre='" + magasin   + "'"+
						" AND   date_ope=to_date('"+date_paie+"','ddmmyyyy')";

			Statement st1 = conn.createStatement();
			st1.executeUpdate(sql);
			st1.close(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void dedup_modele_to_decla( Connection conn, String yyyytm, String date_paie){
		try {
			String sql0="DELETE FROM decla_02 WHERE date_ope=to_date('"+date_paie+"','ddmmyyyy')";
			String sql1="insert into decla_02 "+
			"select VIR_TRESO,OCCASIONNEL,REFERENCE,TRANSACTION,PAYEUR,TIERS,DEVISE,0 MONTANT, "+
			"to_date('"+date_paie+"','ddmmyyyy') , "+
			"MODE_MAJ,COMPTE_DEBITER,CODE_BUDGET, "+
			"MOTIF1|| '"+yyyytm+"' ||MOTIF3, "+
			"TEXTE_LIBRE,DONNEUR_ORDRE,MODE_REGL "+
			"from  modele_02  where tiers='URSSAF'" ;
		
			Statement st1 = null;
			st1 = conn.createStatement();
			st1.executeUpdate(sql0);
			st1.close();			
			st1 = null;
			st1 = conn.createStatement();
			st1.executeUpdate(sql1);
			st1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void maj_modele_02( Connection conn, String magasin, String tiers, String ref1 ,long ref2){
		try {
			String check_modele="select count(*) nbr from modele_02 where texte_libre='"+ magasin +"'";
			Statement st1 = conn.createStatement();
			ResultSet rs1 = st1.executeQuery(check_modele);
			rs1.next();
			int cc = rs1.getInt(1);
			if ( cc == 0 ) {
				//System.out.println("count modele = 0 --> do insert "+VerifExcel.magArray[ii]);
				String insert_modele="INSERT INTO modele_02( "+
			            "vir_treso, occasionnel, reference, transaction, payeur, tiers, "+ 
			            "devise, mode_maj, compte_debiter, code_budget, motif1, motif3, "+
			            "texte_libre, donneur_ordre, mode_regl) "+
			    " VALUES ('N', '0', 'VIRT', 'VDSC', 'JARMG---', '" + tiers + "' , "+
			            " 'EUR', '0', 'CAVMG---', 'CSOC', '" + ref1 + "','"+ ref2 +"','"+
			            magasin +"', 'JARMG---', '010')";
				Statement st2 = conn.createStatement();
				st2.executeUpdate(insert_modele);
				st2.close();
			} else {
				//System.out.println("count modele = 1 --> do update "+VerifExcel.magArray[ii]);
				String update_modele="UPDATE modele_02 "+
			            "SET tiers='" + tiers + "',"+
			            "   motif1='" + ref1  + "',"+
			            "   motif3='" + ref2  + "'"+
			   " WHERE texte_libre='" + magasin   + "'";
				//System.out.println(update_modele);
				Statement st2 = conn.createStatement();
				st2.executeUpdate(update_modele);
				st2.close();
			}
			rs1.close();
			st1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void maj_code_compta( Connection conn, String payeur, String compte_debiter, String donneur_ordre, String magasin){
		try {
        String update_modele = "UPDATE modele_02 SET payeur='"+payeur+"'"+
				" , compte_debiter='"+compte_debiter+"'" +
				" , donneur_ordre='"+donneur_ordre+"'" +
				" WHERE texte_libre='"+magasin+"'" ;
				
			Statement st2 = conn.createStatement();
			st2.executeUpdate(update_modele);
			st2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void maj_XRTGlobal( Connection conn, String vir_treso, String occasionnel, String reference, String transaction ,
			 String devise , String mode_maj , String code_budget ,String mode_regl){
		try {
	        String update_modele = "UPDATE modele_02 SET vir_treso='"+vir_treso+"'"+
					" , occasionnel='"+occasionnel+"'" +
					" , reference='"+reference+"'" +
					" , transaction='"+transaction+"'" +
					" , devise='"+devise+"'" +
					" , mode_maj='"+mode_maj+"'" +
					" , code_budget='"+code_budget+"'" +
					" , mode_regl='"+mode_regl+"'" ;

				Statement st2 = conn.createStatement();
				st2.executeUpdate(update_modele);
				st2.close();
			} catch (SQLException e) {
			e.printStackTrace();
			}
	}
}

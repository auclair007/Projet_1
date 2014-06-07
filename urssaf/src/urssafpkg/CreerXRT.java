package urssafpkg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paUtils.SpoolPostgres;

/**
 * Servlet implementation class CreerXRT
 */
@WebServlet("/CreerXRT")
public class CreerXRT extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreerXRT() {
        super();
        System.out.println("methode CreerXRT()");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet methode CreerXRT()");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost methode CreerXRT()");
		String fxrt = request.getParameter("fichierxrt");
		String yyyytm = request.getParameter("yyyytm");
		System.out.println("fxrt = " + fxrt);
		System.out.println("yyyytm = " + yyyytm);
		

/*  Mise a jour de la table Modele_02   */
		for (int ii=0 ; ii < VerifExcel.magArray.length && VerifExcel.magArray[ii] != null ; ii++) {
			ParamUrssaf.ccc.maj_modele_02(ParamUrssaf.connBDD, VerifExcel.magArray[ii], VerifExcel.tiersArray[ii], VerifExcel.ref1Array[ii], VerifExcel.ref2Array[ii]);
		}

		
/*  Duplication de modele_02 vers decla_02 pour le 15 du mois en cours  */
        Date aujourdhui = new Date();
        SimpleDateFormat dd = new SimpleDateFormat("MMyyyy");
        String date_paie="15" + dd.format(aujourdhui).toString() ;
        System.out.println("Date de paiement "+date_paie);
        
        ParamUrssaf.ccc.dedup_modele_to_decla(ParamUrssaf.connBDD, yyyytm, date_paie);

/*  Update 	decla_02  avec les valeurs pour ce mois  */
		for (int ii=0 ; ii < VerifExcel.magArray.length && VerifExcel.magArray[ii] != null ; ii++) {
			ParamUrssaf.ccc.update_decla_02(ParamUrssaf.connBDD, VerifExcel.magArray[ii], VerifExcel.euroArray[ii], date_paie);
		}
		
/*    Generation du fichier de sortie   */
		           
		String[] args = {
				"C:/Program Files/Postgresql/9.3/bin/psql.exe -h 127.0.0.1 -U urssaf -d urssaf -q -f " ,
				"C:/workspace/urssaf/WebContent/spoolUrssaf.sql",
				fxrt ,
				"UTF-8" ,
				date_paie
				};
		SpoolPostgres.main(args);
		
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
        out.println("<title>Fichier XRT</title>");
        out.println("</head>");
        out.println("<body background =\"mur_du_son_2.jpg\" text=\"yellow\">");
        out.println("<H2>Fichier XRT "+fxrt+"</H2>");
/* -----------------------------------------------*/
		try{
		BufferedReader buff = new BufferedReader(new FileReader(fxrt));
		try {
		String line;
		while ((line = buff.readLine()) != null) {
			out.println(line);
			out.println("<br>");
		}
		} finally {
		buff.close();
		}
		} catch (IOException ioe) {
		System.out.println("Erreur --" + ioe.toString());
		}
/* -----------------------------------------------*/		
        out.println("</body>");
        out.println("</html>"); 

	}

}

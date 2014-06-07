package urssafpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import paUtils.ConnPostgres;

/**
 * Servlet implementation class ParamUrssaf
 */
@WebServlet("/ParamUrssaf")
public class ParamUrssaf extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection connBDD;
	public static ConnPostgres ccc;
       
    
    public ParamUrssaf() {
        super();
        System.out.println("methode ParamUrssaf()");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet methode ParamUrssaf");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost methode ParamUrssaf");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
   		String[] args = {
   				"jdbc:postgresql://127.0.0.1:5432/urssaf",
   				username,password 
   				};
   		
        int ii = paUtils.ConnPostgres.check_conn(args);
        if (ii == 1) {
			RequestDispatcher dispatch = request.getRequestDispatcher("/LoginUrssaf.jsp");
			dispatch.forward (request, response);        	
        } else {
        connBDD = null;
        ccc = new paUtils.ConnPostgres();

		connBDD = ccc.main( args );

		if ( ! connBDD.equals(null) )  {
				String fexcel;
				String fxrt;
				String onglet;
				String firstligne;
				String lastligne;
				String colpdv;
				String colmontant;
				String c_yyyytm;
				String coltiers;
				String colref1;
				String colref2;
		
		    	Properties p = new Properties();
		    	String fini="C:/wk_kepler/urssaf/WebContent/urssaf.cfg";
		        p.load(new FileInputStream (fini));
		        fexcel = p.getProperty("fichier_excel");
		        fxrt=p.getProperty("fichier_xrt");
		        onglet=p.getProperty("onglet");
		        firstligne=p.getProperty("premiere_ligne");
		        lastligne=p.getProperty("derniere_ligne");
		        colpdv=p.getProperty("colonne_magasin");
		        colmontant=p.getProperty("colonne_montant");
		        c_yyyytm=p.getProperty("colonne_yyyytm");
		        coltiers = p.getProperty("colonne_tiers");
		        colref1=p.getProperty("colonne_ref1");
		        colref2=p.getProperty("colonne_ref2");
		        
		        Date aujourdhui = new Date();
		        SimpleDateFormat dd = new SimpleDateFormat("yyyyMMdd-HHmmss");
		        System.out.println(dd.format(aujourdhui));
		        
		        String pp = new File(fxrt).getParent();
		        String ppp = pp.replace("\\", "/");
		        System.out.println(ppp);
		        String nn = new File(fxrt).getName();
		        System.out.println(nn);
		        String fxrt2=ppp + "/" + dd.format(aujourdhui) + "-" + nn ;
		        
		        System.out.println("fexcel = " + fexcel);
		        System.out.println("fxrt = " + fxrt2);
		        System.out.println("onglet = " + onglet);
		        System.out.println("firstligne = " + firstligne);
		        System.out.println("lastligne = " + lastligne);
		        System.out.println("colpdv = " + colpdv);
		        System.out.println("colmontant = " + colmontant);
		        System.out.println("c_yyyytm = " + c_yyyytm);
		        System.out.println("coltiers = " + coltiers);
		        System.out.println("colref1 = " + colref1);
		        System.out.println("colref2 = " + colref2);
		        /*------------------------------------------------------------------------*/
//		    	RequestDispatcher dispatch = request.getRequestDispatcher("ParamUrssaf.jsp");
//		    	dispatch.forward(request, response);
		        
		        PrintWriter out = response.getWriter();
		        out.println("<html>");
		        out.println("<head>");
		        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
		        out.println("<title>Paramètres</title>");
		        out.println("</head>");
		        out.println("<body background =\"mur_du_son_2.jpg\" text=\"yellow\">");
		
		        
		        out.println("<H2>Paramètres URSSAF</H2>");
		        out.println("<form action=\"VerifExcel\" method=\"post\">");
		        out.println("<table border=1>");
		        out.println("<tr>");
		        out.println("<td>Fichier Excel à traiter</td>");
		        out.println("<td><input type=\"text\" size=\"50\" name=\"fichierexcel\" value=\"" +fexcel+ "\"></td>");
		        out.println("</tr>");
		        out.println("<tr>");
		        out.println("<td>Fichier XRT</td>");
		        out.println("<td><input type=\"text\" size=\"50\" name=\"fichierxrt\" value=\"" +fxrt2+ "\"></td>");
		        out.println("</tr>");
		        out.println("<tr>");
		        out.println("<td>Nom de l'onglet</td>");
		        out.println("<td><input type=\"text\" name=\"ref_onglet\" value=\"" +onglet+ "\"></td>");
		        out.println("</tr>");
		        out.println("<tr>");
		        out.println("<td>Première ligne à traiter</td>");
		        out.println("<td><input type=\"text\" name=\"firstligne\" value=\"" +firstligne+ "\">3</td>");
		        out.println("</tr>");
		        out.println("<tr>");
		        out.println("<td>Dernière ligne à traiter</td>");
		        out.println("<td><input type=\"text\" name=\"lastligne\" value=\"" +lastligne+ "\">105</td>");
		        out.println("</tr>");
		        out.println("<tr>");
		        out.println("<td>Colonne magasin</td>");
		        out.println("<td><input type=\"text\" name=\"colpdv\" value=\"" +colpdv+ "\"> Nom du Magasin</td>");
		        out.println("</tr>");
		        out.println("<tr>");
		        out.println("<td>Colonne montant</td>");
		        out.println("<td><input type=\"text\" name=\"colmontant\" value=\"" +colmontant+ "\"> Euros</td>");
		        out.println("</tr>");
		        out.println("<tr>");
		        out.println("<td>Colonne yyyytm</td>");
		        out.println("<td><input type=\"text\" name=\"colmois\" value=\"" +c_yyyytm+ "\"> 201411 to 201443</td>");
		        out.println("</tr>");
		        out.println("<tr>");
		        out.println("<tr>");
		        out.println("<td>Colonne tiers</td>");
		        out.println("<td><input type=\"text\" name=\"coltiers\" value=\"" +coltiers+ "\"> URSSAF</td>");
		        out.println("</tr>");
		        out.println("<tr>");
		        out.println("<tr>");
		        out.println("<td>Colonne Ref1</td>");
		        out.println("<td><input type=\"text\" name=\"colref1\" value=\"" +colref1+ "\"> 99S1</td>");
		        out.println("</tr>");
		        out.println("<tr>");
		        out.println("<tr>");
		        out.println("<td>Colonne Ref2</td>");
		        out.println("<td><input type=\"text\" name=\"colref2\" value=\"" +colref2+ "\"> 1234567890123</td>");
		        out.println("</tr>");
		        out.println("<tr>");
		        out.println("<td align=\"center\" ><input type=\"submit\" name=\"action\" value=\"Sauvegarder\"></td>");
		        out.println("<td align=\"center\" ><input type=\"submit\" name=\"action\" value=\"Vérifier le fichier Excel\"></td>");
		        out.println("</tr>");
		        out.println("</table>");    
		        out.println("<input type=\"hidden\" name=\"username\" value=\"" +username+ "\">");
		        out.println("<input type=\"hidden\" name=\"password\"  value=\"" +password+ "\">");
		        out.println("<input type=\"hidden\" name=\"fini\"  value=\"" +fini+ "\">");
		        out.println("<input type=\"hidden\" name=\"fxrt\"  value=\"" +fxrt+ "\">");
		        out.println("</form>");

		        out.println("<table border=1>");
		        out.println("<tr>");
		        out.println("<form action=\"XrtGlobal\" method=\"post\">");
		        out.println("<td>Modifier les parametres GLOBAUX du fichier XRT</td>");
		        out.println("<td><input type=\"submit\" name=\"modifier\" value=\"Modifier\"></td>");
		        out.println("</form>");
		        out.println("</tr>");		        
		   
		        out.println("<tr>");
		        out.println("<form action=\"CodeCompta\" method=\"post\">");
		        out.println("<td>Affecter les codes compatables aux Magasins</td>");
		        out.println("<td><input type=\"submit\" name=\"affecter\" value=\"Affecter\"></td>");
		        out.println("</form>"); 
		        out.println("</tr>");		        
		        out.println("</table>");    

		        out.println("</body>");
		        out.println("</html>"); 
		        /*------------------------------------------------------------------------*/
			}
        }
	}
//	RequestDispatcher dispatch = request.getRequestDispatcher("LoginUrssaf.jsp");
//	dispatch.forward(request, response);
}

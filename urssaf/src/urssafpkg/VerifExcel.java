package urssafpkg;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import paUtils.Fileini;

/**
 * Servlet implementation class VerifExcel
 */
@WebServlet("/VerifExcel")
public class VerifExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String[] magArray;
	public static long[] euroArray;
	public static String[] tiersArray;
	public static String[] ref1Array;
	public static long[] ref2Array;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifExcel() {
        super();
        System.out.println("methode VerifExcel()");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet methode VerifExcel");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost methode VerifExcel");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fexcel = request.getParameter("fichierexcel");
        String fxrt2 = request.getParameter("fichierxrt");
        String ref_onglet = request.getParameter("ref_onglet");
        String firstligne = request.getParameter("firstligne");
        String lastligne = request.getParameter("lastligne");
        String colpdv = request.getParameter("colpdv");
        String colmontant = request.getParameter("colmontant");
        String c_yyyytm = request.getParameter("colmois");
        String coltiers = request.getParameter("coltiers");
        String colref1 = request.getParameter("colref1");
        String colref2 = request.getParameter("colref2");
        String action = request.getParameter("action");
        String fini = request.getParameter("fini");
        String fxrt = request.getParameter("fxrt");
        
        System.out.println("fini = " + fini);
        System.out.println("action = " + action);
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        System.out.println("fexcel = " + fexcel);
        System.out.println("fxrt = " + fxrt);
        System.out.println("fxrt2 = " + fxrt2);
        System.out.println("onglet = " + ref_onglet);
        System.out.println("firstligne = " + firstligne);
        System.out.println("lastligne = " + lastligne);
        System.out.println("colpdv = " + colpdv);
        System.out.println("colmontant = " + colmontant);
        System.out.println("c_yyyytm = " + c_yyyytm);
        System.out.println("coltiers = " + coltiers);
        System.out.println("colref1 = " + colref1);
        System.out.println("colref2 = " + colref2);
/*------------------------------------------------------------------------*/
        if (action.equals("Sauvegarder")){
        	System.out.println("Sauvegarder");
        	String [] args = {
        			fini,
        	        fexcel ,
        	        fxrt ,
        	        ref_onglet ,
        	        firstligne ,
        	        lastligne ,
        	        colpdv ,
        	        colmontant ,
        	        c_yyyytm ,
        	        coltiers ,
        	        colref1 ,
        	        colref2        			
        	};
        	Fileini.writeUrssafCfg(args);
        	request.getSession().setAttribute("username", username);
        	request.getSession().setAttribute("password", password);
    		RequestDispatcher dispatch = request.getRequestDispatcher("/ParamUrssaf");
			dispatch.forward (request, response);

        } else {
        String liste = "";
	    long mois=(long) 0;
	    long total=(long) 0; 
        try 
        {
		    String pdv ;
		    long montant=(long) 0;
		    String tiers ;
		    String ref1 ;
		    long ref2=(long) 0 ;
	        int ligne=0;
	        magArray = new String[150];
	        euroArray = new long[150];
	        tiersArray = new String[150];
	        ref1Array = new String[150];
	        ref2Array = new long[150];

	        File f = new File(fexcel);
	        if( ! f.exists()){
	        	System.out.println("File NOT existed");
	        	request.getSession().setAttribute("username", username);
	        	request.getSession().setAttribute("password", password);
	    		RequestDispatcher dispatch = request.getRequestDispatcher("/ParamUrssaf");
				dispatch.forward (request, response);
	  		  }else{
	        
		        Workbook wb = WorkbookFactory.create(new File(fexcel));
				Sheet onglet = wb.getSheet(ref_onglet);
				int ii = 0;
				for (ligne = Integer.parseInt(firstligne)-1 ; ligne <= Integer.parseInt(lastligne)-1; ligne++) 
				{
				    // recuperation de chaque ligne
				    Row row = onglet.getRow(ligne);
				    pdv = row.getCell(Integer.parseInt(colpdv)-1)!=null?row.getCell(Integer.parseInt(colpdv)-1).getStringCellValue():"?";
				    mois = (long) (row.getCell(Integer.parseInt(c_yyyytm)-1)!=null?row.getCell(Integer.parseInt(c_yyyytm)-1).getNumericCellValue():0);
				    montant = (long) (row.getCell(Integer.parseInt(colmontant)-1)!=null?row.getCell(Integer.parseInt(colmontant)-1).getNumericCellValue():0);
				    tiers   = row.getCell(Integer.parseInt(coltiers)-1)!=null?row.getCell(Integer.parseInt(coltiers)-1).getStringCellValue():"?";
				    ref1    = row.getCell(Integer.parseInt(colref1)-1)!=null?row.getCell(Integer.parseInt(colref1)-1).getStringCellValue():"?";
				    ref2    = (long) (row.getCell(Integer.parseInt(colref2)-1)!=null?row.getCell(Integer.parseInt(colref2)-1).getNumericCellValue():0);
	//			    System.out.println(ligne + " " +pdv + " " + montant );
				    total = total + montant;
				    liste = liste + "<li>" + pdv + " --> " + montant + "</li>";
				    magArray[ii] = pdv;
				    euroArray[ii] = montant;
				    tiersArray[ii] = tiers;
				    ref1Array[ii] = ref1;
				    ref2Array[ii] = ref2;
				    ii++;
				}
				System.out.println("Tiers "+tiersArray[0]);
				System.out.println("Ref1 "+ref1Array[0]);
				System.out.println("Ref2 "+ref2Array[0]);
				System.out.println(ligne+ " "+ mois);
	        	System.out.println("Fichier traiter --> " + fexcel );
				int nbr = wb.getNumberOfSheets();
				System.out.println("Nrb de sheets --> " + nbr);
				System.out.println("Onglet actif --> " + ref_onglet );
				nbr = onglet.getLastRowNum();
				System.out.println("Nrb de lignes --> " + nbr);
				System.out.println("Total Euro --> " + total);
	  		  }
        }
        catch (InvalidFormatException | IOException e) 
		{
        	e.printStackTrace();
		}
        
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
        out.println("<title>Vérification</title>");
        out.println("</head>");
        out.println("<body background =\"mur_du_son_2.jpg\" text=\"yellow\">");
        
        out.println("<H2>Synthèse des charges URSSAF</H2>");
        out.println("<form action=\"CreerXRT\" method=\"post\">");
        out.println("<table border=1>");
        out.println("<tr>");
        out.println("<td>Fichier Excel traité</td>");
        out.println("<td><input type=\"text\" disabled size=\"50\" name=\"fichierexcel\" value=\"" +fexcel+ "\"></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Fichier XRT</td>");
        out.println("<td><input type=\"text\" size=\"50\" name=\"fichierxrt\" value=\"" +fxrt2+ "\"></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>YYYYTM</td>");
        out.println("<td><input type=\"text\" readonly name=\"yyyytm\" value=\"" +mois+ "\"</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<tr>");
        out.println("<td>Total (Euro)</td>");
        out.println("<td><input type=\"text\" disabled name=\"total\" value=\"" +total+ "\"</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td colspan=2 align=\"right\" ><input type=\"submit\" value=\"Créer le fichier XRT\"></td>");
        out.println("</tr>");
        out.println("</table>");    
        out.println("<input type=\"hidden\" name=\"username\" value=\"" +username+ "\">");
        out.println("<input type=\"hidden\" name=\"password\"  value=\"" +password+ "\">");
        out.println("</form>");
        
        out.println("<ol>");
        out.println(liste);
        out.println("</ol>");
        out.println("</body>");
        out.println("</html>");
        }

/*------------------------------------------------------------------------*/        
	}
}

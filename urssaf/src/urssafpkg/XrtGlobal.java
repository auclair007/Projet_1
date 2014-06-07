package urssafpkg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class XrtGlobal
 */
@WebServlet("/XrtGlobal")
public class XrtGlobal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XrtGlobal() {
        super();
		System.out.println("methode XrtGlobal()");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet methode XrtGlobal");             
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost methode XrtGlobal");

		String[] vir_treso = new String[150];
		String[] occasionnel = new String[150];
		String[] reference = new String[150];
		String[] transaction = new String[150];
		String[] devise = new String[150];
		String[] mode_maj = new String[150];
		String[] code_budget = new String[150];
		String[] mode_regl = new String[150];
		
		vir_treso = ParamUrssaf.ccc.getSelectDistinct(ParamUrssaf.connBDD, "modele_02", "vir_treso");
		occasionnel = ParamUrssaf.ccc.getSelectDistinct(ParamUrssaf.connBDD, "modele_02", "occasionnel");
		reference = ParamUrssaf.ccc.getSelectDistinct(ParamUrssaf.connBDD, "modele_02", "reference");
		transaction = ParamUrssaf.ccc.getSelectDistinct(ParamUrssaf.connBDD, "modele_02", "transaction");
		devise = ParamUrssaf.ccc.getSelectDistinct(ParamUrssaf.connBDD, "modele_02", "devise");
		mode_maj = ParamUrssaf.ccc.getSelectDistinct(ParamUrssaf.connBDD, "modele_02", "mode_maj");
		code_budget = ParamUrssaf.ccc.getSelectDistinct(ParamUrssaf.connBDD, "modele_02", "code_budget");
		mode_regl = ParamUrssaf.ccc.getSelectDistinct(ParamUrssaf.connBDD, "modele_02", "mode_regl");
		
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
        out.println("<title>Global XRT</title>");
        out.println("</head>");
        out.println("<body background =\"mur_du_son_2.jpg\" text=\"yellow\">");
        out.println("<H2>Modification des parametres GLOBAUX du fichier XRT</H2>");

        out.println("<form action=\"MajXRTGlobal\" method=\"post\">");
        out.println("<table border=1>");
        out.println("<tr>");
        out.println("<th>Champs</th>");
        out.println("<th>Défaut</th>");
        out.println("<th>Valeur</th>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>Virement Treso</td>");
        out.println("<td align=\"center\">N</td>");
		out.println("<td><input type=\"text\" maxlength=\"1\"  name=\"vir_treso\" value=\"" +vir_treso[0]+ "\"></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Occasionnel</td>");
        out.println("<td align=\"center\">0</td>");
		out.println("<td><input type=\"text\" maxlength=\"1\"  name=\"occasionnel\" value=\"" +occasionnel[0]+ "\"></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Reference</td>");
        out.println("<td align=\"center\">VIRT</td>");
		out.println("<td><input type=\"text\" maxlength=\"4\"  name=\"reference\" value=\"" +reference[0]+ "\"></td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>Transaction</td>");
        out.println("<td align=\"center\">VDSC</td>");
		out.println("<td><input type=\"text\" maxlength=\"4\"  name=\"transaction\" value=\"" +transaction[0]+ "\"></td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>Devise</td>");
        out.println("<td align=\"center\">EUR</td>");
		out.println("<td><input type=\"text\" maxlength=\"3\"  name=\"devise\" value=\"" +devise[0]+ "\"></td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>Mod maj</td>");
        out.println("<td align=\"center\">0</td>");
		out.println("<td><input type=\"text\" maxlength=\"1\"  name=\"mode_maj\" value=\"" +mode_maj[0]+ "\"></td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>Code budget</td>");
        out.println("<td align=\"center\">CSOC</td>");
		out.println("<td><input type=\"text\" maxlength=\"4\"  name=\"code_budget\" value=\"" +code_budget[0]+ "\"></td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>Mode règlement</td>");
        out.println("<td align=\"center\">010</td>");
		out.println("<td><input type=\"text\" maxlength=\"3\"  name=\"mode_regl\" value=\"" +mode_regl[0]+ "\"></td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td colspan=3 align=\"center\"><input type=\"submit\" name=\"action\" value=\"MàJ\"></td>");
    	out.println("</tr>");
    	
//        out.println("<tr>");
//       out.println("<td colspan=3 align=\"center\"><input type=\"submit\" name=\"action\" value=\"Retour\"></td>");
//    	out.println("</tr>");
    	
        out.println("</table>");
        out.println("</form>");
        
        out.println("</body>");
        out.println("</html>"); 
        
       
	}

}

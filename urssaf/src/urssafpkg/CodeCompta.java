package urssafpkg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CodeCompta
 */
@WebServlet("/CodeCompta")
public class CodeCompta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CodeCompta() {
        super();
		System.out.println("methode CodeCompta()");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet methode CodeCompta");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost methode CodeCompta");
		
		String[][] liste = new String[150][4];
		liste = ParamUrssaf.ccc.getCodeCompta(ParamUrssaf.connBDD );
		
		
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
        out.println("<title>Codes Comptables</title>");
        out.println("</head>");
        out.println("<body background =\"mur_du_son_2.jpg\" text=\"yellow\">");
        out.println("<H2>Affectation des codes Compables aux Magasins</H2>");

        out.println("<form action=\"MajCodeCompta\" method=\"post\">");
        out.println("<table border=1>");

        out.println("<tr><th>Magasin</th><th>Payeur</th><th>Compte débiter</th><th>Donneur Ordre</th></tr>");

	   	System.out.println(liste[0][0]+"--"+liste[0][1]+"--"+liste[0][2]+"--"+liste[0][3]);

        for (int ii=0 ; ii < liste.length && liste[ii][0] != null ; ii++) {
//		   	System.out.println(liste[ii][0]+"--"+liste[ii][1]+"--"+liste[ii][2]+"--"+liste[ii][3]);
            out.println("<tr>");
            out.println("<form action=\"MajCodeCompta\" method=\"post\">");
    		out.println("<td><input type=\"text\" size=\"30\" readonly name=\"magasin\" value=\"" +liste[ii][0]+ "\"></td>");
    		out.println("<td><input type=\"text\" maxlength=\"8\" name=\"payeur\" value=\"" +liste[ii][1]+ "\"></td>");
    		out.println("<td><input type=\"text\" maxlength=\"10\" name=\"compte_debiter\" value=\"" +liste[ii][2]+ "\"></td>");
    		out.println("<td><input type=\"text\" maxlength=\"8\" name=\"donneur_ordre\" value=\"" +liste[ii][3]+ "\"></td>");

            out.println("<td><input type=\"submit\" name=\"action\" value=\"OK\"></td>");

            out.println("</form>");
            out.println("</tr>");

        }
        
        out.println("</table>");
        out.println("</form>");
        
        out.println("</body>");
        out.println("</html>");
	}

}

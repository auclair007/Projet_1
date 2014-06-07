package urssafpkg;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MajCodeCompta
 */
@WebServlet("/MajCodeCompta")
public class MajCodeCompta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MajCodeCompta() {
        super();
        System.out.println("methode MajCodeCompta()");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet MajCodeCompta");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost MajCodeCompta");
		String magasin = request.getParameter("magasin");
		String payeur = request.getParameter("payeur");
		String compte_debiter = request.getParameter("compte_debiter");
		String donneur_ordre = request.getParameter("donneur_ordre");

		System.out.println(magasin);
		System.out.println(payeur);
		System.out.println(compte_debiter);
		System.out.println(donneur_ordre);
		
		ParamUrssaf.ccc.maj_code_compta(ParamUrssaf.connBDD, payeur, compte_debiter, donneur_ordre, magasin);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("/CodeCompta");
		dispatch.forward (request, response);
	}

}

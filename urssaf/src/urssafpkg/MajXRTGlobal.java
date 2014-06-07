package urssafpkg;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MajXRTGlobal
 */
@WebServlet("/MajXRTGlobal")
public class MajXRTGlobal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MajXRTGlobal() {
        super();
        System.out.println("methode MajXrtGlobal()");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet methode MajXrtGlobal");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost methode MajXrtGlobal()");
        String action = request.getParameter("action");
        System.out.println(action);
        String vir_treso = request.getParameter("vir_treso");
        String occasionnel = request.getParameter("occasionnel");
        String reference = request.getParameter("reference");
        String transaction = request.getParameter("transaction");
        String devise = request.getParameter("devise");
        String mode_maj = request.getParameter("mode_maj");
        String code_budget = request.getParameter("code_budget");
        String mode_regl = request.getParameter("mode_regl");
        
        if (action.equals ("M‡J")){
        	ParamUrssaf.ccc.maj_XRTGlobal(ParamUrssaf.connBDD, vir_treso, occasionnel, reference, transaction, devise, mode_maj, code_budget, mode_regl);
        	RequestDispatcher dispatch = request.getRequestDispatcher("/XrtGlobal");
        	dispatch.forward (request, response);
        } else {
    		RequestDispatcher dispatch = request.getRequestDispatcher("/ParamUrssaf");
    		dispatch.forward (request, response);
        }
	}
}

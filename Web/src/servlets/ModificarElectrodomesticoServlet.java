package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.ElectrodomesticoLogic;
import entidades.Electrodomestico;

/**
 * Servlet implementation class ModificarElectrodomesticoServlet
 */
@WebServlet("/ModificarElectrodomesticoServlet")
public class ModificarElectrodomesticoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarElectrodomesticoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idElec = Integer.parseInt(request.getParameter("idElec"));
		
		Electrodomestico elec = new ElectrodomesticoLogic().getOne(idElec);
		
		request.setAttribute("electrodomestico", elec);
		RequestDispatcher rd = request.getRequestDispatcher("/modificarElectrodomesticoJSP.jsp");
		rd.forward(request, response);
	}

}

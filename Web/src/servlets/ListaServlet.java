package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Electrodomestico;
import negocio.ElectrodomesticoLogic;

/**
 * Servlet implementation class ListaServlet
 */
@WebServlet("/ListaServlet")
public class ListaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaServlet() {
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
		boolean error=false;
		String mensajeError=" ";
		String letraConsumo =  request.getParameter("consumos");
		double precioDesde=0;
		double precioHasta=0;
		try {
			precioDesde = Double.parseDouble(request.getParameter("precioDesde"));
			precioHasta = Double.parseDouble(request.getParameter("precioHasta"));
			if (precioDesde<0 || precioHasta< precioDesde) {
				error = true;
				mensajeError = "El precio hasta no puede ser mas chico que el precio desde";
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			error = true;
			mensajeError = "El formato no es el esperado";
		}
		
		
		if (!error) {
			ElectrodomesticoLogic controladorElec = new ElectrodomesticoLogic();
			ArrayList<Electrodomestico> elecs = controladorElec.getAll(
					letraConsumo, precioDesde, precioHasta);
			request.setAttribute("elecs", elecs);
			RequestDispatcher rd = request
					.getRequestDispatcher("/ListaJSP.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request
					.getRequestDispatcher("/index.jsp");
			request.setAttribute("msj", mensajeError);
			rd.forward(request, response);
		}
	}

}

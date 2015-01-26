package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.ColorLogic;
import negocio.ConsumoLogic;
import negocio.ElectrodomesticoLogic;
import entidades.Color;
import entidades.Consumo;
import entidades.Electrodomestico;
import entidades.Lavarropas;
import entidades.Televisor;

/**
 * Servlet implementation class ActualizarElectrodomesticoServlet
 */
@WebServlet("/ActualizarElectrodomesticoServlet")
public class ActualizarElectrodomesticoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarElectrodomesticoServlet() {
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
		Electrodomestico elec = null;
		
		try {
			int idElec = Integer.parseInt(request.getParameter("idElec"));
			double precioBase= Double.parseDouble(request.getParameter("precioBase"));
			float peso = Float.parseFloat(request.getParameter("peso"));
			Color color = new ColorLogic().getOne(request.getParameter("color"));
			Consumo consumo = new ConsumoLogic().getOne(request.getParameter("consumo").charAt(0));
			
			if (request.getParameter("tipoElec").equalsIgnoreCase("Lavarropas")) {
				float carga =Float.parseFloat(request.getParameter("carga"));
				elec = new Lavarropas(precioBase, peso, color, consumo, carga);
			}
			else if(request.getParameter("tipoElec").equalsIgnoreCase("Televisor")) {
				boolean tdt;
				String strtdt = request.getParameter("sintonizador");
				if (strtdt != null) {
					tdt=true;
				}
				else {
					tdt = false;
				}
				float resolucion = Float.parseFloat(request.getParameter("resolucion"));
				elec = new Televisor(precioBase, peso, color, consumo, resolucion, tdt);
			}
			
			new ElectrodomesticoLogic().update(idElec, elec);
			request.setAttribute("msj", "Electrodomestico modificado con exito");
			RequestDispatcher rd = request
					.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msj", "No se pudo realizar la modificacion");
			RequestDispatcher rd = request
					.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
	}

}

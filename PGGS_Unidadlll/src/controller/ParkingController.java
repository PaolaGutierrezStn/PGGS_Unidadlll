package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ParkingDAOImpl;
import model.Parking;

/**
 * Servlet implementation class ParkingController
 */
@WebServlet("/ParkingController")
public class ParkingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Parking parking;
	private List<Parking> parkings;
	private ParkingDAOImpl parkingDAO; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParkingController() {
        super();
        parking = new Parking();
        parkings = new ArrayList<Parking>();
        parkingDAO = new ParkingDAOImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if (request.getParameter("btn_save")!= null) {
			
			parking.setType(request.getParameter("type"));
			parking.setNum_cars(Integer.parseInt(request.getParameter("num_cars")));
			parking.setCompany(request.getParameter("company"));
				
				
			if(parking.getId()==0L) {
				parkingDAO.createParking(parking);
				}else {
					parkingDAO.updateParking(parking);
			}
			
			parkings = parkingDAO.readAllParkings();
			request.setAttribute("parkings",parkings);
			request.getRequestDispatcher("parking_list.jsp").forward(request, response);
			
		}else if (request.getParameter("btn_new")!=null) {
			parking = new Parking();
			request.getRequestDispatcher("parking_form.jsp").forward(request, response);
			
		
		}else if(request.getParameter("btn_edit")!=null) {	
			try {
				Long id = Long.parseLong(request.getParameter("id"));
				parking = parkingDAO.readParking(id);
				
			}catch (Exception e) {
				
				parking = new Parking();
			}
			request.setAttribute("parking", parking);
			
			request.getRequestDispatcher("parking_form.jsp").forward(request, response);
			
			
			
		}else if(request.getParameter("btn_delete")!=null) {
		
			
			try {
			Long id = Long.parseLong(request.getParameter("id"));
			parkingDAO.deleteParking(id);
			parkings = parkingDAO.readAllParkings();
			
			}catch(Exception e) {
				e.printStackTrace();
				
				
			}
			request.setAttribute("parkings", parkings);
			request.getRequestDispatcher("parking_list.jsp").forward(request, response);
		}else {
			parkings = parkingDAO.readAllParkings();
			request.setAttribute("parkings", parkings);
			request.getRequestDispatcher("parking_list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
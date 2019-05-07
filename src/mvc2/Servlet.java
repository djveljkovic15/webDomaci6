package mvc2;

import beans.Asistent;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


public class Servlet extends javax.servlet.http.HttpServlet {

	private ArrayList<Asistent> asistents;
	public Servlet() {
		this.asistents = new ArrayList<>();

	}


	public void addAsistent(Asistent asistent, Double ocena){
		if(!asistents.contains(asistent)){
			asistents.add(asistent);
			asistent.povecajBrojOcena();
			asistent.povecajUkupnuOcenu(ocena);
		}else{
			if(asistent.getIme().equalsIgnoreCase("vuk")){
				return;
			}
			Asistent ass = asistents.get(asistents.indexOf(asistent));

			ass.povecajBrojOcena();
			ass.povecajUkupnuOcenu(ocena);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispecer = getServletContext()
				.getRequestDispatcher("/results.jsp");
		dispecer.forward(request, response);

	}
	protected synchronized void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

		try {
			String name = request.getParameter("name");
			String ocena = request.getParameter("ocena");

			if(name != null && ocena != null) {
				Asistent ass = new Asistent(name);
				addAsistent(ass, Double.parseDouble(ocena));

				request.setAttribute("data", asistents);


				doGet(request, response);
			}
		}catch (NumberFormatException e){
			request.setAttribute("data", asistents);
			doGet(request, response);
		}

//		System.out.println(request.getAttribute("data").getClass());
//		System.out.println(request.getAttribute("data").getClass());
//		for(Asistent i : asistents){
//			System.out.println(i.getIme());
//		}

	}

	public ArrayList<Asistent> getAsistents() {
		return asistents;
	}

	public void setAsistents(ArrayList<Asistent> asistents) {
		this.asistents = asistents;
	}
}

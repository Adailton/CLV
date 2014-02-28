package teste.json.helloworld;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class Server
 */
@WebServlet("/Server")
public class Server extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Server() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Municipio m = new Municipio("Guarabira", "1");
		Municipio m2 = new Municipio("Rio Tinto", "2");
		
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put(m.getId(), m.getNome());
		hm.put(m2.getId(), m2.getNome());
	
		// Cada chave do HashMap vira uma Chave do JSON
		JSONObject json = JSONObject.fromObject(hm);
		
		response.setContentType("application/json");

		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		
	
	}

}

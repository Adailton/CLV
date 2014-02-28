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
import teste.json.helloworld.Municipio;
import teste.json.helloworld.Secao;

/**
 * Servlet implementation class Server2
 */
@WebServlet("/Server2")
public class Server2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Server2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Secao s = new Secao("Rua blá, blá, blá", "1");
		Secao s2 = new Secao("Rua bleh, bleh, bleh", "2");
		
		HashMap<String, String> sm = new HashMap<String, String>();
		sm.put(s.getId(), s.getEndereco());
		sm.put(s2.getId(), s2.getEndereco());
		// Cada chave do HashMap vira uma Chave do JSON
		JSONObject json = JSONObject.fromObject(sm);

		response.setContentType("application/json");

		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		
	}


}

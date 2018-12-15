/**
 * 
 */
package br.com.impacta;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@SuppressWarnings("serial")
public class Servlet1 extends HttpServlet {

	private String message;

	public void init() throws ServletException {
		message = "Hello World";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		
		String nome = request.getParameter("nome");
		System.out.println("Nome: " + nome);
		
		PrintWriter out = response.getWriter();
		out.println("{   \"nome\" : \"  "+ nome + " \"   }");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		
		System.out.println("POST");
		
		Gson gson = new Gson();
		 
        try {
            StringBuilder sb = new StringBuilder();
            String s;
            while ((s = request.getReader().readLine()) != null) {
                sb.append(s);
            }
 
            Usuario usuario = (Usuario) gson.fromJson(sb.toString(), Usuario.class);
 
            Status status = new Status();
            if (usuario.getNome().equalsIgnoreCase("willians")) {
                status.setSuccess(true);
                status.setDescription("successo");
            } else {
                status.setSuccess(false);
                status.setDescription("não é willians");
            }
            response.getOutputStream().print(gson.toJson(status));
            response.getOutputStream().flush();
        } catch (Exception ex) {
            ex.printStackTrace();
            Status status = new Status();
            status.setSuccess(false);
            status.setDescription(ex.getMessage());
            response.getOutputStream().print(gson.toJson(status));
            response.getOutputStream().flush();
        }
		
	}

	public void destroy() {
		
	}

}

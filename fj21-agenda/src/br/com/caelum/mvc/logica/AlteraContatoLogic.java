package br.com.caelum.mvc.logica;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class AlteraContatoLogic implements Logica {

public void executa(HttpServletRequest request,
		HttpServletResponse response)
throws Exception{
	
	Contato contato = new Contato();
	
	String id = request.getParameter("id");
	contato.setId(Long.parseLong(id));
	
	contato.setNome(request.getParameter("nome"));
	
	contato.setEndereco(request.getParameter("endereco"));
	
	contato.setEmail(request.getParameter("email"));
	
	//Converte a data de String para Calendar
	String dataEmTexto = request.getParameter("dataNescimento");
	
	Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
	
	Calendar dataNascimento = Calendar.getInstance();
	
	dataNascimento.setTime(date);
	
	contato.setDataNascimento(dataNascimento);
	
	ContatoDao dao = new ContatoDao();
	dao.altera(contato);
	
	RequestDispatcher rd = request.getRequestDispatcher("/lista-contato-elegante.jsp");
	 
	rd.forward(request, response);
	
	System.out.println("Alterando contato..." + contato.getNome());

}

	
}

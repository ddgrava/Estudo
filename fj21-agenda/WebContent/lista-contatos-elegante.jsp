<html>
	<body>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:import url="cabecalho.jsp"/>

<!-- cria o DAO -->

<jsp:useBean id="dao" class="br.com.caelum.jdbc.dao.ContatoDao"/>

<table>
	<!-- percorre contatos montando as linhas da tabela -->
	<c:forEach var="contato" items="${dao.lista}">
	<tr>
		<td>${contato.nome}</td>
		<td>
			<c:if test="${not empty contato.email}">
				<a href="mailto:${contato.email}">${contato.email}</a> 
			</c:if>
			<c:if test="${empty contato.email}">
				Email n�o Informado
			</c:if>
		</td>
		<td>${contato.endereco}</td>
		<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" /></td>
	</tr>
	</c:forEach>	
</table>
<c:import url="rodape.jsp"/>
</body>
</hmtl>
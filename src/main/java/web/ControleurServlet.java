package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CreditMetierImpl;
import metier.ICrediMetier;


@WebServlet(name = "cs",urlPatterns = {"*.do","*.asp"})
public class ControleurServlet extends HttpServlet {
	private ICrediMetier metier;
	@Override
	public void init() throws ServletException {
	metier=new CreditMetierImpl();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("creditModel", new CreditModel());
		req.getRequestDispatcher("VueCredit.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	double motant =Double.parseDouble(req.getParameter("montant"));
	double taux =Double.parseDouble(req.getParameter("taux"));
	int duree =Integer.parseInt(req.getParameter("duree"));
	CreditModel model =new CreditModel();
	model.setMontant(motant);
	model.setDuree(duree);
	model.setTaux(taux);
	
	double  res =metier.calculerMensualiteCredit(motant, taux, duree);
	//stocker le model dans l'objet request
	req.setAttribute("creditModel", model);
	model.setMensualite(res);
	req.getRequestDispatcher("VueCredit.jsp").forward(req, resp);
	
	}
}

package conroler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import actions.EtablissementAction;
import actions.Type_Etablissement_Action;
import entities.Etablissement;
import entities.ParametreEtbalissement;
import entities.ParametresUtilisateur;
import entities.Type_Etablissement;
import entities.Utilisateur;
import manager.SessionManager;
import service.C;
import utils.Utils;

/**
 * Servlet implementation class GestionEtablissement
 */
@WebServlet("/gestionEtablissement")
public class GestionEtablissement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Utilisateur user = (Utilisateur) SessionManager.getSessionValue(C.Utilisateur.sessionUserConnect, request);
		String action = request.getParameter("action");
		String url = "WEB-INF/GestionEtablissement.jsp";
		if (user != null) {
			if (action.equals(C.Etablissement.urlDisplayEtab)) {
				if (user.getEtablissement().getTypeEtablissement().getId() == 1) {
					ArrayList<Etablissement> etabList = EtablissementAction.getAll();
					request.setAttribute(C.Etablissement.etabList, etabList);

				} else {
					Etablissement unEtab=EtablissementAction.getById(user.getEtablissement().getId());
					request.setAttribute(C.Etablissement.unEtablissement, unEtab);
				}

			}else if(action.equals(C.Etablissement.urlAddEtab)){
				ArrayList<Type_Etablissement>typeList=Type_Etablissement_Action.showAll();
				request.setAttribute(C.Type_Etablissement.typeEtabList, typeList);
				url="WEB-INF/AjoutEtablissement.jsp";
			}
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utilisateur user = (Utilisateur) SessionManager.getSessionValue(C.Utilisateur.sessionUserConnect, request);
		String messageRecu=Utils.recieveJsonRequest(request);
		String messageEnvoye="";
		System.out.println(messageRecu);
		Gson gson= new Gson();
		if(user!= null){
			int etabId=user.getEtablissement().getTypeEtablissement().getId();
			int roleId=user.getRole().getId();
			if(etabId==1 && roleId==1){
				if(!messageRecu.equals("")){
					ParametreEtbalissement param= gson.fromJson(messageRecu, ParametreEtbalissement.class);
					if(param!= null){
						if(param.getUrl().equals(C.Etablissement.urlAddEtab)){
							messageEnvoye=""+EtablissementAction.insert(param.getEtab());
						}else if(param.getUrl().equals(C.Etablissement.urlUpdateEtab)){
//							EtablissementAction.update(param.getEtab());
						}else if(param.getUrl().equals(C.Etablissement.urlDeleteEtab)){
							boolean switcher = param.getParam().getValeurParam().equals("1");
							int idEtab = param.getEtab().getId();
//							EtablissementAction.toggleVisibility(switcher, idEtab);
						}
					}
					
				}
			}
		}
		
	}

}

package fr.seedle.pandora.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.seedle.pandora.dao.MembreDaoImpl;
import fr.seedle.pandora.dto.MembreDto;
import fr.seedle.pandora.interfaces.dao.MembreDao;
import fr.seedle.pandora.singleton.DataSingleton;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {

	private String login = null;

	private String password;

	private MembreDto membreCourant;

	private String message = "Veuillez vous identifier";

	@PostConstruct
	public void init() {
		System.out.println("init de LoginBean");
		DataSingleton.getInstance();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MembreDto getMembreCourant() {
		return membreCourant;
	}

	public void setMembreCourant(MembreDto membreCourant) {
		this.membreCourant = membreCourant;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String identificationMembre() {
		if (login == null || login.length() == 0) {
			this.message = "Veuillez saisir un login";
			return "login";
		}

		// this.membreCourant = MembreSingleton.getInstance().getMembreByLogin(login);

		MembreDao membreDao = new MembreDaoImpl();
		List<MembreDto> listMembres = membreDao.getAll();
		for (MembreDto membre : listMembres) {
			if (membre != null && membre.getLogin().equals(this.login)) {
				this.membreCourant = membre;
				break;
			}
		}

		if (this.membreCourant != null) {
			return "mainpage";
		}

		return "loginwrongid";
	}
}
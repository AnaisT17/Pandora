package fr.seedle.pandora.singleton;

import java.util.ArrayList;
import java.util.List;

import fr.seedle.pandora.dao.MembreDaoImpl;
import fr.seedle.pandora.dto.MembreDto;
import fr.seedle.pandora.interfaces.dao.MembreDao;

public class MembreSingleton {

	private static MembreSingleton membreSingleton;

	private List<MembreDto> listMembres = new ArrayList<>();

	public static MembreSingleton getInstance() {
		if (membreSingleton == null) {
			membreSingleton = new MembreSingleton();
		}
		return membreSingleton;
	}

	public MembreSingleton() {

		final MembreDao membreDao = new MembreDaoImpl();

		final MembreDto m1 = membreDao.getInstance();
		m1.setNom("FADEL");
		m1.setPrenom("Soufiane");
		m1.setLogin("sf");
		m1.setPseudo("MagicMan");
		m1.setEmail("sf@gmail.com");
		// m1.setRole(RoleSingleton.getInstance().getRoleByNom("Magicien"));
		listMembres.add(m1);

		final MembreDto m2 = membreDao.getInstance();
		m2.setNom("TCHICAYA");
		m2.setPrenom("Anais");
		m2.setLogin("at");
		m1.setPseudo("La Fée");
		m2.setEmail("ac@gmail.com");
		// m2.setRole(RoleSingleton.getInstance().getRoleByNom("Fée"));
		listMembres.add(m2);
	}

//	public MembreDto getMembreByLogin(String login) {
//		for (MembreDto membre : listMembres) {
//			if (membre.getLogin().equals(login)) {
//				return membre;
//			}
//		}
//		return null;
//	}
//
//	public List<MembreDto> getListMembres() {
//		return listMembres;
//	}
//
//	public void setListMembres(List<MembreDto> listMembres) {
//		this.listMembres = listMembres;
//	}
}
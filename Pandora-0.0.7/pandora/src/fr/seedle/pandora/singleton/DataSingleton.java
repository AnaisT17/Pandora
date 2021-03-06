package fr.seedle.pandora.singleton;

import java.sql.SQLException;
import java.util.Date;

import fr.seedle.pandora.dao.MembreDaoImpl;
import fr.seedle.pandora.dao.RoleDaoImpl;
import fr.seedle.pandora.data.Datas;
import fr.seedle.pandora.dto.MembreDto;
import fr.seedle.pandora.dto.RoleDto;
import fr.seedle.pandora.interfaces.dao.MembreDao;
import fr.seedle.pandora.interfaces.dao.RoleDao;
import fr.seedle.pandora.interfaces.dto.Role;

public class DataSingleton {

	private static DataSingleton dataSingleton;

	private Datas datas;

	public static DataSingleton getInstance() {
		if (dataSingleton == null) {
			try {
				dataSingleton = new DataSingleton();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dataSingleton;
	}

	public DataSingleton() throws SQLException {
		datas = new Datas();
		datas.createSequence();
		datas.createTableMembre();
		datas.createTableRole();
		datas.createTableRoleMembre();

		generateFalseData();
	}

	public Datas getDatas() {
		return datas;
	}

	public void setDatas(Datas datas) {
		this.datas = datas;
	}

	public void generateFalseData() {
		final RoleDao roleDao = new RoleDaoImpl();
		final Role roleMagicien = roleDao.getInstance();
		roleMagicien.setNom("Magicien");

		final Role roleFee = roleDao.getInstance();
		roleFee.setNom("Fée");

		final Role roleOrk = roleDao.getInstance();
		roleOrk.setNom("Ork");

		try {
			roleDao.insert((RoleDto) roleMagicien);
			roleDao.insert((RoleDto) roleFee);
			roleDao.insert((RoleDto) roleOrk);

		} catch (Throwable e1) {
			e1.printStackTrace();
		}

		final MembreDao membreDao = new MembreDaoImpl();
		final MembreDto membre = membreDao.getInstance();

		membre.setAvatar("Avatar");
		membre.setPseudo("Anais");
		membre.setDateNaissance(new Date());
		membre.setEmail("toto@titi.com");
		membre.setLeader(false);
		membre.setLogin("at");
		membre.setMobile("01 02 03 04 05");
		membre.setNom("TCHICAYA");
		membre.setPrenom("Anais");

		membre.setRole((RoleDto) roleFee);
		System.out.println("Role du membre " + membre.getNom() + " " + membre.getRole());

		final MembreDto membre2 = membreDao.getInstance();

		membre2.setAvatar("Avatar");
		membre2.setPseudo("Bruno");
		membre2.setDateNaissance(new Date());
		membre2.setEmail("tata@titi.com");
		membre2.setLeader(false);
		membre2.setLogin("bm");
		membre2.setMobile("01 02 03 04 05");
		membre2.setNom("Maurin");
		membre2.setPrenom("Bruno");

		membre2.setRole((RoleDto) roleOrk);
		System.out.println("Role du membre " + membre2.getNom() + " " + membre2.getRole());

		final MembreDto membre3 = membreDao.getInstance();

		membre3.setAvatar("Avatar");
		membre3.setPseudo("Remi");
		membre3.setDateNaissance(new Date());
		membre3.setEmail("tata@titi.com");
		membre3.setLeader(false);
		membre3.setLogin("rl");
		membre3.setMobile("01 02 03 04 05");
		membre3.setNom("Leger");
		membre3.setPrenom("Remi");

		membre3.setRole((RoleDto) roleMagicien);
		System.out.println("Role du membre " + membre3.getNom() + " " + membre3.getRole());

		final MembreDto membre4 = membreDao.getInstance();

		membre4.setAvatar("Avatar");
		membre4.setPseudo("tata");
		membre4.setDateNaissance(new Date());
		membre4.setEmail("tata@titi.com");
		membre4.setLeader(false);
		membre4.setLogin("pg");
		membre4.setMobile("01 02 03 04 05");
		membre4.setNom("Gomez");
		membre4.setPrenom("Paola");

		membre4.setRole((RoleDto) roleFee);
		System.out.println("Role du membre " + membre4.getNom() + " " + membre4.getRole());

		try {
			membreDao.insert(membre);
			membreDao.insert(membre2);
			membreDao.insert(membre3);
			membreDao.insert(membre4);

		} catch (Throwable e1) {
			e1.printStackTrace();
		}
	}
}
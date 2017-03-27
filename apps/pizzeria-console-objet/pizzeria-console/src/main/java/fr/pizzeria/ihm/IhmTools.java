package fr.pizzeria.ihm;

import java.util.ResourceBundle;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.dao.PizzaDaoImplFichier;
import fr.pizzeria.model.Pizza;

public class IhmTools {
	

	private final static Scanner SC = new Scanner(System.in);;
	private IPizzaDao<Pizza, String> dao;
	//private final static IPizzaDao<Pizza, String> DAO = new PizzaDaoImplFichier();
	
	public IhmTools(){
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String daoImpl = bundle.getString("dao.impl");
		
		try {
			this.dao = (IPizzaDao<Pizza, String>) Class.forName(daoImpl).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public IPizzaDao<Pizza, String> getDao() {
		return this.dao;
	}

	public Scanner getSc() {
		return this.SC;
	}

	public void close() {
		this.SC.close();
	}

}

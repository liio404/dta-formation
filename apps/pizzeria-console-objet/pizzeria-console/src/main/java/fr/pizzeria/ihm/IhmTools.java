package fr.pizzeria.ihm;

import java.util.ResourceBundle;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoImpl;
<<<<<<< HEAD
=======
import fr.pizzeria.dao.PizzaDaoImplFichier;
>>>>>>> dvp1
import fr.pizzeria.model.Pizza;

public class IhmTools {
	
<<<<<<< HEAD
	private final static Scanner SC = new Scanner(System.in);
	//private final static IPizzaDao<Pizza, String> DAO = new PizzaDaoImplFichier();
	private IPizzaDao<Pizza, String> daoImpl;
	
	public IhmTools(){
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String impl = bundle.getString("dao.impl");
		
		try {
			this.daoImpl = (IPizzaDao<Pizza, String>) Class.forName(impl).newInstance();
			
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// implémentation mémoire par défaut au cas ou
			this.daoImpl = new PizzaDaoImpl();
			//throw new StockageException("Impossible d'avoir les données de l'application",e);
		}
	}

	public Scanner getSc() {
		return SC;
	}
	
=======
	private final static Scanner SC = new Scanner(System.in);;
	private IPizzaDao<Pizza, String> dao;
	//private final static IPizzaDao<Pizza, String> DAO = new PizzaDaoImplFichier();
	
	public IhmTools(){
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String daoImpl = bundle.getString("dao.impl");
		
		try {
			dao = (IPizzaDao<Pizza, String>) Class.forName(daoImpl).newInstance();
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

>>>>>>> dvp1
	public void close() {
		this.SC.close();
	}

	public IPizzaDao<Pizza, String> getDao() {
		return this.daoImpl;
	}
	
}

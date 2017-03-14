package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImpl;

public class IhmTools {
	
	private Scanner sc;
	private PizzaDaoImpl dao;
	
	public IhmTools(){
		sc = new Scanner(System.in);
		dao = new PizzaDaoImpl();
	}

	public Scanner getSc() {
		return sc;
	}

	public PizzaDaoImpl getDao() {
		return dao;
	}

	public void close() {
		sc.close();
	}
	
}

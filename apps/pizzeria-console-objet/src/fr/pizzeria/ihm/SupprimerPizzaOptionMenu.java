package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImpl;

public class SupprimerPizzaOptionMenu extends OptionMenu {
	public static final String LIBELLE = "Supprimer une pizza";
	
	public SupprimerPizzaOptionMenu(){
		super(LIBELLE);
	}

	@Override
	public boolean excetute() {
		Scanner sc = new Scanner(System.in);
		PizzaDaoImpl pizzaDao = new PizzaDaoImpl();
		
		System.out.println("Veuillez saisir le code de la pizza à supprimer");
		pizzaDao.deletePizza(sc.nextLine());
		
		return super.excetute();
	}
	
	
}

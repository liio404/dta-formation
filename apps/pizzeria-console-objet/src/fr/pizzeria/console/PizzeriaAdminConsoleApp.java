package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		// pizzas
		Pizza pepe = new Pizza(0, "PEP", "Peperoni", 12.50D);
		Pizza mar = new Pizza(1, "MAR", "Margherita", 14.00D);
		Pizza frei = new Pizza(2, "REI", "La Reine", 11.50D);
		Pizza fro = new Pizza(3, "FRO", "La 4 fromage", 12.00D);
		Pizza can = new Pizza(4, "CAN", "La cannibale", 12.50D);
		Pizza sav = new Pizza(5, "SAV", "La savoyarde", 13.00D);
		Pizza ori = new Pizza(6, "ORI", "L'orientale", 13.50D);
		Pizza ind = new Pizza(7, "IND", "L'indienne", 14.00D);
		
		Pizza[] pizzas = { pepe, mar, frei, fro, can, sav, ori, ind};
		
		int action = 0;
		Scanner sc = new Scanner(System.in);
		
		do {
			Menu();
			action = sc.nextInt();
			switch (action) {
			case 1:
				ListerPizza(pizzas);
				break;
				
			case 2:
				//AjouterPizza(sc, tab);
				break;
				
			case 3:
				//ModifierPizza();
				break;
				
			case 4:
				//SupprimerPizza();
				break;
				
			case 99:
				System.out.println("au revoir :)");
				System.exit(0);
				break;
			default:
				System.out.println("Ce choix n'est pas disponible merci d'en choisir un autre :)");
				break;
			}
		} while (action != 100);
		
	}
	
	public static void Menu(){
		System.out.println("****** Pizzeria Administration *****");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");
	}
	
	private static void ListerPizza(Pizza[] pizzas) {
		for (Pizza pizza : pizzas) {
			System.out.println(pizza.toString());
		}
	}

}

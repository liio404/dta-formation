package fr.pizzeria.console;

import java.util.Arrays;
import java.util.Scanner;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		String tab[][] = {
				{"PEP", "Pépéroni", "12,50"},
				{"MAR", "Margherita", "14,00"},
				{"REI", "La Reine", "11,50"},
				{"FRO", "La 4 fromages", "12,00"},
				{"CAN", "La cannibale", "12,50"},
				{"SAV", "La savoyarde", "13,00"},
				{"ORI", "L'orientale", "13,50"},
				{"IND", "L'indienne", "14,00"},
		};
		int action = 0;
		Scanner sc = new Scanner(System.in);
		
		
		do {
			Menu();
			action = sc.nextInt();
			switch (action) {
			case 1:
				ListerPizza(tab);
				break;
				
			case 2:
				AjouterPizza(sc, tab);
				break;
				
			case 3:
				//ModifierPizza();
				break;
				
			case 4:
				//SupprimerPizza();
				break;
				
			case 99:
				
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
	
	private static void ListerPizza(String[][] tab) {
		for (int i = 0; i < tab.length; i++) {
			String affiche = "";
			for (int j = 0; j < tab[i].length; j++) {
				affiche += tab[i][j].toString() + " ";
			}
			System.out.println(affiche);
			
		}
	}
	
	private static void AjouterPizza(Scanner sc, String[][] tab) {
		String tmp[][] = Arrays.copyOf(tab, tab.length + 1);
		//System.arraycopy(tab, 0, tmp, 0, tab.length +1);
		
		System.out.println("Veuillez saisir le code");
		tmp[tab.length][0] = sc.nextLine();
		
		System.out.println("Veuillez saisir le nom (sans espace)");
		tmp[tab.length][1] = sc.nextLine();
		
		System.out.println("Veuillez saisir le prix");
		tmp[tab.length][2] = sc.nextLine();
		
		tab = Arrays.copyOf(tmp, tmp.length);
		
	}
}

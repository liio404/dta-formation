package fr.pizzeria.ihm;

import java.util.Scanner;

public abstract class Menu {
	private String titre;
	OptionMenu[] actions;
	
	public Menu(){
		super();
	}
	
	public Menu(String titre){
		this();
		this.titre = titre;
	}
	
	public Menu(String titre, OptionMenu[] actions){
		this(titre);
		this.actions = actions;
	}
	
	public void afficher(){
		System.out.println(titre);
		for (int i = 0; i < actions.length; i++) {
			OptionMenu action = (OptionMenu) actions[i];
			System.out.println(i + ". " + action.getLibelle());
		}
	}
	
	public void executer(){
		Scanner sc = new Scanner(System.in);
		int choix = 0;
		do {
			afficher();
			choix = sc.nextInt();
			// TODO : modifier laction quitter !
			if(choix == 99) break;
			actions[choix].excetute();
			
			
		} while (choix != actions.length +1);
	}
	
	
}

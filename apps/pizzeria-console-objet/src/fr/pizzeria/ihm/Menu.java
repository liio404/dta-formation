package fr.pizzeria.ihm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class Menu {
	private String titre;
	Map<Integer, OptionMenu> actions;
	
	public Menu(){
		super();
		this.actions = new HashMap<>();
	}
	
	public Menu(String titre){
		this();
		this.titre = titre;
	}
	
	public Menu(String titre, Map<Integer, OptionMenu> actions){
		this(titre);
		this.actions = actions;
	}
	
	public void afficher(){
		System.out.println(titre);
		actions.forEach((k,v) -> System.out.println(k + " - " + v ));
		/*
		 * for(Entry<Integer, OptionMenu> entry : actions.entrySet()){
				System.out.println(entry.getKey() + ". " + entry.getValue().getLibelle());
			}
		 */
	}
	
	public void executer(){
		Scanner sc = new Scanner(System.in);
		int choix = 0;
		do {
			this.afficher();
			choix = sc.nextInt();
			// TODO : modifier pour action quitter !
			if(choix == 99) break;
			OptionMenu option = actions.get(choix);
			option.excetute();
			
			
		} while (choix != actions.size() +1);
	}
	
	
}

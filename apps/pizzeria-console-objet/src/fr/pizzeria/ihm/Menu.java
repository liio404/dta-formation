package fr.pizzeria.ihm;

import java.util.HashMap;
import java.util.Map;

public abstract class Menu {
	private String titre;
	Map<Integer, OptionMenu> actions;
	IhmTools tools;
	
	public Menu(){
		super();
		this.actions = new HashMap<>();
	}
	
	public Menu(IhmTools tool, String titre){
		this();
		this.titre = titre;
		this.tools = tool;
	}
	
	public Menu(IhmTools tool, String titre, Map<Integer, OptionMenu> actions){
		this(tool, titre);
		this.actions = actions;
	}
	
	public void afficher(){
		System.out.println(titre);
		actions.forEach((k,v) -> System.out.println(k + " - " + v.getLibelle() ));
		/*
		 * for(Entry<Integer, OptionMenu> entry : actions.entrySet()){
				System.out.println(entry.getKey() + ". " + entry.getValue().getLibelle());
			}
		 */
	}
	
	public void executer(){
		int choix = 0;
		do {
			this.afficher();
			choix = tools.getSc().nextInt();
			// TODO : modifier pour action quitter !
			if(choix == 99) break;
			OptionMenu option = actions.get(choix);
			option.excetute(tools);
			
			
		} while (choix != actions.size() +1);
	}
	
	
}

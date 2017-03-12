package fr.pizzeria.ihm;

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
	
	void Afficher(){
		
		for (int i = 0; i < actions.length; i++) {
			OptionMenu action = (OptionMenu) actions[i];
			System.out.println(i + ". " + action.getLibelle());
		}
		
	}
}

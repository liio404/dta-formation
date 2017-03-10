package fr.pizzeria.ihm;

public abstract class OptionMenu {
	private String libelle;
	
	public OptionMenu(){
		super();
	}
	
	public OptionMenu(String libelle){
		this();
		this.libelle = libelle;
	}
	
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public boolean excetute(){
		return false;
	}

}

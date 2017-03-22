package fr.pizzeria.model;

public class Pizza {
	
	private int id;
	private String code;
	private String nom;
	private double prix;
	private CategoriePizza categorie;
	private static int nbPizza;
	
	public Pizza() {
		super();
		this.nbPizza ++;
	}
	
	public Pizza(int id, String code, String nom, double prix){
		this();
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
	}
	
	public Pizza(int id, String code, String nom, double prix, CategoriePizza categorie){
		this(id, code, nom, prix);
		this.categorie = categorie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public CategoriePizza getCategorie() {
		return categorie;
	}

	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}

	public static int getNbPizza() {
		return nbPizza;
	}

	@Override
	public String toString() {
		return this.code + " - " + this.nom + " (" + this.prix + ")" + " - " + this.categorie.getLibelle();
	}
	
}

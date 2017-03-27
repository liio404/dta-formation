package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatPizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao<Pizza, String> {
	
	List<Pizza> pizzas;

	public PizzaDaoImpl() {
		super();
		pizzas = new ArrayList<>();
		pizzas.add(0, new Pizza(0, "PEP", "Peperoni", 12.50D, CategoriePizza.VIANDE));
		pizzas.add(1, new Pizza(1, "MAR", "Margherita", 14.00D, CategoriePizza.VIANDE));
		pizzas.add(2, new Pizza(2, "REI", "La Reine", 11.50D, CategoriePizza.VIANDE));
		pizzas.add(3, new Pizza(3, "FRO", "La 4 fromage", 12.00D, CategoriePizza.SANS_VIANDE));
		pizzas.add(4, new Pizza(4, "CAN", "La cannibale", 12.50D, CategoriePizza.VIANDE));
		pizzas.add(5, new Pizza(5, "SAV", "La savoyarde", 13.00D, CategoriePizza.POISSON));
		pizzas.add(6, new Pizza(6, "ORI", "L'orientale", 13.50D, CategoriePizza.VIANDE));
		pizzas.add(7, new Pizza(7, "IND", "L'indienne", 14.00D, CategoriePizza.VIANDE));
	}

	@Override
	public List<Pizza> findAll() {
		return pizzas;
	}

	@Override
	public boolean save(Pizza obj) throws StockageException{
		if(obj.getCode().length() == 3){
			//Arrays.copyOf(pizzas, pizzas.length +1);
			pizzas.add(obj);
		}else{
			throw new SavePizzaException("Le code de la pizza ne doit pas dépacer 3 caractère");
		}
		return false;
	}

	@Override
	public boolean update(String code, Pizza obj) throws StockageException{
		if(code.length() == 3 || obj.getCode().length() == 3){
			for (int i = 0; i < pizzas.size(); i++) {
				if(pizzas.get(i).getCode().equals(code)){
					pizzas.set(i, obj);
				}
			}
		}else {
			throw new UpdatPizzaException("Le code de la pizza ne doit pas dépacer 3 caractère");
		}
		
		return false;
	}

	@Override
	public boolean delete(String code) throws StockageException {
		if(code.length() == 3){
			for (int i = 0; i < pizzas.size(); i++) {
				if(pizzas.get(i).getCode().equals(code)){
					pizzas.remove(i);
				}
			}
		}else{
			throw new DeletePizzaException("Le code de la pizza est invalide");
		}
		
		return false;
	}
	
	@Override
	public Pizza find(String code) {
		for (Pizza pizza : pizzas) {
			if (pizza.getCode().equals(code)) {
				return pizza;
			}
		}
		return null;
	}

}

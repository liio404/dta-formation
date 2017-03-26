package fr.pizzeria.dao;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatPizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplFichier implements IPizzaDao {

	@Override
	public List<Pizza> findAllPizzas() {
		try (Stream<Path> files = Files.list(Paths.get("data"))){
			return files.map(path ->{
				String[] pizzaIteration;
				try {
					pizzaIteration = Files.readAllLines(path).get(0).split(";");
					String code = path.getFileName().toFile().getName().replaceFirst(".txt", "");
					return new Pizza(code, pizzaIteration[0], Double.parseDouble(pizzaIteration[1]), CategoriePizza.valueOf(pizzaIteration[2]));
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
				return null;
			}).collect(Collectors.toList());
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("data", pizza.getCode() + ".txt"))){
			writer.write(pizza.getNom() +";"+ pizza.getPrix() +";"+ pizza.getCategorie().toString());
			
		} catch (IOException e) {
			throw new SavePizzaException(e);
		}
		return false;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatPizzaException {
		try {
			deletePizza(codePizza);
			saveNewPizza(pizza);
		} catch (StockageException e) {
			throw new UpdatPizzaException(e);
		}
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		try {
			Files.delete(Paths.get("data", codePizza + ".txt"));
		} catch (IOException e) {
			throw new DeletePizzaException(e);
		}
		
		return false;
	}

}

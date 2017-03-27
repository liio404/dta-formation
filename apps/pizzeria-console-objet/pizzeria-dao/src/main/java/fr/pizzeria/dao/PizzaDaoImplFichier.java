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

public class PizzaDaoImplFichier implements IPizzaDao<Pizza, String> {

	@Override
	public Pizza find(String code) {
		Path path = Paths.get("data", code + ".txt");
		try {
			String[] pizzaIteration = Files.readAllLines(path).get(0).split(";");
			String codeP = path.getFileName().toFile().getName().replaceFirst(".txt", "");
			return new Pizza(codeP, pizzaIteration[0], Double.parseDouble(pizzaIteration[1]), CategoriePizza.valueOf(pizzaIteration[2]));
		} catch (IOException e) {
			//throw new StockageException(e);
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Pizza> findAll() {
		try (Stream<Path> files = Files.list(Paths.get("data"))){
			return files.map(path ->{
				String[] pizzaIteration;
				try {
					pizzaIteration = Files.readAllLines(path).get(0).split(";");
					String codeP = path.getFileName().toFile().getName().replaceFirst(".txt", "");
					return new Pizza(codeP, pizzaIteration[0], Double.parseDouble(pizzaIteration[1]), CategoriePizza.valueOf(pizzaIteration[2]));
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
	public boolean save(Pizza obj) throws StockageException {
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("data", obj.getCode() + ".txt"))){
			writer.write(obj.getNom() +";"+ obj.getPrix() +";"+ obj.getCategorie().toString());
			
		} catch (IOException e) {
			throw new SavePizzaException(e);
		}
		return false;
	}

	@Override
	public boolean update(String code, Pizza obj) throws StockageException {
		try {
			delete(code);
			save(obj);
		} catch (StockageException e) {
			throw new UpdatPizzaException(e);
		}
		return false;
	}

	@Override
	public boolean delete(String code) throws StockageException {
		try {
			Files.delete(Paths.get("data", code + ".txt"));
		} catch (IOException e) {
			throw new DeletePizzaException(e);
		}
		
		return false;
	}

}

package be.vdab.repositories;

import be.vdab.entities.pizza;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class PizzaRepository {

	private static final Map<Long, pizza> PIZZAS = new ConcurrentHashMap<>();

	static {
		PIZZAS.put(1L, new pizza(1, "Prosciutto", BigDecimal.valueOf(5), true));
		PIZZAS.put(2L, new pizza(2, "Margherita", BigDecimal.valueOf(4), false));
		PIZZAS.put(3L, new pizza(3, "Calzone", BigDecimal.valueOf(4), true));
		PIZZAS.put(4L, new pizza(4, "Fungi & Olive", BigDecimal.valueOf(6), false));
	}


	public List<pizza> findAll() {
		return new ArrayList<>(PIZZAS.values());
	}

	public Optional<pizza> read(long id) {
		pizza pizza = PIZZAS.get(id);
		return pizza == null ? Optional.empty() : Optional.of(pizza);
	}

	public List<pizza> findByPriceBetween(BigDecimal van, BigDecimal tot) {
		return PIZZAS.values().stream().filter(pizza -> pizza.getPrijs().compareTo(van) >= 0 && pizza.getPrijs().compareTo(tot) <= 0).collect(Collectors.toList());
	}

	public void create(pizza pizza) {
		pizza.setId(Collections.max(PIZZAS.keySet()) + 1);
		PIZZAS.put(pizza.getId(), pizza);
	}
}
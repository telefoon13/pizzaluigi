package be.vdab.repositories;

import be.vdab.entities.pizza;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class PizzaRepository {

	private static final Map<Long, pizza> PIZZAS = new ConcurrentHashMap<>();

	static {
		PIZZAS.put(12L, new pizza(12, "Prosciutto", BigDecimal.valueOf(5), true));
		PIZZAS.put(14L, new pizza(14, "Margherita", BigDecimal.valueOf(4), false));
		PIZZAS.put(17L, new pizza(17, "Calzone", BigDecimal.valueOf(7), true));
		PIZZAS.put(24L, new pizza(24, "Fungi & Olive", BigDecimal.valueOf(5), false));
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
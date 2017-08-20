package be.vdab.entities;

import java.math.BigDecimal;

public class pizza {

	private long id;
	private String naam;
	private BigDecimal prijs;
	private boolean pikant;

	public pizza(String naam, BigDecimal prijs, boolean pikant) {
		setNaam(naam);
		setPrijs(prijs);
		setPikant(pikant);
	}

	public pizza(long id, String naam, BigDecimal prijs, boolean pikant) {
		this(naam, prijs, pikant);
		setId(id);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		if (!isNaamValid(naam)) {
			throw new IllegalArgumentException();
		} else {
			this.naam = naam;
		}
	}

	public BigDecimal getPrijs() {
		return prijs;
	}

	public void setPrijs(BigDecimal prijs) {
		if (!isPrijsValid(prijs)) {
			throw new IllegalArgumentException();
		} else {
			this.prijs = prijs;
		}
	}

	public boolean isPikant() {
		return pikant;
	}

	public void setPikant(boolean pikant) {
		this.pikant = pikant;
	}

	public static boolean isNaamValid(String naam) {
		return naam != null && !naam.isEmpty();
	}

	public static boolean isPrijsValid(BigDecimal prijs) {
		return prijs != null && prijs.compareTo(BigDecimal.ZERO) >= 0;
	}
}

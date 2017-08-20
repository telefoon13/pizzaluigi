package be.vdab.entities;


public class Adres {

	private String straat;
	private String huisnummer;
	private String postcode;
	private String gemeente;

	public Adres(String straat, String huisnummer, String postcode, String gemeente) {
		setStraat(straat);
		setHuisnummer(huisnummer);
		setPostcode(postcode);
		setGemeente(gemeente);
	}

	public String getStraat() {
		return straat;
	}

	public void setStraat(String straat) {
		this.straat = straat;
	}

	public String getHuisnummer() {
		return huisnummer;
	}

	public void setHuisnummer(String huisnummer) {
		this.huisnummer = huisnummer;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getGemeente() {
		return gemeente;
	}

	public void setGemeente(String gemeente) {
		this.gemeente = gemeente;
	}
}

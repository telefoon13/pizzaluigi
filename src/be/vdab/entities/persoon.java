package be.vdab.entities;

public class persoon {

	private String voornaam;
	private String famillienaam;
	private int kinderen;
	private boolean gehuwd;
	private Adres adres;

	public persoon(String voornaam, String famillienaam, int kinderen, boolean gehuwd, Adres adres) {
		setVoornaam(voornaam);
		setFamillienaam(famillienaam);
		setKinderen(kinderen);
		setGehuwd(gehuwd);
		setAdres(adres);
	}

	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public String getFamillienaam() {
		return famillienaam;
	}

	public void setFamillienaam(String famillienaam) {
		this.famillienaam = famillienaam;
	}

	public int getKinderen() {
		return kinderen;
	}

	public void setKinderen(int kinderen) {
		this.kinderen = kinderen;
	}

	public boolean isGehuwd() {
		return gehuwd;
	}

	public void setGehuwd(boolean gehuwd) {
		this.gehuwd = gehuwd;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	public String getNaam() {
		return getFamillienaam() + ' ' + getVoornaam();
	}
}

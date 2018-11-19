package dev.paie.ihm;

public abstract class OptionMenu {

	protected String libelle;
	
	public OptionMenu(String libelle) {
		this.libelle = libelle;
	}
	
	public String getLibelle() {
		return libelle;
	}
	
	abstract public void executer();
}

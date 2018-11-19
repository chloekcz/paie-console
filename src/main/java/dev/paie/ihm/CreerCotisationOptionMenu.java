package dev.paie.ihm;

import java.math.BigDecimal;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dev.paie.service.CotisationService;

@Controller
public class CreerCotisationOptionMenu extends OptionMenu {
	
	@Autowired
	private Scanner scanner;
	
	@Autowired
	private CotisationService cotisationService;
	
	public CreerCotisationOptionMenu(Scanner scanner) {
		super("Créer une cotisation");
		this.scanner = scanner;
	}
	
	@Override
	public void executer() {
		System.out.println("Création en cours");
		System.out.println("Veuillez saisir le code : ");
		String codeSaisie = this.scanner.next();
		
		System.out.println("Veuillez saisir le libellé : ");
		String libelleSaisie = this.scanner.next();
		
		System.out.println("Veuillez saisir le taux patronal : ");
		//BigDecimal tauxPatronalSaisie = new BigDecimal(tauxPatronalSaisie);
		BigDecimal tauxPatronalSaisie = this.scanner.nextBigDecimal();
		
		System.out.println("Veuillez saisir le net imposable :");
		Boolean imposableSaisie = this.scanner.nextBoolean();
		
		System.out.println("Veuillez saisir le taux salarial : ");
		BigDecimal tauxSalarialSaisie = this.scanner.nextBigDecimal();
		

		System.out.println("Vous avez saisie : " + codeSaisie + ", " + libelleSaisie
				+ ", " + imposableSaisie + ", " + tauxSalarialSaisie + ", " + tauxPatronalSaisie);
		
		cotisationService.sauver(codeSaisie, libelleSaisie, imposableSaisie, tauxSalarialSaisie, tauxSalarialSaisie);
	}

}

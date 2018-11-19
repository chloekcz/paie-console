package dev.paie.ihm;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dev.paie.service.CotisationService;

@Controller
public class SupprimerCotisationOptionMenu extends OptionMenu {

	@Autowired
	Scanner scanner;

	@Autowired
	private CotisationService cotisationService;

	public SupprimerCotisationOptionMenu() {
		super("Supprimer une cotisation");
	}

	@Override
	public void executer() {
		
		int id = scanner.nextInt();
		System.out.println("idCotis : " + id);
				
		cotisationService.supprimer(id);

	}

}

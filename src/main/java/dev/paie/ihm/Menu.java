package dev.paie.ihm;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import dev.paie.service.CotisationService;

@Controller
public class Menu {

	private Map<Integer, OptionMenu> options = new HashMap<>();
	private Scanner scanner;

	@Autowired
	private ApplicationContext context;

	@Autowired
	public Menu(Scanner scanner, CotisationService cotisService, ApplicationContext context) {
		init2(scanner, cotisService, context);
		this.scanner = scanner;
	}

	/*
	 * avec boucle for sans AtomicInteger private void init(Scanner scanner,
	 * CotisationService cotisService, ApplicationContext context) { // Recherche
	 * dans le contexte des beans Spring de type OptionMenu Map<String, OptionMenu>
	 * beansTrouves = context.getBeansOfType(OptionMenu.class);
	 * 
	 * Collection<OptionMenu> optionsTrouve = beansTrouves.values();
	 * 
	 * int i = 1;
	 * 
	 * for(OptionMenu opt : optionsTrouve) { this.options.put(i, opt); i++; }
	 * 
	 * this.options.put(1, new ListerCotisationOptionMenu(cotisService));
	 * this.options.put(2, new CreerCotisationOptionMenu(scanner));
	 * 
	 * }
	 */

	private void init2(Scanner scanner, CotisationService cotisService, ApplicationContext context) {
		Map<String, OptionMenu> beansTrouves = context.getBeansOfType(OptionMenu.class);

		// Création d'un incrément
		// Remplace le i++ à cause de la lambda
		AtomicInteger index = new AtomicInteger();

		beansTrouves.forEach((cle, valeur) -> {
			this.options.put(index.incrementAndGet(), valeur);
		});
	}

	public void demarrer() {
		while(true) {
			// Afficher les libellés des options
			this.options.forEach((key, option) -> {
				System.out.println(key + ". " + option.getLibelle());
			});

			int optionMenuChoisie = this.scanner.nextInt();

			this.options.get(optionMenuChoisie).executer();
		}
	}

}

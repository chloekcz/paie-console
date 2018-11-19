package dev.paie.console;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.paie.config.AppConfig;
import dev.paie.ihm.Menu;


/*
 * 1. Ajouter dépendance Maven (spring-context)
 * 2. Créer un contexte Spring
 */
public class App {
	public static void main(String[] args) {
		
		// Création contexte Spring
		try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
			
			Menu menu = context.getBean(Menu.class);
			menu.demarrer();
			
		}
		
		
		
	}
}

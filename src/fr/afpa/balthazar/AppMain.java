package fr.afpa.balthazar;

import fr.afpa.balthazar.logic.configuration.AppConfig;
import fr.afpa.balthazar.logic.controllers.MainController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AppMain {



	public static void main(String args[]) {

		//Get Context From AppCOnfig Class.
		ApplicationContext appCtx = new AnnotationConfigApplicationContext(AppConfig.class);

//		Instantiate MainController
		MainController mainController =  appCtx.getBean(MainController.class);
		//Set  up Menu Listeners.
		mainController.setUpListeners();

	}
}

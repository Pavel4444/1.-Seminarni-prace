package com.github.Pavel4444.adventura2.ui;
import javafx.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import com.github.Pavel4444.adventura2.logika.HerniPlan;
import com.github.Pavel4444.adventura2.logika.Hra;
import com.github.Pavel4444.adventura2.logika.Prostor;
import com.github.Pavel4444.adventura2.logika.Vec;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


import java.io.IOException;



/**
 * Kontroler, který zprostředkovává komunikaci mezi grafikou
 * a logikou adventury
 * 
 * @author Pavel Pivovarčík
 *
 */
public class HomeController extends GridPane implements Observer {
	
	@FXML private TextField vstupniText;
	@FXML private TextArea vystup;
	@FXML private ListView<Vec> seznamVeciMistnost;
	@FXML private ListView<Prostor> seznamVychodu;
	@FXML private ImageView uzivatel; 
	@FXML private ImageView chleba;
	@FXML private ImageView mec;
	@FXML private ImageView lektvar;
	@FXML private Button button; 
	 
	
	private Hra hra;
	
	/**
	 * metoda čte příkaz ze vstupního textového pole
	 * a zpracuje ho
	 * 
	 */
	
	 

	   @FXML
	    private void handleButtonAction(ActionEvent event) throws IOException // Když je stisknut button s fx:id handleButtonAction načte se Napoveda na nové vytvořené scéně
	    {
		   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Napoveda.fxml"));
		   Parent root1 = (Parent) fxmlLoader.load();
		   Stage stage = new Stage();
		   stage.setScene(new Scene(root1));  
		   stage.show();
	    } 
	  
	    @FXML
	    private void konec(ActionEvent event) //ukončení hry
	    {
	        Platform.exit();
	    }
	
	    @FXML
	    private void NovaHra(ActionEvent event) //Nova hra, nejdříve nastavím věci na false, aby se batoh resetoval, pak vycistim listview seznam vychodu a vytvořím novou hru
	    {   
	    	HerniPlan.setJedl(false);
	    	HerniPlan.setSebralChleba(false);
	    	HerniPlan.setSebralLektvar(false);
	    	HerniPlan.setSebralMec(false);
	    	seznamVychodu.getItems().clear();
	    	aktualizujBatoh();
	    	Hra hra = new Hra();
	    	this.hra = hra;
	    	aktualizujBatoh();
			vystup.setText(hra.vratUvitani());
			vystup.setEditable(false);
			
			
	    	seznamVeciMistnost.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getVeci());
			seznamVychodu.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getVychody());
			uzivatel.setX(hra.getHerniPlan().getAktualniProstor().getX());
			uzivatel.setY(hra.getHerniPlan().getAktualniProstor().getY());
			hra.getHerniPlan().addObserver(this);
	    }
	    

	    
	   
	
	
	@FXML public void odesliPrikaz() {
		String vystupPrikazu = hra.zpracujPrikaz(vstupniText.getText());
		vystup.appendText("\n----------\n"+vstupniText.getText()+"\n----------\n");
		vystup.appendText(vystupPrikazu);
		vstupniText.setText("");
		if(hra.konecHry()) {
			vystup.appendText("\n----------\nKonec hry\n----------\n");
			vstupniText.setDisable(true);
		}
	}
	
	/**
	 * Metoda bude soužit pro předání objektu se spuštěnou hrou
	 * kontroleru a zobrazí stav hry v grafice.
	 * @param objekt spuštěné hry
	 */
	public void inicializuj(Hra hra) { //start hry
		aktualizujBatoh();
		vystup.setText(hra.vratUvitani());
		vystup.setEditable(false);
		this.hra = hra;
		seznamVeciMistnost.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getVeci());
		seznamVychodu.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getVychody());
		uzivatel.setX(hra.getHerniPlan().getAktualniProstor().getX());
		uzivatel.setY(hra.getHerniPlan().getAktualniProstor().getY());
		hra.getHerniPlan().addObserver(this);
	}

	@Override
	public void update(Observable arg0, Object arg1) { // Aktualizace vychodu, veci, batohu atd.
		aktualizujBatoh();
		seznamVeciMistnost.getItems().clear();
		seznamVychodu.getItems().clear();
		seznamVeciMistnost.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getVeci());
		seznamVychodu.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getVychody());
		uzivatel.setX(hra.getHerniPlan().getAktualniProstor().getX());
		uzivatel.setY(hra.getHerniPlan().getAktualniProstor().getY());
		
	}
    public void aktualizujBatoh() { // metoda, která zobrazuje obrázky v aplikaci podle toho, jestli jsou sebrané nebo snězené
     
        
        if(HerniPlan.sebralMec()) {
        	mec.setVisible(true);
        } else {
        	mec.setVisible(false);
        }
        
        if(HerniPlan.sebralLektvar()) {
        	lektvar.setVisible(true);
        } else {
        	lektvar.setVisible(false);
        }
        if(HerniPlan.sebralChleba() && !HerniPlan.jedlJidlo()) {
            chleba.setVisible(true);
        } else {
        	chleba.setVisible(false);
        }

    }


}


/*
 * To change this license header, choose License Headers in Project Properties.private TextField tuloskentta;
    private TextField syotekentta;
    private Button nollaa;
    private Button undo;
    private Sovelluslogiikka sovellus;
    
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author jussiste
 */
public class Erotus extends Operaatio {

    public Erotus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        int miinus;
        try{
            miinus = Integer.parseInt(syotekentta.getText());
        }catch (Exception e){
            miinus=0;
        }
        sovellus.miinus(miinus);
        this.tuloskentta.setText(Integer.toString(sovellus.tulos()));
    }

    @Override
    public void peru() {
        this.sovellus.palauta();
        this.tuloskentta.setText(Integer.toString(sovellus.tulos()));
    }
}

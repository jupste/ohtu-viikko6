/*
 * To change this license header, choose License Headers in Project Properties.
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
public class Summa extends Operaatio {

    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        int plus;
        try {
            plus = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
            plus = 0;
        }
        sovellus.plus(plus);
        this.tuloskentta.setText(Integer.toString(sovellus.tulos()));
    }

    @Override
    public void peru() {
        this.sovellus.palauta();
        this.tuloskentta.setText(Integer.toString(sovellus.tulos()));
    }
}

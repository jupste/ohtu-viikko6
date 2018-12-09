package laskin;

public class Sovelluslogiikka {

    private int tulos;
    private int[] muisti;
    private int osoitin;

    public Sovelluslogiikka() {
        this.muisti = new int[100];
        this.osoitin = 0;
    }

    public void plus(int luku) {
        tulos += luku;
        liikuta();
        this.muisti[osoitin] = tulos;
    }

    public void miinus(int luku) {
        tulos -= luku;
        liikuta();
        this.muisti[osoitin] = tulos;
    }

    public void nollaa() {
        liikuta();
        this.muisti[osoitin] = tulos;
        tulos = 0;
    }

    public int tulos() {
        return tulos;
    }

    public void palauta() {
        if (osoitin == 0) {
            osoitin = 99;
            this.tulos = muisti[osoitin];
        }
        osoitin--;
        this.tulos = muisti[osoitin];
    }

    private void liikuta() {
        this.osoitin++;
        if (this.osoitin >= 100) {
            this.osoitin = 0;
        }
    }
}

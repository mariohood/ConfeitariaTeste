//Os comentários para essa classe são os mesmos da classe BoloNormal

package modelo;

import java.util.Objects;

public class BoloTorta extends Bolo {

    private Recheio recheio; // Agregação

    public BoloTorta(Sabor sabor, double preco) {
        super(sabor, preco);
    }

    @Override
    public String toString() {
        return super.toString() + "\n    Tipo: Torta" + " - Recheio: " + recheio;
    }

    public Recheio getRecheio() {
        return recheio;
    }

    public void setRecheio(Recheio recheio) {
        this.recheio = recheio;
    }
    
    @Override
    public void incrementarCamada (){
        setCamadaExtra(!this.isCamadaExtra());
        this.setPreco(calcularPrecoBoloComIncremento());
    }

    @Override
    public void decrementarCamada() {
        setCamadaExtra(!this.isCamadaExtra());
        this.setPreco(calcularPrecoBoloComDecremento());    
    }

    @Override
    public double calcularPrecoBoloComIncremento() {
        return this.getPreco() + (this.getPreco() / 3);
    }
 
    @Override
    public double calcularPrecoBoloComDecremento() {
        return (this.getPreco()/ 4) * 3;
    }
    
}//BoloTorta extends Bolo

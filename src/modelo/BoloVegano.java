//Os comentários para essa classe são os mesmos da classe BoloNormal

package modelo;

import java.util.Objects;

public class BoloVegano extends Bolo {
    
    private Pedacos pedacos; // Agregação

    public BoloVegano(Sabor sabor, double preco) {
        super(sabor, preco);
    }

    @Override
    public String toString() {
        return super.toString() + "\n    Tipo: Vegano" + " - Pedaços: " + pedacos;
    }

    public Pedacos getPedacos() {
        return pedacos;
    }

    public void setPedacos(Pedacos pedacos) {
        this.pedacos = pedacos;
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
       return (this.getPreco() + (this.getPreco() / 3) + 5);
    }
    
    @Override
    public double calcularPrecoBoloComDecremento() {
        return ((this.getPreco() - 5) / 4) * 3;
    }
 
}//BoloVegano extends Bolo

package modelo;  // Expecifica o pacote ao qual a classe pertence

import java.util.Objects;

public class BoloNormal extends Bolo { // Essa classe extende a classe Bolo, ou seja, é sua filha.
    
    private Cobertura cobertura; // Agregação

    public BoloNormal(Sabor sabor, double preco) { // Método construtor
        super(sabor, preco); // Enviando dados para construtor da classe mãe
    }

    @Override // Sobrescrevendo a classe toString
    public String toString() { 
        return super.toString() + "\n    Tipo: Normal" + " - Cobertura: " +  cobertura;
    }

    @Override // Sobrescrevendo método abstrato
    public void incrementarCamada (){
        setCamadaExtra(!this.isCamadaExtra());
        this.setPreco(calcularPrecoBoloComIncremento());
    }
    
    @Override // Sobrescrevendo método abstrato
    public void decrementarCamada() {
        setCamadaExtra(!this.isCamadaExtra());
        this.setPreco(calcularPrecoBoloComDecremento());
    }
    
    @Override // Sobrescrevendo método abstrato
    public double calcularPrecoBoloComIncremento() {
        return this.getPreco() + (this.getPreco() / 2);
    }
    
    @Override // Sobrescrevendo método abstrato
    public double calcularPrecoBoloComDecremento() {
         return (this.getPreco()/3) * 2;
    }

    public Cobertura getCobertura() {
        return cobertura;
    }

    public void setCobertura(Cobertura cobertura) {
        this.cobertura = cobertura;
    }

}//BoloNormal extends Bolo

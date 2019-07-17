/*Alguns comentários sobre Construtor, toString, equals etc... não estão expostos aqui pois são semelhantes
ou seriam mais ou menos os mesmos da classe bolo.*/

package modelo;

import java.util.Objects;

public class Cobertura {
    
    private String nome; 
    private String sabor; 
    private String adereco; 

    public Cobertura(String nome, String sabor, String adereco) {
        this.nome = nome;
        this.sabor = sabor;
        this.adereco = adereco;
    }

    @Override
    public String toString() {
        return getNome() + "(" + getSabor() + ", " + getAdereco() + ")";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getAdereco() {
        return adereco;
    }

    public void setAdereco(String adereco) {
        this.adereco = adereco;
    }

    /*Comentarios seguem o modelo dos comentario do equals da classe "Bolo".
    Com a diferença que aqui temos dois atributos como critério de comparação 
    que é o "nome" e o sabor. */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cobertura other = (Cobertura) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.sabor, other.sabor)) {
            return false;
        }
        return true;
    }
  
}//Cobertura

/*Alguns comentários sobre Construtor, toString, equals etc... não estão expostos aqui pois são semelhantes
ou seriam mais ou menos os mesmos da classe bolo.*/

package modelo;

import java.util.Objects;

public class Recheio {
    
    private String nome; 
    private String sabor1; 
    private String sabor2;

    public Recheio(String nome, String sabor1, String sabor2) {
        this.nome = nome;
        this.sabor1 = sabor1;
        this.sabor2 = sabor2;
    }

    @Override
    public String toString() {
        return getNome() + "(" + getSabor1() + ", " + getSabor2() + ")";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSabor1() {
        return sabor1;
    }

    public void setSabor1(String sabor1) {
        this.sabor1 = sabor1;
    }

    public String getSabor2() {
        return sabor2;
    }

    public void setSabor2(String sabor2) {
        this.sabor2 = sabor2;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Recheio other = (Recheio) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
 
}//Recheio

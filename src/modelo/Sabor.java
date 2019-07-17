/*Alguns comentários sobre Construtor, toString, equals etc... não estão expostos aqui pois são semelhantes
ou seriam mais ou menos os mesmos da classe bolo.*/

package modelo;

import java.util.Objects;

public class Sabor {
    
    private String nome;

    public Sabor(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return getNome();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sabor other = (Sabor) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
   
}//Sabor

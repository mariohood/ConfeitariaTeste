/*Alguns comentários sobre Construtor, toString, equals etc... não estão expostos aqui pois são semelhantes
ou seriam mais ou menos os mesmos da classe bolo.*/

package modelo; // Expecifica o pacote ao qual a classe pertence

import java.util.Objects;

public class Cliente {
    
    private String nome;
    private String telefone;

    public Cliente(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    @Override 
    public String toString() {
        return getNome() + ", Tel: " + getTelefone();
    }

    /*Comentarios seguem o modelo dos comentario do equals da classe "Bolo".
    Aqui o atributo de comparação é o "nome"*/
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
  
}//Cliente

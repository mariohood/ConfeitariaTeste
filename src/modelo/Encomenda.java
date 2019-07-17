/*Alguns comentários sobre Construtor, toString, equals etc... não estão expostos aqui pois são semelhantes
ou seriam mais ou menos os mesmos da classe bolo.*/

package modelo;

import java.util.ArrayList;

public class Encomenda {
    
    private static int contador = 0;
   
    private int codigoEncomenda; // É gerado automáticamente com a ajuda do contador
    private Cliente cliente; 
    private ArrayList<Bolo> listaDeBolos = new ArrayList(); // lista de bolos

    public Encomenda(Cliente cliente) {
        contador++; 
        this.codigoEncomenda = contador;
        this.cliente = cliente;
    }

    @Override
    public String toString() {      
        return  "\n\nEnc " + getCodigoEncomenda() + " - Cliente: " + getCliente() + "\nBolos: " + getListaDeBolos();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Encomenda other = (Encomenda) obj;
        if (this.getCodigoEncomenda() != other.getCodigoEncomenda()) {
            return false;
        }        
        return true;
    }

    public int getCodigoEncomenda() {
        return codigoEncomenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Bolo> getListaDeBolos() { //Retorna a lista de bolos
        return listaDeBolos;
    }

    public void setListaDeBolos(ArrayList<Bolo> listaDeBolos) {
        this.listaDeBolos = listaDeBolos;
    }
    
    public void inserirBolo(Bolo bolo){
        listaDeBolos.add(bolo); //adiciona um bolo na lista
    }
    
    /* Recebe o código do bolo e se encontra o objeto correspondente o retorna 
    senão retorna null*/
    public Bolo buscarBolo (int codigo){ 
        for(int i = 0 ; i < getListaDeBolos().size() ; i++){
            Bolo bolo = getListaDeBolos().get(i);
           if(codigo == bolo.getCodBolo()){ 
               return bolo; 
           }     
        } 
        return null; 
    }
    
    public boolean excluirBolo(Object obj) {
        Bolo ob = (Bolo)obj; // Fazendo um cast de Object para caber na variável Bolo ob      
        listaDeBolos.remove(ob); // método "remove" remove a primeira ocorrência do objeto encontrada dentro da lista
            return true;
        }         
     
}//Encomenda
    
    


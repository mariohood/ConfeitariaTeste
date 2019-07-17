/*Alguns comentários sobre Construtor, toString, equals etc... não estão expostos aqui pois são semelhantes
ou seriam mais ou menos os mesmos da classe bolo.*/

package classesDAO;

import interfaces.InterfaceDAO; // Importando classe de outro pacote
import modelo.Encomenda;  // Importando classe de outro pacote
import java.util.ArrayList;

public class EncomendaDAO implements InterfaceDAO {
    
    private ArrayList<Encomenda> encomendas = new ArrayList(); // Coleção de objetos Encomenda - Collection

    public EncomendaDAO() { // Método construtor
    }
 
    @Override // Inserindo um objeto na coleção "encomendas"
    public boolean inserir(Object obj) {
        Encomenda e = (Encomenda) obj;
        return (getEncomendas().add(e));
    }

    @Override
    public boolean excluir(Object obj) { // Excluindo um objeto da coleção "encomendas"
        Encomenda ob = (Encomenda)obj;        
            if(encomendas.remove(ob)){ // método "remove" remove a primeira ocorrência do objeto encontrada dentro da lista
            return true;
            }         
        return false;
    }

    @Override
    public boolean editar(Object obj) { // Editando um objeto na coleção "encomendas"
        Encomenda e = (Encomenda) obj;
       
        for(int i = 0 ; i < encomendas.size() ; i++){    
            if(e.equals(encomendas.get(i))){
                encomendas.remove(i);
                encomendas.add(e);
                return true;
            }
    }
       return false;
    }

    @Override
    public ArrayList pesquisar() { // Retornados os objetos da coleção "encomendas"
        return getEncomendas();
    }

    public ArrayList<Encomenda> getEncomendas() {
        return encomendas;
    }

    public void setEncomendas(ArrayList<Encomenda> encomendas) {
        this.encomendas = encomendas;
    }
    
    public Encomenda buscarEncomenda (int codigo){ // Buscando uma "Encomenda" específica
        for(int i = 0 ; i < getEncomendas().size() ; i++){
            Encomenda encomenda = getEncomendas().get(i);
           if(codigo == encomenda.getCodigoEncomenda()){ 
               return encomenda; 
           }     
        } 
        return null; 
    }
    
}//EncomendaDAO implements InterfaceDAO

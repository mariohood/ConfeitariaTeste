package interfaces;

import java.util.ArrayList;

public interface InterfaceDAO { // Uma interface não pode ser instanciada
    
    //Todos os métodos por padrão são abstratos
    public boolean inserir(Object obj);
    public boolean excluir(Object obj);
    public boolean editar(Object obj);
    public ArrayList pesquisar();

}//InterfaceDAO


package modelo; // Expecifica o pacote ao qual a classe pertence

public abstract class Bolo { // Classe abstrata. Não pode ser instanciada
    
    private static int contador = 0; // Contador estático pra ser lido por todas as instâncias da classe
    
    private int codBolo;
    private Sabor sabor; // Composição
    private double preco;
    private boolean camadaExtra = false; // Inicia com false porque ao ser criado um objeto bolo não tem camada extra.

    public Bolo(Sabor sabor, double preco) { // Método construtor
        contador = contador + 10; // Contador que incrementa o valor do código automaticamente cada vez que um objeto é criado.
        this.codBolo = contador;
        this.sabor = sabor;
        this.preco = preco;
    }
    
    @Override // sobrescrevendo o método toString
    public String toString() { 
        return "\nCod: " + getCodBolo() + " - Sabor: " + getSabor() 
                + " - Preço: R$" + getPreco() + " - Camada Extra: " + isCamadaExtra();
    }
    
    /* Os métodos abstratos a seguir são abstratos porque são implementados 
    de maneira diferente em cada classe filha de Bolo */
    public abstract void incrementarCamada (); // método abstrato. 
    public abstract void decrementarCamada (); // método abstrato. 
    public abstract double calcularPrecoBoloComIncremento (); // método abstrato. 
    public abstract double calcularPrecoBoloComDecremento (); // método abstrato. 

    // Este método não é abstrato porque é a mesma implementação para todas as classes filhas
    public void mudarStatusCamadaExtra(){
        this.camadaExtra = !this.camadaExtra;
    }
    
    public int getCodBolo() {
        return codBolo;
    }
    
    /* Não há "setCodBolo()" pois o "CodBolo" é um identificador. Só 
    pode ser gerado dinamicamente e não deve ser modificado. */

    public Sabor getSabor() {
        return sabor;
    }

    public void setSabor(Sabor sabor) {
        this.sabor = sabor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    /* Atributos Boolean não são obtidos por meio de get. 
    Como são variáveis de "verdadeiro" ou "falso" ou seja "ser" ou "não ser" 
    elas são verificadas se são, ou seja, "is" */
    public boolean isCamadaExtra() { 
        return camadaExtra;
    }

    public void setCamadaExtra(boolean camadaExtra) {
        this.camadaExtra = camadaExtra;
    }

    @Override // Sobrescrevendo o método equals
    public boolean equals(Object obj) {
        if (obj == null) { // verifica se o objeto recebido não é nulo
            return false;
        }
        if (getClass() != obj.getClass()) { // verifica se o objeto recebido e o que recebeu são instâncias da mesma classe
            return false;
        }
        final Bolo other = (Bolo) obj; /* se nenhum if satisfez a condição então ele cria um novo objeto 
        fazendo um cast para forçar um enquadramento no mesmo tipo do receptor*/
        
        /*Apartir daqui começa a comparar os atributos especificados pelo programador dos dois objetos 
        pra ver se são diferentes. Caso nenhum dos proximos ifs satisfaçam a condição então ele retorna 
        "true",ou seja, os objetos são iguais*/
        if (this.codBolo != other.codBolo) { 
            return false;
        }
        return true;
    }   

}//Bolo

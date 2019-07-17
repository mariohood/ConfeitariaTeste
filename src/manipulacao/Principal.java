package manipulacao;

import classesDAO.EncomendaDAO;
import modelo.Sabor;
import modelo.Recheio;
import modelo.Pedacos;
import modelo.Cobertura;
import modelo.BoloTorta;
import modelo.Encomenda;
import modelo.Bolo;
import modelo.BoloVegano;
import modelo.BoloNormal;
import modelo.Cliente;
import java.util.ArrayList;
import javax.swing.*;

public class Principal {

    public static void main(String[] args){
        
    //Criando sabores 
    Sabor chocolate = new Sabor ("Chocolate");
    Sabor laranja = new Sabor ("Laranja");
    Sabor limao = new Sabor ("Limao");
    //Mario
    //Criando coberturas
    Cobertura cCafeComLeite = new Cobertura ("Café com Leite","Chocolate","Bombons Brancos");
    Cobertura cNoiteDeGala = new Cobertura ("Noite de Gala","Nata","Morangos");
    Cobertura cTerraDoNunca = new Cobertura ("Terra do Nunca","Creme","MM's");
    
    //Criando recheios
    Recheio rBlackAndWhite = new Recheio ("Black and White","Choclate Preto","Chocolate Branco");
    Recheio rNoiteFeliz = new Recheio ("Noite Feliz","Chocolate Branco","Morango");
    Recheio rSoftBrown = new Recheio ("Soft Brown","Creme","Nata");
    
    //Criando pedaços
    Pedacos pChocolate = new Pedacos("Chocolate");
    Pedacos pCanela = new Pedacos("Canela");
    Pedacos pMorango = new Pedacos("Morango");
    
    //Criando a coleção DAO
    EncomendaDAO ecmDAO = new EncomendaDAO();
    
    int codOperacao = 0;
    
    do{
 
    if(ecmDAO.getEncomendas().isEmpty()){ 
        /* Verificando se a lista de encomendas está vazia.
        Se estiver não há porquê exibir opções como "excluir", "pesquisar", "editar", etc*/
        do{
            codOperacao = Integer.parseInt(JOptionPane.showInputDialog
                    ("A lista de encomendas está vazia."
                        + "\n1-Inserir Encomenda"
                        + "\n0-Sair\n"));
            if (codOperacao != 1 && codOperacao != 0)
                JOptionPane.showMessageDialog(null,"Opção Inválida. Digite uma opção válida.");  

        }while(codOperacao != 1 && codOperacao != 0);
        
    }else{
        
    codOperacao = Integer.parseInt(JOptionPane.showInputDialog
                ("Selecione a opção desejada:\n"
                    + "1-Nova Encomenda\n"
                    + "2-Excluir Uma Encomenda\n"
                    + "3-Editar Uma Encomenda\n"
                    + "4-Ver Lista De Encomendas\n"
                    + "5-Buscar Uma Encomenda\n"
                    + "0-Sair\n"));
    }
    
    switch(codOperacao){
        case 1: // NOVA ENCOMENDA
            
            //Criando cliente
            String nomeCliente = JOptionPane.showInputDialog ("Cliente: ");
            String telefoneCliente = JOptionPane.showInputDialog ("Telefone: ");
            Cliente cliente = new Cliente(nomeCliente,telefoneCliente);
            
            //Criando uma encomenda
            Encomenda encomenda = new Encomenda (cliente);
            
            int controlador;
            controlador = 1;
            do{
                int op = Integer.parseInt(JOptionPane.showInputDialog // Escolhendo o tipo de bolo
                ("1-Inserir Bolo\n"
                + "2-Fechar Encomenda\n"));
                
                switch(op){
                    case 1:
//INICIO INSERIR BOLO//////////////INICIO INSERIR BOLO//////////////INICIO INSERIR BOLO//////////////FIM INSERIR BOLO//////////////INSERIR BOLO////////////                      
                        //Criando bolo
                        
                        Sabor s = null; // Criando uma variável para salvar o sabor
                        int verificador;

                        verificador = 1; // Controla o do-while
                        do{
                        int sabor = Integer.parseInt(JOptionPane.showInputDialog // Escolhendo o sabor do Bolo
                                    ("Selecione o sabor:\n"
                                    + "1-Chocolate\n"
                                    + "2-Laranja\n"
                                    + "3-Limão\n"));

                        switch(sabor){
                            case 1:
                                s = chocolate;
                                verificador = 1;
                                break;
                            case 2:
                                s = laranja;
                                verificador = 1;
                                break;
                            case 3:
                                s = limao;
                                verificador = 1;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null,"Opção Inválida. Digite uma opção válida.");
                                verificador = 0;
                        }
                        }while(verificador == 0);
            
                        Bolo boloFinal = null;
                        String nomeDoTipo = "";
                        
                        verificador = 1;
                        do{ 
                            int tipoDeBolo = Integer.parseInt(JOptionPane.showInputDialog // Escolhendo o tipo de bolo
                            ("Selecione o tipo de bolo que deseja inserir:\n"
                            + "1-Bolo Normal\n"
                            + "2-Bolo Torta\n"
                            + "3-Bolo Vegano\n" ));
                            
                            int codigo = 0 ; 
                            double preco = 0;
                            
                            if(tipoDeBolo == 1 || tipoDeBolo == 2 || tipoDeBolo == 3){
                                preco = Double.parseDouble (JOptionPane.showInputDialog 
                                ("Digite o preço do bolo: "));  //Atribuindo um preço para o bolo
                            }
                            
                            switch(tipoDeBolo){

                                case 1:
                                    BoloNormal n = new BoloNormal(s,preco); //Montando um bolo normal com os dados já informados

                                    int cobertura;
                                    Cobertura c = null; // para salvar a cobertura

                                    verificador = 1;
                                    do{
                                        cobertura = Integer.parseInt(JOptionPane.showInputDialog
                                        ("Selecione a cobertura:\n"
                                        + "1-Café com Leite\n"
                                        + "2-Noite de Gala\n"
                                        + "3-Terra do Nunca\n" )); //Escolhendo a cobertura

                                        if(cobertura == 1){
                                            c = cCafeComLeite; //Salvando a cobertura para adicionar depois
                                            verificador = 1;
                                        }
                                        else if(cobertura == 2){
                                            c = cNoiteDeGala;
                                            verificador = 1;
                                        }
                                        else if(cobertura == 3){    
                                            c = cTerraDoNunca; 
                                            verificador = 1;
                                        }
                                        else {
                                            verificador = 0;
                                            JOptionPane.showMessageDialog(null,"Opção Inválida. Digite uma opção válida.");
                                        }
                                    }while(verificador == 0);

                                    n.setCobertura(c); // Atribuindo a cobertura ao bolo
                                    JOptionPane.showMessageDialog(null,"Bolo Normal Criado"
                                                                    + "\nPreço: R$" + n.getPreco());
                                    
                                    //inserindo bolo normal em boloFinal
                                    boloFinal = n; // Obs: Variável bolo final foi criada pra não ter que repetir código
                                    nomeDoTipo = "normal";
                                    
                                    verificador = 1;
                                    break;
                                case 2:
                                    BoloTorta t = new BoloTorta(s,preco); //Montando um bolo torta com os dados já informados
                                    
                                    Recheio r = null;

                                    verificador = 1;
                                    do{
                                    int recheio = Integer.parseInt(JOptionPane.showInputDialog
                                    ("Selecione o Recheio:\n"
                                    + "1-Black and White\n"
                                    + "2-Noite Feliz\n"
                                    + "3-Soft Brown\n" ));

                                    if(recheio == 1){   
                                        r = rBlackAndWhite;
                                            verificador = 1;
                                        }else if(recheio == 2){
                                            r = rNoiteFeliz;  
                                            verificador = 1;
                                        }
                                        else if(recheio == 3){   
                                            r = rSoftBrown;
                                            verificador = 1;
                                        }
                                        else {
                                            verificador = 0;
                                            JOptionPane.showMessageDialog(null,"Opção Inválida. Digite uma opção válida.");
                                        }
                                    }while(verificador == 0);

                                    t.setRecheio(r);
                                    
                                    JOptionPane.showMessageDialog(null,"Bolo Torta Criado"
                                            + "\nPreço: R$" + t.getPreco());
                                    
                                    //Inserindo bolo torta em boloFinal
                                    boloFinal = t; 
                                    nomeDoTipo = "torta";
                                    
                                    verificador = 1;
                                    break;
                                case 3:

                                    BoloVegano v = new BoloVegano(s,preco); //Montando um bolo vegano com os dados já informados
                                    
                                    Pedacos p = null; // Variável criada para salvar Pedaços

                                    verificador = 1;
                                    do{
                                        int pedacos = Integer.parseInt(JOptionPane.showInputDialog
                                        ("Selecione o tipo de pedaços:\n"
                                        + "1-Chocolate\n"
                                        + "2-Canela\n"
                                        + "3-Morango\n" ));

                                        if(pedacos == 1){
                                            p = pChocolate;
                                            verificador = 1;
                                        }
                                        else if(pedacos == 2){
                                            p = pCanela;  
                                            verificador = 1;
                                        }
                                        else if(pedacos == 3){    
                                            p = pMorango; 
                                            verificador = 1;
                                        }
                                        else {
                                            verificador = 0;
                                            JOptionPane.showMessageDialog(null,"Opção Inválida. Digite uma opção válida.");
                                        }

                                    }while(verificador == 0);

                                    v.setPedacos(p);
                                    
                                    
                                    JOptionPane.showMessageDialog(null,"Bolo Vegano Criado"
                                                        + "\nPreço: R$" + v.getPreco());
                                    
                                    //Inserindo bolo vegano em boloFinal
                                    boloFinal = v; 
                                    nomeDoTipo = "vegano";
                                    
                                    verificador = 1;
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null,"Opção Inválida. Digite uma opção válida.");
                                    verificador = 0;
                            }   
                        }while(verificador == 0);  

                    //INSERINDO CAMADA - INICIO //------------------------ INSERINDO CAMADA --//
                                    
                                    int camadaExtra = 0;
                                    
                                    do{
                                    camadaExtra = Integer.parseInt(JOptionPane.showInputDialog
                                            ("Adicionar uma camada extra?"
                                                + "\nValor atual: " + boloFinal.getPreco() // Apresentando o preço sem a camada
                                                + "\nValor com camada extra: " 
                                                + boloFinal.calcularPrecoBoloComIncremento() // Apresentando o preço com a camada
                                                + "\n1-Sim"
                                                + "\n2-Não"));
                                    
                                        if (camadaExtra!=1 && camadaExtra!=2)
                                            JOptionPane.showMessageDialog(null,"Opção Inválida, digite 1 ou 2");
                                    
                                    }while(camadaExtra!=1 && camadaExtra!=2);
                                    
                                    if (camadaExtra==1){
                                            boloFinal.incrementarCamada();
                                            JOptionPane.showMessageDialog(null,"Camada extra adicionada."
                                                                        + "\nNovo preço: R$" + boloFinal.getPreco()); // Confirmando o preço com a camada
                                    } else JOptionPane.showMessageDialog(null,"Não foi adicionado camada extra.");
                                //Inserindo bolo na encomenda  
                                encomenda.inserirBolo(boloFinal);
                                JOptionPane.showMessageDialog(null,"Bolo " + nomeDoTipo + " inserido na Encomenda"
                                        + "\nO código desse bolo é: " + boloFinal.getCodBolo() // Apresentando o código do bolo pro cliente guardar
                                        + "\nRecomendamos guardar o código do bolo.");    
                                    
//INSERINDO CAMADA - FIM//------------------------ INSERINDO CAMADA - FIM-// 
                        

                        controlador = 0;
//FIM INSERIR BOLO//////////////FIM INSERIR BOLO//////////////FIM INSERIR BOLO//////////////FIM INSERIR BOLO//////////////INSERIR BOLO////////////
                        break;
                    case 2:
                        if(!encomenda.getListaDeBolos().isEmpty()){ // Esse teste é feito para impedir que se salve uma encomenda sem nenhum bolo.
                        ecmDAO.inserir(encomenda);
                        JOptionPane.showMessageDialog(null,"Encomenda Concluida."
                                + "\nO código da sua encomenda é: " + encomenda.getCodigoEncomenda()
                                + "\nPor favor guarde o código de sua encomenda.");
                        }
                        else {
                            JOptionPane.showMessageDialog(null,"A encomenda não foi salva porque está vazia.");
                        }
                        controlador = 1;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Opção Inválida. Digite uma opção válida.");
                        controlador = 0;
                }
            
            }while(controlador == 0);
 
            
            break;
        case 2: // EXCLUIR UMA ENCOMENDA
            
                int codigoBolosExcluir = Integer.parseInt(JOptionPane.showInputDialog
                ("\nCódigo da encomenda que deseja excluir:")); // informando o codigo do bolo que deseja excluir 
                Encomenda encomendaEncontradaExcluir = ecmDAO.buscarEncomenda(codigoBolosExcluir);
                if(encomendaEncontradaExcluir != null){ // se encontrou então começa o processo para exclusão
                    
                    int decisaoExcluir;

                    do{

                        decisaoExcluir = Integer.parseInt(JOptionPane.showInputDialog("Encomenda encontrada.\n" 
                                + encomendaEncontradaExcluir + "\n\nExcluir encomenda?"
                                + "\n1-Sim"
                                + "\n2-Não"));
                        if (decisaoExcluir != 1 && decisaoExcluir != 2){
                            JOptionPane.showMessageDialog(null,"Opção inválida. Escolha 1 ou 2."); 
                        }else if (decisaoExcluir == 1) {
                            ecmDAO.excluir(encomendaEncontradaExcluir); // Excuindo encomenda pelo método excluir
                            JOptionPane.showMessageDialog(null,"Encomenda excluida.");  
                        }else if (decisaoExcluir == 2){
                            JOptionPane.showMessageDialog(null,"A encomenda não foi excluida.");
                        }

                    }while(decisaoExcluir != 1 && decisaoExcluir != 2);
                }

                else JOptionPane.showMessageDialog(null,"Encomenda não encontrada."); //Exibindo mensagem de erro caso a operação retorne um false
            
            break;
      
        case 3: // EDITAR UMA ENCOMENDA
            
// INICIO DE -> EDITAR UMA ENCOMENDA////////////// INICIO DE -> EDITAR UMA ENCOMENDA////////////
            
            int codigoBolosEditar = Integer.parseInt(JOptionPane.showInputDialog
            ("Código da encomenda que deseja editar:\n"));
            Encomenda encomendaEncontradaEditar = ecmDAO.buscarEncomenda(codigoBolosEditar);
            if(encomendaEncontradaEditar == null){
                JOptionPane.showMessageDialog(null,"Encomenda não encontrada");
            } else { // Se encomenda existir então começa o processo pra edição da mesma
                
            boolean existeEssaEncomenda = true;
            int x = 1;
            do{
                
                int oQueEditar = Integer.parseInt(JOptionPane.showInputDialog
                ("Encomenda:\n" + encomendaEncontradaEditar + "\n\nO que deseja editar?\n"
                + "1-Cliente\n"
                + "2-Lista de Bolos\n"));  
                
                switch(oQueEditar){
                    case 1: // EDITAR CLIENTE
                        
                        int verificador;
                        
                        verificador = 1;
                        do{
                        int oQueEditarEmCliente = Integer.parseInt(JOptionPane.showInputDialog
                        ("O que deseja editar em cliente?\n"
                        + "1-Nome\n"
                        + "2-Telefone\n"));
                        
                        switch(oQueEditarEmCliente){
                            
                            case 1:
                               
                                String novoNome = JOptionPane.showInputDialog 
                                ("Nome Atual: " + encomendaEncontradaEditar.getCliente().getNome() 
                                + "\nDigite o novo nome: ");
                                encomendaEncontradaEditar.getCliente().setNome(novoNome);
                                JOptionPane.showMessageDialog(null,"Nome atualizado: "
                                + encomendaEncontradaEditar.getCliente().getNome());
                                verificador = 1;
                                break;
                            case 2:
                                
                                String novoTelefone = JOptionPane.showInputDialog 
                                ("Telefone Atual: " + encomendaEncontradaEditar.getCliente().getTelefone() 
                                + "\nDigite o novo telefone: ");
                                encomendaEncontradaEditar.getCliente().setTelefone(novoTelefone);
                                JOptionPane.showMessageDialog(null,"Telefone atualizado: "
                                + encomendaEncontradaEditar.getCliente().getTelefone());
                                verificador = 1;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null,"Opção inválida. Digite um número válido.");
                                verificador = 0;

                        }
                        
                        if (verificador == 1){
                            
                            int continuar;
                            
                            do{
                                continuar = Integer.parseInt(JOptionPane.showInputDialog
                                ("Continuar editando cliente?\n"
                                + "1-Sim\n"
                                + "2-Não\n"));
                                if (continuar != 1 && continuar != 2)
                                    JOptionPane.showMessageDialog(null,"Opção inválida. Digite 1 ou 2");
                                else if (continuar == 1) verificador = 0;
                                else if (continuar == 2) {
                                    verificador = 1;
                                    JOptionPane.showMessageDialog(null,"Cliente editado.");
                                }
                            }while(continuar != 1 && continuar != 2);
                        }
                        
                        }while(verificador == 0);
                        x = 1;
                                break;
                    case 2: // EDITAR LISTA DE BOLO
                        
                        verificador = 1;
                        do{
                        int oQueEditarNaLista = Integer.parseInt(JOptionPane.showInputDialog
                        ("O que deseja fazer na lista de bolos da encomenda?\n"
                        + "1-Inserir bolo\n"
                        + "2-Excluir Bolo\n"
                        + "3-Editar Bolo\n"));
                        
                        switch(oQueEditarNaLista){
                            
                            case 1: // INSERIR BOLO                                                             
//INICIO INSERIR BOLO//////////////INICIO INSERIR BOLO//////////////INICIO INSERIR BOLO//////////////FIM INSERIR BOLO//////////////INSERIR BOLO////////////                      
                                //Criando bolo
                                //Escolhendo o sabor
                                Sabor s = null;

                                verificador = 1;
                                do{
                                    int sabor = Integer.parseInt(JOptionPane.showInputDialog // Escolhendo o sabor do Bolo
                                                ("Selecione o sabor:\n"
                                                + "1-Chocolate\n"
                                                + "2-Laranja\n"
                                                + "3-Limão\n"));

                                    switch(sabor){
                                        case 1:
                                            s = chocolate;
                                            verificador = 1;
                                            break;
                                        case 2:
                                            s = laranja;
                                            verificador = 1;
                                            break;
                                        case 3:
                                            s = limao;
                                            verificador = 1;
                                            break;
                                        default:
                                            JOptionPane.showMessageDialog(null,"Opção Inválida. Digite uma opção válida.");
                                            verificador = 0;
                                    }
                                }while(verificador == 0);
                                
                                Bolo boloFinal = null;
                                String nomeDoTipo = "";

                                verificador = 1;
                                do{ 
                                    int tipoDeBolo = Integer.parseInt(JOptionPane.showInputDialog // Escolhendo o tipo de bolo
                                    ("Selecione o tipo de bolo que deseja inserir:\n"
                                    + "1-Bolo Normal\n"
                                    + "2-Bolo Torta\n"
                                    + "3-Bolo Vegano\n" ));

                                    int codigo = 0 ; 
                                    double preco = 0;

                                    if(tipoDeBolo == 1 || tipoDeBolo == 2 || tipoDeBolo == 3){
                                        /*codigo = Integer.parseInt (JOptionPane.showInputDialog 
                                        ("Digite um código para o bolo: ")); */ //Atribuindo um código para o bolo
                                        preco = Double.parseDouble (JOptionPane.showInputDialog 
                                        ("Digite o preço do bolo: "));  //Atribuindo um preço para o bolo
                                    }

                                    switch(tipoDeBolo){

                                        case 1:
                                            BoloNormal n = new BoloNormal(/*codigo,*/s,preco); //Montando um bolo normal com os dados já informados
                                            
                                            int cobertura;
                                            Cobertura c = null;

                                            verificador = 1;
                                            do{
                                                cobertura = Integer.parseInt(JOptionPane.showInputDialog
                                                ("Selecione a cobertura:\n"
                                                + "1-Café com Leite\n"
                                                + "2-Noite de Gala\n"
                                                + "3-Terra do Nunca\n" )); //Escolhendo a cobertura

                                                if(cobertura == 1){
                                                    c = cCafeComLeite; //Salvando a cobertura para adicionar depois
                                                    verificador = 1;
                                                }
                                                else if(cobertura == 2){
                                                    c = cNoiteDeGala;
                                                    verificador = 1;
                                                }
                                                else if(cobertura == 3){    
                                                    c = cTerraDoNunca; 
                                                    verificador = 1;
                                                }
                                                else {
                                                    verificador = 0;
                                                    JOptionPane.showMessageDialog(null,"Opção Inválida. Digite uma opção válida.");
                                                }
                                            }while(verificador == 0);

                                            n.setCobertura(c);
                                            JOptionPane.showMessageDialog(null,"Bolo Normal Criado"
                                                                        + "\nPreço: " + n.getPreco());
                                            
                                            //Bolo normal inserido em bolo final
                                            boloFinal = n;
                                            nomeDoTipo = "normal";
                                            
                                            verificador = 1;
                                            break;
                                        case 2:
                                            BoloTorta t = new BoloTorta(/*codigo,*/s,preco); //Montando um bolo torta com os dados já informados

                                            Recheio r = null;

                                            verificador = 1;
                                            do{
                                            int recheio = Integer.parseInt(JOptionPane.showInputDialog
                                            ("Selecione o Recheio:\n"
                                            + "1-Black and White\n"
                                            + "2-Noite Feliz\n"
                                            + "3-Soft Brown\n" ));

                                            if(recheio == 1){   
                                                r = rBlackAndWhite;
                                                    verificador = 1;
                                                }else if(recheio == 2){
                                                    r = rNoiteFeliz;  
                                                    verificador = 1;
                                                }
                                                else if(recheio == 3){   
                                                    r = rSoftBrown;
                                                    verificador = 1;
                                                }
                                                else {
                                                    verificador = 0;
                                                    JOptionPane.showMessageDialog(null,"Opção Inválida. Digite uma opção válida.");
                                                }
                                            }while(verificador == 0);

                                            t.setRecheio(r);
                                            JOptionPane.showMessageDialog(null,"Bolo Torta Criado"
                                                                            + "\nPreço: " + t.getPreco());
                                            
                                            //Bolo torta inserido em bolo final
                                            boloFinal = t;
                                            nomeDoTipo = "torta";
                                            verificador = 1;
                                            break;
                                        case 3:

                                            BoloVegano v = new BoloVegano(/*codigo,*/s,preco); //Montando um bolo vegano com os dados já informados
                                            
                                            Pedacos p = null;

                                            verificador = 1;
                                            do{
                                                int pedacos = Integer.parseInt(JOptionPane.showInputDialog
                                                ("Selecione o tipo de pedaços:\n"
                                                + "1-Chocolate\n"
                                                + "2-Canela\n"
                                                + "3-Morango\n" ));

                                                if(pedacos == 1){
                                                    p = pChocolate;
                                                    verificador = 1;
                                                }
                                                else if(pedacos == 2){
                                                    p = pCanela;  
                                                    verificador = 1;
                                                }
                                                else if(pedacos == 3){    
                                                    p = pMorango; 
                                                    verificador = 1;
                                                }
                                                else {
                                                    verificador = 0;
                                                    JOptionPane.showMessageDialog(null,"Opção Inválida. Digite uma opção válida.");
                                                }

                                            }while(verificador == 0);

                                            v.setPedacos(p);
                                            JOptionPane.showMessageDialog(null,"Bolo Vegano Criado"
                                                                            + "\nPreço: " + v.getPreco());
                                            
                                            //Bolo vegano inserido em bolo final
                                            boloFinal = v;
                                            nomeDoTipo = "vegano";
 
                                            verificador = 1;
                                            break;
                                        default:
                                            JOptionPane.showMessageDialog(null,"Opção Inválida. Digite uma opção válida.");
                                            verificador = 0;
                                    }   
                                }while(verificador == 0);  
                                
//INICIO DE -> INSERINDO CAMADA DA EDIÇÃO DE ENCOMENDA ---/////--- INICIO DE -> INSERINDO CAMADA DA EDIÇÃO DE ENCOMENDA  
                                    
                                    int camadaExtra = 0;
                                    
                                    do{
                                        
                                        camadaExtra = Integer.parseInt(JOptionPane.showInputDialog
                                            ("Adicionar uma camada extra?"
                                                + "\nValor atual: " + boloFinal.getPreco()
                                                + "\nValor com camada extra: " 
                                                + boloFinal.calcularPrecoBoloComIncremento()
                                                + "\n1-Sim"
                                                + "\n2-Não"));
                               
                                        if (camadaExtra!=1 && camadaExtra!=2)
                                            JOptionPane.showMessageDialog(null,"Opção Inválida, digite 1 ou 2");
                                    
                                    }while(camadaExtra!=1 && camadaExtra!=2);
                                    
                                    if (camadaExtra==1){
                                            boloFinal.incrementarCamada();
                                            JOptionPane.showMessageDialog(null,"\nCamada extra adicionada."
                                                                            + "\nNovo preço: R$" + boloFinal.getPreco());
                                    } else JOptionPane.showMessageDialog(null,"\nNão foi adicionado camada extra.");
                                    
                                    encomendaEncontradaEditar.inserirBolo(boloFinal);
                                    JOptionPane.showMessageDialog(null,"\nBolo " + nomeDoTipo + " inserido na Encomenda"
                                            + "\nO código desse bolo é: " + boloFinal.getCodBolo()
                                            + "\nRecomendamos que guarde o código do bolo");
                                    
// FIM DE -> INSERINDO CAMADA DA EDIÇÃO DE ENCOMENDA ------------------- FIM DE -> INSERINDO CAMADA DA EDIÇÃO DE ENCOMENDA 

                                controlador = 1;
// FIM DE -> INSERIR BOLO DA EDIÇÃO DE ENCOMENDA //////////////// FIM DE -> INSERIR BOLO DA EDIÇÃO DE ENCOMENDA //////////////

                                verificador = 1;
                                break;
/////////////////////---------------------////////////////////////////----------------------///////////////////////////---
                            case 2: // EXCLUIR BOLO
                                
                                int excluirMesmo;

                                int codDoBoloExcluir = Integer.parseInt(JOptionPane.showInputDialog
                                ("Digite o código do bolo para excluir."));
                                Bolo bExcluir = encomendaEncontradaEditar.buscarBolo(codDoBoloExcluir);
                                if(bExcluir != null && encomendaEncontradaEditar.getListaDeBolos().size() > 1){
                                // Se tiver mais de um bolo na lista eu posso excluir normalmente    
                                    do{
                                        excluirMesmo = Integer.parseInt(JOptionPane.showInputDialog
                                                (bExcluir + "\nTem certeza que deseja excluir esse bolo?"
                                                        + "\n1-Sim"
                                                        + "\n2-Não"));
                                        
                                        if(excluirMesmo != 1 && excluirMesmo != 2)
                                            JOptionPane.showMessageDialog(null,"Opção inválida. Digite 1 ou 2");
                                        else if(excluirMesmo == 1){
                                            encomendaEncontradaEditar.excluirBolo(bExcluir); // Excluindo bolo
                                            JOptionPane.showMessageDialog(null,"Bolo excluido");
                                        }
                                             
                                    }while(excluirMesmo != 1 && excluirMesmo != 2);
        
                                }else if(bExcluir != null && encomendaEncontradaEditar.getListaDeBolos().size() == 1){
                                // Se tiver só um bolo na lista eu posso excluir, mas a encomenda também será excluida.     
                                    
                                    do{
                                        excluirMesmo = Integer.parseInt(JOptionPane.showInputDialog
                                                (bExcluir + "\nEste é o ultimo bolo da lista. "
                                                + "\nSe você excluir esse bolo a encomenda será deletada."
                                                + "\nTem certeza que deseja excluir esse bolo?"
                                                        + "\n1-Sim"
                                                        + "\n2-Não"));
                                        
                                        if(excluirMesmo != 1 && excluirMesmo != 2)
                                            JOptionPane.showMessageDialog(null,"Opção inválida. Digite 1 ou 2");
                                        else if(excluirMesmo == 1){
                                            encomendaEncontradaEditar.excluirBolo(bExcluir); // Excluindo bolo
                                            ecmDAO.excluir(encomendaEncontradaEditar); // Excluindo encomenda
                                            
                                            int codEncomenda = encomendaEncontradaEditar.getCodigoEncomenda();
                                            Encomenda aindaExisteEncomenda = ecmDAO.buscarEncomenda(codEncomenda); // buscando a encomenda que estamos trabalhando para ver se elea não foi excluida
                                            if(aindaExisteEncomenda == null) { 
                                                JOptionPane.showMessageDialog(null,"Bolo excluido");
                                                JOptionPane.showMessageDialog(null,"Encomenda excluida!");
                                                existeEssaEncomenda = false; // Se ela foi excluida, essa variável será usada para futura verificação 
                                            }
                 
                                        }
                                             
                                    }while(excluirMesmo != 1 && excluirMesmo != 2);
                                    
                                }
                                else {
                                    JOptionPane.showMessageDialog(null,"Bolo não encontrado");
                                  
                                }
                                verificador = 1;
                                break;
                            
                            case 3: // EDITAR BOLO 

// INICIO DE -> EDITAR BOLO DA EDIÇÃO DE ENCOMENDA -----------INICIO DE -> EDITAR BOLO DA EDIÇÃO DE ENCOMENDA --------                                

                                int codDoBoloEditar = Integer.parseInt(JOptionPane.showInputDialog
                                ("Digite o código do bolo que deseja editar."));
                                Bolo bEditar = encomendaEncontradaEditar.buscarBolo(codDoBoloEditar);
                                if(bEditar != null){
                                    
                                    int controlEditBolo = 1;
                                    do{
                                        int oQueEditarEmBolo = Integer.parseInt(JOptionPane.showInputDialog
                                        ("BOLO \n" + bEditar + "\n\nO que deseja editar em Bolo?\n"
                                        + "\n1-Sabor"
                                        + "\n2-Camada Extra"
                                        + "\n3-Preço"
                                        + "\n4-Elemento Extra"));
                                                                                
                                        switch(oQueEditarEmBolo){
                                            
                                            case 1:
                                                

                                                int controlSabor;
                                                do{
                                                    int sabor = Integer.parseInt(JOptionPane.showInputDialog // Escolhendo o sabor do Bolo
                                                                ("Sabor Atual: " + bEditar.getSabor().getNome() 
                                                                + "\n\nSelecione o sabor:\n"
                                                                + "1-Chocolate\n"
                                                                + "2-Laranja\n"
                                                                + "3-Limão\n"));

                                                    switch(sabor){
                                                        case 1:
                                                            bEditar.setSabor(chocolate);
                                                            controlSabor = 1;
                                                            break;
                                                        case 2:
                                                            bEditar.setSabor(laranja);
                                                            controlSabor = 1;
                                                            break;
                                                        case 3:
                                                            bEditar.setSabor(limao);
                                                            controlSabor = 1;
                                                            break;
                                                        default:
                                                            JOptionPane.showMessageDialog(null,"Opção Inválida. Digite uma opção válida.");
                                                            controlSabor = 0;
                                                    }
                                                }while(controlSabor == 0);
                                                JOptionPane.showMessageDialog(null,"Novo sabor: " + bEditar.getSabor().getNome());

                                                controlEditBolo = 1;
                                                break;
                                                
                                            case 2: // EDITANDO A CAMADA EXTRA
     
                                                if(bEditar.isCamadaExtra()){ // Se há camada devemos retirar 
                                                    
                                                    int retirar;
                                                    
                                                    
                                                    do{
                                                        retirar = Integer.parseInt(JOptionPane.showInputDialog(null,"Este bolo já tem camada extra.\n"
                                                                                    + "\nValor atual do bolo: " + bEditar.getPreco() // Mostrando ao usuário o preço atual 
                                                                                    + "\nValor sem a camada extra: " 
                                                                                    + bEditar.calcularPrecoBoloComDecremento() // Mostrando ao usuário qual será o preço se a camada for retirada 
                                                                                    + "\nDeseja retirar a camada extra?"
                                                                                    + "\n1-Sim"
                                                                                    + "\n2-Não"));
                             
                                                        if(retirar == 1){
                                                            bEditar.decrementarCamada(); // Retirando camada
                                                            JOptionPane.showMessageDialog(null,"Camada retirada."
                                                                        + "Novo preço: " + bEditar.getPreco()); // Exibindo o novo preço
                                                        }
                                                        else if(retirar == 2){
                                                            JOptionPane.showMessageDialog(null,"A camada não foi retirada.");    
                                                        }
                                                        else {
                                                            JOptionPane.showMessageDialog(null,"Opção inválida."
                                                                    + "\nEscolha uma opção válida.");
                                                        }
                                                    }while(retirar != 1 && retirar != 2);
                                                    
                                                }else{ // Se não há camada devemos incrementar 
                                                    
                                                    int incrementar;
                                                    
                                                    do{
                                                    
                                                        incrementar = Integer.parseInt(JOptionPane.showInputDialog(null,"Este bolo não tem camada extra.\n"
                                                                                    + "\nValor atual do bolo: " + bEditar.getPreco() 
                                                                                    + "\nValor com a camada extra: " 
                                                                                    + bEditar.calcularPrecoBoloComIncremento()
                                                                                    + "\nDeseja incrementar a camada extra?"
                                                                                    + "\n1-Sim"
                                                                                    + "\n2-Não"));
                                                        
                                                        if(incrementar == 1){
                                                            bEditar.incrementarCamada(); // Incrementando camada
                                                            JOptionPane.showMessageDialog(null,"Camada inserida."
                                                                    + "Novo preço: " + bEditar.getPreco());
                                                        }
                                                        if(incrementar == 2){
                                                            JOptionPane.showMessageDialog(null,"A camada não foi inserida.");
                                                        }
                                                        if(incrementar != 1 && incrementar != 2){
                                                            JOptionPane.showMessageDialog(null,"Opção inválida."
                                                                    + "\nEscolha uma opção válida.");
                                                        }
                                                    
                                                    }while(incrementar != 1 && incrementar != 2);
                                                    
                                                }
                                                controlEditBolo = 1;
                                                break;
                                            case 3:
                                                
                                                double novoPreco = Double.parseDouble(JOptionPane.showInputDialog(null,"Preço atual: " 
                                                        + bEditar.getPreco() + "\nDigite o novo preço (Sem considerar camada adicional)"));
                                                // para mudar o preço de um bolo temos que implemetar as seguintes operações 
                                                bEditar.setPreco(novoPreco);
                                                if(bEditar.isCamadaExtra()) { // Se o bolo tiver camada extra, seu atributo camadaExtra será "true", então devemos: 
                                                    bEditar.mudarStatusCamadaExtra(); // mudar esse estatus para false
                                                    bEditar.setPreco(novoPreco); // inserir o novo preço do bolo sem camada 
                                                    bEditar.incrementarCamada(); // incrementar a camada para que ele reclacule o preço a passe o camadaExtra para "true"
                                                    JOptionPane.showMessageDialog(null,"Este bolo contém camada extra."
                                                            + "\nEntão seu valor fica R$" + bEditar.calcularPrecoBoloComIncremento());
                                                
                                                }else{ // Se o bolo tiver camada extra, seu atributo camadaExtra será "false", então devemos: 
                                                    bEditar.setPreco(novoPreco); // apenas inserir o novo preço
                                                    JOptionPane.showMessageDialog(null,"Este bolo não contém camada extra."
                                                            + "\nEntão seu valor permanece R$" + bEditar.calcularPrecoBoloComIncremento());
                                                }
                                                controlEditBolo = 1;
                                                break;
                                            
                                            case 4:  // EDITAR ADEREÇO: COBERTURA, RECHEIO OU PEDAÇOS
 ////////////SUPER TESTE//////////////////////SUPER TESTE//////////////////////SUPER TESTE//////////////////////                                               
                                                if (bEditar instanceof BoloNormal){ /* verifica se é uma instancia do bolo Normal: 
                                                                                     se sim, edito a cobertura */
                                                    BoloNormal bEditarNormal = (BoloNormal)bEditar;
                                                    
                                                    int cobertura;
                                                    
                                                    int verBoloNormal = 1;
                                                    do{
                                                        cobertura = Integer.parseInt(JOptionPane.showInputDialog
                                                        ("Cobertura atual: " + bEditarNormal.getCobertura().getNome()
                                                                + "\nSelecione a cobertura:"
                                                                + "\n1-Café com Leite"
                                                                + "\n2-Noite de Gala"
                                                                + "\n3-Terra do Nunca" )); //Escolhendo a cobertura

                                                        if(cobertura == 1){
                                                            bEditarNormal.setCobertura(cCafeComLeite);
                                                            JOptionPane.showMessageDialog(null,"Cobertura CAFÉ COM LEITE adicionada.");
                                                            verBoloNormal = 1;
                                                        }
                                                        else if(cobertura == 2){
                                                            bEditarNormal.setCobertura(cNoiteDeGala);
                                                            JOptionPane.showMessageDialog(null,"Cobertura NOITE DE GALA adicionada.");
                                                            verBoloNormal = 1;
                                                        }
                                                        else if(cobertura == 3){    
                                                            bEditarNormal.setCobertura(cTerraDoNunca);
                                                            JOptionPane.showMessageDialog(null,"Cobertura TERRA DO NUNCA adicionada.");
                                                            verBoloNormal = 1;
                                                        }
                                                        else {
                                                            verBoloNormal = 0;
                                                            JOptionPane.showMessageDialog(null,"Opção Inválida. Digite uma opção válida.");
                                                        }
                                                    }while(verBoloNormal == 0);

                                                    bEditar = bEditarNormal;
                                                    
                                                    
                                                    
                                                }else if(bEditar instanceof BoloTorta){ /* verifica se é uma instancia do bolo Torta: 
                                                                                     se sim, edito o recheio */
                                                    BoloTorta bEditarTorta = (BoloTorta)bEditar;
                                                    
                                                    int verBoloTorta = 1;
                                                    do{
                                                    int recheio = Integer.parseInt(JOptionPane.showInputDialog
                                                    ("Recheio atual: " + bEditarTorta.getRecheio().getNome()
                                                            + "\nSelecione o Recheio:"
                                                            + "\n1-Black and White"
                                                            + "\n2-Noite Feliz"
                                                            + "\n3-Soft Brown" ));

                                                    if(recheio == 1){ 
                                                        bEditarTorta.setRecheio(rBlackAndWhite);
                                                        JOptionPane.showMessageDialog(null,"Recheio BLACK AND WHITE adicionado.");
                                                        verBoloTorta = 1;
                                                        }else if(recheio == 2){
                                                            bEditarTorta.setRecheio(rNoiteFeliz);
                                                            JOptionPane.showMessageDialog(null,"Recheio NOITE FELIZ adicionado.");
                                                            verBoloTorta = 1;
                                                        }
                                                        else if(recheio == 3){   
                                                            bEditarTorta.setRecheio(rSoftBrown);
                                                            JOptionPane.showMessageDialog(null,"Recheio SOFT BROWN adicionado.");
                                                            verBoloTorta = 1;
                                                        }
                                                        else {
                                                            verBoloTorta = 0;
                                                            JOptionPane.showMessageDialog(null,"Opção Inválida. Digite uma opção válida.");
                                                        }
                                                    }while(verBoloTorta == 0);

                                                    bEditar = bEditarTorta;
 
                                                }else if(bEditar instanceof BoloVegano){ /* verifica se é uma instancia do bolo Normal: 
                                                                                     se sim, edito os pedazos */
                                                   
                                                    BoloVegano bEditarVegano = (BoloVegano)bEditar;
                                                    
                                                    int verBoloVegano = 1;
                                                    do{
                                                        int pedacos = Integer.parseInt(JOptionPane.showInputDialog
                                                        ("Pedaços atual: " + bEditarVegano.getPedacos().getNome()
                                                                + "\nSelecione o tipo de pedaços:"
                                                                + "\n1-Chocolate"
                                                                + "\n2-Canela"
                                                                + "\n3-Morango" ));

                                                        if(pedacos == 1){                                                       
                                                            bEditarVegano.setPedacos(pChocolate);
                                                            JOptionPane.showMessageDialog(null,"Adicionado pedaços de CHOCOLATE.");
                                                            verBoloVegano = 1;
                                                        }
                                                        else if(pedacos == 2){
                                                            bEditarVegano.setPedacos(pCanela);
                                                            JOptionPane.showMessageDialog(null,"Adicionado pedaços de CANELA.");
                                                            verBoloVegano = 1;
                                                        }
                                                        else if(pedacos == 3){    
                                                            bEditarVegano.setPedacos(pMorango);
                                                            JOptionPane.showMessageDialog(null,"Adicionado pedaços de MORANGO.");
                                                            verBoloVegano = 1;
                                                        }
                                                        else {
                                                            verBoloVegano = 0;
                                                            JOptionPane.showMessageDialog(null,"Opção Inválida. Digite uma opção válida.");
                                                        }

                                                    }while(verBoloVegano == 0);

                                                    
                                                    bEditar = bEditarVegano;
                                                    
                                                }
                                                controlEditBolo = 1;    
                                                break;    
                                                
                                                
                                            default:
                                                JOptionPane.showMessageDialog(null,"Opção Inválida. Digite uma opção válida.");
                                                controlEditBolo = 0;     
                                        }
                                        
                                        if(controlEditBolo == 1){
                                        
                                            int continuar;
                                            do{
                                                continuar = Integer.parseInt(JOptionPane.showInputDialog("Deseja continuar editando este bolo?"
                                                        + "\n1-Sim"
                                                        + "\n2-Não"));
                                                if (continuar != 1 && continuar != 2)
                                                    JOptionPane.showMessageDialog(null,"Opção inválida"
                                                            + "\nPor favor escolha 1 ou 2");
                                                else if (continuar == 1) controlEditBolo = 0; // Se sim 'controlEditBolo' recebe Zero para não sair do laço
                                                else if (continuar == 2) controlEditBolo = 1; // Se não'controlEditBolo' recebe 1 para sair do laço
                                            
                                            }while(continuar != 1 && continuar != 2);
                                            
                                            
                                        }

                                    }while(controlEditBolo == 0);
                                    
                                }
                                else 
                                    JOptionPane.showMessageDialog(null,"Bolo não encontrado");
                                
                                verificador = 1;
                                break;
 // FIM DE -> EDITAR BOLO DA EDIÇÃO DE ENCOMENDA -----------FIM DE -> EDITAR BOLO DA EDIÇÃO DE ENCOMENDA --------------------------------                                

                            default:
                                JOptionPane.showMessageDialog(null,"Opção Inválida. Digite um número válido.");
                                verificador = 0;
                                
                        } // FIM DE -> SWITCH "INSERIR BOLO" "EXCLUIR BOLO" "EDITAR BOLO"
 //------- INICIO DE -> VERIFICANDO SE DESEJA CONTINUAR EDITANDO A LISTA DE BOLOS DA ENCOMENDA EM EDIÇÃO                      
                        if(verificador == 1){
                            
                            
                            if(existeEssaEncomenda == true){ /* é necessário fazer esse teste pois a 
                                encomenda pode ter sido excluida se o último bolo dela foi excluido
                                então não tem como continuar editando ela*/
                         
                                int continuar;   
                                do{   
                                    continuar = Integer.parseInt(JOptionPane.showInputDialog
                                    ("Continuar editando lista de bolos dessa encomenda?\n"
                                    + "1-Sim\n"
                                    + "2-Não\n"));

                                    if(continuar == 1) verificador = 0;
                                    if(continuar == 2) verificador = 1;
                                    if(continuar!=1 && continuar !=2) JOptionPane.showMessageDialog(null,"Opção inválida. Escolha 1 ou 2");    

                                }while(continuar!=1 && continuar !=2);
                            }
                        }
//------- FIM DE -> VERIFICANDO SE DESEJA CONTINUAR EDITANDO A LISTA DE BOLOS DA ENCOMENDA EM EDIÇÃO                        
 
                        }while(verificador == 0);
                  
                    x = 1;
                    break;
                    default:
                        JOptionPane.showMessageDialog(null,"Opção inválida. Escolha 1 ou 2");    
                        x = 0;   
                    }
                
                if(existeEssaEncomenda == false) x = 1; // Senão existe mais encomenda o x recebe 1 pra sair do laço
                else if(existeEssaEncomenda == true && x==1){
                    int continuar;
                    do{
                        continuar = Integer.parseInt(JOptionPane.showInputDialog
                        ("Continuar editando essa encomenda?"
                                + "\n1-Sim"
                                + "\n2-Não"));
                        if(continuar == 1) x = 0;
                        if(continuar == 2) x = 1;
                        if(continuar!=1 && continuar !=2) 
                            JOptionPane.showMessageDialog(null,"Opção inválida. Escolha 1 ou 2");
                    }while(continuar != 1 && continuar != 2);
                }
   
            }while(x == 0);

            } 
            break;
      
            
        case 4:  // VER LISTA DE ENCOMENDAS
            
            ArrayList <Object> lista = ecmDAO.pesquisar();
            if(!lista.isEmpty()) /*Verificação um tanto desnecessária, pois se a lista de encomendas estiver 
                vazia o programa não dará ao usuário a opção "ver lista de encomendas", mas enfim... 
                por uma medida se segurança caso seja mudada a programação inicial*/
                JOptionPane.showMessageDialog(null,"ENCOMENDAS\n" + ecmDAO.pesquisar());
            else 
                JOptionPane.showMessageDialog(null,"A lista de encomendas está vazia");
            break;
        case 5:  
            int encomendaParaPesquisar = Integer.parseInt(JOptionPane.showInputDialog
            ("Código da encomenda que deseja pesquisar:\n"));
            Object bolo = ecmDAO.buscarEncomenda(encomendaParaPesquisar);
            if (bolo != null)
                JOptionPane.showMessageDialog(null,"ENCOMENDA\n" + ecmDAO.buscarEncomenda(encomendaParaPesquisar));
            else 
                JOptionPane.showMessageDialog(null,"Encomenda não encontrada.\n");
            break;
        case 0: // SAIR
            JOptionPane.showMessageDialog(null,"Saindo...");
            break;
        default:
            JOptionPane.showMessageDialog(null,"Opção Inválida. Digite uma opção válida.");
            
    }
    
    } while (codOperacao != 0);
              
  //-FIM DO DO-WHILE      
   
    }//Fim main
}//Fim TestaReceitas


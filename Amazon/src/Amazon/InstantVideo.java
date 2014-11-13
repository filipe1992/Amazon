/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Amazon;
import Produtos.Filmes;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author ELIETE
 */
public final class InstantVideo extends Amazon {
    protected enum Tipodenegocio {ALUGAR , COMPRAR, INDEFINIDOO};
    
    protected Tipodenegocio negocio;
    protected static ArrayList<Filmes> filmes;
    protected ArrayList<Filmes> filmesalugados;
    protected ArrayList<Filmes> filmescomprados;

    public InstantVideo(ArrayList<Filmes> filmes, ArrayList<Filmes> filmesalugados) {
        super();
        setNegocio();
        InstantVideo.filmes = filmes;
        this.filmesalugados = filmesalugados;
    }

    public InstantVideo() {
        super();
        this.negocio= Tipodenegocio.INDEFINIDOO;
        InstantVideo.filmes = new ArrayList<>();
        this.filmesalugados= new ArrayList<>(3);
        this.filmescomprados = new ArrayList<>();
    }

    public Tipodenegocio getNegocio() {
        return negocio;
    }

    public final void setNegocio() {
        System.out.println(this.lema);//chamada de uma variarel da super classe na subcasse
        Scanner in = new Scanner(System.in);
        int escolha;
        do{
            System.out.println("digite o tipo de compra");
            System.out.println("\n1- Alugar\n2- Comprar");
            escolha=in.nextInt();
            switch(escolha){
                case 1:
                    this.negocio = Tipodenegocio.ALUGAR;
                    break;
                case 2:
                    this.negocio = Tipodenegocio.COMPRAR;
                    break;
                default:
                    System.out.println("digite um valor valido!!");
            }
        }while(escolha < 1 && escolha > 2);
    }

    public ArrayList<Filmes> getFilmes() {
        return filmes;
    }

    public void setFilmes(ArrayList<Filmes> filmes) {
        InstantVideo.filmes = filmes;
    }
   
    private boolean verificar(Filmes filme){
        System.out.println(this.lema);//chamada de uma variarel da super classe na subcasse
        Scanner in = new Scanner(System.in);
        if (InstantVideo.filmes.contains(filme)){
            System.out.println("você ja possui esse Filme!!");
            return true;
        }else if (this.filmesalugados.contains(filme)){
            System.out.println("Voce alugou este filme!!");
            System.out.println("deseja Compra-lo[Y/N]: ");
            String val = in.next();
            if (val.equalsIgnoreCase("Y"))
                comprar(InstantVideo.filmes.indexOf(filme));
            
            return true;
        }else 
            return false;
        }
 
    
    private void mostrar(){
        super.detalhes();
        for (int i = 0; i < InstantVideo.filmes.size(); i++) {
            System.out.println("codigo: "+i);
            InstantVideo.filmes.get(i).detalhes();
        }
    }
    
    private void add(){
        System.out.println(this.lema);//chamada de uma variarel da super classe na subcasse
        Scanner in = new Scanner(System.in);
        System.out.println("digite o nome do Filme: ");
        String nome = in.next();
        System.out.println("Digite o preço: ");
        float preco = in.nextFloat();
        System.out.println("Digite o numero de duração: ");
        int duracao = in.nextInt();
        Filmes filme = new Filmes(preco,nome,duracao);
        
        if (InstantVideo.filmes.add(filme)){
            System.out.println("LIVRO ADCIONADO COM SUCESSO!!!");
            InstantVideo.filmes.get(this.filmes.size()).detalhes();
        }else
            System.out.println("LIVRO << NÃO >> ADCIONADO!!!");   
        InstantVideo.filmes.add(filme);
    }
    
    public void alugar(){
        System.out.println(this.lema);//chamada de uma variarel da super classe na subcasse
        Scanner in =new Scanner(System.in);
        mostrar();
        System.out.println("digite o codigo do filme a ser alugado");
        int codigo = in.nextInt();
        this.filmesalugados.add(InstantVideo.filmes.get(codigo));
    }
    
    public void comprar(){
        System.out.println(this.lema);//chamada de uma variarel da super classe na subcasse
        Scanner in =new Scanner(System.in);
        mostrar();
        System.out.println("digite o codigo do filme: ");
        int codigo = in.nextInt();
        if (this.verificar(InstantVideo.filmes.get(codigo)))
            this.filmescomprados.add(InstantVideo.filmes.get(codigo));        
    }
    
    public void comprar(int i){
        this.filmescomprados.add(InstantVideo.filmes.get(i));
    }
    
    @Override
    public void menu(){
        System.out.println(this.lema);//chamada de uma variarel da super classe na subcasse
        Scanner in = new Scanner(System.in);
        int escolha;
        do{
            System.out.println("###########MENU-filme%%%%%%%%%%%\n1- Alugar \n2- comprar \n3- Adicionar\n4- Sair ");
            escolha = in.nextInt();
            
            switch(escolha){
                case 1:
                    this.alugar();
                    break;
                case 2:
                    this.comprar();
                    break;
                case 3:
                    this.add();
                    break;
                case 4:
                    System.out.println("ate logo...");
                    break;
                default:
                    System.out.println("Digite um valor valido");
            }
             super.menu();
        }while(escolha != 4);
    }
    
}

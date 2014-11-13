/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Amazon;
import Produtos.Livros;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ELIETE
 */
public final class LojaOnline extends Amazon {
    
    public enum Tipodecompra { BOLETO_BAMCARIO, CARTAO_DE_CREDITO };
   
    protected Tipodecompra formadepagamento;
    protected static int quantidadedelivros = 0;
    protected int livrosccomprados;
    protected ArrayList<Livros> livros;

    public LojaOnline(int tamanhoinicial) {
        super();
        setFormadepagamento();
        setLivros(tamanhoinicial);
        setLivrosccomprados(0);
    }
    
    public LojaOnline(){
        super();
        this.formadepagamento=Tipodecompra.CARTAO_DE_CREDITO;
        setLivros(1);
        setLivrosccomprados(0);
    }
    
    public Tipodecompra getFormadepagamento() {
        return formadepagamento;
    }

    public void setFormadepagamento() {
        Scanner in =new Scanner(System.in);
        int escolha;       
        System.out.println("ESCOLHA FORMA DE PAGAMENTO: ");
        do{
            System.out.println("1- BOLETO BANCARIO\n2- CARTÃO DE CRÉDITO");
            escolha = in.nextInt();
            switch(escolha){
                case 1:
                    this.formadepagamento=Tipodecompra.BOLETO_BAMCARIO;
                    break;
                case 2:
                    this.formadepagamento=Tipodecompra.CARTAO_DE_CREDITO;
                    break;
                default :
                    System.out.println("Digite um valor valido");
            }
        }while(escolha < 4 || escolha < 1);
    }

    public static int getQuantidadedelivros() {
        return quantidadedelivros;
    }

    public static void setQuantidadedelivros(int quantidadedelivros) {
        LojaOnline.quantidadedelivros = quantidadedelivros;
    }

    public ArrayList getLivros() {
        return livros;
    }

    public void setLivros(int tamanhoinicial) {
        if (tamanhoinicial > 0)
            this.livros = new ArrayList<>(tamanhoinicial);
        else
            this.livros = new ArrayList<>(tamanhoinicial);
    }

    public int getLivrosccomprados() {
        return livrosccomprados;
    }

    public void setLivrosccomprados(int livrosccomprados) {
        this.livrosccomprados = livrosccomprados;
    }
    
    public void addLivro(){
        System.out.println(this.lema);//chamada de uma variarel da super classe na subcasse
        Scanner in = new Scanner(System.in);
        System.out.println("digite o nome do livro: ");
        String nome = in.next();
        System.out.println("Digite o numero de paginas: ");
        int numerodepaginas = in.nextInt();
        System.out.println("Digite o numero de exemplares: ");
        int exemplatres = in.nextInt();
        System.out.println("Digite o preço: ");
        float preco = in.nextFloat();
        Livros livro = new Livros(preco,nome,numerodepaginas,exemplatres);
        
        if (this.livros.add(livro)){
            System.out.println("LIVRO ADCIONADO COM SUCESSO!!!");
            this.livros.get(this.livros.size()-1).detalhes();
            quantidadedelivros++;
        }else
            System.out.println("LIVRO << NÃO >> ADCIONADO!!!");        
    }
    
    public void atualizarLivro(){
        System.out.println(this.lema);//chamada de uma variarel da super classe na subcasse
        Livros livro = this.livros.remove(codigo());
        livro.atualizar();
        this.livros.add(livro);
    }
    
    public void mostrarLivros(){
        System.out.println(this.lema);//chamada de uma variarel da super classe na subcasse
        if (this.livros.isEmpty())
            System.out.println("A lista esta vazia");
        else
            for (Livros iterador : this.livros){
                System.out.println();
                iterador.detalhes();
                System.out.println();
            }  
    }
    
    private int codigo(){
        System.out.println(this.lema);//chamada de uma variarel da super classe na subcasse
        for (int i = 0; i < this.livros.size(); i++) {
            System.out.println("-------codigo do livro: "+i+"-------");
            this.livros.get(i).detalhes();
        }
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o codigo do livro: ");
        int codigo = in.nextInt();
        return codigo;
    }
    
    public void Comprar(){
        Livros livro = this.livros.remove(codigo());
        livro.comprarlivro();
        this.livros.add(livro);
        
    }
    
    private int totalDeExemplares(){
        int total = 0;
        for (Livros livro : this.livros) {
            total += livro.getNumerodeexemplares();
        }
        return total;
    }
    
    @Override
    public void detalhes(){
        super.detalhes();
        System.out.println("-------Loja Online-------");
        System.out.println("voce escolheu pagar com: "+this.formadepagamento.name()+".");
        System.out.println("voce ja comprou: "+this.livrosccomprados+" livros.");
        System.out.println("a loja possui: "+quantidadedelivros+" Livros diferemtes.");
        System.out.println("E um total de: "+totalDeExemplares());    
    }
    @Override
    public void menu(){
        Scanner in = new Scanner(System.in);
        int escolha;
        do{
            System.out.println("###########MENU-livros%%%%%%%%%%%\n1- Comprar \n2- Atualizar \n3- Adicionar \n4- Ver detahees\n5- sair");
            escolha = in.nextInt();
            
            switch(escolha){
                case 1:
                    this.Comprar();
                    break;
                case 2:
                    this.atualizarLivro();
                    break;
                case 3:
                    this.addLivro();
                    break;
                case 4:
                    this.detalhes();
                    break;
                case 5:
                    System.out.println("ate logo...");
                    break;
                default:
                    System.out.println("Digite um valor valido");
            }
            super.menu();
            
        }while(escolha != 5);
    }
}

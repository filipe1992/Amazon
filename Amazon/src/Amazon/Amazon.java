/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Amazon;
import java.util.Scanner;

/**
 *
 * @author ELIETE
 */
public class Amazon {
    //declaração da classe NOTA
    protected enum Nota { Ruim, Bom, Excelente, Indefinida};
    
    protected final static String CNPJ = "15.436.940/0001-03";
    protected final String lema = "A Amazon é uma empresa seríssima";
    protected Nota satisfacaodocliente;
    
    public Amazon(){
        this.satisfacaodocliente = Nota.Indefinida;
    }

    public Amazon(Nota satisfacaodocliente) {
        this.satisfacaodocliente=satisfacaodocliente;
    }

    public Nota getSatisfacaodocliente() {
        return satisfacaodocliente;
    }

    public void setSatisfacaodocliente() {
        Scanner in = new Scanner(System.in);
        int escolha;
        do{
            System.out.println("digite sua satisfação com nossos sistemas");
            System.out.println("\n1- Ruim\n2- Bom\n3- Exelente");
            escolha=in.nextInt();
            switch(escolha){
                case 1:
                    this.satisfacaodocliente = Nota.Ruim;
                    break;
                case 2:
                    this.satisfacaodocliente = Nota.Bom;
                    break;
                case 3:
                    this.satisfacaodocliente = Nota.Excelente;
                    break;
                default:
                    System.out.println("digite um valor valido!!");
            }
        }while(escolha < 1 && escolha > 3);
    }
    
    public void detalhes(){
        System.out.println("##############AMAZOM.COM##############");
        System.out.println(this.lema);
        System.out.println("com o CNPJ: "+CNPJ);
        System.out.println("E com a nota definida por você: "+this.satisfacaodocliente.name());
    }
    
    public void menu(){  
        
        Scanner in = new Scanner(System.in);
        int escolha;
        do{
            System.out.println("###########MENU%%%%%%%%%%%\n1- Dê uma nota para o nosso serviço: \n2- Ve detalhes\n3- sair ");
            escolha = in.nextInt();
            
            switch(escolha){
                case 1:
                    this.darNota();
                    break;
                case 2:
                    this.detalhes();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Digite um valor valido");
            }
            
        }while(escolha != 3);
        
    }
    
    public void darNota(){
        System.out.println(this.lema);
        Scanner in = new Scanner(System.in);
        int escolha;
        System.out.println("digite um valor de 1 a 3 para nota do serviço:");
        do{
        System.out.println("onde:\n1- RUIM\n2- BOM\n3- EXCELENTE");          
        escolha = in.nextInt();    
            switch(escolha){
                case 1:
                    this.satisfacaodocliente=Nota.Ruim;
                    break;
                case 2:
                    this.satisfacaodocliente=Nota.Bom;
                    break;
                case 3:
                    this.satisfacaodocliente=Nota.Excelente;
                    break;
                default:
                    System.out.println("Digite um valor valido!!!!");
            }
        }while(escolha < 0 || escolha > 5);
    }

}

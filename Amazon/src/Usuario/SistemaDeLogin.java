/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import Amazon.Amazon;
import Amazon.InstantVideo;
import Amazon.LojaOnline;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ELIETE
 */
public class SistemaDeLogin {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Amazon> amazon;
    private static int numerodecadastros=0;

    public SistemaDeLogin() {
        this.usuarios = new ArrayList<>();
        this.amazon = new ArrayList<>();
    }

    public SistemaDeLogin(ArrayList<Usuario> usuarios, ArrayList<Amazon> amazon) {
        this.usuarios = usuarios;
        this.amazon = amazon;
    }
        
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Amazon> getAmazon() {
        return amazon;
    }

    public void setAmazon(ArrayList<Amazon> amazon) {
        this.amazon = amazon;
    }
    
    public void fazerLogin(){
        Scanner in = new Scanner(System.in);
        byte valor=0;
        System.out.println("digite seu login: ");
        String login = in.next();
        System.out.println("digite sua senha: ");
        String senha = in.next();
        if (!this.amazon.isEmpty()){
            for (int i = 0; i < numerodecadastros; i++) {
               if (this.usuarios.get(i).getLogin().equals(login)) {
                    if (this.usuarios.get(i).getSenha().equals(senha)){
                        System.out.println("accesso permitido");

                        this.amazon.get(i).menu();// acessar o menu da classe concreta escolida no momento do cadastro;

                        break;
                    }else
                        valor=1;
                }else 
                   valor=2;
            }
        }else
             valor=3;
        if (valor == 1)
            System.out.println("Senha incorreta!!");
        else if (valor == 2)
            System.out.println("Usuario inexistente!!");
        else if (valor == 3)
            System.out.println("não ha ninguém cadastrado !!");
    }
    
    public static void cadastrar(SistemaDeLogin sistema ,Usuario usuario){
        int escolha;
        Amazon amazon;
        Scanner in = new Scanner(System.in);
        if (sistema.usuarios.contains(usuario)){
            System.out.println("Este usuario já existe!!!");
        }else{
            do{
                System.out.println("voce deseja usar qual servico da amazon: \n1-loja de livros \n2-loja de filmes");
                escolha = in.nextInt();
            }while (escolha!=1 && escolha!=2);
            if (escolha==1)
                amazon = new LojaOnline();
            else
                amazon = new InstantVideo();
            
            sistema.usuarios.add(sistema.usuarios.size(), usuario);
            sistema.amazon.add(sistema.amazon.size(), amazon);
            System.out.println("o usuario: "+usuario.getNome()+" foi cadastrado!!!");
            numerodecadastros++;
        }
    }
    
    public static void deletar(SistemaDeLogin sistema){
        Scanner in= new Scanner(System.in);
        int posicao=-1;
        do{
            System.out.println("Digire o login: ");
            String login = in.next();
            System.out.println("Digite a senha");
            String senha =in.next();
            for (int i = 0; i < numerodecadastros; i++) {
               if (sistema.usuarios.get(i).getLogin().equals(login)){
                   if (sistema.usuarios.get(i).getSenha().equals(senha)){
                       System.out.println("accesso permitido");
                       posicao=i;
                       break;
                   }else
                       System.out.println("Senha incorreta!!");
                }else
                    System.out.println("Usuario inexitente");
            }
    }while (posicao!=-1);
        //remove
        sistema.usuarios.remove(posicao);
        sistema.amazon.remove(posicao);
        System.out.println("Usuario removido com sucesso!!");
        
    } 
    
    public static void menu(SistemaDeLogin sistema){
        Scanner in = new Scanner(System.in);
        int escolha;
        do{
            System.out.println("##############MENU###############\n1- Para fazer login\n2- Para fazer seu cadastro \n3- Para deletar usuario:");
            escolha =in.nextInt();
            switch(escolha){
                case 1:
                    sistema.fazerLogin();
                    break;
                case 2:
                    Usuario usuario = new Usuario();
                    usuario.Cadastrar();
                    cadastrar(sistema, usuario);
                    break;
                case 3:
                    deletar(sistema);
                    break;
                default:
                    System.out.println("Digite um valor valido");
            }
        }while (escolha>3 && escolha<1);
    }
}

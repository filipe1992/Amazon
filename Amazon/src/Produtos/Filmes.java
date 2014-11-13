/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Produtos;

import java.util.Scanner;

/**
 *
 * @author ELIETE
 */
public class Filmes {
    
    protected enum Genero {ROMANCE,AVENTURA,FICCAO_CIENTIFICA,OUTROS};
    
    private float preco;
    private String nome;
    private Genero tiposdeflme;
    private float duracao;

    public Filmes() {
        this.preco = 00;
        this.nome = "Sem nome";
        this.tiposdeflme = Genero.OUTROS;
        this.duracao = 0;
    }

    public Filmes(float preco, String nome, int duracao) {
        setPreco(preco);
        setNome(nome);
        setTiposdeflme();
        setDuracao(duracao);
    }

    public float getPreco() {
        return preco;
    }

    public final void setPreco(float preco) {
        if (preco < 0){
            this.preco=0;
        }else
            this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public final void setNome(String nome) {
        this.nome = nome;
    }

    public Genero getTiposdeflme() {
        return tiposdeflme;
    }

    public final void setTiposdeflme() {
        Scanner in =new Scanner(System.in);
        int escolha;       
        System.out.println("ESCOLHA O GENERO DE FILME: ");
        do{
            System.out.println("1- ROMANCE\n2- AVENTURA\n3FICCAO_CIENTIFICA");
            escolha = in.nextInt();
            switch(escolha){
                case 1:
                    this.tiposdeflme=Genero.ROMANCE;
                    break;
                case 2:
                    this.tiposdeflme=Genero.AVENTURA;
                    break;
                case 3:
                    this.tiposdeflme=Genero.FICCAO_CIENTIFICA;
                    break;
                case 4:
                    this.tiposdeflme=Genero.OUTROS;
                    break;
                default :
                    System.out.println("Digite um valor valido");
            }
        }while(escolha < 4 || escolha < 1);
    }

    public float getDuracao() {
        return duracao;
    }

    public final void setDuracao(float duracao) {
        if (duracao > 0)
            this.duracao = duracao;
        else
            this.duracao=1;
    }
    
    //funções ulteis
    public final void detalhes(){
        System.out.println("################## "+this.nome+" ##################");
        System.out.println("com: "+this.duracao+" minutos de duração.");
        System.out.println("do genero: "+this.tiposdeflme.name()+".");
        System.out.println("com: "+this.preco+" exemplares no estoque");
    }
}
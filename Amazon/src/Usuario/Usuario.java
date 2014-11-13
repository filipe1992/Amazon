/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author ELIETE
 */
public final class Usuario {
    private String nome;
    private String endereco;
    private String login,senha;

    public Usuario(String nome, String login,String senha,String endereco) {
        setNome(nome);
        setLogin(login);
        setSenha(senha);
        this.endereco = endereco;
    }

    public Usuario() {
        setNome("desconhecido");
        setLogin("sem nome");
        setSenha("");
        this.endereco = " ";
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String Loguin) {
        this.login = Loguin;
    }
    
    public void Cadastrar(){
        Scanner in = new Scanner(System.in);
        System.out.println("digite seu nome: ");
        String nome = in.next();
        System.out.println("digite seu endereço ");
        String endereco = in.next();
        System.out.println("digite seu digite seu login: ");
        String login = in.next();
        System.out.println("digite sua senha: ");
        String senha = in.next();
        setEndereco(endereco);
        setLogin(login);
        setNome(nome);
        setSenha(senha);
    }

    public boolean equals(Usuario obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        return true;
    }   
}

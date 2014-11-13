/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;


import Amazon.*;
import Produtos.*;
import Usuario.*;
import java.util.Scanner;
/**
 *
 * @author ELIETE
 */
public class principal {
    
    public static void main(String[] args) {
        String escolha;
        Scanner in = new Scanner(System.in);
        SistemaDeLogin sistema = new SistemaDeLogin();
        do{
            SistemaDeLogin.menu(sistema);
            
            System.out.println("deseja sair <S=sim/N=não>");
            escolha = in.next();
            if (escolha.equalsIgnoreCase("N"))
                System.out.println("Otima escolha!!\n continue a usar nossos serviços: ");
        }while (!escolha.equalsIgnoreCase("S"));
        
        
    }
    
    
}

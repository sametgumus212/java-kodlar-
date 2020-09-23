/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otomat;

import java.util.Scanner;

/**
 *
 * @author chs
 */
public class Otomat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner k=new Scanner(System.in);
        System.out.println("Stringi gir");
        String a=k.nextLine();
        String Q="q0";
        for(int i=0;i<a.length();i++){
            String D=a.substring(i,i+1);
            if(!D.equals("0")&&!D.equals("1")){
                System.out.println("yanlış karakter girdin");
            System.exit(i);
            }
            if(Q.equals("q0")){
                if(D.equals("0"))
                    Q="q0";
                else
                    Q="q1";
            }
            else if(Q.equals("q1")){
                if(D.equals("0"))
                    Q="q2";
                else
                    Q="q0";
                
            }
             else if(Q.equals("q2")){
                if(D.equals("0"))
                    Q="q1";
                else
                    Q="q2";
                
            }
        }
        if(Q.equals("q1")||Q.equals("q2")){
            System.out.println(a+"..stringi tanır");
        }
        else System.out.println(a+"  ..stringi tanımaz");
    }
    
}

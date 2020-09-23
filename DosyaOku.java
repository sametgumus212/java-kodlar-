/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dosyaoku;

import java.io.*;
import java.util.Scanner;




public class DosyaOku {

    
    public static void dosya_yaz(String str){
        try{
            File dosya = new File("A.dat");
            if(!dosya.exists()){
                System.out.println("Dosya Bulunamadı.");
            }
            else{
                
                FileWriter Fwriter = new FileWriter(dosya,false);
                BufferedWriter Bwriter = new BufferedWriter(Fwriter);    
                Bwriter.write(str);
                Bwriter.newLine();
                Bwriter.close();
                Fwriter.close();
            }
            }        
        catch(IOException e){ 
            // Dosya yazma sırasında herhangi bir hata olursa hata mesajını bildirir.
            System.out.println("Hata:");
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        
        try {
            File dosya = new File("A.dat");
            if (dosya.createNewFile()) {
                System.out.println("Dosya oluşturuldu " + dosya.getName());
            } else {
                System.out.println("Dosya Zaten Var");
            }
        } catch (IOException e) {
            System.out.println("Hata!");            
        }
        
        Scanner k = new Scanner(System.in);
        String kelime;
        
        int sayac=0;
        
        while(sayac<=20){
            
            System.out.println("Bir kelime giriniz. ");
            kelime = k.nextLine();
            
            if(kelime.charAt(0)=='a' || kelime.charAt(0)=='A'){
                sayac++;
                dosya_yaz(kelime);
            }
            
        }       
        
    }
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vy6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author group
 */
public class Vy6 {
/*public static int listesayi() throws FileNotFoundException{
    int satirsayisi=0;
    String path="D:\\tamsayi.txt";
    File f=new File(path);
    Scanner s=new Scanner(f);
    while(s.hasNextLine()){
        String ss=s.nextLine();
        satirsayisi++;
    }
    return satirsayisi;
}*/
public static Cbliste dosyaoku()throws FileNotFoundException{
  String isim="";
  int para=0;
    Dugum tmp=new Dugum(isim,para);
    Cbliste list=new Cbliste();
 // tmp=list.bas;
  String path="D:\\tamsayi.txt";
    File f=new File(path);
    Scanner s=new Scanner(f);
    while(s.hasNextLine()){
        String satir=s.nextLine();
        String [] dizim=satir.split(" ");
        int param=0;
        tmp.isim=dizim[0];
        //System.out.println(tmp.isim);
        for(int i=0;i<dizim.length;i++){
            
            if(dizim[i].endsWith("TL")){
                String spara=dizim[i];
                int a=spara.length();
                String sspara=spara.substring(0,a-2);
               //System.out.println(sspara);
                param=Integer.parseInt(sspara);
                //System.out.println(param);
            }
            else 
                tmp.para=0;
        }
        
        tmp.para=param;
        
        list.sonaekle(tmp);
        
        list.dugumgoster();
        list.bas=list.bas.ileri;
    }
  return list;
}
    public static void main(String[] args) throws FileNotFoundException {
        dosyaoku();
    }
}  
class Dugum{
    String isim;
    int para;
    Dugum ileri;
    Dugum geri;
    public Dugum(String isim,int para){
        this.isim=isim;
        this.para=para;
        ileri=null;
        geri=null;
    }
}
class Cbliste{
    Dugum bas;
    Dugum son;
    public Cbliste(){
        bas=null;
        son=null;
    }
    void basaekle(Dugum yeni){
        if(bas==null&&son==null){
            bas=yeni;
            son=yeni;
        }
        else{
            yeni.ileri=bas;
            bas.geri=yeni;
            yeni=bas;
        }
    }
    void sonaekle(Dugum yeni){
        if(bas==null){
            bas=yeni;
            son=yeni;
            }
        else{
            son.ileri=yeni;
            yeni.geri=son;           
            son=yeni;
        }
    }
    void dugumgoster(){
        System.out.println();
           
            Dugum temp = bas;
            while (temp != null) {
                 System.out.println("isim= "+bas.isim+"......para miktarı= "+bas.para);
                temp = temp.ileri;
            }
        
        
    }
    
}


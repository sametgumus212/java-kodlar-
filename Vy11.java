/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vy11;

/**
 *
 * @author chs
 */
public class Vy11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Dugum d1=new Dugum("aaa",7,55 ,60);
       Dugum d2=new Dugum("bbb",8,55 ,60);
       Dugum d3=new Dugum("ccc",6,55 ,60);
       Dugum d4=new Dugum("ddd",9,55 ,60);
       Dugum d5=new Dugum("eee",4,55 ,60);
       Dugum d6=new Dugum("fff",10,55 ,60);
       Dugum d7=new Dugum("ggg",3,55 ,60);
       Agac ac=new Agac();
       ac.ekle(d1);
       ac.ekle(d2);
       ac.ekle(d3);
       ac.ekle(d4);
       ac.ekle(d5);
       ac.ekle(d6);
       ac.ekle(d7);
       ac.inorder(d7);
    //   ac.postorder(d7);
     //  ac.preorder(d7);
       
       
       
    }
    
}
class Dugum{
    String isim;
    int no;
    int vnot;
    int fnot;
    Dugum sol;
    Dugum sag;
    int boy;
    //Dugum derinlik;
    //Dugum yukseklik;
    //Dugum derece;
    public Dugum(String isim,int no,int vnot,int fnot){
        this.isim=isim;
        this.no=no;
        this.vnot=vnot;
        this.fnot=fnot;
        sol=null;
        sag=null;
        boy=1;
    }
    void yazdir(){
        System.out.println("isim= "+isim+"numara= "+no+"vize notu= "+vnot+"final notu= "+fnot);
    }
}
class Agac{
    Dugum kok;
    public Agac(){
        kok=null;
    }
    void ekle(Dugum yeni){
        Dugum once=null;
        Dugum tmp=kok;
        while(tmp!=null){
            once=tmp;
         if(yeni.no<tmp.no){
             tmp=tmp.sol;}
         
         else{
             tmp=tmp.sag;
         }
         if(once==null)
             kok=yeni;
         else
             if(yeni.no<once.no)
                 once.sol=yeni;
             else once.sag=yeni;
        }
    }
    
    
    /////.....dolaşımlar.....////
   void inorder(Dugum tamp){
      // Dugum tmp=null;
   //  Dugum sol=kok.sol;
    //Dugum sag=kok.sag;
     if(tamp==null)
        return ;
     else{
        inorder(tamp.sol);
        tamp.yazdir();
        inorder(tamp.sag);
     
     
     }
   }
       
     
   
   void preorder(Dugum tamp){
       if(tamp==null) System.exit(0);
       tamp.yazdir();
       preorder(tamp.sol);
       preorder(tamp.sag);
   }
   void postorder(Dugum tamp){
       if(tamp==null)return;
       postorder(tamp.sol);
       postorder(tamp.sag);
       tamp.yazdir();
   }
   
   ///////////////
   int boy(Dugum aranan){
       if(aranan==null){
           return 0;
       }
       else return aranan.boy;
   }
}
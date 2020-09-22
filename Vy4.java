/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vy4;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author group
 */
public class Vy4 {
static CbListe dosyaoku() throws FileNotFoundException{
    int dizi[]=new int[200] ;
    String sd[]=new String[200];
    String isim="a";
    int para=0;
    Dugum d=new Dugum(isim,para);
    CbListe list=new CbListe();
    String path="D:\\tamsayi.txt";
    File f=new File(path);
    Scanner oku=new Scanner(f);
    System.out.println("para"+para);
    Dugum tmp=new Dugum(isim, para);
   
    int i=0;
    int sayac;
    int kelime=0,harf=0,satir=0;
    while (oku.hasNextLine()){
        satir++;
        String sat=oku.nextLine();
              System.out.println("Satır:"+sat);
    }
    String dizilim[][]=new String[satir][2];
  while(oku.hasNext()){
       String isimler = oku.next();
       
       int paralar = oku.nextInt();
       String s_paralar=Integer.toString(paralar);
       
                  dizilim[satir][0] = isimler;
                  dizilim[satir][1] = s_paralar;
                  int param=Integer.parseInt(dizilim[satir][1]);
                tmp.isim=dizilim[satir][0];
                tmp.para=param;
                //list.listeBasinaEkle(tmp);
                list.listeBasinaEkle(new Dugum(tmp.isim,tmp.para));
                //tmp=tmp.ileri;
                System.out.println("asa"+list.bas);
                list.dugumlerigez();
                satir++;
  }
  /*  while(oku.hasNextLine()){
     
      System.out.println("selam");
     // sd[i]=oku.next(); 
    // sd[i]=kelimeler[0]; 
     tmp.isim=sd[i];
      //tmp.isim=nisim;
       //System.out.println("selam");
        //...... int s=Integer.parseInt(oku.next());
      dizi[i]=s;
      tmp.para=dizi[i];
     // tmp.para=a;
      
      
        list.listeBasinaEkle(new Dugum(tmp.isim,tmp.para));
       //tmp=tmp.ileri;
        System.out.println("kelam");
        //int opara=oku.nextInt();
      // tmp.para=dizi[i];
        //System.out.println("selam");
     //   System.out.println(oku.next());
       //  System.out.println(oku.nextInt());
       //list.basaekle(tmp);
        //System.out.println(list.bas);
       
     //tmp=tmp.ileri;
    sayac=list.dugumSayisi();
        System.out.println("sayi="+sayac); 
   list.dugumlerigez();
     
   System.out.println("dizi"+dizi[i]+"ss"+sd[i]);
       i++;
    }*/
    return list;
}
public static Yigit  y1=new Yigit(3);
  public static Yigit y2=new Yigit(2);
static int yigitaekle(int bir,int iki){
 int toplam=0;
  
  int M=y1.N+y2.N;
  while(!y1.dolumu()||!y2.dolumu()){
      if(!y1.dolumu()&&y2.dolumu()){
          
          y1.ekleme(bir);
          y1.ekleme(iki);
          toplam+=y1.dizi[y1.ust]+y1.dizi[y1.ust];
          System.out.println("y2 dolu ......y1 e y2 nin elemanı eklendi"+toplam);
      
      }
      else if(y1.dolumu()&&!y2.dolumu()){
      y2.ekleme(bir);toplam+=y1.dizi[y1.ust]+y2.dizi[y2.ust];
          System.out.println("y1 dolu.......y2 ye y1 in elemanı eklendi"+toplam);
  }
      else if (y1.dolumu()&& y2.dolumu()){
          
          toplam+=y1.dizi[y1.ust]+y2.dizi[y2.ust];
          System.out.println("her ikisi dolu"+toplam);
      }
      else {
          y1.ekleme(bir);
      y2.ekleme(iki);
      toplam+=y1.dizi[y1.ust]+y2.dizi[y2.ust];
          System.out.println("heriki yığıta kendi elemanları eklendi."+toplam);
       
      }
      System.out.println("1-->"+y1.dizi[y1.ust]+"---2--->"+y2.dizi[y2.ust]);
  }
  return toplam;
 
}
public static int dizisatirsay() throws FileNotFoundException{
    String Satir="";
    int Strsayisi=0;
    String isimler;
    int paralar;
    String path="D:\\sonot.txt";
    File f=new File(path);
    Scanner oku=new Scanner(f);
    while(oku.hasNextLine()){
        System.out.println("bas"+Strsayisi);
        Satir=oku.nextLine();
        
        Strsayisi++;
    }
   
    return Strsayisi;
   
}
public static String [][] diziyeata(int Strsayisi) throws FileNotFoundException{
     String sdizi[][] =new String [Strsayisi][2];
    String path="D:\\sonot.txt";
    File f=new File(path);
    Scanner oku=new Scanner(f);
   int index=0;
    String isimler;
    //int paralar;
     while(oku.hasNextLine()){
     
            System.out.println("selem");
              isimler=oku.nextLine();
              String [] ilkisim=isimler.split(" ");
             System.out.println("selem2");
             System.out.println(ilkisim[0]);
              sdizi[index][0]=ilkisim[0];
              System.out.println("selem");
       //    String par=ilkisim.toString().con;
         int paralar=oku.nextInt();
        System.out.println("selem3");
         String sparalar=Integer.toString(paralar);
         System.out.println("selam");
        sdizi[index][1]=sparalar;
         System.out.println(sdizi[index][0]+sdizi[index][1]);
    index++;
     }
    return sdizi;
}
public static void dizigoster(String sdizim[][]){
    for(int i=0;i<sdizim.length;i++){
        for(int j=0;j<2;j++){
            System.out.println("elemanlar"+sdizim[i][j]);
        }
    }
}
    public static void main(String[] args) throws FileNotFoundException {
  //    int ss= dizisatirsay();
    //    diziyeata(ss);
    // dizigoster(diziyeata(ss));
        CbListe listem=new CbListe();
     // Dugum dd=new Dugum("ali",49);
    //  Dugum dd1=new Dugum("veli",50);
  //   listem.basaekle(dd);
//listem.basaekle(dd1);     
//.......listem=dosyaoku();
//listem.yazdir(listem);
   //....... listem.dugumlerigez(); */
 y1=new Yigit(7);    
    y2=new Yigit(2);
   /* int i,j=8,N=10;
   
   for(i=1,j=9;i<=N ;i++,j++){
        yigitaekle(i, j);
    }*/
  
       int a= yigitaekle(3, 6);
        
    //   int b= yigitaekle(9, 7);
      //  int c=yigitaekle(7, 4);
        //int d=yigitaekle(6, 5);
     // int e=  yigitaekle(2, 1);
    
   System.out.println("g");
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
    void goster(){
        System.out.println("sss"+isim+"pppp"+para);
    }
}

class CbListe{
    Dugum bas;
    Dugum son;
    CbListe(){
        bas=null;
        son=null;
    }
    void listeBasinaEkle(Dugum yeni) {
        if (son == null) {
            son = yeni;
        } else {
            bas.geri = yeni;
        }
        yeni.ileri = bas;
        bas = yeni;
    }
    void listeyeEkle(Dugum yeni) {
        if (bas == null) {
            bas = yeni;
            son=yeni;
        } else {
            son.ileri = yeni;
            yeni.geri = son;
            son = yeni;
           
        } }
    void listeBasiSil() {
        bas = bas.ileri;
        if (bas == null) {
            son = null;
        } else {
            bas.geri = null;
        }
    }
    public int dugumSayisi(){
                Dugum cn = bas;
                int count = 0;
                while(cn != null){
                        count++;
                        cn = cn.ileri;
                }
                return count;
        }
    public void dugumlerigez(){
        Dugum tmp=bas;
        while(tmp!=null){
            System.out.println(tmp.isim+"-->"+tmp.para);
            tmp=tmp.ileri;
        }
    }
    //x sayısının ilk oluşumunu listeden siler. x listede yoksa, değişiklik yapılmaz. Bu yöntemin listede arama yapması gerekiyor.
    public boolean elemansil(int x){
         Dugum cn = bas;
                while(cn.para != x){
                        cn = cn.ileri;
                }                
                if(cn != null){
                        if(cn.geri== null){
                                bas = cn.ileri;
                                if(bas==null){
                                        bas.geri=null;
                                }
                        }else if(cn.ileri== null){
                                son = cn.geri;
                                if(bas!=null){
                                        son.ileri=null;
                                }
                        }else{
                                cn.geri.ileri=cn.ileri;
                                cn.ileri=cn.geri;
                        }
                }
                
                return cn != null;
    }
}
    
class Yigit{
    int N,ust;
    int []dizi;
    public Yigit(int N){
        dizi=new int[N];
        this.N=N;
        ust=-1;
    }
    public int tepe(){
        if(ust!=-1)return dizi[ust];
        else return -1;
    }
    public boolean bosmu(){
        if(ust==-1)return true;
        else return false;
    }
    public boolean dolumu(){
        if(ust==N-1)return true;
        else return false;
    }
    public void ekleme(int yeni){
        if(!dolumu()){
            ust++;
            dizi[ust]=yeni;
        }
        else System.out.println("yığıt dolu");
    }
    int sil(){
        if(!bosmu()){
            ust--;
            return dizi[ust+1];
        }
        else return -1;
    }
}
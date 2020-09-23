/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vy5;
//import static com.company.CiftBaglıListe.dosya;
    import java.io.File;
    import java.io.FileNotFoundException;
    //import java.io.PrintWriter;
    import java.util.Scanner;

    class eleman{
        String isim;
        String miktar;
        eleman ileri;
        eleman geri;
       eleman(String isim,String miktar){
           this.isim=isim;
           this.miktar=miktar;
           ileri=null;
           geri=null;
        }
        public void yazdir() {
            System.out.print("---> " + isim+" --->"+miktar);
        }
            }

    class cbliste{
        eleman bas,son;
        cbliste(){
            bas=null;
            son=null;
        }
        void basekle(eleman yeni){
            if(son==null){
                bas=yeni;
                son=yeni;
            }
            else{
                yeni.ileri=bas;
                bas.geri=yeni;
                bas=yeni;
            }
        }
        void sonekle(eleman yeni){
            if(bas==null){
                bas=yeni;
                son=yeni;
            }
            else {
                son.ileri=yeni;
                yeni.geri=son;
                son=yeni;
            }

            }
        public void listele() {
            System.out.println();
            System.out.print("Bastan Sona Liste : ");
            eleman etkin = bas;
            while (etkin != null) {
                etkin.yazdir();
                etkin = etkin.ileri;
            }
        }
        }




    public class Vy5 {
        public static eleman dosya()throws FileNotFoundException{
            File f = new File("D:\\tamsayi.txt");
            Scanner k=new Scanner(f);
            cbliste cb1=new cbliste();
            String a="";
            String b="";
            eleman e1=new eleman(a,b);
            //eleman tmp=cb1.bas;//sen ne işe yarıyorsun öğren.
            String y="";
            String x="";
            while (k.hasNextLine()){
                String s=k.nextLine();
                String []dizi=s.split(" ");
                for (int i = 0; i <dizi.length ; i++) {
                    if(dizi[i].endsWith("TL")){
                        x=dizi[i];
                    }
                }

                e1.isim=dizi[0];
                dizi[1]=x;
                e1.miktar=dizi[1];
                cb1.sonekle(e1);
                cb1.listele();

                cb1.bas=cb1.bas.ileri;

            }
            k.close();
            return cb1.bas;
        }
        public static void main(String[] args) throws FileNotFoundException {
            cbliste cb2=new cbliste();
            cb2.bas=dosya();
        }
    }
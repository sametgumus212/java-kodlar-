/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vy12;
public class Vy12 {

    int[] dizi;
    int tane;
    int boyut;//N

    public  Vy12(int boyut) {
        this.boyut = boyut;
        this.tane = 0;
        dizi = new int[this.boyut + 1];
        dizi[0] = Integer.MAX_VALUE;
    }

    int ebeveyn(int no) {
        return no / 2;
    }

   int solcocuk(int no) {
        return (2 * no)+1;
    }
    int sagcocuk(int no) {
        return (2 * no) + 2;
    }

    boolean yaprak(int no) {
        if (no >= (tane / 2) && no <= tane) {
            return true;
        }
        return false;
    }

        void yerdegistir(int fno, int sno) {
        int tmp;
        tmp = dizi[fno];
        dizi[fno] = dizi[sno];
        dizi[sno] = tmp;
    }

    void asagiIn(int no) {
        if (yaprak(no)) {
            return;
        }

        if (dizi[no] < dizi[solcocuk(no)]
                || dizi[no] < dizi[sagcocuk(no)]) {

            if (dizi[solcocuk(no)] > dizi[sagcocuk(no)]) {
                yerdegistir(no, solcocuk(no));
                asagiIn(solcocuk(no));
                //solcocuk(no)=2*no+1;
            } else {
                yerdegistir(no, sagcocuk(no));
                asagiIn(sagcocuk(no));
            }
        }
    }

    public void ekleme(int eleman) {
        dizi[++tane] = eleman;

        int indis = tane;
        while (dizi[indis] > dizi[ebeveyn(indis)]) {
            yerdegistir(indis, ebeveyn(indis));
            indis = ebeveyn(indis);
        }
    }

    public void goster() {
        for (int i = 1; i <= tane / 2; i++) {
            System.out.print(" EBEVEYN : " + dizi[i] + " SOL ÇOCUK : "
                    + dizi[2 * i] + " SAĞ ÇOCUK :" + dizi[2 * i + 1]);
            System.out.println();
        }
    }

    
    int maximum() {
        int ust = dizi[1];
        dizi[1] = dizi[tane--];
        asagiIn(1);
        return ust;
    }
    int arama(int aranan){
       
        for (int i = 0; i <boyut; i++) {
            if (dizi[i]==aranan) {
                return aranan;
                
            }
        }
        return -1;
    }
    
    
    
    public static void main(String[] arg) {
        
        System.out.println("MAX HEAP");
        Vy12 maxHeap = new Vy12(15);
        maxHeap.ekleme(5);
        maxHeap.ekleme(3);
        maxHeap.ekleme(37);
        maxHeap.ekleme(10);
        maxHeap.ekleme(84);
        maxHeap.ekleme(39);
        maxHeap.ekleme(6);
        maxHeap.ekleme(22);
        maxHeap.ekleme(9);
      // maxHeap.ekleme(3);
      maxHeap.maximum();
        System.out.println("ARANAN DEĞER : "+maxHeap.arama(3));
        maxHeap.goster();
        System.out.println("MAX DEĞER " + maxHeap.maximum());
       
        System.out.println(maxHeap.solcocuk(9));
        
    }
}
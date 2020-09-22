/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 klavyeden girilecek sayıları aşağıdaki şekilde sıralayan
    5
    1  5
    1  3  5
    -9999 1 3 5 şeklinde giden bir yapı oluştur...-9999 yazınca program sonlansın

 */
package handikapdizi;

import java.util.Scanner;

public class Handikapdizi {

    public static void main(String[] args) {
        // TODO code application logic here
        int sayac = 0;
        int dizi[] = new int[1];
        int ydizi[] = new int[1];
        Scanner k = new Scanner(System.in);
        
        int sayi ;
        int i = 0;
        while (true) {
             sayac++;
            sayi=k.nextInt();          
            if (sayac == 1) {
                dizi[0] = sayi;
                ydizi[0] = sayi;
                System.out.println(dizi[i]);
            } else {
                dizi = new int[sayac];
                
                for (int r = 0; r < sayac-1; r++) {
                    dizi[r] = ydizi[r];            
                }
                dizi[sayac-1]=sayi;
               
                int tmp;
                for(int m=0;m<dizi.length;m++){
                    for(int n=1;n<dizi.length-m;n++){
                        if(dizi[n-1]>dizi[n]){
                            tmp=dizi[n-1];
                            dizi[n-1]=dizi[n];
                            dizi[n]=tmp;
                        }
                    }
                }
                ydizi=new int[dizi.length];
                for(int l=0;l<dizi.length;l++){
                    ydizi[l]=dizi[l];
                }
                for(int h=0;h<dizi.length;h++){
                    System.out.print(dizi[h]+ "  ");
                }

            }
            if(sayi==-9999)break;
            //i++;

        }
    }

}

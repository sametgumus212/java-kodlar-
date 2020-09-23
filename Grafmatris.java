package grafmatris;


public class Grafmatris {

    public static void main(String[] args) {
        cizge c =new cizge(4);
        c.kenarEkle(0,1);
        c.kenarEkle(1,0);
        c.kenarEkle(1,2);
        c.kenarEkle(2,1);
        c.kenarEkle(2,3);
        c.kenarEkle(3,2);
        c.kenarEkle(3,1);
        c.kenarEkle(1,3);  
        c.goster();
        c.yonlu();
        c.kenarSayisi();
        c.baglimi();
        c.tamMı();
    }
    
}
class cizge{
    int [][]kenar;
    int N;
    boolean yon=false;
    cizge(int N){
        this.N=N;
        kenar=new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                kenar[i][j]=0;//bağlantı yok
                
            }
        }
    }
    void kenarEkle(int baslangic, int bitis){
        kenar[baslangic][bitis]=1;
    }
    boolean yonlu(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <N; j++) {
                if (kenar[i][j]!=kenar[j][i]) {
                    yon=true;
                    break;
                }
            }
        }
        if (yon==true) {
            System.out.println("graf yönlüdür");
        }
        else{
            System.out.println("graf yönsüzdür");
        }
        return yon;
    }
    void kenarSayisi(){
        int toplam=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {         
                    toplam+=kenar[i][j];        
            }
        }
        if (yonlu()) {
            System.out.println(toplam);
        }
        else
        System.out.println(toplam/2);
    }
    void baglimi(){
     int   toplam=0;
        for (int i = 0; i <N; i++) {
            for (int j = 0; j < N; j++) {
                toplam+=kenar[i][N-1];    
            }
        }
              if (toplam==0) {
                  System.out.println("bağlı olmayan düğüm vardır");
    }
              else
                  System.out.println("tüm düğümler bağlıdır");
        }
    void tamMı(){
        boolean t= false;
        for (int i = 0; i < N; i++) {
            t=false;
            for (int j = 0; j < N; j++){ 
                if (kenar[i][j]==1){ 
                    t=true;
                }
            }
                if (t==false) {
                    System.out.println("graf tam değil");
                    break;
                }
        }
          if (t==true) {
                System.out.println("graf tam");
                
            }
        
    }
      
    void goster(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(kenar[i][j]+" ");
            }
            System.out.println();
        }
    }
}
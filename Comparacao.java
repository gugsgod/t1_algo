import java.util.Calendar;

public class Comparacao {
    public static void main(String [] args){
        long ini;
        long fim;
        NossoVetor v1m = new NossoVetor(10000);
        System.out.println("bubble-sort");
        for(int i=0;i<30;i++){
            v1m.preecheVetor();
            int iteracoes = v1m.bubbleSort();
            System.out.println(iteracoes);
        }
        System.out.println("insertion-sort");
        for(int j=0;j<30;j++){
            v1m.preecheVetor();
            ini = Calendar.getInstance().getTimeInMillis();
            v1m.insertionSort();
            fim = Calendar.getInstance().getTimeInMillis();
            System.out.println(fim-ini);
        }
        System.out.println("selection-sort");
        for(int j=0;j<30;j++){
            v1m.preecheVetor();
            ini = Calendar.getInstance().getTimeInMillis();
            v1m.selectionSort();
            fim = Calendar.getInstance().getTimeInMillis();
            System.out.println(fim-ini);
        }
    }
}

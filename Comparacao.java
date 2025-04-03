import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;

public class Comparacao {
    public static void main(String [] args){
        NossoVetor v100k = new NossoVetor(100000);
        NossoVetor v200k = new NossoVetor(200000);
        NossoVetor v400k = new NossoVetor(400000);
        NossoVetor v800k = new NossoVetor(800000);
        NossoVetor v1m600k = new NossoVetor(1600000);
        todosOsTestes(v100k,30,"100k");
        todosOsTestes(v200k,30,"200k");
        todosOsTestes(v400k,30,"400k");
        todosOsTestes(v800k, 30, "800k");
        todosOsTestes(v1m600k, 10, "16kk");
    }
    
    static void todosOsTestes(NossoVetor vetor, int reps, String watermark){
        testeSS(vetor, reps, watermark);
        testeIS(vetor, reps, watermark);
        testeBBS(vetor, reps, watermark);
        comparacaoBuscas(vetor, reps, watermark);
    }

    static void testeSS(NossoVetor vetor, int reps, String watermark){
        long[] total = new long[reps];
        long[] time = new long[reps];
        for(int i = 0; i < reps; i++){
            vetor.preecheVetor();
            long ini = Calendar.getInstance().getTimeInMillis();
            long trocas = vetor.selectionSort();
            long fim = Calendar.getInstance().getTimeInMillis();
            long tempo = fim-ini;
            total[i] = trocas;
            time[i] = tempo;
        }
        System.out.println(watermark + Arrays.toString(total));
        System.out.println(watermark + Arrays.toString(time));
    }

    static void testeIS(NossoVetor vetor, int reps, String watermark){
        long[] total = new long[reps];
        long[] time = new long[reps];
        for(int i = 0; i < reps; i++){
            vetor.preecheVetor();
            long ini = Calendar.getInstance().getTimeInMillis();
            long trocas = vetor.insertionSort();
            long fim = Calendar.getInstance().getTimeInMillis();
            long tempo = fim-ini;
            total[i] = trocas;
            time[i] = tempo;
        }
        System.out.println(watermark + Arrays.toString(total));
        System.out.println(watermark + Arrays.toString(time));
    }

    static void testeBBS(NossoVetor vetor, int reps, String watermark) {
        long[] total = new long[reps];
        long[] time = new long[reps];
        for(int i = 0; i < reps; i++){
            vetor.preecheVetor();
            long ini = Calendar.getInstance().getTimeInMillis();
            long trocas = vetor.bubbleSort();
            long fim = Calendar.getInstance().getTimeInMillis();
            long tempo = fim-ini;
            total[i] = trocas;
            time[i] = tempo;
        }
        System.out.println(watermark + Arrays.toString(total));
        System.out.println(watermark + Arrays.toString(time));
    }

    static void comparacaoBuscas(NossoVetor vetor, int reps, String watermark){
        long[] totalLinear = new long[reps];
        long[] timeLinear = new long[reps];
        long[] totalBinario = new long[reps];
        long[] timeBinario = new long[reps];
        for(int i = 0; i < reps; i++){
            vetor.preecheVetor();
            Random random = new Random();
            long alvo = random.nextInt(vetor.getTamanho());
            long ini = Calendar.getInstance().getTimeInMillis();
            long comp = vetor.buscaSimples(alvo);
            long fim = Calendar.getInstance().getTimeInMillis();
            long tempo = fim - ini;
            totalLinear[i] = comp;
            timeLinear[i] = tempo;

            ini = Calendar.getInstance().getTimeInMillis();
            //ordenar
            vetor.insertionSort();
            //buscar
            comp = vetor.buscaBinaria(alvo);
            fim = Calendar.getInstance().getTimeInMillis();
            tempo = fim - ini;
            totalBinario[i] = comp;
            timeBinario[i] = tempo;
        }
        System.out.println(watermark + Arrays.toString(totalLinear));
        System.out.println(watermark + Arrays.toString(timeLinear));
        System.out.println(watermark + Arrays.toString(totalBinario));
        System.out.println(watermark + Arrays.toString(timeBinario)+ "\n");
    }
}
import java.util.Arrays;
import java.util.Random;

public class Comparacao {
    public static void main(String [] args){
        NossoVetor v100k = new NossoVetor(100000);
        NossoVetor v200k = new NossoVetor(200000);
        NossoVetor v400k = new NossoVetor(400000);
        NossoVetor v800k = new NossoVetor(800000);
        NossoVetor v1m600k = new NossoVetor(1600000);
        todosOsTestes(v100k,30,"100k");
//        todosOsTestes(v200k,30,"200k");
//        todosOsTestes(v400k,30,"400k");
//        todosOsTestes(v800k, 30, "800k");
//        todosOsTestes(v1m600k, 1, "16kk");
    }
    
    static void todosOsTestes(NossoVetor vetor, int reps, String watermark){
        //testeSS(vetor, reps, watermark);
        //testeIS(vetor, reps, watermark);
        //testeBBS(vetor, reps, watermark);
        comparacaoBuscas(vetor, reps, watermark);
    }

    static void testeSS(NossoVetor vetor, int reps, String watermark){
        long[] total = new long[reps];
        for(int i = 0; i < reps; i++){
            vetor.preecheVetor();
            long trocas = vetor.selectionSort();
            total[i] = trocas;
        }
        System.out.println(watermark + Arrays.toString(total));
    }

    static void testeIS(NossoVetor vetor, int reps, String watermark){
        long[] total = new long[reps];
        for(int i = 0; i < reps; i++){
            vetor.preecheVetor();
            long trocas = vetor.insertionSort();
            total[i] = trocas;
        }
        System.out.println(watermark + Arrays.toString(total));
    }

    static void testeBBS(NossoVetor vetor, int reps, String watermark) {
        long[] total = new long[reps];
        for(int i = 0; i < reps; i++){
            vetor.preecheVetor();
            long trocas = vetor.bubbleSort();
            total[i] = trocas;
        }
        System.out.println(watermark + Arrays.toString(total));
    }

    static void comparacaoBuscas(NossoVetor vetor, int reps, String watermark){
        long[] totalLinear = new long[reps];
        long[] custoOrdenacao = new long[reps];
        long[] totalBinario = new long[reps];
        for(int i = 0; i < reps; i++){
            vetor.preecheVetor();
            Random random = new Random();
            long alvo = random.nextInt(vetor.getTamanho());
            long comp = vetor.buscaSimples(alvo);
            totalLinear[i] = comp;

            //ordenar
            long dale = vetor.insertionSort();
            custoOrdenacao[i] = dale;
            //buscar
            comp = vetor.buscaBinaria(alvo);
            totalBinario[i] = comp;
        }
        System.out.println(watermark + Arrays.toString(totalLinear));
        System.out.println(watermark + Arrays.toString(custoOrdenacao));
        System.out.println(watermark + Arrays.toString(totalBinario));
    }
}

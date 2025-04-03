import java.util.Random;

public class NossoVetor {
  private int ocupacao;
  private int[] vetor;

  public NossoVetor(int tamanho) {
    vetor = new int[tamanho];
    ocupacao = 0;
  }

  public NossoVetor() {
    this(10);
  }

  public void inserir(int i) {
    if (estaCheio())
      redimensiona(vetor.length * 2);
    vetor[ocupacao++] = i;
  }

  public int getTamanho() {
    return vetor.length;
  }

  public int remover() {
    if (estaVazio())
      throw new VetorVazioException("vetor vazio, nao ha o que remover");
    int aux = vetor[--ocupacao];
    if (vetor.length >= 6 && ocupacao <= vetor.length / 4)
      redimensiona(vetor.length / 2);
    return aux;
  }

  public boolean estaCheio() {
    return ocupacao == vetor.length;
  }

  public boolean estaVazio() {
    return ocupacao == 0;
  }

  @SuppressWarnings("ManualArrayToCollectionCopy")
  private void redimensiona(int novoTamanho) {
    int[] temp = new int[novoTamanho];
    for (int i = 0; i < ocupacao; i++) {
      temp[i] = vetor[i];
    }
    vetor = temp;
  }

  @Override
  public String toString() {
    return "";
  }

  public boolean contem(int i) {
    for (int j = 0; j < ocupacao; j++)
      if (vetor[j] == i)
        return true;
    return false;
  }

  public int indiceDe(int i) {
    for (int j = 0; j < ocupacao; j++)
      if (vetor[j] == i)
        return j;
    return -1;
  }

  public void preecheVetor() {
    Random random = new Random();
    for (int i = 0; i < vetor.length; i++) {
      vetor[i] = random.nextInt(vetor.length * 10);
    }
    ocupacao = vetor.length;
  }

  public long bubbleSort() {
    long trocas = 0;
    long comparacao = 0;
    
    for (int i = 1; i < vetor.length; i++) {
        for (int j = 0; j < vetor.length - i; j++) {
            comparacao++;
            if (vetor[j] > vetor[j + 1]) {
                int aux = vetor[j];
                vetor[j] = vetor[j + 1];
                vetor[j + 1] = aux;
                trocas++;
            }
        }
    }
    long total = trocas + comparacao;
    return (total);
}

  public long selectionSort() {
        long trocas = 0;
        long comparacao = 0;
        for (int i = 0; i < vetor.length - 1; ++i) {
            int min = i;
            for (int j = i + 1; j < vetor.length; ++j){
                comparacao++;
                if (vetor[j] < vetor[min]){
                    trocas++;
                    min = j;
                }
            }
            int x = vetor[i];
            vetor[i] = vetor[min];
            vetor[min] = x;
        }
        return (trocas + comparacao);
    }

  public long insertionSort() {
    long trocas = 0;
    long comparacao = 0;
    for (int j = 1; j < vetor.length; ++j) {
      int x = vetor[j];
      int i;
      for (i = j - 1; i >= 0 && vetor[i] > x; --i, comparacao++){
        trocas++;
        vetor[i + 1] = vetor[i];
      }
      comparacao++;
      trocas++;
      vetor[i + 1] = x;
    }
    return (trocas + comparacao);
  }

  public long buscaSimples (long alvo) {
    int x = vetor[(int) alvo];
    int comparacoes = 0;
    for (int i=0; i < vetor.length; i++) { 
      comparacoes++;  
      if (vetor[i] == x) {
        return comparacoes;
      }
    }
    return -1;
  }
  

  public long buscaBinaria(long alvo) {
    int x = vetor[(int) alvo];
    long ini = 0;
    long fim = vetor.length - 1; 
    long comparacao = 0;
    while (ini <= fim) {
      int meio =(int)((ini + fim) / 2);
      long metade = vetor[meio];
      if (x == metade) {
        comparacao++;
        return comparacao;
      }
      if (x > metade) {
        ini = meio + 1;
        comparacao++;
      }else {
        fim = meio - 1;
        comparacao++;
      }
    }
    return -1;
  }

}



class VetorVazioException extends RuntimeException {
  public VetorVazioException(String msg) {
    super(msg);
  }
}
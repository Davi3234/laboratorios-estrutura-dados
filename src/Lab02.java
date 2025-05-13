import java.util.*;

public class Lab02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o número do cenário:");
        System.out.println("1 - Não alterar o conteúdo de A.");
        System.out.println("2 - Inicialmente ordenar os elementos de A.");
        int opcao = sc.nextInt();

        System.out.println("Informe o tamanho do array da base 10:");
        int n = (int) Math.pow(10, sc.nextInt());

        int[] array = geraArrayAleatorio(n);

        long start, end;
        start = System.currentTimeMillis();

        if(opcao == 1) {
            System.out.println("Soma: "+somaValoresIntervaloNaoOrdenado(array, 580, 788));
            System.out.println("k-esimo: "+ kMenorNaoOrdenado(array, 73));
        } else if(opcao == 2) {
            Arrays.sort(array);
            System.out.println("Soma: "+somaValoresIntervaloOrdenado(array, 580, 788));
            System.out.println("k-esimo: "+ array[73-1]);
        }

        end = System.currentTimeMillis();
        System.out.println("Tempo: " + (end - start) + "ms");
    }

    public static int[] geraArrayAleatorio(int n) {
        Random r = new Random();
        int[] array = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = r.nextInt(1000);
        }
        return array;
    }

    public static long somaValoresIntervaloNaoOrdenado(int[] array, int a, int b) {
        long soma = 0;
        for (int v : array) {
            if (v >= a && v <= b)
                soma += v;
        }
        return soma;
    }

    public static long somaValoresIntervaloOrdenado(int[] array, int a, int b) {
        int inicio = Arrays.binarySearch(array, a);
        int fim = Arrays.binarySearch(array, b);

        if(inicio < 0) inicio = -inicio - 1;
        if(fim < 0) fim = -fim - 2;

        long soma = 0;
        for(int i = inicio; i <= fim; i++) {
            soma += array[i];
        }
        return soma;
    }

    public static int kMenorNaoOrdenado(int[] array, int k) {
        int[] copia = Arrays.copyOf(array, array.length);
        Arrays.sort(copia);
        return copia[k-1];
    }
}

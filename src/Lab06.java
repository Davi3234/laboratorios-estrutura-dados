import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a quantidade de cartas: ");
        int input = sc.nextInt();

        ArrayList<Integer> arrayCartas = populaArray(input);

        ArrayList<Integer> arrayCartasDescartadas = new ArrayList<>();

        while(arrayCartas.size() > 1){
            arrayCartasDescartadas.add(arrayCartas.removeFirst());
            int proximaCarta = arrayCartas.removeFirst();
            arrayCartas.addLast(proximaCarta);
        }

        System.out.println("Discarded: "+ arrayCartasDescartadas);
        System.out.println("Remaining: "+ arrayCartas);

    }

    public static ArrayList<Integer> populaArray(int input){
        ArrayList<Integer> arrayCartas = new ArrayList<>();

        for(int i = 1; i <= input; i++){
            arrayCartas.add(i);
        }
        return arrayCartas;
    }
}

import java.util.HashMap;
import java.util.Scanner;

public class Lab08 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        HashMap<String, Integer> map = new HashMap<>();

        String input = "";
        int maiorQtdVoto = 0;
        int qtd = 1;
        String pessoa = "";
        do{
            input = s.nextLine();

            map.computeIfAbsent(input, k -> 0);
            int votos = (map.get(input))+1;

            map.put(input, votos);

            if(votos > maiorQtdVoto){
                maiorQtdVoto = votos;
                qtd = 1; 
                pessoa = input;
            }
            else if(votos == maiorQtdVoto){
                qtd++;
            }
        }
        while(!input.equals("***"));

        System.out.println(qtd > 1 ? "Segundo Turno!" : pessoa);
    }
}

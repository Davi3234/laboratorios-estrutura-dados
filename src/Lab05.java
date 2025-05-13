import java.util.*;

public class Lab05 {
    public static void main(String[] args) {
        String[] arrayNomes = {
                "sergio", "ana", "maria", "carlos", "eva", "joaquim",
                "jo", "mara", "laura", "lucas", "ari", "paulo"
        };

        Map<Integer, Queue<String>> mapa = new HashMap<>();

        for (String nome : arrayNomes) {
            int tamanho = nome.length();
            mapa.putIfAbsent(tamanho, new LinkedList<>());
            mapa.get(tamanho).add(nome);
        }

        int linhas = 0;
        for (Queue<String> fila : mapa.values()) {
            linhas = Math.max(linhas, fila.size());
        }

        for (int i = 0; i < linhas; i++) {
            List<String> linha = new ArrayList<>();
            for (int tamanho = 2; tamanho <= 10; tamanho++) {
                Queue<String> fila = mapa.get(tamanho);
                if (fila != null && !fila.isEmpty()) {
                    linha.add(fila.poll());
                }
            }
            System.out.println(String.join(", ", linha));
        }
    }
}

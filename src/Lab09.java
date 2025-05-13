import java.util.*;

public class Lab09 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int qtd = Integer.parseInt(s.nextLine());

        Map<String, Set<String>> userWords = new HashMap<>();
        Map<String, Integer> wordCount = new HashMap<>();

        for (int i = 0; i < qtd; i++) {
            String linha = s.nextLine();
            String[] partes = linha.split(" ");

            String user = partes[0];

            userWords.putIfAbsent(user, new HashSet<>());

            for (int j = 1; j < partes.length; j++) {
                String palavra = partes[j];

                userWords.get(user).add(palavra);

                wordCount.put(palavra, wordCount.getOrDefault(palavra, 0) + 1);
            }
        }

        Set<String> intersecao = null;

        for (Set<String> palavras : userWords.values()) {
            if (intersecao == null) {
                intersecao = new HashSet<>(palavras);
            } else {
                intersecao.retainAll(palavras);
            }
        }

        if (intersecao == null || intersecao.isEmpty()) {
            System.out.println("ALL CLEAR");
        } else {
            List<String> palavrasComuns = new ArrayList<>(intersecao);

            palavrasComuns.sort((a, b) -> {
                int freqA = wordCount.get(a);
                int freqB = wordCount.get(b);

                if (freqA != freqB) {
                    return Integer.compare(freqB, freqA);
                }
                return a.compareTo(b);
            });

            for (String palavra : palavrasComuns) {
                System.out.println(palavra);
            }
        }
    }
}

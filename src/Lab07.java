import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Lab07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantos minutos?");
        int minutos = sc.nextInt();

        System.out.println("Quantas entradas?");
        int entradas = sc.nextInt();

        PriorityQueue<Depoimento> filaPrioridade = new PriorityQueue<>(entradas);

        for (int i = 1; i <= entradas; i++) {
            System.out.println("Nome: ");
            String nome = sc.next();
            System.out.println("Horário da aparição: ");
            LocalTime hora = LocalTime.parse(sc.next());

            filaPrioridade.add(new Depoimento(nome, hora));
        }

        ArrayList<Depoimento> depoimentosValidos = new ArrayList<>();

        LocalTime meiaNoite = LocalTime.MIDNIGHT;

        for (Depoimento depoimento : filaPrioridade) {
            Duration duracao = Duration.between(meiaNoite, depoimento.getHorario());

            long duracaoMinutos = duracao.toMinutes();

            if(depoimento.getHorario().isAfter(meiaNoite)) {
                duracaoMinutos = Math.abs(duracaoMinutos - (24*60));
            }

            System.out.println(duracaoMinutos);

            if(duracaoMinutos <= minutos){
                depoimentosValidos.add(depoimento);
            }
        }
        for (Depoimento depoimento : depoimentosValidos) {
            System.out.println(depoimento.toString());
        }
    }
}

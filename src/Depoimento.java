import java.time.LocalTime;

public class Depoimento implements Comparable<Depoimento>{
    private String nome;
    private LocalTime horario;

    public Depoimento(String nome, LocalTime horario) {
        this.nome = nome;
        this.horario = horario;
    }

    public String getNome() {
        return nome;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public int compareTo(Depoimento o) {
        return this.horario.compareTo(o.getHorario());
    }

    @Override
    public String toString() {
        return "Depoimento{" +
                "nome='" + nome + '\'' +
                ", horario=" + horario +
                '}';
    }
}

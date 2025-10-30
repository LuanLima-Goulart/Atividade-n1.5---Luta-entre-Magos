//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Mago Luan = new Mago("Luan", 100, 100, 50);
        Mago Bruesk = new Mago("Gustav", 100, 100, 50);
        Duelo Torneio = new Duelo();
        Torneio.marcarDuelo(Luan, Bruesk);
        Luan.apresentar();
        Bruesk.apresentar();
        Luan.bolaDeFogo();
        Bruesk.receberDano(Luan.bolaDeFogo());
        Luan.statusDuelo();
    }
}
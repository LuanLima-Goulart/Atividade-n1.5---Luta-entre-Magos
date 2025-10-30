// Importamos o Random para a IA dos magos
import java.util.Random;

/**
 * A classe Duelo gerencia um combate entre dois Magos.
 * Ela usa o conceito de Agregação (ela "tem" dois Magos).
 * * Adaptado da sua classe 'Corrida'.
 */
public class Duelo {

    // --- Atributos ---
    private Mago desafiante; // Em vez de Veiculo, usamos Mago
    private Mago desafiado;
    private int turnos; // Em vez de rodadas
    private boolean dueloAprovado;

    // --- Regras de Negócio ---
    // a) Um mago não pode duelar contra si mesmo.
    // b) O duelo só pode ocorrer se ambos os desafiantes existirem.

    /**
     * Prepara o duelo entre dois magos.
     */
    public void marcarDuelo(Mago desafiante, Mago desafiado) {
        // A regra é mais simples: só não podem ser o mesmo mago
        if (desafiante != null && desafiado != null && desafiante != desafiado) {
            this.dueloAprovado = true;
            this.desafiante = desafiante;
            this.desafiado = desafiado;
            System.out.println("Duelo MARCADO: " + desafiante.getNome() + " VS " + desafiado.getNome());
        } else {
            this.dueloAprovado = false;
            this.desafiante = null;
            this.desafiado = null;
            System.out.println("Duelo RECUSADO: Os desafiantes não são válidos.");
        }
    }

    /**
     * Executa o duelo turno por turno até que um vencedor seja decidido.
     * Esta é a maior adaptação do método 'correr()'.
     */
    public void lutar() {
        if (!this.dueloAprovado) {
            System.out.println("Sentimos muito, mas este duelo não pode acontecer.");
            return; // Encerra o método
        }

        // Apresentação dos lutadores
        System.out.println("--- O DUELO COMEÇA! ---");
        System.out.println(desafiante.getNome() + " (Vida: " + desafiante.getVida() + " | Mana: " + desafiante.getMana() + ")");
        System.out.println("VS");
        System.out.println(desafiado.getNome() + " (Vida: " + desafiado.getVida() + " | Mana: " + desafiado.getMana() + ")");
        System.out.println("---------------------------------");

        Random random = new Random(); // Para a IA escolher as magias

        // Loop do Duelo: continua enquanto AMBOS estiverem vivos
        while (desafiante.estaVivo() && desafiado.estaVivo()) {

            // --- Checagem de EMPATE por falta de mana ---
            if (!desafiante.podeLancarMagia() && !desafiado.podeLancarMagia()) {
                System.out.println("Ambos os magos estão exaustos e sem mana!");
                break; // Sai do loop
            }

            this.turnos++; // Incrementa o contador de turnos
            System.out.println("\n=== TURNO " + this.turnos + " ===");

            // --- Turno do Desafiante (Mago 1) ---
            System.out.println("--- Turno de " + desafiante.getNome() + " ---");
            int escolha1 = random.nextInt(3) + 1; // IA escolhe magia 1, 2 ou 3
            int dano1 = 0;
            switch (escolha1) {
                case 1: dano1 = desafiante.bolaDeFogo(); break;
                case 2: dano1 = desafiante.raio(); break;
                case 3: dano1 = desafiante.gelo(); break;
            }
            if (dano1 > 0) {
                desafiado.receberDano(dano1);
            }

            // Checa se o Desafiado morreu
            if (!desafiado.estaVivo()) {
                break; // Sai do loop
            }

            System.out.println("-----------------");

            // --- Turno do Desafiado (Mago 2) ---
            System.out.println("--- Turno de " + desafiado.getNome() + " ---");
            int escolha2 = random.nextInt(3) + 1;
            int dano2 = 0;
            switch (escolha2) {
                case 1: dano2 = desafiado.bolaDeFogo(); break;
                case 2: dano2 = desafiado.raio(); break;
                case 3: dano2 = desafiado.gelo(); break;
            }
            if (dano2 > 0) {
                desafiante.receberDano(dano2);
            }

            System.out.println("---------------------------------");
            // O loop recomeça
        }

        // --- Fim do Duelo ---
        System.out.println("\n=== FIM DO DUELO ===");

        // A lógica de vitória/derrota/empate é diferente do 'switch' da Corrida
        // Ela é baseada no status 'estaVivo()' dos magos
        if (desafiante.estaVivo() && !desafiado.estaVivo()) {
            System.out.println("VENCEDOR: " + desafiante.getNome());
        } else if (!desafiante.estaVivo() && desafiado.estaVivo()) {
            System.out.println("VENCEDOR: " + desafiado.getNome());
        } else {
            System.out.println("O Duelo termina em EMPATE!");
        }
    }


    // --- Getters e Setters (Adaptados) ---

    public Mago getDesafiante() {
        return desafiante;
    }

    public void setDesafiante(Mago desafiante) {
        this.desafiante = desafiante;
    }

    public Mago getDesafiado() {
        return desafiado;
    }

    public void setDesafiado(Mago desafiado) {
        this.desafiado = desafiado;
    }

    public int getTurnos() {
        return turnos;
    }

    public void setTurnos(int turnos) {
        this.turnos = turnos;
    }

    public boolean isDueloAprovado() {
        return dueloAprovado;
    }

    public void setDueloAprovado(boolean dueloAprovado) {
        this.dueloAprovado = dueloAprovado;
    }
}
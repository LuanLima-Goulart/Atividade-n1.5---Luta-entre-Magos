public class Mago {
    private String nome;
    private int vida;
    private int mana;
    private int defesa;

    private int duelosVencidos;
    private int duelosPerdidos;
    private int duelosEmpatados;

    private static final int CUSTO_MANA_BOLA_DE_FOGO = 10;
    private static final int CUSTO_MANA_PARAR_TEMPO = 25;
    private static final int CUSTO_MANA_RAIO = 15;
    private static final int CUSTO_MANA_GELO = 20;

    private static final int DANO_BOLA_DE_FOGO = 30;
    private static final int DANO_RAIO = 20;
    private static final int DANO_GELO = 25;

    public Mago(String nome, int vida, int mana, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.mana = mana;
        this.defesa = defesa;

        this.duelosVencidos = 0;
        this.duelosPerdidos = 0;
        this.duelosEmpatados = 0;
    }

    public int bolaDeFogo(){
        System.out.println(getNome() + " tenta lançar Bola de Fogo...");
        if (getMana() >= CUSTO_MANA_BOLA_DE_FOGO) {
            setMana(getMana() - CUSTO_MANA_BOLA_DE_FOGO);
            System.out.println("Uma bola de fogo é gerada em sua mão!");
            System.out.println("Mana restante: " + getMana());
            return DANO_BOLA_DE_FOGO;
        } else {
            System.out.println("MANA INSUFICIENTE!");
            System.out.println("Mana atual: " + getMana() + " | Custo necessário: " + CUSTO_MANA_BOLA_DE_FOGO);
            return 0;
        }
    }

    public int pararTempo(){
        System.out.println(getNome() + " tenta parar o tempo...");
        if (getMana() >= CUSTO_MANA_PARAR_TEMPO) {
            setMana(getMana() - CUSTO_MANA_PARAR_TEMPO);
            System.out.println("ZA WARUDO!");
            System.out.println("O tempo para!");
            System.out.println("Mana restante: " + getMana());
            return 0;
        } else {
            System.out.println("MANA INSUFICIENTE!");
            System.out.println("Mana atual: " + getMana() + " | Custo necessário: " + CUSTO_MANA_PARAR_TEMPO);
            return 0;
        }
    }

    public int raio(){
        System.out.println(getNome() + " tenta soltar um raio...");
        if (getMana() >= CUSTO_MANA_RAIO) {
            setMana(getMana() - CUSTO_MANA_RAIO);
            System.out.println("Um raio sai de suas mãos!");
            System.out.println("Mana restante: " + getMana());
            return DANO_RAIO;
        } else {
            System.out.println("MANA INSUFICIENTE!");
            System.out.println("Mana atual: " + getMana() + " | Custo necessário: " + CUSTO_MANA_RAIO);
            return 0;
        }
    }

    public int gelo(){
        System.out.println(getNome() + " tenta usar magia de gelo...");
        if (getMana() >= CUSTO_MANA_GELO) {
            setMana(getMana() - CUSTO_MANA_GELO);
            System.out.println("Um vento frio sai de suas mãos!");
            System.out.println("Mana restante: " + getMana());
            return DANO_GELO;
        } else {
            System.out.println("MANA INSUFICIENTE!");
            System.out.println("Mana atual: " + getMana() + " | Custo necessário: " + CUSTO_MANA_GELO);
            return 0;
        }
    }

    public void receberDano(int danoRecebido) {
        int danoFinal = danoRecebido - getDefesa();
        if (danoFinal < 0) {
            danoFinal = 0;
        }
        this.vida -= danoFinal;
        if (getVida() < 0) {
            setVida(0);
        }
        System.out.println(getNome() + " recebeu " + danoFinal + " de dano!");
        System.out.println("Vida restante de " + getNome() + ": " + getVida());
    }

    public boolean estaVivo() {
        return getVida() > 0;
    }

    public boolean podeLancarMagia() {
        return getMana() >= CUSTO_MANA_BOLA_DE_FOGO;
    }

    public void statusDuelo() {
        System.out.println(getNome() + " é um mago com " + getVida() + " de vida restante.");
        System.out.println(getDuelosVencidos() + " vitórias / " + getDuelosPerdidos() +
                " derrotas / " + getDuelosEmpatados() + " empates");
    }
    public void apresentar() {
        System.out.println("=== FICHA DO MAGO ===");
        System.out.println("Nome: " + getNome());
        System.out.println("Vida: " + getVida());
        System.out.println("Mana: " + getMana());
        System.out.println("Defesa: " + getDefesa());
        System.out.println("--- Histórico ---");
        System.out.println("Vitórias: " + getDuelosVencidos());
        System.out.println("Derrotas: " + getDuelosPerdidos());
        System.out.println("Empates: " + getDuelosEmpatados());
        System.out.println("=====================");
    }

    public void vencerDuelo() {
        setDuelosVencidos(getDuelosVencidos() + 1);
    }

    public void perderDuelo() {
        setDuelosPerdidos(getDuelosPerdidos() + 1);
    }

    public void empatarDuelo() {
        setDuelosEmpatados(getDuelosEmpatados() + 1);
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getVida() { return vida; }
    public void setVida(int vida) { this.vida = vida; }
    public int getMana() { return mana; }
    public void setMana(int mana) { this.mana = mana; }
    public int getDefesa() { return defesa; }
    public void setDefesa(int defesa) { this.defesa = defesa; }

    public int getDuelosVencidos() { return duelosVencidos; }
    public void setDuelosVencidos(int duelosVencidos) { this.duelosVencidos = duelosVencidos; }
    public int getDuelosPerdidos() { return duelosPerdidos; }
    public void setDuelosPerdidos(int duelosPerdidos) { this.duelosPerdidos = duelosPerdidos; }
    public int getDuelosEmpatados() { return duelosEmpatados; }
    public void setDuelosEmpatados(int duelosEmpatados) { this.duelosEmpatados = duelosEmpatados; }
}
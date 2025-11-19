class State {
    protected String name;
    protected long population;
    protected double area;

    public State(String name, long population, double area) {
        this.name = name;
        this.population = population;
        this.area = area;
    }

    public void Show() {
        System.out.println("Name: " + this.name);
        System.out.println("Population: " + this.population);
        System.out.println("Area: " + this.area + " sq. km.");
    }
}

class Republic extends State {
    private String president;

    public Republic(String name, long population, double area, String president) {
        super(name, population, area);
        this.president = president;
    }

    @Override
    public void Show() {
        System.out.println("--- REPUBLIC ---");
        super.Show();
        System.out.println("Form of Government: Republic");
        System.out.println("Head of State (President): " + this.president);
    }
}

class Monarchy extends State {
    protected String monarch;

    public Monarchy(String name, long population, double area, String monarch) {
        super(name, population, area);
        this.monarch = monarch;
    }

    @Override
    public void Show() {
        System.out.println("--- MONARCHY ---");
        super.Show();
        System.out.println("Form of Government: Monarchy");
        System.out.println("Head of State (Monarch): " + this.monarch);
    }
}

class Kingdom extends Monarchy {
    private String dynasty;

    public Kingdom(String name, long population, double area, String monarch, String dynasty) {

        super(name, population, area, monarch);
        this.dynasty = dynasty;
    }

    @Override
    public void Show() {
        System.out.println("--- KINGDOM ---");
        super.Show();

        System.out.println("Type of Monarchy: Kingdom");
        System.out.println("Ruling Dynasty: " + this.dynasty);
    }
}

public class Main {

    public static void main(String[] args) {

        State[] states = new State[3];

        states[0] = new Republic(
                "United States of America",
                331_900_000,
                9_833_520,
                "Joe Biden"
        );

        states[1] = new Monarchy(
                "Japan",
                125_700_000,
                377_975,
                "Emperor Naruhito"
        );

        states[2] = new Kingdom(
                "United Kingdom",
                67_330_000,
                242_495,
                "King Charles III",
                "Windsor"
        );


        System.out.println("<<< ТЕСТ >>>\n");

        for (State s : states) {
            s.Show();
            System.out.println("----------------------------------------\n");
        }
    }
}

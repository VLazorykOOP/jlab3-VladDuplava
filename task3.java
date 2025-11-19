import java.util.Objects;

interface Series2 {

    // Методи в інтерфейсі за замовчуванням є public abstract

    double calculateTerm(int n);
    double calculateSum(int n);
}

class Linear2 implements Series2 {

    private double a1;
    private double d;

    public Linear2(double a1, double d) {
        this.a1 = a1;
        this.d = d;
    }

    @Override
    public double calculateTerm(int n) {
        if (n <= 0) return Double.NaN;
        return this.a1 + (n - 1) * this.d;
    }

    @Override
    public double calculateSum(int n) {
        if (n <= 0) return 0.0;
        return (2 * this.a1 + (n - 1) * this.d) * n / 2.0;
    }

    @Override
    public String toString() {
        return "Linear[a1=" + a1 + ", d=" + d + "]";
    }

    @Override
    public boolean equals(Object obj) {
        // Повна реалізація (без super.equals() з Series)
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Linear linear = (Linear) obj;
        // Перевіряємо всі поля
        return Double.compare(linear.a1, this.a1) == 0 &&
                Double.compare(linear.d, this.d) == 0;
    }

    @Override
    public int hashCode() {
        // Генеруємо хеш на основі всіх полів
        return Objects.hash(a1, d);
    }
}

class Exponential2 implements Series2 {

    // Поля 'a1' (з абстрактного класу) і 'r' (власне)
    private double a1;
    private double r;

    public Exponential2(double a1, double r) {
        this.a1 = a1;
        this.r = r;
    }

    @Override
    public double calculateTerm(int n) {
        if (n <= 0) return Double.NaN;
        return this.a1 * Math.pow(this.r, n - 1);
    }

    @Override
    public double calculateSum(int n) {
        if (n <= 0) return 0.0;

        if (Double.compare(this.r, 1.0) == 0) {
            return this.a1 * n;
        }

        return this.a1 * (1 - Math.pow(this.r, n)) / (1 - this.r);
    }

    @Override
    public String toString() {
        return "Exponential[a1=" + a1 + ", r=" + r + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Exponential that = (Exponential) obj;
        return Double.compare(that.a1, this.a1) == 0 &&
                Double.compare(that.r, this.r) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a1, r);
    }
}


public class task3 {

    public static void main(String[] args) {

        // Масив об'єктів типу ІНТЕРФЕЙСУ
        Series[] progressions = new Series[4];

        progressions[0] = new Linear(1, 2);
        progressions[1] = new Exponential(2, 3);
        progressions[2] = new Linear(10, -3);
        progressions[3] = new Exponential(100, 0.5);


        System.out.println("--- Ілюстрація роботи методів ---");
        System.out.println("--- (Обчислюємо 4-й член та суму 4-х членів) ---\n");

        for (Series s : progressions) {

            System.out.println("Об'єкт: " + s.toString());

            int n = 4;
            System.out.println("  Член " + n + ": " + s.calculateTerm(n));
            System.out.println("  Сума " + n + ": " + s.calculateSum(n));
            System.out.println("--------------------");
        }


        System.out.println("\n--- Ілюстрація роботи методів equals() ---");

        Linear p1_linear = new Linear(1, 2);
        Linear p2_linear = new Linear(1, 2);
        Linear p3_linear = new Linear(5, 5);
        Exponential p4_exp = new Exponential(1, 2);

        System.out.println("p1.equals(p2): " + p1_linear.equals(p2_linear));
        System.out.println("p1.equals(p3): " + p1_linear.equals(p3_linear));
        System.out.println("p1.equals(p4): " + p1_linear.equals(p4_exp));
    }
}

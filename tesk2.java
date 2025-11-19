import java.util.Objects;

abstract class Series {

    protected double a1;

    public Series(double firstTerm) {
        this.a1 = firstTerm;
    }

    public abstract double calculateTerm(int n);

    public abstract double calculateSum(int n);

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Series series = (Series) obj;
        return Double.compare(series.a1, this.a1) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a1);
    }
}

class Linear extends Series {

    double d;

    public Linear(double a1, double d) {
        super(a1);
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
        if (!super.equals(obj)) return false;
        Linear linear = (Linear) obj;
        return Double.compare(linear.d, this.d) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), d);
    }
}

class Exponential extends Series {

    double r;

    public Exponential(double a1, double r) {
        super(a1);
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
        if (!super.equals(obj)) return false;
        Exponential that = (Exponential) obj;
        return Double.compare(that.r, this.r) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), r);
    }
}

public class task2 {

    public static void main(String[] args) {

        Series[] progressions = new Series[4];

        progressions[0] = new Linear(1, 2);
        progressions[1] = new Exponential(2, 3);
        progressions[2] = new Linear(10, -3);
        progressions[3] = new Exponential(100, 0.5);


        System.out.println("--- Ilustratsiia roboty metodiv ---");
        System.out.println("--- (Obchysliuiemo 4-y chlen ta sumu 4-kh chleniv) ---\n");

        for (Series s : progressions) {

            System.out.println("Obiekt: " + s.toString());

            int n = 4;
            System.out.println("  Chlen " + n + ": " + s.calculateTerm(n));
            System.out.println("  Suma " + n + ": " + s.calculateSum(n));
            System.out.println("--------------------");
        }


        System.out.println("\n--- Ilustratsiia roboty metodiv equals() ---");

        Linear p1_linear = new Linear(1, 2);
        Linear p2_linear = new Linear(1, 2);
        Linear p3_linear = new Linear(5, 5);
        Exponential p4_exp = new Exponential(1, 2);

        System.out.println("p1.equals(p2): " + p1_linear.equals(p2_linear));
        System.out.println("p1.equals(p3): " + p1_linear.equals(p3_linear));
        System.out.println("p1.equals(p4): " + p1_linear.equals(p4_exp));
    }
}

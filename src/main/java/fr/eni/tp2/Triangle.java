package fr.eni.tp2;

public class Triangle {

    public enum Type { EQUILATERAL, ISOCELE, SCALENE, INVALIDE }

    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /** Vérifie que les trois côtés forment un triangle valide. */
    public boolean estValide() {
        return a > 0 && b > 0 && c > 0
            && (a + b > c)
            && (a + c > b)
            && (b + c > a);
    }

    /** Retourne le type du triangle. */
    public Type getType() {
        if (!estValide()) return Type.INVALIDE;
        if (a == b && b == c) return Type.EQUILATERAL;
        if (a == b || b == c || a == c) return Type.ISOCELE;
        return Type.SCALENE;
    }

    /** Calcule le périmètre. */
    public double perimetre() {
        return a + b + c;
    }

    /** Calcule l'aire (formule de Héron). */
    public double aire() {
        double s = perimetre() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public static void main(String[] args) {
        Triangle t = new Triangle(3, 4, 5);
        System.out.println("Triangle(3,4,5)");
        System.out.println("  Type      : " + t.getType());
        System.out.println("  Périmètre : " + t.perimetre());
        System.out.printf ("  Aire      : %.2f%n", t.aire());
    }
}

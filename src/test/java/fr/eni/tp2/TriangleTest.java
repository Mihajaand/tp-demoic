package fr.eni.tp2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void triangleEquilateralEstValide() {
        Triangle t = new Triangle(5, 5, 5);
        assertTrue(t.estValide());
        assertEquals(Triangle.Type.EQUILATERAL, t.getType());
    }

    @Test
    void triangleIsoceleEstValide() {
        Triangle t = new Triangle(5, 5, 3);
        assertTrue(t.estValide());
        assertEquals(Triangle.Type.ISOCELE, t.getType());
    }

    @Test
    void triangleScaleneEstValide() {
        Triangle t = new Triangle(3, 4, 5);
        assertTrue(t.estValide());
        assertEquals(Triangle.Type.SCALENE, t.getType());
    }

    @Test
    void triangleInvalideEstDetecte() {
        Triangle t = new Triangle(1, 2, 10);
        assertFalse(t.estValide());
        assertEquals(Triangle.Type.INVALIDE, t.getType());
    }

    @Test
    void triangleAvecCoteNulEstInvalide() {
        Triangle t = new Triangle(0, 4, 5);
        assertFalse(t.estValide());
    }

    @Test
    void perimetreCorrect() {
        Triangle t = new Triangle(3, 4, 5);
        assertEquals(12.0, t.perimetre(), 0.001);
    }

    @Test
    void aireCorrectePourTriangleRectangle() {
        // Triangle rectangle 3-4-5 => aire = 6
        Triangle t = new Triangle(3, 4, 5);
        assertEquals(6.0, t.aire(), 0.001);
    }
}

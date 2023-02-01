import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PruebasCalculadora<T> {
    
    IStack stack = new PostFixCalculator<T>();
    IPostfixCalculator calculadora = new PostFixCalculator<T>();
    

    @Test
    public void sumaTest(){
        int resultado = calculadora.suma(2, 4);
        assertEquals(6,resultado);
    }

    @Test
    public void restaTest(){
        int resultado = calculadora.resta(2, 4);
        assertEquals(-2, resultado);
    }

    @Test 
    public void multiplicacionTest(){
        int resultado = calculadora.multiplicacion(2, 4);
        assertEquals(8, resultado);
    }

    @Test
    public void divisionTest(){
        int resultado = calculadora.division(4, 2);
        assertEquals(2, resultado);
    }

    @Test
    public void pushTest(){
        stack.push(45);
        assertEquals(45, stack.peek());
    }

    @Test
    public void countTest(){
        Integer[] lista = new Integer[1];
        lista[0] = 1;
        stack.push(5);
        assertEquals(lista.length, stack.count());
    }
}

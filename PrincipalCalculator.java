import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

/**
 * @author José Prince
 */

public class PrincipalCalculator {
  
  /** 
   * @param args
   */
  public static <T> void main(String[] args) {
	  System.out.println("Ingrese la ruta del archivo ej C:\\ejemplos\\example1.txt");
	  Scanner in = new Scanner(System.in);
	  String fpath = in.nextLine();
      PostFixCalculator<T> calculadora = new PostFixCalculator<>();
      int a;
      int b;
      T resultado;
	  
    try {
      File myObj = new File(fpath);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
        //calculadora.getItems(data);
        String[] listaStrings = data.split(" ");
        for (int i = 0; i<listaStrings.length; i++){
            if (listaStrings[i].matches("[0-9]*")){
                calculadora.getItems(listaStrings[i]);
                //listaPostFix = calculadora.getItems(data);
            } else if (listaStrings[i].matches("[+,-,*,/]")){
                if (calculadora.count() > 1){
                switch (listaStrings[i]) {
                    case "+":
                        b = Integer.valueOf((String) calculadora.peek());
                        calculadora.pull();
                        a = Integer.valueOf((String) calculadora.peek());
                        calculadora.pull();
                        resultado = (T) String.valueOf(calculadora.suma(a, b));
                        calculadora.push(resultado);

                        if (listaStrings[listaStrings.length - 1] == listaStrings[i]){
                            System.out.println("Resultado: " + resultado);
                            calculadora.pull();
                        }
                        break;
                    case "-":
                        b = Integer.valueOf((String) calculadora.peek());
                        calculadora.pull();
                        a = Integer.valueOf((String) calculadora.peek());
                        calculadora.pull();
                        resultado = (T) String.valueOf(calculadora.resta(a, b));
                        calculadora.push(resultado);

                        if (listaStrings[listaStrings.length - 1] == listaStrings[i]){
                            System.out.println("Resultado: " + resultado);
                            calculadora.pull();
                        }
                        break;
                    case "*":
                        b = Integer.valueOf((String) calculadora.peek());
                        calculadora.pull();
                        a = Integer.valueOf((String) calculadora.peek());
                        calculadora.pull();
                        resultado = (T) String.valueOf(calculadora.multiplicacion(a, b));
                        calculadora.push(resultado);

                        if (listaStrings[listaStrings.length - 1] == listaStrings[i]){
                            System.out.println("Resultado: " + resultado);
                            calculadora.pull();
                        }
                        break;
                    case "/":
                        b = Integer.valueOf((String) calculadora.peek());
                        calculadora.pull();
                        a = Integer.valueOf((String) calculadora.peek());
                        calculadora.pull();
                        
                        if (b == 0){
                            System.out.println("No se puede realizar la división entre 0");
                            break;
                        } else {
                            resultado = (T) String.valueOf(calculadora.division(a, b));
                            calculadora.push(resultado);

                            if (listaStrings[listaStrings.length - 1] == listaStrings[i]){
                                System.out.println("Resultado: " + resultado);
                                calculadora.pull();
                            }
                        }

                        break;
                    default:
                        break;
                    }
                } else {
                    System.out.println("Insuficientes operandos para el operador");
                }
                }
            
            }
        }
      
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}



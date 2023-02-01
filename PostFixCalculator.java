import java.util.ArrayList;

/**
 * @author José Prince
 * 
 */
public class PostFixCalculator<T> implements IStack<T>, IPostfixCalculator {

	private ArrayList<T> miListaInterna;
	
	public PostFixCalculator() {
		miListaInterna = new ArrayList<T>(); 
	}
	
	
	/** 
	 * @return int
	 * Cuenta los elementos del stack
	 */
	@Override
	public int count() {
		return miListaInterna.size();
	}

	
	/** 
	 * @return boolean
	 * Indica si no hay elementos en el stack
	 */
	@Override
	public boolean isEmpty() {
		return miListaInterna.isEmpty();
	}

	
	/** 
	 * @param value
	 * Añade un dato a la pila
	 */
	@Override
	public void push(T value) {
		miListaInterna.add(0, value);
	}

	
	/** 
	 * @return T
	 * Quita el primer dato de la pila
	 */
	@Override
	public T pull() {
		return miListaInterna.remove(0);
	}

	
	/** 
	 * @return T
	 * Obtiene el dato de la primera posición del stack
	 */
	@Override
	public T peek() {		
		return miListaInterna.get(0);
	}

	
	/** 
	 * @param operandos
	 * @return boolean
	 * Muestra si solo hay un elemento en el stack
	 */
	public boolean isOneItem(IStack operandos){
		boolean oneItem = false;
		if (miListaInterna.size() == 1){
			oneItem = true;
		}
		return oneItem;
	}

	
	/** 
	 * @param a
	 * @param b
	 * @return int
	 * Hace una suma
	 */
	public int suma(int a, int b){
		return a + b;
	}

	
	/** 
	 * @param a
	 * @param b
	 * @return int
	 * Hace una resta
	 */
	public int resta(int a, int b){
		return a - b;
	}
	
	
	/** 
	 * @param a
	 * @param b
	 * @return int
	 * Hace una multiplicación
	 */
	public int multiplicacion(int a, int b){
		return a * b;
	}
	
	
	/** 
	 * @param a
	 * @param b
	 * @return int
	 * Hace una división
	 */
	public int division(int a, int b){
		return a/b;
	}
	
	
	/** 
	 * @param item
	 * @return boolean
	 * Indica si un elemento es un operador
	 */
	public boolean isOperator(String item){
			boolean operator = false;
			if (item.matches("[+,-,*,/]")){
				operator = true;
			}
		return operator;
	}
	
	
	/** 
	 * @param _expresion
	 * @return ArrayList<String>
	 * Introduce el elemento indicado al stack
	 */
	public ArrayList<String> getItems(String _expresion){
		T newItem = (T) _expresion;
		push(newItem);

		return (ArrayList<String>) miListaInterna;
	}
}
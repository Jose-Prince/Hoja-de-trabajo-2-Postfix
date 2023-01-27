import java.util.ArrayList;

/**
 * @author MAAG
 *
 */
public class PostFixCalculator<T> implements IStack<T>, IPostfixCalculator {

	private ArrayList<T> miListaInterna;
	
	public PostFixCalculator() {
		miListaInterna = new ArrayList<T>(); 
	}
	
	@Override
	public int count() {
		return miListaInterna.size();
	}

	@Override
	public boolean isEmpty() {
		return miListaInterna.isEmpty();
	}

	@Override
	public void push(T value) {
		miListaInterna.add(0, value);
	}

	@Override
	public T pull() {
		return miListaInterna.remove(0);
	}

	@Override
	public T peek() {		
		return miListaInterna.get(0);
	}

	public boolean isOneItem(IStack operandos){
		boolean oneItem = false;
		if (miListaInterna.size() == 1){
			oneItem = true;
		}
		return oneItem;
	}

	public int suma(int a, int b){
		b = (int) peek();
		pull();
		a = (int) peek();
		pull();

		return a + b;
	}

	public int resta(int a, int b){
		b = (int) peek();
		pull();
		a = (int) peek();
		pull();

		return a - b;
	}
	
	public int multiplicacion(int a, int b){
		b = (int) peek();
		pull();
		a = (int) peek();
		pull();

		return a * b;
	}
	
	public int division(int a, int b){
		b = (int) peek();
		pull();
		a = (int) peek();
		pull();

		return a/b;
	}
	
	public boolean isOperator(String item){
			boolean operator = false;
			if (item.matches("[+,-,*,/]")){
				operator = true;
			}
		return operator;
	}
	
	public ArrayList<String> getItems(String _expresion){
			if (_expresion.matches("[0-9]*")){
				T newItem = (T) _expresion;
				push(newItem);
			}
		return (ArrayList<String>) miListaInterna;
	}
}
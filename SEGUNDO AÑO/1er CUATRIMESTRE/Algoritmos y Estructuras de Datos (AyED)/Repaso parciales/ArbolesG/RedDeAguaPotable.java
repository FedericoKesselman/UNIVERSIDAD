package ArbolesG;
import java.util.*;

public class RedDeAguaPotable {
	private GeneralTree<Character> arbol;
	
	public RedDeAguaPotable(GeneralTree<Character> arbol) {
		this.arbol = arbol;
	}
	
	public double minimoCaudal(double caudal) {
		if (!arbol.isEmpty())
			return minimoCaudalHelper (arbol, caudal);
		else
			return -1;
	}
	
	private double minimoCaudalHelper (GeneralTree<Character> nodo, double caudal) {
		if (!nodo.hasChildren())
			return caudal;
		else {
			double min = 99999;
			double cant = 0;
			
			for (GeneralTree<Character> child: nodo.getChildren()) {
				cant = minimoCaudalHelper (child, (caudal/nodo.getChildren().size()) );
			
				if (cant < min)
					min = cant;
			}
			
			return min;
		}	
	}
	
	public static void main (String[] args) {
        GeneralTree<Character> ab1 = new GeneralTree<Character>('B');
        
        List<GeneralTree<Character>> subChildren1 = new LinkedList<GeneralTree<Character>>();
        subChildren1.add(new GeneralTree<Character>('L'));
        GeneralTree<Character> subAb1 = new GeneralTree<Character>('G', subChildren1);
        List<GeneralTree<Character>> subChildren2 = new LinkedList<GeneralTree<Character>>();
        subChildren2.add(new GeneralTree<Character>('F'));
        subChildren2.add(subAb1);
        GeneralTree<Character> ab2 = new GeneralTree<Character>('C', subChildren2);
        
        List<GeneralTree<Character>> subChildren3 = new LinkedList<GeneralTree<Character>>();
        subChildren3.add(new GeneralTree<Character>('M'));
        subChildren3.add(new GeneralTree<Character>('N'));
        GeneralTree<Character> subAb2 = new GeneralTree<Character>('J', subChildren3);
        List<GeneralTree<Character>> subChildren4 = new LinkedList<GeneralTree<Character>>();
        subChildren4.add(new GeneralTree<Character>('H'));
        subChildren4.add(new GeneralTree<Character>('I'));
        subChildren4.add(subAb2);
        subChildren4.add(new GeneralTree<Character>('K'));
        subChildren4.add(new GeneralTree<Character>('P'));
        GeneralTree<Character> ab3 = new GeneralTree<Character>('D', subChildren4);
        
        GeneralTree<Character> ab4 = new GeneralTree<Character>('E');
        
        List<GeneralTree<Character>> arbol = new LinkedList<GeneralTree<Character>>();
        arbol.add(ab1);
        arbol.add(ab2);
        arbol.add(ab3);
        arbol.add(ab4);
        GeneralTree<Character> ab = new GeneralTree<Character>('A', arbol);
        
        RedDeAguaPotable red = new RedDeAguaPotable(ab);
        System.out.println("Caudal minimo que recibe una casa: " + red.minimoCaudal(1000.0));
    }
	
}

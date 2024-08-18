package Tp3.Ej11;

import Tp3.Ej1235.GeneralTree;
import java.util.*;
import Tp1.ejercicio8.Queue;

public class ParcialArboles { 
    public static boolean resolver(GeneralTree<Integer> arbol) {
        if (!arbol.isEmpty())
            return resolverHelper(arbol);
        else
            return false;
    }
  
    private static boolean resolverHelper(GeneralTree<Integer> arbol) {
        int nivel = 2; // arranca procesando en el nivel 2

        GeneralTree<Integer> tree_aux;
        Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();

        queue.enqueue(arbol);
        queue.enqueue(null);

        while (!queue.isEmpty()) {
            tree_aux = queue.dequeue();

            if (tree_aux != null) { 
                for (GeneralTree<Integer> child: tree_aux.getChildren()) 
                    queue.enqueue(child);
            }
            else { 
            	if (!queue.isEmpty()) {
            		if (nivel != queue.size()) // en la cola unicamente van a quedar los nodos del nivel
                        return false;  // corta todo el metodo directamente

                    nivel++; // aumenta nivel 
                    queue.enqueue(null); // se va a procesar nivel nuevo
            } }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        List <GeneralTree<Integer>> subChildren1 = new LinkedList <GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(83));
        GeneralTree<Integer> subAb1 = new GeneralTree<Integer>(18, subChildren1);
        
        List <GeneralTree<Integer>> subChildren2 = new LinkedList <GeneralTree<Integer>>();
        subChildren2.add(subAb1);
        GeneralTree<Integer> subAb2 = new GeneralTree<Integer>(5, subChildren2);
        
        List <GeneralTree<Integer>> subChildren3 = new LinkedList <GeneralTree<Integer>>();
        subChildren3.add(new GeneralTree<Integer>(33));
        subChildren3.add(new GeneralTree<Integer>(12));
        subChildren3.add(new GeneralTree<Integer>(17));
        subChildren3.add(new GeneralTree<Integer>(9));
        GeneralTree<Integer> subAb3 = new GeneralTree<Integer>(3, subChildren3);
        
        List <GeneralTree<Integer>> subChildren4 = new LinkedList <GeneralTree<Integer>>();
        subChildren4.add(new GeneralTree<Integer>(7));
        subChildren4.add(new GeneralTree<Integer>(11));
        subChildren4.add(subAb3);
        GeneralTree<Integer> subAb4 = new GeneralTree<Integer>(4, subChildren4);
        
        List <GeneralTree<Integer>> subArbIzq = new LinkedList <GeneralTree<Integer>>();
        subArbIzq.add(subAb2);
        subArbIzq.add(subAb4);
        GeneralTree<Integer> arbIzq = new GeneralTree<Integer>(1, subArbIzq);
        
        List <GeneralTree<Integer>> subArbDer = new LinkedList <GeneralTree<Integer>>();
        subArbDer.add(new GeneralTree<Integer>(13));
        GeneralTree<Integer> arbDer = new GeneralTree<Integer>(25, subArbDer);
        
        List <GeneralTree<Integer>> arbol = new LinkedList <GeneralTree<Integer>>();
        arbol.add(arbIzq);
        arbol.add(arbDer);
        GeneralTree<Integer> a = new GeneralTree<Integer>(2, arbol);
        
        System.out.println("Es creciente el arbol 1: " + resolver(a));
        
        List<GeneralTree<Integer>> subChildren5 = new LinkedList <GeneralTree<Integer>>();
        subChildren5.add(new GeneralTree<Integer>(7));
        subChildren5.add(subAb3);
        GeneralTree<Integer> subAb5 = new GeneralTree<Integer>(4, subChildren5);
        
        List<GeneralTree<Integer>> subArbIzq2 = new LinkedList<GeneralTree<Integer>>();
        subArbIzq2.add(subAb2);
        subArbIzq2.add(subAb5);
        GeneralTree<Integer> arbIzq2 = new GeneralTree<Integer>(1, subArbIzq2);
        
        List <GeneralTree<Integer>> arbol2 = new LinkedList <GeneralTree<Integer>>();
        arbol2.add(arbIzq2);
        arbol2.add(arbDer);
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(2, arbol2);
        
        System.out.println("Es creciente el arbol 2: " + resolver(a2));
        
        
        //Mas casos para evaluar
        
        List <GeneralTree<Integer>> arbol3 = new LinkedList <GeneralTree<Integer>>();
        arbol3.add(new GeneralTree<Integer>(1));
        arbol3.add(new GeneralTree<Integer>(2));
        arbol3.add(new GeneralTree<Integer>(3));
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(4, arbol3);
        
        System.out.println("Es creciente el arbol 3: " + resolver(a3));
        
        List <GeneralTree<Integer>> arbol4 = new LinkedList <GeneralTree<Integer>>();
        arbol4.add(new GeneralTree<Integer>(19));
        GeneralTree<Integer> a4 = new GeneralTree<Integer>(2, arbol4);
        
        System.out.println("Es creciente el arbol 4: " + resolver(a4)); //Me devolvia true porque la cola se vacio justo en el null y no llega a evaluar el else if y sale del while, retornando true (en mi primera resolucion)
        
        List <GeneralTree<Integer>> subArb1 = new LinkedList <GeneralTree<Integer>>();
        subArb1.add(new GeneralTree<Integer>(1));
        subArb1.add(new GeneralTree<Integer>(2));
        GeneralTree<Integer> subA3 = new GeneralTree<Integer>(4, subArb1);
        List <GeneralTree<Integer>> subArb2 = new LinkedList <GeneralTree<Integer>>();
        subArb2.add(new GeneralTree<Integer>(3));
        subArb2.add(subA3);
        GeneralTree<Integer> a5 = new GeneralTree<Integer>(6, subArb2); 
        
        System.out.println("Es creciente el arbol 5: " + resolver(a5));
    }

}


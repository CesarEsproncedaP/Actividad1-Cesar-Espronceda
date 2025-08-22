package Act1;

public class DataTypeExamples {
    public static void showExamples(LinkedList list, String exampleType) {
        LinkedList tempList = new LinkedList(exampleType);

        if (exampleType.equals("simple")) {
            System.out.println("Lista Simple de Cadena:");
            tempList.insert("Cesar", "end");
            tempList.insert("Brayan", "end");
            tempList.insert("Juan", "end");
            tempList.insert("Palomo", "end");
            displayList(tempList, exampleType);

            tempList = new LinkedList(exampleType); 
            System.out.println("\nLista Simple de Números Enteros:");
            tempList.insert(7, "end");
            tempList.insert(11, "end");
            tempList.insert(16, "end");
            tempList.insert(77, "end");
            displayList(tempList, exampleType);

            tempList = new LinkedList(exampleType); 
            System.out.println("\nLista Simple de Números dobles:");
            tempList.insert(12.12, "end");
            tempList.insert(44.52, "end");
            tempList.insert(71.90, "end");
            tempList.insert(77.77, "end");
            displayList(tempList, exampleType);
        } else if (exampleType.equals("doble")) {
            System.out.println("Lista de Cadenas (Izq a Der):");
            tempList.insert("Cesar", "end");
            tempList.insert("Brayan", "end");
            tempList.insert("Juan", "end");
            tempList.insert("Palomo", "end");
            displayList(tempList, exampleType);
            System.out.println("Lista de Cadenas (Der a Izq):");
            displayListReverse(tempList, exampleType);

            tempList = new LinkedList(exampleType); 
            System.out.println("\nLista de Números Enteros (Izq a Der):");
            tempList.insert(7, "end");
            tempList.insert(11, "end");
            tempList.insert(16, "end");
            tempList.insert(77, "end");
            displayList(tempList, exampleType);
            System.out.println("Lista de Números Enteros (Der a Izq):");
            displayListReverse(tempList, exampleType);

            tempList = new LinkedList(exampleType); 
            System.out.println("\nLista de Números Dobles (Izq a Der):");
            tempList.insert(12.12, "end");
            tempList.insert(44.52, "end");
            tempList.insert(71.90, "end");
            tempList.insert(77.77, "end");
            displayList(tempList, exampleType);
            System.out.println("Lista de Números Dobles (Der a Izq):");
            displayListReverse(tempList, exampleType);
        } else {
            System.out.println("Lista de Cadenas (Izq a Der):");
            tempList.insert("Cesar", "end");
            tempList.insert("Brayan", "end");
            tempList.insert("Juan", "end");
            tempList.insert("Palomo", "end");
            displayList(tempList, exampleType);

            tempList = new LinkedList(exampleType); 
            System.out.println("\nLista de Números Enteros (Izq a Der):");
            tempList.insert(7, "end");
            tempList.insert(11, "end");
            tempList.insert(16, "end");
            tempList.insert(77, "end");
            displayList(tempList, exampleType);

            tempList = new LinkedList(exampleType); 
            System.out.println("\nLista de Números Dobles (Izq a Der):");
            tempList.insert(12.12, "end");
            tempList.insert(44.52, "end");
            tempList.insert(71.90, "end");
            tempList.insert(77.77, "end");
            displayList(tempList, exampleType);
        }
    }

    private static void displayList(LinkedList list, String type) {
        if (list.head == null) {
            System.out.println("La lista está vacía");
            return;
        }

        Node current = list.head;
        StringBuilder output = new StringBuilder();
        if (type.equals("circular")) {
            int maxDisplay = 8; 
            int count = 0;
            do {
                output.append(current.data);
                current = current.next;
                count++;
                if (current != list.head) {
                    output.append(" -> ");
                }
                if (current == list.head) {
                    output.append(" -> ").append(current.data); 
                    break; 
                }
            } while (count < maxDisplay && current != null);
            output.append(" (continúa como en un ciclo, ya que no tiene un fin como tal, todos los nodos tienen un enlace con otro)");
        } else {
            do {
                output.append(current.data);
                current = current.next;
                if (current != null) {
                    output.append(" -> ");
                }
            } while (current != null);
        }
        System.out.println(output.toString());
    }

    private static void displayListReverse(LinkedList list, String type) {
        if (list.head == null) {
            System.out.println("La lista está vacía");
            return;
        }

        StringBuilder output = new StringBuilder();
        if (type.equals("doble")) {
            Node current = list.tail;
            if (current == null) {
                System.out.println("La lista está vacía");
                return;
            }
            do {
                output.append(current.data);
                current = current.prev;
                if (current != null) {
                    output.append(" -> ");
                }
            } while (current != null);
        }
        System.out.println(output.toString());
    }
}
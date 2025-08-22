package Act1;

import java.util.Scanner;

public class Main {
    private static LinkedList currentList = null;
    private static LinkedList contactList = null;       
    private static String listType = "simple";
    private static Scanner scanner = new Scanner(System.in);
    private static Pila processStack = new Pila();
    private static Cola taskQueue = new Cola();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Programa Act 1 | César Espronceda | AL07040765 ===");
            System.out.println("1. Crear una lista");
            System.out.println("2. Ejemplos de las listas");
            System.out.println("3. Agenda de contactos");
            System.out.println("4. Gestión de sistema operativo");
            System.out.println("5. Salir");
            System.out.print("Opción: ");

            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    createList();
                    if (currentList != null) {
                        handleListMenu();
                    }
                    break;
                case 2:
                    handleExampleMenu();
                    break;
                case 3:
                    handleContactMenu();
                    break;
                case 4:
                    handleOSMenu();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Tu opción no es válida.");
            }
        }
    }

    private static void createList() {
        System.out.println("Elige tu tipo de lista:");
        System.out.println("1. Simple");
        System.out.println("2. Doble");
        System.out.println("3. Circular");
        System.out.print("Opción: ");
        int type = scanner.nextInt();
        scanner.nextLine();

        String typeStr = (type == 1) ? "simple" : (type == 2) ? "doble" : "circular";
        currentList = new LinkedList(typeStr);
        contactList = new LinkedList(typeStr); 
        listType = typeStr;
        System.out.println("Lista " + typeStr + " creada.");

        System.out.print("¿Quieres agregar elementos a la lista? (Si/No) ");
        String add = scanner.nextLine();
        if (add.equalsIgnoreCase("si")) {
            System.out.println("Ingresa los elementos que quiewras (escribe 'fin' para terminar):");
            while (true) {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("fin")) break;
                currentList.insert(input, "end"); 
                System.out.println("Se ha insertado: " + input);
            }
            System.out.println("Elementos insertados:");
            currentList.display(false); 
        }
    }

    private static void handleListMenu() {
        while (true) {
            System.out.println("\n=== Menú de " + listType + " ===");
            System.out.println("1. Insertar elemento");
            System.out.println("2. Eliminar elemento");
            System.out.println("3. Buscar elemento");
            System.out.println("4. Mostrar elementos");
            if (listType.equals("doble")) {
                System.out.println("5. Mostrar elementos de derecha a izquierda");
            }
            System.out.println("6. Volver al menú principal");
            System.out.print("Opción: ");

            int op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    System.out.println("¿Dónde quieres insertar el elemento?");
                    System.out.println("1. Al inicio");
                    System.out.println("2. Al final");
                    System.out.print("Opción: ");
                    int pos = scanner.nextInt();
                    scanner.nextLine();
                    String position = (pos == 1) ? "start" : "end";
                    System.out.print("Ingresa el elemento: ");
                    String insertData = scanner.nextLine();
                    currentList.insert(insertData, position);
                    System.out.println("Insertado " + position + ": " + insertData);
                    break;
                case 2:
                    System.out.print("Ingresa el elemento que quieres eliminar: ");
                    String deleteData = scanner.nextLine();
                    currentList.delete(deleteData);
                    System.out.println("Elemento " + deleteData + " se ha eliminado.");
                    break;
                case 3:
                    System.out.print("Ingresa el elemento a buscar: ");
                    String searchData = scanner.nextLine();
                    if (currentList.search(searchData)) {
                        System.out.println("Encontrado");
                    } else {
                        System.out.println("No encontrado");
                    }
                    break;
                case 4:
                    System.out.println("Elementos:");
                    currentList.display(false); 
                    break;
                case 5:
                    if (listType.equals("doble")) {
                        System.out.println("Elementos (Der a Izq):");
                        displayReverse(currentList);
                    } else {
                        System.out.println("Tu ipción no esta disponible para este tipo de lista.");
                    }
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Tu opción no es válida.");
            }
        }
    }

    private static void handleExampleMenu() {
        while (true) {
            System.out.println("\n=== Ejemplos de Listas ===");
            System.out.println("1. Ejemplo Lista Simple");
            System.out.println("2. Ejemplo Lista Doble");
            System.out.println("3. Ejemplo Lista Circular");
            System.out.println("4. Volver al menú principal");
            System.out.print("Opción: ");

            int op = scanner.nextInt();
            scanner.nextLine();

            LinkedList tempList = (currentList != null) ? currentList : new LinkedList("simple");
            switch (op) {
                case 1:
                    DataTypeExamples.showExamples(tempList, "simple");
                    break;
                case 2:
                    DataTypeExamples.showExamples(tempList, "doble");
                    break;
                case 3:
                    DataTypeExamples.showExamples(tempList, "circular");
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void handleContactMenu() {
        if (contactList == null && listType != null) {
            contactList = new LinkedList(listType);
            System.out.println("Lista de contactos creada con tipo " + listType + ".");
        } else if (contactList == null) {
            System.out.println("Primero crea una lista en el menú principal.");
            return;
        }

        while (true) {
            System.out.println("\n=== Menú de Agenda de Contactos ===");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Eliminar contacto");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Mostrar contactos");
            System.out.println("5. Volver al menú principal");
            System.out.print("Opción: ");

            int op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Nombre: ");
                    String name = scanner.nextLine();
                    System.out.print("Dirección: ");
                    String address = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String phone = scanner.nextLine();
                    Contact contact = new Contact(name, address, phone);

                    if (!contactList.search(contact)) {
                        contactList.insert(contact, "end");
                        System.out.println("Insertado: " + contact);
                    } else {
                        System.out.println("Contacto " + name + " ya existe.");
                    }
                    break;
                case 2:
                    System.out.print("Ingresa el nombre del contacto a eliminar: ");
                    String deleteName = scanner.nextLine();
                    Contact tempContact = new Contact(deleteName, "", ""); 
                    if (contactList.search(tempContact)) {
                        contactList.delete(tempContact);
                        System.out.println("Contacto " + deleteName + " eliminado.");
                    } else {
                        System.out.println("Contacto " + deleteName + " no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Ingresa nombre del contacto a buscar: ");
                    String searchName = scanner.nextLine();
                    Contact searchContact = new Contact(searchName, "", ""); 
                    if (contactList.search(searchContact)) {
                        System.out.println("Contacto " + searchName + " encontrado.");
                    } else {
                        System.out.println("Contacto " + searchName + " no encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Contactos:");
                    contactList.display(false); 
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Tu opción no es valida.");
            }
        }
    }

    private static void handleOSMenu() {
        while (true) {
            System.out.println("\n=== Gestión de Sistema Operativo ===");
            System.out.println("1. Pilas");
            System.out.println("2. Colas");
            System.out.println("3. Volver al menú principal");
            System.out.print("Opción: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    handleStackMenu();
                    break;
                case 2:
                    handleQueueMenu();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Tu opción no es válida.");
            }
        }
    }

    private static void handleStackMenu() {
        while (true) {
            System.out.println("\n=== Menú de Pilas ===");
            System.out.println("1. Agregar comando a la pila");
            System.out.println("2. Eliminar el último comando");
            System.out.println("3. Ver el último comando en la pila");
            System.out.println("4. Volver al menú anterior");
            System.out.print("Opción: ");

            int op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Ingresa nombre del comando: ");
                    String comando = scanner.nextLine();
                    processStack.push(comando);
                    System.out.println("Se ha insertado: " + comando);
                    break;
                case 2:
                    String popped = (String) processStack.pop();
                    if (popped != null) {
                        System.out.println("El comando: " + popped + " se ha eliminado.");
                    }
                    break;
                case 3:
                    String peekStack = (String) processStack.peek();
                    if (peekStack != null) {
                        System.out.println("Elementos:");
                        System.out.println(peekStack);
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Tu opción no es válida.");
            }
        }
    }

    private static void handleQueueMenu() {
        while (true) {
            System.out.println("\n=== Menú de Colas ===");
            System.out.println("1. Agregar programa a la cola");
            System.out.println("2. Ejecutar el siguietn programa");
            System.out.println("3. Ver el primer programa en la cola");
            System.out.println("4. Volver al menú anterior");
            System.out.print("Opción: ");

            int op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Ingresa nombre de la tarea: ");
                    String task = scanner.nextLine();
                    taskQueue.enqueue(task);
                    System.out.println("Se ha insertado: " + task);
                    break;
                case 2:
                    String dequeued = (String) taskQueue.dequeue();
                    if (dequeued != null) {
                        System.out.println("La tarea: " + dequeued + " se ha eliminado de la cola.");
                    }
                    break;
                case 3:
                    String peekQueue = (String) taskQueue.peek();
                    if (peekQueue != null) {
                        System.out.println("Elementos:");
                        System.out.println(peekQueue);
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Tu opción no es válida.");
            }
        }
    }

    private static void displayReverse(LinkedList list) {
        if (list.head == null) {
            System.out.println("La lista está vacía");
            return;
        }
        Node current = list.tail;
        StringBuilder output = new StringBuilder();
        do {
            output.append(current.data);
            current = current.prev;
            if (current != null) {
                output.append(" -> ");
            }
        } while (current != null);
        System.out.println(output.toString());
    }
}
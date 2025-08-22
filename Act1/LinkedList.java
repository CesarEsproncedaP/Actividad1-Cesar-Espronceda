package Act1;

//Se que me recomendó cambiar: El manejar nombres de texto para definir las clases, "circular," "doble" , no es lo recomendable. Debes de usar de preferencia números.
public class LinkedList {
    Node head;
    Node tail;
    private String type;

    public LinkedList(String type) {
        this.type = type;
        this.head = null;
        this.tail = null;
    }

    public String getType() {
        return type;
    }

    public void insert(Object data, String position) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            if (type.equals("circular")) {
                head.next = head;
                head.prev = head;
                tail = head;
            } else {
                tail = head;
            }
            return;
        }

        if (position.equals("start")) {
            newNode.next = head;
            if (type.equals("doble") || type.equals("circular")) {
                head.prev = newNode;
            }
            head = newNode;
            if (type.equals("circular")) {
                tail.next = head;
                head.prev = tail;
            }
        } else {
            Node current = head;
            while (current.next != null && (!type.equals("circular") || current.next != head)) {
                current = current.next;
            }
            current.next = newNode;
            if (type.equals("doble") || type.equals("circular")) {
                newNode.prev = current;
            }
            tail = newNode;
            if (type.equals("circular")) {
                tail.next = head;
                head.prev = tail;
            }
        }
    }

    public void delete(Object data) {
        if (head == null) {
            System.out.println("La lista esta vacía, no se puede eliminar.");
            return;
        }

        Node current = head;
        Node prev = null;

        do {
            if (current.data.equals(data)) {
                if (prev == null) { 
                    head = current.next;
                    if (head == null) {
                        tail = null;
                    } else {
                        if (type.equals("doble") || type.equals("circular")) {
                            head.prev = null;
                        }
                        if (type.equals("circular")) {
                            tail.next = head;
                            if (head != null) {
                                head.prev = tail;
                            }
                        }
                    }
                } else { 
                    prev.next = current.next;
                    if (type.equals("doble") || type.equals("circular")) {
                        if (current.next != null) {
                            current.next.prev = prev;
                        } else {
                            tail = prev; 
                        }
                    }
                    if (type.equals("circular") && current == tail) {
                        tail = prev;
                        tail.next = head;
                        if (head != null) {
                            head.prev = tail;
                        }
                    }
                }
                return;
            }
            prev = current;
            current = current.next;
        } while (current != null && (!type.equals("circular") || current != head));

        System.out.println("Elemento no encontrado.");
    }

    public boolean search(Object data) {
        if (head == null) {
            return false;
        }

        Node current = head;
        do {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        } while (current != null && (!type.equals("circular") || current != head));
        return false;
    }

    public void display(boolean isExample) {
        if (head == null) {
            System.out.println("La lista está vacía");
            return;
        }

        Node current = head;
        StringBuilder output = new StringBuilder();
        if (type.equals("circular") && !isExample) {
            do {
                output.append(current.data);
                current = current.next;
                if (current != null && current != head) {
                    output.append(" -> ");
                }
            } while (current != null && current != head);
        } else if (type.equals("circular")) {
            int maxDisplay = 10; 
            int count = 0;
            Node startNode = current; 
            boolean hasCompletedCycle = false;

            do {
                if (count >= maxDisplay) break; 
                output.append(current.data);
                current = current.next;
                count++;
                if (current != startNode || !hasCompletedCycle) {
                    output.append(" -> ");
                }
                if (current == startNode && count > 1) {
                    hasCompletedCycle = true;
                    output.append(current.data);
                    output.append(" (continúa cíclicamente)");
                    break;
                }
            } while (current != null);
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

    public Node getTail() {
        return tail;
    }
}
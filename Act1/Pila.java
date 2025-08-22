package Act1;

public class Pila {
    private LinkedList list;

    public Pila() {
        list = new LinkedList("simple");
    }

    public void push(Object data) {
        list.insert(data, "start");
    }

    public Object pop() {
        if (list.head == null) {
            System.out.println("La lista esta vacía, no se puede eliminar.");
            return null;
        }
        Object data = list.head.data;
        list.delete(data);
        return data;
    }

    public Object peek() {
        if (list.head == null) {
            System.out.println("La lista está vacía");
            return null;
        }
        return list.head.data;
    }

    public void display() {
        list.display(false);
    }
}
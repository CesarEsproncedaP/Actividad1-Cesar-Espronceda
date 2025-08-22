package Act1;

public class Cola {
    private LinkedList list;

    public Cola() {
        list = new LinkedList("simple");
    }

    public void enqueue(Object data) {
        list.insert(data, "end");
    }

    public Object dequeue() {
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
package Act1;


public class Contact {
    String name;
    String address;
    String phone;

    public Contact(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contact other = (Contact) obj;
        return name.equals(other.name);
    }

    @Override
    public String toString() {
        return "Contacto: " + name + ", Dirección: " + address + ", Télefono: " + phone;
    }
}
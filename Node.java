public class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
    public void setLink(Node<T> other) {
        this.next = other;
    }
    public Node<T> getNext(){
        return next;
    }
    public T getData() {
        return data;
    }
    public String toString() {
        return "" + data;
    }
}
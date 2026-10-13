public class LearningLinks {
    public static void main(String[] args) {
        Node one = new Node<>(20);
        //System.out.println(one);

        Node two = new Node<>(3);
        one.setLink(two);
        
        //System.out.println(one);
        //System.out.println(one.getNext());

        //Node three = new Node<>(1);

        one.getNext().setLink(new Node<>(1));

        //Node three = new Node<>(-4);

        //two.setLink(three);
        //System.out.println(one.getNext().getNext());

        Node temp = one;
        /*while(temp != null){
            System.out.println(temp.getData());
            temp = temp.getNext();
        }*/

        temp = one;
        while(temp.getNext() != null){
            temp = temp.getNext();
        }
        temp.setLink(new Node<>(5));
        Node newNode = new Node<>(4);

        newNode.setLink(one);
        temp = newNode;
        while(temp != null){
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
        Node temp2 = newNode;
        while(temp2.getNext().getNext() != null){
            temp2 = temp2.getNext();
        }
        temp2.setLink(null);
        while(temp != null){
            System.out.println(temp.getData());
        }
    }

}

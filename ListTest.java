public class ListTest {

    //needs to throw EmptyCollectionException
    public static void main(String[] args) throws EmptyCollectionException{
        SortedLinkedList<Character> sll = new SortedLinkedList<Character>();
        
        sll.add('e');
        sll.add('c');
        sll.add('a');
        System.out.println(sll);
        
        sll.reverse();
        System.out.println(sll);
        
        sll.add('d');
        System.out.println(sll);
        
        sll.reverse();
        System.out.println(sll);
        
        sll.add('d');
        sll.add('d');
        System.out.println(sll);
        
        System.out.println(sll.get(5));
        
        System.out.println(sll.contains('d'));
        System.out.println(sll.contains('f'));
        
        sll.remove(2);
        sll.remove(2);
        sll.remove(2);
        System.out.println(sll.getSize());
        
        sll.remove(2);
        System.out.println(sll);
        
        sll.clear();
        
        try {
            sll.remove(1);
        } catch(EmptyCollectionException e) {
            System.out.println("Exception caught: " + e.toString());
        }
        
        try {
            sll.get(3);
        }catch(IndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e.toString());
        }
        
        sll.add('a');
        sll.add('a');
        
        try {
            sll.remove(10);
        }catch(IndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e.toString());
        }
    }

}
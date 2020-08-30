//author: Kevin Elfert
//date: 26 March 2020
public class SortedLinkedList<T extends Comparable<? super T>>
{
    //the size of the list
    private int size = 0;

    private int modCount = 0; // need to find where to put these

    private boolean reverse = false;

    private Node<T> head;

    private Node<T> tail;

    //constructor
    public SortedLinkedList()
    {
        clear();
    }//end constructor

    //clear
    public void clear()
    {
        head = new Node<T>(null, null, tail);
        tail = new Node<T>(null, head, null);
        size = 0;
        modCount++;
    }//end clear

    //getSize
    public int getSize()
    {
        return size;
    }//end get size

    //toString
    public String toString()
    {
        String output = "";
        int count;
        for (count = 1; count<=size-1; count++)
        {
            output+=getNode(count).element + ", ";
        }
        output+=getNode(count).element;
        return "List:\n" + output;
    }//end to String

    //add
    public boolean add(T obj)
    {
        Node<T> current = head.next;
        Node<T> nodeToAdd = new Node<T>(obj, null, null);
        if(size == 0)
        {
            head.next = nodeToAdd;
            nodeToAdd.prev = head;
            tail.prev = nodeToAdd;
            nodeToAdd.next = tail;
            modCount++;
            size++;
            return true;
        }
        if(reverse == false)
        {
            while(current.next != null)
            {
                   
                int result = nodeToAdd.element.compareTo(current.element);
                if (result < 0)
                {
                    current.prev.next = nodeToAdd;
                    nodeToAdd.prev = current.prev;
                    current.prev = nodeToAdd;
                    nodeToAdd.next = current;
                    modCount++;
                    size++;
                    return true;
                }
                if(result>=0&&current.next == tail)
                {
                    current.next.prev = nodeToAdd;
                    nodeToAdd.next = current.next;
                    current.next = nodeToAdd;
                    nodeToAdd.prev = current;
                    modCount++;
                    size++;
                    return true;
                }
                current = current.next;
            }
        }
        else
        {
            while(current.next != null)
            {
                int result = nodeToAdd.element.compareTo(current.element);
                if (result >= 0)
                {
                    current.prev.next = nodeToAdd;
                    nodeToAdd.prev = current.prev;
                    current.prev = nodeToAdd;
                    nodeToAdd.next = current;
                    modCount++;
                    size++;
                    return true;
                }
                if(result<0&&current.next == tail)
                {
                    current.next.prev = nodeToAdd;
                    nodeToAdd.next = current.next;
                    current.next = nodeToAdd;
                    nodeToAdd.prev = current;
                    modCount++;
                    size++;
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }//end add

    //remove
    public T remove(int index) throws EmptyCollectionException
    {
        Node<T> remove = null;
        Node<T> temp = null;
        if(index>size+2)
            throw new IndexOutOfBoundsException();
        if (size<=0)
            throw new EmptyCollectionException();
        try {
            size--;
            remove = getNode(index+1);
            temp = remove.prev;
            temp.next = remove.next;
            temp = remove.next;
            temp.prev = remove.prev;
            modCount++;
            return remove.element;
        } catch (NullPointerException e) {
            //TODO: handle exception
        }
        return null;
    }//end remove


    //get
    public T get(int index)
    {
        Node<T> nodeToGet = null;
        if(index>size)
            throw new IndexOutOfBoundsException();
        nodeToGet = getNode(index+1);
        return nodeToGet.element;
    }//end get

    //getNode
    public Node<T> getNode(int index)
    {
        Node<T> current = head;
        int count = 0;
        while (count < index) 
        {
            current = current.next;
            count++;
        }
        return current;
    }//end get node

    //reverse
    public void reverse()
    {
        if(reverse == false)
            reverse = true;
        else    
            reverse = false;  
        if(size>0)
        {
            Node<T> current = head.next;
            Node<T> temp = null;
            while(current.next != null)
            {
                temp = current.prev;
                current.prev = current.next;
                current.next = temp;
                current = current.prev;
            }
            head.next.next = tail;
            tail.prev.prev = head;
            temp = head.next;
            head.next = tail.prev;
            tail.prev = temp;
            modCount++;
        }
    }//end reverse

    //contains
    public boolean contains(T item)
    {
        for (int i = 0; i<=size; i++)
        {
            if(item.equals(get(i)))
                return true;
        }
        return false;
    }


    private static class Node<T>
    {
        T element;
        Node<T> next;
        Node<T> prev;

        public Node(T item,Node<T> prevNode, Node<T> nextNode)
        {
            element = item;
            prev = prevNode;
            next = nextNode;
            
        }
    }//end node class
}//end sorted linked list class
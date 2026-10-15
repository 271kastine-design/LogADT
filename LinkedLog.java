
/**
 * This LinkedLog object represents a Log ADT implemented as
 * a LinkedList using the EnhancedLogInterface.
 * 
 * @author 
 * @version 
 */
public class LinkedLog<T> implements EnhancedLogInterface<T>
{
    private LLNode<T> log;
    private String name;
    private int size;

    public LinkedLog(String name)
    {
        this.name = name;
        this.log = null;
        this.size = 0;
    }
    
    // returns the name of this StringLog
    public String getName()
    {
        return this.name;
    }

    // returns the logical size of this StringLog
    public int size()
    {
        return this.size;
    }
    
    // returns true if this list contains no elements
    public boolean isEmpty()
    {
        return this.size == 0;
    }
    
    // returns true if this list is completely full
    public boolean isFull()
    {
        return false;
    }

    // appends the specified element to the end of this list
    public void add(T element)
    {
        LLNode<T> newNode = new LLNode<T>(element);
        if (log == null)
        {
            log = newNode;
        }
        else
        {
            LLNode<T> current = log;
            while (current.getLink() != null)
            {
                current = current.getLink();
            }
            current.setLink(newNode);
        }
        size++;
    }
  
    // returns the element at the specified position in this list
    public T get(int index)
    {
        int temp = 0;
        LLNode<T> temporary = this.log;
        while(temporary != null){
            if(temp!= index){
            temporary = temporary.getLink();
            temp++;
            }
            else{
                return temporary.getInfo();
            }
        }
        return null;
    }
    
    // returns the index of the first occurance of the specified element
    // in this list, or -1 if this list does not contain the element
    public int indexOf(T element)
    {
        int index = 0;
        LLNode<T> temp = log;
        LLNode<T> end = new LLNode<T>(element);
        while(temp != null){
            if(temp.getInfo().equals(end.getInfo())){
                return index;
            }
            temp = temp.getLink();
            index++;
        }
        return -1;
    }
    
    // returns true if this list contains the specified element
    public boolean contains(T element)
    {
        LLNode<T> temp = log;
        LLNode<T> end = new LLNode<T>(element);
        while(temp != null){
            if(temp.getInfo().equals(end.getInfo())){
                return true;
            }
            temp = temp.getLink();
        }
        return false;
    }
    
    // returns a formatted string representation of this StringLog
    public String toString()
    {
        String result = "Log: " + name + "\n";
        LLNode<T> curNode = log;
        int count = 0;
    
        while (curNode != null)
        {
            count++;
            result += count + ". " + curNode.getInfo() + "\n";
            curNode = curNode.getLink();
        }
    return result;
    }
    
    // replaces the element at the specified position in this list
    // with the specified element
    public T set(int index, T element)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException();
        }

        int i = 0;
        LLNode<T> temp = log;

        while (temp != null)
        {
            if (i == index)
            {
                T oldElement = temp.getInfo();
                temp.setInfo(element);
                return oldElement;
            }
            temp = temp.getLink();
            i++;
        }
        throw new IndexOutOfBoundsException();
    }
    
    // inserts the specified element at the specified position in this list
    public void add(int index, T element)
    {
        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException();
        }

        LLNode<T> newNode = new LLNode<T>(element);
        if (index == 0)
        {
            newNode.setLink(log);
            log = newNode;
        }
        else
        {
            LLNode<T> previous = log;
            for (int i = 0; i < index - 1; i++)
            {
                previous = previous.getLink();
            }
            newNode.setLink(previous.getLink());
            previous.setLink(newNode);
        }
        size++;
    }
    
    // removes the element at the specified position in this list
    public T remove(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException();
        }

        LLNode<T> removed;
        if (index == 0)
        {
            removed = log;
            log = log.getLink();
        }
        else
        {
            LLNode<T> previous = log;
            for (int i = 0; i < index - 1; i++)
            {
                previous = previous.getLink();
            }
            removed = previous.getLink();
            previous.setLink(removed.getLink());
        }
        size--;
        return removed.getInfo();
    }
    
    // removes the first occurance of the specified element from this
    // list, if it is present
    public boolean remove(T element)
    {
        LLNode<T> current = log;
        LLNode<T> previous = null;
        while (current != null)
        {
            boolean matches = element == null
                ? current.getInfo() == null
                : element.equals(current.getInfo());
            if (matches)
            {
                if (previous == null)
                {
                    log = current.getLink();
                }
                else
                {
                    previous.setLink(current.getLink());
                }
                size--;
                return true;
            }
            previous = current;
            current = current.getLink();
        }
        return false;
    }
        
    // removes all of the elements from this list
    public void clear()
    {
        log = null;
        size = 0;
    }
}

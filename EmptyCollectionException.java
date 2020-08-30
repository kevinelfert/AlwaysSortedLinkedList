//author: Kevin Elfert
//date: 26 March 2020
public class EmptyCollectionException extends Exception
{
    public EmptyCollectionException()
    {
        super();
    }

    public EmptyCollectionException(String message)
    {
        super(message);
    }

    public EmptyCollectionException(Exception e)
    {
        super(e);
    }

    public EmptyCollectionException(String message, Exception e)
    {
        super(message, e);
    }
}
package src;

public interface Stack<E>
{
    public void push(E data);

	public Node <E>  pop();

	public Node <E>  top();
	 
    public boolean isEmpty();
	 
	public String toString();
	 
}

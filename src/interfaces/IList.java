package interfaces;

import java.util.Collection;
import java.util.List;

public interface IList<T> {
	
	public boolean add(T value);
	
	public boolean remove(T value);
	
	public void clear();
	
	public boolean contains(T value);
	
	public int size();
	
	public boolean validate();
	
	public List<T> toList();

	public Collection<T> toCollection();	
	
}

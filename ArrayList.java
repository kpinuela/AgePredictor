package predictagefinal;

import java.util.Iterator;




public class ArrayList<T> implements List<T> {
	
	T [] arr;
	int  size;
	
	

	private class ListIterator<T> implements Iterator<T> {
		
		private int next;
		
		public ListIterator() {
			next = 0;
		}

		@Override
		public boolean hasNext() {
			if (next < size)
				return true;
			return false;
		}

		
		@Override
		public T next() {
			return (T) arr[next++];
		}
		
	}
	
	
	
	public ArrayList () {
		size = 0;
		arr = (T[]) new Object[10];
	}
	
	public Iterator<T> iterator() {
		return new ListIterator<T>();
	}
	
	private void growArray () {
		T[] newArray = (T[]) new Object[arr.length * 2];
		for (int i = 0; i < arr.length; i++) 
			newArray[i] = arr[i];
		arr = newArray;
	}

	@Override
	public void add(T item) throws Exception { 
		if (size == arr.length) 
			growArray();
		arr[size++] = item;
	}

	@Override
	public void add(int pos, T item) throws Exception {  
		if (pos < 0 || pos > size-1 )
			throw new Exception("List index out of bounds");
		if (size == arr.length)
			growArray();
		for (int i = size; i > pos; i--) {
			arr[i] = arr[i-1];
		}
		arr[pos] = item;
		++size;
	}

	@Override
	public T get(int pos) throws Exception { 
		if (pos < 0 || pos > size-1 )
			throw new Exception(" index out of bounds");
		return arr[pos];
	}

	@Override
	public T remove(int pos) throws Exception { 
		if (pos < 0 || pos > size-1 )
			throw new Exception("index out of bounds");
		T item = arr[pos];
		for (int i = pos; i < size-1; i++)
			arr[i] = arr[i+1];
		--size;
		return item;
	}

	@Override
	public int size() {  
		return size;
	}

	@Override
	public void add(PersonInfo data) {
		if (size == arr.length) 
			growArray();
		T item = null;
		arr[size++] = item;
		
	}
	
	public void set(int index, T newVal) {
        if (index < 0 || index >= size()) throw new ArrayIndexOutOfBoundsException();
        T old = arr[index];
        arr[index] = newVal;
      
    }
    
		// TODO Auto-generated method stub
		
	
}
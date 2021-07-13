package predictagefinal;
import java.util.Iterator;

public class LinkedList<T> implements List<T> {
	

	private class Node<T> {
		T data;
		Node<T> next;
		
		public Node(T value) {
			data = value;
			next = null;
		}
	}
	
	

	private class LinkedIterator<T> implements Iterator<T> {
		
		private Node<T> node;
		
		
		public LinkedIterator() {
			node = (Node<T>) head;
		}

		@Override
		public boolean hasNext() {
			if (node != null)
				return true;
			else
				return false;
		}

		@Override
		public T next() {
			Node<T> old = node;
			node = node.next;
			return old.data;
		}
		
	}
	
	
	private int size;
	private Node<T> head;
	
	
	public LinkedList () {
		size = 0;
		head = null;
	}
	

	@Override
	public void add(T item) throws Exception {
		if (head == null) {
			head = new Node<T>(item);
			++size;
		} else {
			Node<T> node = head;
			for (int i = 0; i < size-1; i++)
				node = node.next;
			Node<T> newNode = new Node<T>(item);
			node.next = newNode;
			++size;
		}
	}

	
	public void add(int pos, T item) throws Exception {
		if (pos < 0 || pos > size)
			throw new Exception("List index out of bounds");
		if (pos == 0) {
			Node<T> node = new Node<T>(item);
			node.next = head;
			head = node;
			++size;
		} else {
			Node<T> old = head;
			for (int i = 0; i < pos-1; i++)
				old = old.next;
			Node<T> newNode = new Node<T>(item);
			newNode.next = old.next;
			old.next = newNode;
			++size;
		}
	}

	@Override
	public T get(int pos) throws Exception {
		if (pos < 0 || pos >= size)
			throw new Exception("List index out of bounds");
		Node<T> current = head;
		for (int i = 0; i < pos; i++)
			current = current.next;
		return current.data;
	}

	@Override
	public T remove(int pos) throws Exception {
		if (pos < 0 || pos > size)
			throw new Exception("List index out of bounds");

		if (pos == 0) {
			Node<T> node = head;
			head = head.next;
			--size;
			return node.data;
		}

		Node<T> old = head;
		for (int i = 0; i < pos-1; i++) {
			old = old.next;
		}
		Node<T> node = old.next;
		old.next = node.next;
		--size;
		return node.data;
	}
	

	@Override
	public int size() {
		return size;
	}
	
	
	public Iterator<T> iterator() {
		return new LinkedIterator<T>();
	}


	@Override
	public void add(PersonInfo data) {
		T item = null;
		if (head == null) {
			head = new Node<T>(item);
			++size;
		} else {
			Node<T> node = head;
			for (int i = 0; i < size-1; i++)
				node = node.next;
			Node<T> newNode = new Node<T>(item);
			node.next = newNode;
			++size;
		}
		
	}


	@Override
	public void set(int pos, T item) {
		// TODO Auto-generated method stub
		
	}
}
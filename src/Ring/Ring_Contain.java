package Ring;

public class Ring_Contain<T> {
	
	private Node<T> head;
	/**
	 * Addicting new node in the ring on the end
	 */
	public void AddInEnd(T data) throws Exception
	{
		if (head == null)
			AddFirst(data);
		else
			AddInPosition(GetLength(), data);
		
	}
	/**
	 * Addicting new node in the ring on the top
	 * @param data
	 */
	public void AddInTop(T data)
	{
		if (head == null)
			AddFirst(data);
		else
			AddInPosition(0, data);
	}
	
	public void AddInMiddle(int index, T data)
	{
		if (head == null)
			AddFirst(data);
		else
			AddInPosition(index-1, data);
	}
	
	public void AddInPosition(int index, T data)
	{
		Node<T> n;
		Node<T> curr;
		
		try
		{
			if (!isUnique(data))
				throw new Exception("������������ ������");
			
			if (index != GetLength())
			{
				curr = FindNodeForPosition(index);
				n = new Node<T>(data, curr);
				PreviousNode(curr).setNext(n);
				if (index == 0)
					head = n;
			}
			else
			{
				n = new Node<T>(data, head);
				PreviousNode(head).setNext(n);
			}
			
			PrintConfirm(index, data);
		}
		catch(Exception f)
		{
			System.out.println(f.getMessage() + ", ������� � ����������: "+ data +" �� ����� ���� ��������");
		}
	}
	
	public void PrintRing()
	{
		Node<T> n = head;
		try
		{
			if (head == null)
				throw new Exception("������ �����");
			do
			{
				if (n.getNext() == head)
					System.out.println(n.getData());
				else
					System.out.print(n.getData()+" -> ");
				n = n.getNext();
			}
			while (n != head);
		}
		catch(Exception f)
		{
			System.out.println(f.getMessage());
		}
	}
	
	public void FindElement(T data)
	{
		try
		{
			if (head == null)
				throw new Exception("������ �����");
			
			Node<T> n = FindNodeForData(data);
			if(n != null)
				System.out.println("������� � ���������� "+ data +" ������");
			else
				System.out.println("������� � ���������� "+ data +" �� ������");
		}
		catch(Exception f)
		{
			System.out.println(f.getMessage());
		}
	}
	
	public void DeleteElement(T data)
	{
		try
		{
			if (head == null)
				throw new Exception("������ �����");
			
			Node<T> n = FindNodeForData(data);
			if(n != null)
			{
				
				PreviousNode(n).setNext(n.getNext());
				System.out.println("������� � ���������� "+ data +" �����");
				if (n == head)
					if (head.getNext() == head)
						head = null;
					else
						head = n.getNext();
			}
			else
				System.out.println("������� � ���������� "+ data +" �� ������");
		}
		catch(Exception f)
		{
			System.out.println(f.getMessage());
		}
	}
	
	/**
	 * Sorted only number types Integer, Double and Float
	 */
	public void Sort()
	{
		Node<T> n;
		try
		{
			if (head == null)
				throw new Exception("������ �����");
			
			n = head;
			if ((n.getData() instanceof Integer) || (n.getData() instanceof Double) ||(n.getData() instanceof Float))
			{
				SortNumber();
		    }
			else
			{
				throw new Exception("������������ <"+n.getData().getClass().getSimpleName() +"> ��� ������, ���������� �� ��������");
			}
		}
		catch(Exception f)
		{
			System.out.println(f.getMessage());
		}
	}
	
	private void SortNumber()
	{
		Node<T> n;
		Node<T> first, second, temp;
		for(int i = 0; i < GetLength()-1; i++)
		{
			n = head;
			for(int j = 0; j < GetLength()-1; j++)
			{
				if (CompareNumber(n.getData(),n.getNext().getData()))
				{
					
					first = n;
					second = n.getNext();
					
					temp = new Node<T>(second.getData(), second.getNext());
					PreviousNode(second).setNext(temp);
					second.setNext(PreviousNode(temp));
					PreviousNode(first).setNext(second);
					first.setNext(temp.getNext());
					
					if (n == head)
						head = second;
					n = first;
				}
				else
				{
					n = n.getNext();
				}
			}
		}
	}
	/**
	 * Compare 2 numbers types Integer, Doubles or Float
	 * if first > second return true
	 * else false 
	*/
	private Boolean CompareNumber(T first, T second)
	{
		if(first instanceof Integer)
			if ((int)first > (int)second)
				return true;
		if(first instanceof Double)
			if ((double)first > (double)second)
				return true;
		if(first instanceof Float)
			if ((float)first > (float)second)
				return true;
		return false;
	}
	
	private void PrintConfirm(int index, T data)
	{
		if (index == 0)
		{
			System.out.println("� ������ �������� ������� � ����������: "+ data);
		}	
		else
		{
			index++;
			if (index == GetLength())
			{
				System.out.println("� ����� �������� ������� � ����������: "+ data);
			}
			else
			{
				System.out.println("�� ������� ["+ index +"] �������� ������� � ����������: "+ data);
			}
		}
	}
	
	private int GetLength()
	{
		int count = 0;
		Node<T> n = head;
		do
		{
			count++;
			n = n.getNext();
		}
		while (n != head);
		return count;
	}
	
	private Node<T> PreviousNode(Node<T> Current)
	{
		Node<T> Prev = head;
		do
		{
			if (Prev.getNext() == Current)
				return Prev;
			
			Prev = Prev.getNext();
		}
		while (true);
		//return null;
	}

	private Node<T> FindNodeForData(T data)
	{
		Node<T> n = head;
		do
		{
			if (n.DataIsEqual(data))
				return n;
			
			n = n.getNext();
		}
		while (n != head);
		return null;
	}
	
	private Node<T> FindNodeForPosition(int index)
	{
		Node<T> n = head;
		int count = index;
		do
		{
			if (count == 0)
				return n;
			
			n = n.getNext();
			count--;
		}
		while (n != head);
		return null;
	}

	private void AddFirst(T data)
	{
		Node<T> n = new Node<T>(data, null);
		head = n;
		head.setNext(head);
		System.out.println("�������� ������ ������� � ����������: "+ data);
	}
	
	private boolean isUnique(T data)
	{
		Node<T> n = head;
		do
		{
			if (n.DataIsEqual(data))
				return false;
			
			n = n.getNext();
		}
		while (n != head);
		return true;
	}

	public Ring_Contain()
	{
	}
}

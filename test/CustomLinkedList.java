package test;

class Node
{
	public int data;
	public Node next;
}

public class CustomLinkedList 
{	
	private Node head=null;
	public boolean isEmpty()
	{
		if(head==null)
			return true;
		else
			return false;
	}
	
	public void addElement(int currentData)
	{
		Node currrentNode=new Node();
		currrentNode.data=currentData;
		currrentNode.next=null;
		
		if(head==null)
			head=currrentNode;
		else if(head.next==null)
			head.next=currrentNode;
		else
		{
			//Node tn=new Node(); tn=head;
			Node tn=head;
			while(tn.next !=null)
			{
					tn=tn.next;
			}
			tn.next=currrentNode;
		}		
	}
	
	public void showData()
	{
		if(head==null)
			System.out.println("Empty list");
		else if(head.next==null)
			System.out.println(head.data);
		else
		{
			//Node tn=new Node(); tn=head;
			Node tn=head;
			while(tn.next!=null)
			{
					System.out.print(tn.data+" ");
					tn=tn.next;
			}
			System.out.println(tn.data);
		}
	}
	public void removeData(int removaldata)
	{
		if(head==null)
			System.out.println("Empty list");
		else if(head.next==null && head.data==removaldata)
		{
			head=null;
			System.out.println(removaldata+" removed from list");
		}
		else if(head.data==removaldata && head.next!=null)
		{
			head=head.next;
			System.out.println(removaldata+" removed from list");
		}
		else
		{
			Node tn=head;//traverse
			Node t2=head;//follower
			while(tn.next!=null && tn.data!=removaldata)
			{
				t2=tn;
				tn=tn.next;
			}
			if(tn.next==null && tn.data!=removaldata)
				System.out.println("Data not present in list");
			if(tn.data==removaldata &&tn.next != null)
			{
				t2.next=tn.next;
				System.out.println(removaldata+" removed from list");
			}
			if(tn.data==removaldata && tn.next==null)
			{
				t2.next=null;
			}
		}
	}
	public static void main(String[] args) 
	{
		//final long startTime = System.nanoTime();
		
		CustomLinkedList a=new CustomLinkedList();
		a.addElement(12);
		a.addElement(32);
		a.addElement(64);
		a.addElement(82);
		a.addElement(42);
		a.addElement(94);
		a.showData();
		a.removeData(12);
		a.removeData(82);
		a.removeData(94);
		a.removeData(64);
		a.showData();
		
		//final long duration = System.nanoTime() - startTime;
		//System.out.println("duration :"+duration);
		
	}
}




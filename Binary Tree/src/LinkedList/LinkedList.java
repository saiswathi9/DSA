package LinkedList;

public class LinkedList{
	private Node head;
	public static class Node{
		private Node next;
		private int data;
		
		Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	
	public void pushToLinkedList(int x) {
		Node n = new Node(x);
		n.next=head;
		head=n;		
	}
	
	public void print() {
		Node tmp = head;
		while(tmp!=null) {
			System.out.println(tmp.data);
			tmp=tmp.next;
		}			
		System.out.println("end");
	}
	
	public int length() {
		Node tmp=head;
		int cnt = 0;
		while(tmp!=null) {
			cnt++;
			tmp=tmp.next;
		}
		return cnt;
	}
	
	public void inserAtEnd(int x) {
		Node n = new Node(x);
		Node tmp=head;
		while(tmp.next!=null) {
			tmp=tmp.next;
		}
			tmp.next=n;
	}
	
	public void insertAtK(int x, int pos) {
		Node tmp = head;
		Node n = new Node(x);
		for(int i=1;i<pos-1;i++) {
			tmp=tmp.next;
		}
		n.next=tmp.next;
		tmp.next=n;		
	}
	
	public int deleteFirstNode() {
		Node tmp=head;
		head=tmp.next;
		return tmp.data;
	}
	
	public void deleteLastNode() {
		Node tmp=head;
		for(int i=1;i<length()-1;i++) {
			tmp=tmp.next;
		}
		tmp.next=tmp.next.next;
	}
	
	public void deleteAtK(int k) {
		Node tmp = head;
		while(--k>0)
			tmp=tmp.next;
		tmp.next = tmp.next.next;
	}
	
	public boolean search(int x) {
		Node tmp = head;
		while(tmp!=null) {
			if(x==tmp.data) {
				return true;
			}
			tmp = tmp.next;
		}
		return false;
	}
	
	public int middleNode() {
		Node tmp = head;
		for(int i=0;i<length()/2;i++) {
			tmp=tmp.next;
		}
		return tmp.data;
	}
	
	public int kthFromEnd(int k) {
		Node tmp = head;
		for(int i =0 ;i<length()-k;i++)
			tmp=tmp.next;
		return tmp.data;
	}
	
	public void removeDuplicates() {
		Node tmp= head;
		for(int i=0;i<length();i++) {
			if(tmp.next!=null && tmp.data==tmp.next.data)
				tmp.next=tmp.next.next;
			tmp=tmp.next;
		}
	}
	
	public void removeKey(int x) {
		Node tmp = head;
		while(tmp.next!=null) {
			if(x==tmp.next.data) {
				tmp.next = tmp.next.next;
			}
			tmp = tmp.next;
		}
	}
	
	public void insertNodeInSortedList(int x) {
		
		Node tmp = head;
		Node n = new Node(x);
		while(tmp.next!=null && x>tmp.next.data) {
				tmp=tmp.next;
			}
			n.next = tmp.next;
			tmp.next = n;
		
	}
	
	public Node reverse() {
		Node curr = head;
		Node prev = null;
		Node next = null;
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	public boolean detectLoop() {
		Node fpt = head;
		Node spt = head;
		while(fpt!=null || fpt.next!=null) {
			fpt = fpt.next.next;
			spt = spt.next;
			if(fpt == spt)
				return true;
		}
		return false;
	}
	
	public boolean palindrome() {
		Node tmp = head;
		Node rev = reverse();
			if(tmp.data == rev.data) {
				tmp = tmp.next;
				rev = rev.next;
				return true;
			}
		return false;
	}
	
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new Node(0);
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(4);
		Node d = new Node(6);
		ll.head.next = a;
		a.next=b;
		b.next=c;
		c.next=b;
		System.out.println(ll.detectLoop());
//		System.out.println(ll.palindrome());
//		System.out.println(ll.length());
//		ll.inserAtEnd(5);
//		ll.insertAtK(99, 3);
//		System.out.println(ll.deleteFirstNode());
//		ll.deleteLastNode();
//		ll.deleteAtK(2);
//		ll.removeDuplicates();
//		ll.removeKey(3);
//		ll.insertNodeInSortedList(3);
//		ll.print();
//		Node n = ll.reverse();
//		ll.head = n;
//		ll.print();
//		System.out.println(ll.search(1));
//		System.out.println(ll.middleNode());
//		System.out.println(ll.kthFromEnd(4));
	}
}
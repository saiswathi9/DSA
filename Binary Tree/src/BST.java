import java.util.ArrayList;
import java.util.List;

public class BST{
	private TreeNode root;
	class TreeNode{
		private TreeNode left;
		private TreeNode right;
		int data;
		
		TreeNode(int data){
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
	
	public void insert(int x) {
		root= insert(root,x);
	}
	
	public TreeNode insert(TreeNode root, int x) {
		if(root==null) {
			root = new TreeNode(x);
			return root;
		}
		if(x>root.data)
			root.right = insert(root.right,x);
		else
			root.left = insert(root.left,x);
		return root;
	}
	
	public List inOrder(TreeNode root, List<Integer> l) {
		if(root==null)
			return l;
		inOrder(root.left, l);
		l.add(root.data);
		inOrder(root.right, l);
		return l;
	}
	
	public int largestEle(TreeNode root, int k) {
		List<Integer> l = inOrder(root, new ArrayList<Integer>());
		System.out.println(l.toString());
		return l.get(k-1);
	}
	
	public int findDist(TreeNode root, int a , int b) {
		int tmp=0;
		if(a>b) {
			tmp=a;
			a=b;
			b=tmp;
		}
		return distanceBetween2(root,a,b);
	}
	
	private int distanceBetween2(TreeNode root, int a, int b) {
		if(root==null)
			return 0;
		if(a>root.data && b>root.data)
			return distanceBetween2(root.right,a,b);
		if(a<root.data && b<root.data)
			return distanceBetween2(root.left,a,b);
		if(root.data>=a && root.data<=b)
			return distanceFromRoot(root,a)+distanceFromRoot(root,b);
		return 0;
	}

	private int distanceFromRoot(TreeNode root, int x) {
		if(root.data==x)
			return 0;
		else if(root.data>x)
			return 1+distanceFromRoot(root.left,x);
		else
			return 1+distanceFromRoot(root.right,x);
	}

	public static void main(String[] args) {
		BST b = new BST();
		b.insert(1);
		b.insert(11);
		b.insert(9);
		b.insert(5);
		b.insert(3);
		List<Integer> l = new ArrayList<>();
		b.inOrder(b.root,l);
		System.out.println("largest: "+b.largestEle(b.root, 2));
		System.out.println("dist between nodes: "+b.findDist(b.root, 1, 9));
	}
}
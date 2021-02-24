import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BinaryTree{
	private TreeNode root;
	
	public class TreeNode{
		private int data;
		private TreeNode left;
		private TreeNode right;
		
		public TreeNode(int data){
			this.data=data;
		}		
	}
	
	public void createBinaryTree() {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		
		
		root = a;
		a.left = b;
		a.right = c;
		b.left = d;
		b.right =e ;
	}
	
	public void preOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		System.out.println(""+root.data);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public void postOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(""+root.data);
	}
	
	public void inOrder(TreeNode root) {
		if(root == null)
			return;
		inOrder(root.left);
		System.out.println(""+root.data);
		inOrder(root.right);
	}
	
	public int max(int a, int b) {
		if(a >= b)
			return a;
		return b;
	}
	
	public int heightOfTree(TreeNode root) {
		if(root == null)
			return 0;
		return max(heightOfTree(root.left), heightOfTree(root.right))+1;
	}
	
	public void inOrderIterative(TreeNode root) {
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode temp = root;
		while(!stack.isEmpty() || temp!=null) {
			if(temp!= null) {
				stack.push(temp);
				temp = temp.left;
			}
			else {
				temp = stack.pop();
				System.out.println(""+temp.data);
				temp = temp.right;
			}
		}
	}
	
	public void postOrderQ(TreeNode root) {
		if(root == null) 
			return;
		postOrderQ(root.left);
		postOrderQ(root.right);
		System.out.println(root.data);
	}
	
	public void preOrderIterative(TreeNode root) {
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			System.out.println(""+temp.data);
			
			if(temp.right != null)
				stack.push(temp.right);
			if(temp.left != null)
				stack.push(temp.left);
		}
	}
	
	public void postOrderIterative(TreeNode root) {
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			
			if(temp.right != null)
				stack.push(temp.right);
			if(temp.left != null)
				stack.push(temp.left);
			System.out.println(""+temp.data);

		}
	}
	
	private List inorder(TreeNode root) {
		TreeNode tmp = root;
		List<Integer> l = new ArrayList<>();
		Stack<TreeNode> st = new Stack<>();
		while(tmp!=null || !st.isEmpty()) {
			if(tmp!=null) {
				st.push(tmp);
				tmp=tmp.left;
			}
			else {
				tmp = st.pop();
				l.add(tmp.data);
				tmp=tmp.right;
			}
		}
		return l;		
	}
	
	private List preorder(TreeNode root) {
		TreeNode tmp = root;
		List<Integer> l = new ArrayList<>();
		Stack<TreeNode> st = new Stack<>();
		st.push(tmp);
		while(!st.isEmpty()) {
			tmp=st.pop();
			l.add(tmp.data);
			if(tmp.left!=null) {
				st.push(tmp.left);
			}
			if(tmp.right!=null) {
				st.push(tmp.right);
			}
		}
		return l;
	}
	
	private List postOrder2(TreeNode root) {
		List<Integer> l = new ArrayList<>();
		if(root==null)
			return l;
		TreeNode tmp = root;

		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		s1.push(tmp);
		while(!s1.isEmpty()) {
			tmp=s1.pop();
			s2.push(tmp);
			if(tmp.left!=null)
				s1.push(tmp.left);
			if(tmp.right!=null)
				s1.push(tmp.right);
		}
		while(!s2.isEmpty())
			l.add(s2.pop().data);
		return l;
	}
	
	public void ancestorMatrix(TreeNode root, int[][] arr, int n) {
		if(root==null)
			return;
		ancestorMatrix(root.left,arr,n);
		ancestorMatrix(root.right,arr,n);
		if(root.left!=null) {
			arr[root.data][root.left.data]=1;
			
			for(int i=0;i<n;i++) {
				if(arr[root.left.data][i] == 1)
					arr[root.data][i]=1;
			}
		}
		
		else if(root.right!=null) {
			arr[root.data][root.right.data]=1;
			for(int i=0;i<n;i++) {
				if(arr[root.right.data][i]==1)
					arr[root.data][i]=1;
			}
		}
		
	}
	
	public int depthOfBT(TreeNode root) {
		if(root==null)
			return 0;
		return Math.max(depthOfBT(root.left),depthOfBT(root.right))+1;
	}
	
	public boolean search(TreeNode root, int x) {
		if(root==null)
			return false;

		if(root.data==x)
			return true;
		return (search(root.right,x))||(search(root.left,x));
	}
	
	public boolean isSymmetric(TreeNode root) {
		return symmetric(root, root);
	}
	
	private boolean symmetric(TreeNode a, TreeNode b) {
		if(a==null || b==null)
			return false;
		if(a==null && b==null)
			return true;
		return (a.data==b.data) && symmetric(a.left,b.right) && symmetric(a.right,b.left);
	}

	public static void main(String[] args) {
		BinaryTree btree = new BinaryTree();
		btree.createBinaryTree();
//		btree.preOrder(btree.root);
//		btree.postOrder(btree.root);
//		System.out.println("\n");
//		btree.preOrderIterative(btree.root);
//		btree.postOrderIterative(btree.root);
//		btree.inOrder(btree.root);
//		btree.inOrderIterative(btree.root);
		int res = btree.heightOfTree(btree.root);
		System.out.println(res);
//		btree.postOrderQ(btree.root);
//		List<Integer> l = new ArrayList<>();
//		l = btree.postOrder2(btree.root);
//		l = btree.preorder(btree.root);
//		System.out.println(Arrays.toString(l.toArray()));
//		int n=5;
//		int[][] mat=new int[n][n];
//		btree.ancestorMatrix(btree.root, mat,n);
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				System.out.println(mat[i][j]+" ");
//			}
//			System.out.println();
//		}
		System.out.println(btree.depthOfBT(btree.root));
		System.out.println(btree.search(btree.root, 9));
	}

}
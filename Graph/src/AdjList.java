import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AdjList
{
	private LinkedList<Integer>[] l;
	private int E;
	private int V;
	
	public AdjList(int n)
	{
		this.V=n;
		this.E=0;
		this.l=new LinkedList[n];
		for(int i=0;i<n;i++)
		{
			l[i]=new LinkedList<>();
		}
	}
	public void addEdge(int u,int v)
	{
		l[u].add(v);
		l[v].add(u);
		E++;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(V + " vertices, " + E + " edges " + "\n");
		for(int i = 0; i < V; i++) {
			sb.append(i + ": ");
			for(int w : l[i]) {
				sb.append(w + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public void bfs(int src) {
		Queue<Integer> q=new LinkedList<>();
		boolean visited[]=new boolean[V];
		q.add(src);
		visited[src]=true;
		while(!q.isEmpty()) {
			int res=q.poll();
			System.out.println(res);
			for(int i:l[res]) {
			if(!visited[i]) {
				q.add(i);
				visited[i]=true;
			}
			}
		}
	}
	
	public void dfs(int src) {
		boolean[] visited=new boolean[V];
		Stack<Integer> s=new Stack<Integer>();
		s.add(src);
		while(!s.isEmpty()) {
			int u=s.pop();
			if(!visited[u]) {
				visited[u]=true;
				System.out.println(u);
				for(int i:l[u]) {
					s.push(i);
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		AdjList al=new AdjList(5);
		al.addEdge(0, 1);
		al.addEdge(1, 2);
		al.addEdge(2, 3);
		al.addEdge(3, 0);
		al.addEdge(2, 4);
		
		System.out.println(al.toString());
		al.bfs(0);
		System.out.println("DFS");
		al.dfs(0);
	}
}
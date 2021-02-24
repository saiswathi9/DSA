public class Graph
{
	private int e;
	private int V;
	private int[][] adj;
	
	public Graph(int n)
	{
		this.V=n;
		this.e=0;
		this.adj=new int[n][n];
	}
	public void addEdge(int u,int v)
	{
		adj[u][v]=1;
		adj[v][u]=1;
		e++;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(V + " vertices, " + e + " edges " + "\n");
		for(int i = 0; i < V; i++) {
			sb.append(i + ": ");
			for(int w : adj[i]) {
				sb.append(w + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	public static void main(String args[])
	{
		Graph g=new Graph(4); 
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 0);
		System.out.println(g);
	}
}
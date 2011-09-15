import java.util.List;
import java.util.Random;

import obsolete.MaxFlowDinicMatrix;

public class MaxFlowTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int V = 1500;
		int E = 1000000;
		Random rnd = new Random(1);
		List<Integer>[] g = RandomGraph.getRandomUndirectedConnectedGraph(V, E, rnd);
		MaxFlowDinic f1 = new MaxFlowDinic();
		MaxFlowDinicMatrix f2 = new MaxFlowDinicMatrix();
		MaxFlowPreflow f3 = new MaxFlowPreflow();

		System.out.println("starting");

		f1.init(V);
		f2.init(V);
		f3.init(V);

		for (int i = 0; i < g.length; i++) {
			for (int j : g[i]) {
				int cap = rnd.nextInt(100) + 1;
				f1.addEdge(i, j, cap);
				f2.addEdge(i, j, cap);
				f3.addEdge(i, j, cap);
			}
		}

		long time = System.currentTimeMillis();
		int flow1 = f1.maxFlow(0, V - 1);
		System.out.println(System.currentTimeMillis() - time);

		time = System.currentTimeMillis();
		int flow2 = f2.maxFlow(0, V - 1);
		System.out.println(System.currentTimeMillis() - time);

		time = System.currentTimeMillis();
		int flow3 = f3.maxFlow(0, V - 1);
		System.out.println(System.currentTimeMillis() - time);

		System.out.println(flow1 + " " + flow2 + " " + flow3);
	}
}

package kz.greetgo.diploma.register.impl;

import kz.greetgo.depinject.core.Bean;

import java.util.Scanner;


@Bean
public class AntAlgorithmRegisterImpl {

	class Way_type {

		int itabu;

		int length;

		int tabu;
	}

	double probability(int to, Way_type W, double pheromone[][], double distance[][], int vertex) {

		Constanta CT = new Constanta();
		int T = W.tabu;
		int arr[] = new int[vertex];
		arr[vertex] = T;

		for(int m = 0; m < W.itabu; m++)
			{
				if(to == arr[m])
					{
						return 0;
					}
			}
		double sum = 0.0;
		int from = arr[W.itabu - 1];
		for(int j = 0; j < vertex; j++)
			{
				boolean flag = true;
				for(int c = 0; c < W.itabu; ++c)
					if(j == arr[c])
						flag = false;
				if(flag) sum += Math.pow(pheromone[from][j], CT.ALPHA) * Math.pow(distance[from][j], CT.BETTA);
			}
		return Math.pow(pheromone[from][to], CT.ALPHA) * Math.pow(distance[from][to], CT.BETTA) / sum;
	}

	Way_type AntColonyOptimization(int vertex, int start, int finish) {

		Way_type Way = new Way_type();
		Way.itabu = 0;
		Way.length = -1;
		double distance[][] = new double[vertex][vertex];
		double pheromone[][] = new double[vertex][vertex];
		double distance0[][] = new double[vertex][vertex];
		for(int z = 0; z < vertex; ++z)
			{
				for(int j = 0; j < vertex; ++j)
					{
						distance[z][j] = vertex;
						pheromone[z][j] = 1.0 / vertex;
						if(z != j)
							distance[z][j] = 1.0 / distance0[z][j];
					}
			}
		Constanta CT = new Constanta();
		Way_type ants[] = new Way_type[CT.M];
		for(int k = 0; k < CT.M; k++)
			{
				ants[k].itabu = 0;
				ants[k].length = 0;
				int AR = ants[k].tabu;
				int ar[] = new int[vertex];
				AR = ar[vertex];
				ar[ants[k].itabu++] = start;
			}
		Way_type way = new Way_type();
		for(int m = 0; m < CT.T_MAX; m++)
			{
				for(int k = 0; k < CT.M; k++)
					{
						int AR = ants[k].tabu;
						int ar[] = new int[vertex];
						AR = ar[vertex];
						do
							{
								int j_max = -1;
								double p_max = 0.0;
								for(int j = 0; j < vertex; ++j)
									{
										if(ar[ants[k].itabu - 1] != j)
											{
												double p = probability(j, ants[k], pheromone, distance, vertex);
												if(p >= p_max)
													{
														p_max = p;
														j_max = j;
													}
											}
									}
								ants[k].length += distance0[ar[ants[k].itabu - 1]][j_max];
								ar[ants[k].itabu++] = j_max;
							} while(ar[ants[k].itabu - 1] != finish);
						for(int y = 0; y < ants[k].itabu - 1; y++)
							{
								int from = ar[y % ants[k].itabu];
								int to = ar[(y + 1) % ants[k].itabu];
								pheromone[from][to] += CT.Q / ants[k].length;
								pheromone[to][from] = pheromone[from][to];
							}
						//Way_type way = new Way_type();
						if(ants[k].length < way.length || way.length < 0)
							{
								way.itabu = ants[k].itabu;
								way.length = ants[k].length;
								for(int v = 0; v < way.itabu; v++)
									{
										int W = way.tabu;
										int w[] = new int[v];
										W = w[v];
										w[v] = ar[v];
									}
							}
						ants[k].itabu = 1;
						ants[k].length = 0;
					}
				for(int p = 0; p < vertex; ++p)
					for(int j = 0; j < vertex; j++)
						if(p != j) pheromone[p][j] *= (1 - CT.RHO);
			}
		return way;
	}

	public void main(String[] args) throws java.lang.Exception {

		Constanta CT = new Constanta();
		int N = 0, A = 0, B = 0;
		while(N < CT.N_MIN || N > CT.N_MAX)
			{
				Scanner sc = new Scanner(System.in);
				System.out.println("Введіть кількість вершин: ");
				N = sc.nextInt();
				double D[][] = new double[N][N];
				System.out.println("Введіть матрицю відстаней: ");
				for(int i = 0; i < N; i++)
					{
						for(int j = 0; j < N; j++)
							{
								D[i][j] = sc.nextInt();
							}
					}
				while(A < 1 || A > N)
					{
						System.out.println("Введіть початкову вершину від 1 до " + N + ": ");
						A = sc.nextInt();
					}
				while(B < 1 || B > N || B == A)
					{
						System.out.println("Введіть кінцеву вершину від 1 до " + N + " виключаючи " + A + ": ");
						B = sc.nextInt();
					}
				Way_type WAY = AntColonyOptimization(N, --A, --B);
				System.out.println("Довжина шляху: " + WAY.length);
				int T = WAY.tabu;
				int t[] = new int[0];
				t[0] = T;
				System.out.println("Шлях: " + ++t[0]);
				for(int i = 1; i < WAY.itabu; i++)
					{
						int R = WAY.tabu;
						int ar[] = new int[i];
						ar[i] = R;
						System.out.println(" -> " + ++ar[i]);
					}
			}
	}

}

class Constanta {

	int N_MIN = 3;

	int N_MAX = 30;

	int ALPHA = 1;

	int BETTA = 3;

	int T_MAX = 100;

	int M = 20;

	int Q = 100;

	double RHO = 0.5;
}


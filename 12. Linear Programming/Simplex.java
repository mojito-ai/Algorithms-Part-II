/**
* <h1> <b>Simplex Algorithm</b> Simplex algorithm. [George Dantzig, 1947] </h1>
* 
* <li> Developed shortly after WWII in response to logistical problems, including Berlin airlift.
* <li> Ranked as one of top 10 scientific algorithms of 20th century. 
* 
* <li> Generic algorithm.
* <li> Start at some extreme point.
* <li> Pivot from one extreme point to an adjacent one. (never decreasing objective function)
* <li> Repeat until optimal.
* 
* <li> How to implement? Linear algebra
* @author  Mohit Sharma
* @version 2.0
* @since   04-03-2021
* 
*/

public class Simplex {
	
	/*
	 * Simplex tableau
	 * 1. Encode standard form LP in a single Java 2D array
	 * 2. Simplex algorithm transforms initial 2D array into solution.
	 * 
	 */
	private double [][] a;	//simplex tableau
	private int m, n;		//M constraints, N variables
	/*
	 *1. Simplex algorithm: basis
	 *A basis is a subset of m of the n variables.
	 *
	 *Basic feasible solution (BFS).
	 *		Set n – m nonbasic variables to 0, solve for remaining m variables.
	 *		Solve m equations in m unknowns.
	 *		If unique and feasible ⇒ BFS.
	 *		BFS ⇔ extreme point. 
	 * 
	 *
	 *2. Simplex algorithm: initialization 
	 *
	 *Initial basic feasible solution.
	 *		Start with slack variables { SC , SH , SM } as the basis. {one basic variable per row}
	 *		Set non-basic variables A and B to 0.
	 *		3 equations in 3 unknowns yields SC = 480, SH = 160, SM = 1190.
 	 *
 	 *
 	 *3. Simplex algorithm: pivot 1
 	 *
 	 *substitute B = (1/15) (480 – 5A – SC) and add B into the basis (rewrite 2nd equation, eliminate B in 1st, 3rd, and 4th equations)
	 *
	 *Q. Why pivot on column 2 (corresponding to variable B)?
	 *		Its objective function coefficient is positive.
	 *		(each unit increase in B from 0 increases objective value by $23)
	 *		Pivoting on column 1 (corresponding to A) also OK.
	 *
	 *Q. Why pivot on row 2?
	 *		Preserves feasibility by ensuring RHS ≥ 0.
	 *		Minimum ratio rule: min { 480/15, 160/4, 1190/20 }.
	 *
	 *4. Simplex algorithm: pivot 2
	 *substitute A = (3/8) (32 + (4/15) SC – SH ) and add A into the basis (rewrite 3rd equation, eliminate A in 1st, 2nd, and 4th equations
	 *
	 *5. Simplex algorithm: optimality
	 *
	 *Q. When to stop pivoting?
	 *A. When no objective function coefficient is positive.
	 *
	 *Q. Why is resulting solution optimal?
	 *A. Any feasible solution satisfies current system of equations.
	 *		In particular: Z = 800 – SC – 2 SH
	 *		Thus, optimal objective value Z* ≤ 800 since SC , SH ≥ 0.
	 *		Current BFS has value 800 ⇒ optimal.
	 */

	public Simplex(double [] [] A, double [] b, double [] c)
	{
		m=b.length;
		n=c.length;
		a=new double [m+1][m+n+1];
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				a[i][j]=A[i][j];		//put A[][] into tableau
		
		for(int j=n; j<m+n; j++)	a[j-n][j]=1.0;	//put I[][] into tableau
		for(int j=0; j<n; j++)		a[m][j]=c[j];	//put c[] into tableau
		for(int i=0; i<m; i++)		a[i][m+n]=b[i];	//put b[] into tableau
	}
}

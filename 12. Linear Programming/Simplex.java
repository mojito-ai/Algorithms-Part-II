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
* 
* @author  Mohit Sharma
* @version 3.0
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

	/**
	 * Simplex Algorithm: Running time 
	 * <li> Remarkable property. In typical practical applications, simplex algorithm terminates after at most 2 (m + n) pivots.
	 * 
	 * <li> “ Yes. Most of the time it solved problems with m equations in 2m or 3m steps—
 	 * <li> that was truly amazing. I certainly did not anticipate that it would turn out to
	 * <li> be so terrific. I had had no experience at the time with problems in higher
 	 * <li> dimensions, and I didn't trust my geometrical intuition. For example, my
 	 * <li> intuition told me that the procedure would require too many steps wandering
 	 * <li> from one adjacent vertex to the next. In practice it takes few steps. In brief,
 	 * <li> one's intuition in higher dimensional space is not worth a damn! Only now,
 	 * <li> almost forty years from the time when the simplex method was first proposed,
 	 * <li> are people beginning to get some insight into why it works as well as it does. ” — George Dantzig 1984
 	 * 
	 * @param A
	 * @param b
	 * @param c
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
	
	/**
	 * Bland's Rule
	 * <li> Find entering column q using Bland's rule:
	 * <li> index of first column whose objective function coefficient is positive.
	 * @return
	 */
	private int bland()
	{
		for(int q=0; q<m+n; q++)
			if(a[m][q]>0)	return q;		//entering column q has positive objective function coefficient
		return -1;		//optimal
	}
	
	/**
	 * Min-Ratio rule
	 * <li> Find leaving row p using min ratio rule. (Bland's rule: if a tie, choose first such row)
	 * @param q
	 * @return
	 */
	private int minRatioRule(int q)
	{
		int p=-1;
		for(int i=0; i<m; i++)		//leaving row
		{
			if(a[i][q]<=0)	continue;		//consider only positive entries
			else if(p==-1)	p=i;
			else if(a[i][m+n]/a[i][q] < a[p][m+n]/a[p][q])
				p=i;		//row p has min ratio so far
		}
		return p;
	}
	
	/**
	 * Pivot on leaving variable
	 * <li> Pivot on element row p, column q.
	 * <li> Pivoting rules. Carefully balance the cost of finding an entering variable with the number of pivots needed.
	 * <li> No pivot rule is known that is guaranteed to be polynomial.
	 * <li> Most pivot rules are known to be exponential (or worse) in worst-case.
	 * @param p
	 * @param q
	 */
	public void pivot(int p, int q)
	{
		 for (int i = 0; i <= m; i++)
			 for (int j = 0; j <= m+n; j++)
				 if (i != p && j != q)
					 	a[i][j] -= a[p][j] * a[i][q] / a[p][q];		//scale all entries but row p and column q
			 
		 for (int i = 0; i <= m; i++)
			 if (i != p) a[i][q] = 0.0;		//zero out column q
			 
		 for (int j = 0; j <= m+n; j++)
			 if (j != q) a[p][j] /= a[p][q];		//scale row p
			 	
		 a[p][q] = 1.0;
	}

	/**
	 * Bare-bones implementation
	 * <li> Execute the simplex algorithm.
	 */
	public void solve()
	{
		while(true)
		{
			int q=bland();		
			if(q==-1)	break;		//entering column q (optimal if -1)
				
			int p=minRatioRule(q);	//leaving row p (unbounded if -1)
			if(p==-1)
				break;
			
			pivot(p,q);		//pivot on row p, column q
		}
	}
	
	/*
	 * 1. Simplex algorithm: degeneracy
	 * 		Degeneracy. New basis, same extreme point ("stalling" is common in practice)
	 * 
	 * 2. Cycling. Get stuck by cycling through different bases that all correspond to same extreme point.
	 * 		Doesn't occur in the wild.
	 *		Bland's rule guarantees finite # of pivots. (choose lowest valid index for entering and leaving columns)
	 *
	 * 3. Simplex algorithm: implementation issues
	 * 
	 * To improve the bare-bones implementation.
	 * 		Avoid stalling. --> requires artful engineering
	 * 		Maintain sparsity. --> requires fancy data structures
	 * 		Numerical stability. --> requires advanced math
	 * 		Detect infeasibility. --> run "phase I" simplex algorithm
	 * 		Detect unboundedness. --> no leaving row
	 * 
	 * Best practice. Don't implement it yourself!
	 * Basic implementations. Available in many programming environments.
	 * Industrial-strength solvers. Routinely solve LPs with millions of variables.
	 * Modeling languages. Simplify task of modeling problem as LP.
	 */
}

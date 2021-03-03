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
* @version 1.0
* @since   03-03-2021
* 
*/

public class Simplex {
	
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
	 */

}

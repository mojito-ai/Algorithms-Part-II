# Algorithms-Part-II

![Algorithms-Part-II](https://i.ytimg.com/vi/60BKdKQzLbo/maxresdefault.jpg)

#### Essential information that every serious programmer needs to know about algorithms and data structures, with emphasis on applications and scientific performance analysis of Java implementations. Designed in accordance with Princeton University MOOC (Coursera) and programmed in Java.

[Link to the course](https://online.princeton.edu/node/166)

#### The git-repo includes algorithms used widely in computational science, computational biology and in all IT sectors. The algorithms are divided into the following categories:

1. **Undirected Graphs:** We define an undirected graph API and consider the adjacency-matrix and adjacency-lists representations. We introduce two classic algorithms for searching a graph—depth-first search and breadth-first search. We also consider the problem of computing connected components and conclude with related problems and applications.

2. **Directed Graphs:** We begin with depth-first search and breadth-first search in digraphs and describe applications ranging from garbage collection to web crawling. Next, we introduce a depth-first search based algorithm for computing the topological order of an acyclic digraph. Finally, we implement the Kosaraju-Sharir algorithm for computing the strong components of a digraph.

3. **Minimum Spanning Trees:** We study the minimum spanning tree problem. We begin by considering a generic greedy algorithm for the problem. Next, we consider and implement two classic algorithm for the problem—Kruskal's algorithm and Prim's algorithm. We conclude with some applications and open problems.

4. **Shortest Paths:** We study shortest-paths problems. We begin by analyzing some basic properties of shortest paths and a generic algorithm for the problem. We introduce and analyze Dijkstra's algorithm for shortest-paths problems with nonnegative weights. Next, we consider an even faster algorithm for DAGs, which works even if the weights are negative. We conclude with the Bellman–Ford–Moore algorithm for edge-weighted digraphs with no negative cycles. We also consider applications ranging from content-aware fill to arbitrage.

5. **Maximum Flow and Minimum Cut:** We introduce the maximum flow and minimum cut problems. We begin with the Ford–Fulkerson algorithm. To analyze its correctness, we establish the maxflow–mincut theorem. Next, we consider an efficient implementation of the Ford–Fulkerson algorithm, using the shortest augmenting path rule. Finally, we consider applications, including bipartite matching and baseball elimination.

6. **Radix Sorts:** We consider specialized sorting algorithms for strings and related objects. We begin with a subroutine to sort integers in a small range. We then consider two classic radix sorting algorithms—LSD and MSD radix sorts. Next, we consider an especially efficient variant, which is a hybrid of MSD radix sort and quicksort known as 3-way radix quicksort. We conclude with suffix sorting and related applications.

7. **Tries:**  We consider specialized algorithms for symbol tables with string keys. Our goal is a data structure that is as fast as hashing and even more flexible than binary search trees. We begin with multiway tries; next we consider ternary search tries. Finally, we consider character-based operations, including prefix match and longest prefix, and related applications.

8. **Substring Search:** We consider algorithms for searching for a substring in a piece of text. We begin with a brute-force algorithm, whose running time is quadratic in the worst case. Next, we consider the ingenious Knuth–Morris–Pratt algorithm whose running time is guaranteed to be linear in the worst case. Then, we introduce the Boyer–Moore algorithm, whose running time is sublinear on typical inputs. Finally, we consider the Rabin–Karp fingerprint algorithm, which uses hashing in a clever way to solve the substring search and related problems.

9. **Regular Expressions:** We complete our study of string processing by considering a number of ingenious algorithms that take full advantage of several of the fundamental methods covered earlier in the course. In the first lecture, we consider regular expression pattern matching, where the goal is to find strings from a specified set in a given text. A regular expression is a method for specifying a set of strings. Our topic for this lecture is the famous grep algorithm that determines whether a given text contains any substring from the set. We examine an efficient implementation that makes use of our digraph reachability implementation from Week 1.

10. **Data Compression:** We study and implement several classic data compression schemes, including run-length coding, Huffman compression, and LZW compression. We develop efficient implementations from first principles using a Java library for manipulating binary data that we developed for this purpose, based on priority queue and symbol table implementations from earlier lectures.

11. **Reductions:** Our goal is to develop ways to classify problems according to their computational requirements. We introduce the concept of reduction as a technique for studying the relationship among problems. People use reductions to design algorithms, establish lower bounds, and classify problems in terms of their computational requirements.

12. #### **Linear Programming**
13. #### **Intractability**

## **Author: Mohit Sharma**
## **Email: msharma3@me.iitr.ac.in**

#### Proper care has been taken to ensure that the speed analysis and the space analysis is done. There is a classic space/time tradeoff and the author has ensured to ensure fast processing algorithms in accordance with Moore's Law. Still there might be several errors or performance bugs at some places. Users are welcomed to create PR's or fork the repository to create better performing algorithms.

### > Algorithms: A common language for Nature, Human & Computer. - Avi Widgerson

### > Beware of bugs in the above code; I have only proved it correct, not tried it. - Sir Donald Knuth

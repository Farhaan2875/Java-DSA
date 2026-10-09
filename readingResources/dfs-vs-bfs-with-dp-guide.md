# DFS vs BFS in the World of DP
### Why your 01 Matrix solution failed, and how to know which tool to reach for (Java)

> **Small note:** the problem in your code is **LeetCode 542 – "01 Matrix"** (541 is a different problem, *Reverse String II*). Worth double-checking the number when you search for editorials or discussions.

---

## 0. TL;DR

- **DFS + memoization is top-down DP.** It is only valid when the answer to a subproblem depends **only on the subproblem itself** and the subproblems **never loop back** on each other (a DAG).
- A grid where you can move in all 4 directions is full of loops. "Distance to nearest zero" for a cell depends on its neighbours, and the neighbours depend right back on it. **DFS + memo is unsound here.**
- **BFS explores in layers of distance.** The first time BFS reaches a cell, that is its shortest distance. So BFS is the right tool for "minimum steps" in graphs with loops.
- Your visited-array idea was a good instinct for *stopping infinite loops*, but combined with memoization it silently stores wrong answers. Details in Section 4.

---

## 1. What DP actually requires

Every DP solution, whether it's written as recursion + memo or as nested loops, rests on two conditions:

| Condition | Plain-English meaning | Test it with |
|---|---|---|
| **A. State-only answer** | `answer(state)` depends *only* on `state`, never on *how you got there* | "If I reach this state through a different route, is its answer the same?" |
| **B. No cycles** | Subproblems can be ordered so each one only needs *earlier* ones | "Can state A need state B while B also needs A?" |

If both hold, you can cache each answer once and reuse it forever. That is the whole point of memoization.

**Examples where both hold:**

- `fib(n)` needs `fib(n-1)` and `fib(n-2)`. Always smaller, never loops back.
- Unique Paths (move only right/down): `paths(r,c)` needs `paths(r-1,c)` and `paths(r,c-1)`. Always moves toward the origin.
- LIS, Coin Change, Knapsack: the state shrinks (index goes down, remaining amount goes down).

**Example where B fails:**

- 01 Matrix: `dist(A) = 1 + min(dist of A's neighbours)`, and one of A's neighbours is B, whose formula includes `dist(A)`. **A needs B and B needs A.** There is no valid "compute the smaller one first" order.

---

## 2. DFS + memo: the intuition

DFS goes **deep first**: "to answer this question, I must first answer a smaller question, so go ask that one."

```
solve(state):
    if state already cached  -> return cached answer
    if state is a base case  -> return known answer
    ask smaller states (recursive calls)
    combine their answers
    cache and return
```

This is perfect when "smaller" really is smaller, i.e. each call moves toward a base case and can never come back to a state that is currently being computed. That is why the recursion guide's *"does every call make progress?"* checklist item matters so much for DP.

**Contrast case, same grid, different verdict: LeetCode 329 (Longest Increasing Path in a Matrix).** It is also a grid with 4 directions, and DFS + memo works perfectly there. Why? Because you may only move to a **strictly larger** value. You can never return to a cell you came from, so there are no cycles. The problem *itself* guarantees a DAG.

> **Rule of thumb:** a 4-direction grid DFS+memo is safe only if the problem forces movement to be one-directional in some measurable way (strictly increasing values, only right/down, etc.).

---

## 3. BFS: the intuition

Imagine dropping a stone in water. Ripples spread outward one ring at a time:

- ring 0 = the stone itself (distance 0)
- ring 1 = everything one step away
- ring 2 = everything two steps away
- ...

BFS is exactly this ripple. A queue holds the current ring; processing it produces the next ring.

**The key property:** with every move costing 1, **the first time BFS touches a cell is the shortest distance to it.** A longer route can't arrive earlier, because rings are processed in increasing order of distance.

**Multi-source BFS** starts several stones at once. For 01 Matrix, every `0` is a stone: put *all* zeros in the queue at distance 0, and the ripples spread simultaneously. Each `1` is reached first by its *nearest* zero, which is exactly what the problem asks.

```
mat:        distance (what BFS discovers, ring by ring):
0 1 1       0 1 2
1 1 1       1 2 3
1 1 1       2 3 4

ring 0: (0,0)
ring 1: (0,1) (1,0)
ring 2: (0,2) (1,1) (2,0)
ring 3: (1,2) (2,1)
ring 4: (2,2)
```

**Another way to see it:** BFS is DP where the *evaluation order is discovered on the fly*. The cycle problem from Section 1 disappears, because we process cells in increasing order of distance, and a cell's distance is finalized the moment we see it.

---

## 4. What went wrong in your code

Here is your solution (unchanged):

```java
public int _updateMatrix(int r, int c, int[][] mat, int[][] visited, Integer[][] memo) {
    if(r < 0 || c < 0 || r > mat.length - 1 || c > mat[0].length - 1) {
        return Integer.MAX_VALUE;
    }
    if(mat[r][c] == 0) { memo[r][c] = 0; return 0; }
    if(memo[r][c] != null) { return memo[r][c]; }
    if(visited[r][c] == -1) { return Integer.MAX_VALUE; }   // <-- (X) path-blocking
    visited[r][c] = -1;
    int up    = _updateMatrix(r - 1, c, mat, visited, memo);
    int down  = _updateMatrix(r + 1, c, mat, visited, memo);
    int left  = _updateMatrix(r, c - 1, mat, visited, memo);
    int right = _updateMatrix(r, c + 1, mat, visited, memo);
    int res = Math.min(up, Math.min(down, Math.min(left, right)));
    visited[r][c] = 0;
    memo[r][c] = 1 + res;                                    // <-- (Y) overflow + permanent caching
    return memo[r][c];
}
```

### What you got right (genuinely good instincts)

- Base case for zeros: correct.
- Out-of-bounds returns "infinity": correct idea.
- You noticed that the grid has cycles and added `visited` to stop infinite recursion. Many people forget this entirely.
- You cache results with `memo`. Correct habit for DP.

### The real bug: a path-dependent answer stored as if it were permanent

Line (X) says: "if this cell is on my current DFS path, pretend it's unreachable."
That makes the result of a call depend on **which cells happen to be on the current path**, which breaks **Condition A** from Section 1.

Then line (Y) saves that result in `memo` forever, so a wrong answer computed under a temporary blockade becomes a permanent fact.

### Trace of the smallest failing input

Input: `[[1, 0, 1, 1]]` (one row). Expected: `[[1, 0, 1, 2]]`.

```
Index:      0    1    2    3
mat:        1    0    1    1

The outer loop reaches index 2 first (index 0 is fine, index 1 is a zero).

_update(0,2): mark (0,2) as "on path".
   left  -> (0,1) is a zero              -> 0
   right -> _update(0,3):
              mark (0,3) as "on path".
              left -> (0,2) is "on path" -> MAX_VALUE   <-- blocked by YOUR OWN CALLER
              right/up/down -> MAX_VALUE
              res = MAX_VALUE
              memo[0][3] = 1 + MAX_VALUE = overflow = -2147483648   (!!)
   res = min(0, -2147483648) = -2147483648
   memo[0][2] = -2147483647                                      (!!)
```

Cell `(0,3)` could not "see" the zero because the only route to it goes *through* `(0,2)`, which was blocked by the call that was in the middle of computing it. Its true distance is 2, but the algorithm stored garbage.

I ran your code against a reference solution on thousands of random small grids, and it fails on many of them. Actual outputs:

| Input | Expected | Your code's output |
|---|---|---|
| `[[1,0,1,1]]` | `[[1,0,1,2]]` | `[[1,0,-2147483647,-2147483648]]` |
| `[[1,1,0],[1,1,1],[1,1,1]]` | `[[2,1,0],[3,2,1],[4,3,2]]` | `[[-2147483644,1,0],[-2147483645,-2147483646,-2147483647],[-2147483646,-2147483647,-2147483648]]` |

### Bug #2: `1 + Integer.MAX_VALUE` overflows

`Integer.MAX_VALUE + 1` wraps around to the most negative integer. Anywhere you use "infinity" and then add to it, you must guard against this (or use a smaller sentinel such as `100000`). This is what produced the huge negative numbers above.

### But fixing the overflow is NOT enough

If you only guard the overflow (`res == MAX ? MAX : 1 + res`), the output changes to:

| Input | Expected | After overflow-only fix |
|---|---|---|
| `[[1,0,1,1]]` | `[[1,0,1,2]]` | `[[1,0,1,2147483647]]` |

Now cell `(0,3)` is permanently cached as "infinity". The *root cause* (a path-dependent answer being cached) is still there.

### Why you can't just patch the DFS

You are stuck in a dilemma:

1. **Without `visited`:** the recursion loops forever (`(0,2) -> (0,3) -> (0,2) -> ...`), since a memo entry is only written *after* a call returns.
2. **With `visited`:** answers become path-dependent, so memoizing them is wrong.
3. **With `visited` but no memo:** correct-ish, but you re-explore every simple path through the grid, which can blow up exponentially.

The grid has cycles, and top-down memo recursion has no good way to deal with cycles. That's not a coding slip; it's a **mismatch between the tool and the problem**.

### Small extras

- The first double loop assigns `result[i][j]` and then the second loop overwrites it with `memo`. One of them is redundant.
- On the largest LeetCode inputs (up to about 10,000 cells), a recursive DFS can go thousands of frames deep, which risks a `StackOverflowError`. BFS uses an explicit queue instead.

---

## 5. Correct solution #1: Multi-source BFS (the one to learn first)

```java
import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int[][] dist = new int[rows][cols];   // answer grid
        Deque<int[]> queue = new ArrayDeque<>();

        // Step 1: every 0 is a "stone dropped in the water" (distance 0).
        //         Every 1 is marked -1 meaning "not reached yet".
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (mat[r][c] == 0) {
                    dist[r][c] = 0;
                    queue.add(new int[]{r, c});
                } else {
                    dist[r][c] = -1;
                }
            }
        }

        // Step 2: spread the ripples ring by ring.
        int[] dr = {-1, 1, 0, 0};   // up, down, left, right
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                // skip cells outside the grid
                if (nr < 0 || nc < 0 || nr >= rows || nc >= cols) continue;

                // skip cells already reached (their distance is already final)
                if (dist[nr][nc] != -1) continue;

                // first time we reach this cell = shortest distance to it
                dist[nr][nc] = dist[r][c] + 1;
                queue.add(new int[]{nr, nc});
            }
        }

        return dist;
    }
}
```

**Why it's correct:** rings are processed in order of distance, so the first visit to a cell is via a shortest route. Each cell is enqueued once, so time is **O(rows x cols)** and extra space is **O(rows x cols)**.

**Notice what disappeared:** no recursion, no visited-un-marking, no memo-poisoning, no infinity sentinel to overflow. `dist[nr][nc] != -1` plays the role of both "visited" and "memo", and it is safe because the value is final the instant it is written.

---

## 6. Correct solution #2: Two-pass bottom-up DP

When you *can* find a valid evaluation order by hand, plain loops are even simpler. The trick is to break the 4-direction cycle into **two acyclic halves**:

- **Pass 1 (top-left to bottom-right):** each cell looks only at its **up** and **left** neighbours (already computed in this pass).
- **Pass 2 (bottom-right to top-left):** each cell looks only at its **down** and **right** neighbours.

```java
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int INF = 100000;   // bigger than any real distance, small enough to never overflow

        int[][] dp = new int[rows][cols];

        // Pass 1: look at neighbours above and to the left
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dp[r][c] = (mat[r][c] == 0) ? 0 : INF;
                if (r > 0) dp[r][c] = Math.min(dp[r][c], dp[r - 1][c] + 1);
                if (c > 0) dp[r][c] = Math.min(dp[r][c], dp[r][c - 1] + 1);
            }
        }

        // Pass 2: look at neighbours below and to the right
        for (int r = rows - 1; r >= 0; r--) {
            for (int c = cols - 1; c >= 0; c--) {
                if (r < rows - 1) dp[r][c] = Math.min(dp[r][c], dp[r + 1][c] + 1);
                if (c < cols - 1) dp[r][c] = Math.min(dp[r][c], dp[r][c + 1] + 1);
            }
        }

        return dp;
    }
}
```

**Why two passes are enough (intuition):** the nearest zero is in one of four directions from a cell.

- zero is **up-left** -> caught by pass 1
- zero is **down-right** -> caught by pass 2
- zero is **up-right** -> pass 1 carries it *down* its column, then pass 2 carries it *left* along the row
- zero is **down-left** -> pass 1 carries it *right* along its row, then pass 2 carries it *up* the column

Both solutions above were tested against a brute-force reference on about 24,000 random grids with zero mismatches.

**BFS vs two-pass DP:** both are O(rows x cols). BFS works on *any* unweighted graph, so it is the more reusable skill. Two-pass DP is a neat trick specific to grids.

---

## 7. Decision guide: which tool, when?

| If the problem looks like... | Reach for | Why |
|---|---|---|
| Count ways / min or max cost / is-it-possible, where states shrink (index, remaining amount, size) | **DFS + memo** or bottom-up DP | Subproblems form a DAG |
| **Fewest steps / minimum moves / shortest path**, every move costs the same, graph can loop | **BFS** | First visit = shortest distance |
| "Nearest X" for every cell, or things spreading at the same time (rotting oranges, fire, flood) | **Multi-source BFS** | All sources ripple together |
| Shortest path with different non-negative edge weights | **Dijkstra** | BFS's weighted cousin |
| Enumerate **all** solutions (permutations, subsets, N-Queens, word search) | **DFS backtracking** (choose, explore, un-choose) | You want every path, not a cached answer |
| Connectivity: islands, components, flood fill, cycle detection, topological sort | **DFS** (or BFS) | You only need reachability |
| Grid DP where movement is forced one way (right/down only, strictly increasing values) | **DFS + memo** or loops | Problem guarantees no cycles |

### The backtracking contrast you should remember

Your `visited[r][c] = -1` ... `visited[r][c] = 0` pattern (mark, explore, un-mark) is **exactly correct for backtracking**, where you want to *enumerate paths* and a cell may appear in different paths. It is only wrong when you **combine it with memoization**, because memo claims "this answer is universal" while un-marking says "this answer depends on the current path." Those two ideas contradict each other.

### Four questions to ask before writing any code

1. **Can I describe a state so the answer depends only on that state?** (If not, memo is invalid.)
2. **Can states move in a loop (A -> B -> A)?** (If yes, plain top-down memo is a red flag.)
3. **Am I asking for the fewest steps, with equal-cost moves?** (If yes, think BFS first.)
4. **Is there a natural direction to the states** (index increasing, size shrinking, value increasing)? (If yes, DP works.)

---

## 8. Common traps (a checklist)

- Memoizing a result that was computed while some cells were temporarily blocked by a visited set.
- Using `Integer.MAX_VALUE` as infinity and then adding 1 to it.
- Reaching for DFS just because "recursion + memo" is the pattern you practised most.
- Using DFS to find the *shortest* path in an unweighted graph. DFS finds *a* path, not necessarily the shortest.
- In BFS, marking cells visited when you *dequeue* instead of when you *enqueue*. That lets the same cell be added many times.
- Forgetting that multi-source BFS needs **all sources in the queue before the loop starts**.

---

## 9. Practice ladder

**DFS + memo (DAG-style states):**
1. LC 70 Climbing Stairs
2. LC 62 Unique Paths
3. LC 322 Coin Change
4. LC 300 Longest Increasing Subsequence
5. LC 329 Longest Increasing Path in a Matrix *(grid, but cycle-free, great contrast with 542)*

**BFS (shortest steps, loops allowed):**
1. LC 542 01 Matrix *(redo it with BFS)*
2. LC 994 Rotting Oranges *(multi-source BFS)*
3. LC 1091 Shortest Path in Binary Matrix
4. LC 1162 As Far from Land as Possible
5. LC 127 Word Ladder

**Habit to build:** before coding any grid or graph DP problem, write one line: *"Can this state graph contain a cycle? Yes -> BFS / No -> DFS+memo."* That single sentence would have saved this attempt.

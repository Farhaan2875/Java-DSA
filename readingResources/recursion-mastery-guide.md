# Recursion, From the Ground Up
### A practical framework for breaking down recursive problems (with Java examples)

---

## 1. Why recursion "feels" hard

Most students can write a base case and *some* of the recursive call, but get stuck because they try to **mentally simulate the entire call stack** — tracing every single call down and back up. That's not how experienced people solve recursion problems. They use a mental trick called the **"leap of faith"** (also called **recursive trust**).

> **The Leap of Faith:** Assume that the recursive call you're about to write *already works correctly* for a smaller version of the problem. Don't trace it. Trust it. Your only job is to figure out how to combine that trusted smaller answer into the answer for your current input.

If you try to trace the whole recursion tree in your head every time, you will always miss something for problems bigger than toy examples. The framework below removes that need.

---

## 2. The 5-Step Framework

Every recursive function you write should go through these steps, **in this order**:

| Step | Question to ask | What it produces |
|---|---|---|
| 1. Define the function's job in words | "Given X, this function returns/does ___" | A one-sentence contract (this is CRITICAL and most people skip it) |
| 2. Find the base case(s) | "What's the smallest / simplest input where I already know the answer without recursing?" | `if (...) return ...;` |
| 3. Assume the recursive call already works | "If I called this same function on a *smaller* version of the input, what would it give me back?" | Nothing written yet — just a mental fact |
| 4. Combine | "Given that trusted smaller answer, how do I build the answer for my *current*, full-size input?" | The line(s) that use the recursive call's result |
| 5. Check progress toward the base case | "Does every recursive call move strictly closer to a base case?" | Verify the argument shrinks (n-1, half the array, one fewer character, etc.) |

**The step people skip is Step 1.** If you can't state in one sentence exactly what the function promises to return for *any* valid input, you cannot reliably do Step 4. Write that sentence as a comment above every recursive function you write, even in exams.

---

## 3. Worked Example #1 — Factorial (Linear Recursion)

**Step 1 — Contract:** `factorial(n)` returns n! (the product of all integers from 1 to n).

**Step 2 — Base case:** The smallest input we already know the answer to: `factorial(0) = 1`.

**Step 3 — Trust:** Assume `factorial(n - 1)` already correctly returns `(n-1)!`.

**Step 4 — Combine:** `n! = n * (n-1)!`, so `factorial(n) = n * factorial(n - 1)`.

**Step 5 — Progress:** `n - 1 < n`, and it moves toward 0. ✅

```java
public class Factorial {
    // Contract: returns n! for n >= 0
    public static long factorial(int n) {
        if (n == 0) {                    // Step 2: base case
            return 1;
        }
        return n * factorial(n - 1);     // Step 4: trust + combine
    }

    public static void main(String[] args) {
        System.out.println(factorial(5)); // 120
    }
}
```

Notice: nowhere did we think about `factorial(4)`, `factorial(3)`, etc. We trusted `factorial(n-1)` blindly.

---

## 4. Worked Example #2 — Sum of Array (Where People Usually Miss Something)

**Problem:** Given an array, return the sum of its elements using recursion.

The typical mistake: forgetting to pass an **index** so the array itself doesn't need to shrink (which is expensive) — or forgetting to define what a "sub-array" even means as the input shrinks.

**Step 1 — Contract:** `sum(arr, i)` returns the sum of all elements from index `i` to the end of `arr`.

**Step 2 — Base case:** If `i == arr.length` (no elements left), the sum is `0`.

**Step 3 — Trust:** Assume `sum(arr, i + 1)` correctly returns the sum from `i+1` to the end.

**Step 4 — Combine:** `sum(arr, i) = arr[i] + sum(arr, i + 1)`.

**Step 5 — Progress:** `i + 1 > i`, moves toward `arr.length`. ✅

```java
public class SumArray {
    // Contract: returns sum of arr[i..arr.length-1]
    public static int sum(int[] arr, int i) {
        if (i == arr.length) {           // base case: nothing left
            return 0;
        }
        return arr[i] + sum(arr, i + 1); // trust + combine
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(sum(nums, 0)); // 15
    }
}
```

**Why this pattern matters:** This "index instead of shrinking the container" trick is the single most common thing students miss. Whenever a problem involves an array or string, ask: *"Can I use an index (or two: start/end) instead of physically slicing it?"* This is both more efficient and conceptually cleaner.

---

## 5. Worked Example #3 — Reverse a String (Combine step goes *after* the call)

**Step 1 — Contract:** `reverse(s)` returns the reverse of string `s`.

**Step 2 — Base case:** An empty string or single character is its own reverse.

**Step 3 — Trust:** Assume `reverse(s.substring(1))` correctly reverses everything except the first character.

**Step 4 — Combine:** Take that trusted reversed remainder, and stick the first character **at the end**.

```java
public class ReverseString {
    // Contract: returns the reverse of s
    public static String reverse(String s) {
        if (s.length() <= 1) {                     // base case
            return s;
        }
        char first = s.charAt(0);
        String restReversed = reverse(s.substring(1)); // trust
        return restReversed + first;                   // combine
    }

    public static void main(String[] args) {
        System.out.println(reverse("hello")); // "olleh"
    }
}
```

**Key insight:** In factorial, the combine step was `n * result`. Here it's `result + first`. **Where you place the "extra piece" relative to the recursive result determines the order of operations** — this is exactly the kind of detail people miss because they don't explicitly ask "where does my current piece go — before or after the trusted result?"

---

## 6. Worked Example #4 — Fibonacci (Tree Recursion — two calls, not one)

Not every recursive function makes **one** recursive call. Some make two or more — this is called **tree recursion**, and it's where people get lost trying to trace the whole tree. Don't. Trust *both* calls independently.

**Step 1 — Contract:** `fib(n)` returns the n-th Fibonacci number (`fib(0)=0`, `fib(1)=1`).

**Step 2 — Base cases:** `fib(0) = 0`, `fib(1) = 1`.

**Step 3 — Trust:** Assume `fib(n-1)` and `fib(n-2)` both already work correctly.

**Step 4 — Combine:** `fib(n) = fib(n-1) + fib(n-2)`.

```java
public class Fibonacci {
    public static int fib(int n) {
        if (n == 0) return 0;             // base case 1
        if (n == 1) return 1;             // base case 2
        return fib(n - 1) + fib(n - 2);   // trust both, combine
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(fib(i) + " ");
        }
        // 0 1 1 2 3 5 8 13 21 34
    }
}
```

**Don't trace the tree by hand for anything beyond n=3 or 4.** Trust the contract. If you don't trust it, prove it *once* with a tiny example (n=2 or n=3), then trust it going forward.

---

## 7. Worked Example #5 — Backtracking (Subsets) — the pattern people fear most

Backtracking problems (subsets, permutations, N-Queens, Sudoku) feel harder because there are **choices** at each step, not just one shrinking input. The trick: think of it as **"choose → explore → un-choose."**

**Problem:** Print all subsets of an array.

**Step 1 — Contract:** `generate(arr, i, current)` explores every way of deciding include/exclude for `arr[i..end]`, given that `current` already holds decisions made for indices `0..i-1`.

**Step 2 — Base case:** `i == arr.length` → we've decided for every element, so print `current`.

**Step 3 — Trust:** Assume the recursive calls correctly handle everything from index `i+1` onward.

**Step 4 — Combine:** At index `i`, there are exactly two choices — include `arr[i]` or don't. Try both.

```java
import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void generate(int[] arr, int i, List<Integer> current) {
        if (i == arr.length) {           // base case: decision made for all
            System.out.println(current);
            return;
        }

        // Choice 1: exclude arr[i]
        generate(arr, i + 1, current);

        // Choice 2: include arr[i]
        current.add(arr[i]);             // CHOOSE
        generate(arr, i + 1, current);   // EXPLORE (trust it handles the rest)
        current.remove(current.size() - 1); // UN-CHOOSE (backtrack!)
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        generate(arr, 0, new ArrayList<>());
    }
}
```

**The step almost everyone misses in backtracking:** the **un-choose** (`current.remove(...)`) line. If you add something to a shared list/structure before recursing, you *must* remove it after, or every future branch will see stale state from a path that already finished. This is the #1 backtracking bug.

---

## 8. The Checklist to Run Before You Submit Any Recursive Solution

Whenever you think you're "missing something," run through this checklist — it catches ~90% of bugs:

1. **Contract check** — Can I state in one sentence what this function guarantees to return/do for *any* valid input, not just the example I'm thinking of?
2. **Base case completeness** — Are there multiple ways the input could become "trivial"? (e.g., empty array AND single-element array; n=0 AND negative n if that's possible)
3. **Progress check** — Does *every* recursive call strictly shrink the problem toward a base case? (Off-by-one here causes infinite recursion / StackOverflowError.)
4. **Combine placement** — Did I decide *where* my current piece of work goes relative to the trusted recursive result (before, after, multiplied, added)?
5. **Shared state check** (only for backtracking/mutable state) — If I modified a shared list/array/counter before recursing, did I undo that modification after?
6. **Multiple calls independence** — If I make more than one recursive call, am I trusting each independently instead of trying to trace how they interleave?
7. **Return vs. print** — Am I confusing "this call should *return* a value to its caller" with "this call should *print/store* something globally"? Mixing these up is a very common source of bugs.

---

## 9. How to Debug When It's Still Wrong

- **Add one `System.out.println` at the very top of the function**, printing the parameters. Run on the smallest failing input (size 2 or 3). Read the indentation of calls — don't trace by hand, just read what actually happened.
- **Draw the recursion tree only for the smallest failing case** — not the full-size input. If `fib(2)` is wrong, you don't need to draw `fib(10)`.
- **Isolate the base case first.** Comment out the recursive case temporarily and confirm the base case alone returns correctly for the smallest input.
- **Check your contract against your base case.** A surprising number of bugs come from the base case returning something that doesn't match what the function promises (e.g., contract says "returns the count" but base case returns `true`).

---

## 10. Practice Ladder (in order of difficulty)

1. Sum of digits of a number
2. Power function (`x^n`) — try both O(n) and O(log n) versions
3. Check if a string is a palindrome
4. Binary search (recursive)
5. Merge sort (divide and conquer — two recursive calls + a combine step that does real work)
6. Tower of Hanoi
7. Generate all permutations of a string
8. N-Queens (backtracking)
9. Word search in a grid (backtracking + recursion on a 2D grid)

Work through these in order using the 5-step framework and the checklist above — write the **contract sentence** first, every time, before writing a single line of code. That one habit fixes most of the "I always miss something" problem.

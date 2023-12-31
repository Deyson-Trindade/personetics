# personetics - chain validator

There are two kind of lists, each for a different type of values. First type: a list of one digit and two-digit
numbers, second type: a list of words and single characters consist of a-z letters (only lower case).
A list can either be of the first or second type, but not mixed with both.
Multiple digits/letters objects have dependency on single digit/letters objects which are they consist of.
For example, the number 24 is dependent on two objects: 2 and 4, the word “aba” is dependent on two
objects: “a” and “b”.
Write java code for the following:
Implement a method boolean validate(List&lt;Node&gt; nodes) which will determine if a chain is valid, such
that multi characters dependency is satisfied by other single characters numbers in the list. Same method
should work for both kind of Node types.

## below are listed some scenarios that may be used to test.

    Valid chain: 36, 6, 24, 4, 47, 7, 2, 3, 27                         - true
    Valid chain: 10, 1, 0, 5, 15, 1, 5, 30, 3                          - true
    Valid chain: "p", "aba", "a", "b", "perso", "o", "r", "e", "s"     - true
    Valid chain: "apple", "a", "p", "le", "e", "l"                     - true

    Not valid chain: "cat", "car" ,"c", "a", "r", "m", "e", "o", "w"   - false
    Not valid chain: 35, 5, 65, 6, 24, 4                               - false
    Not valid chain: 25, 2, 5, 10, 2, 0, 4, 8                          - false
#   p e r s o n e t i c s  
 
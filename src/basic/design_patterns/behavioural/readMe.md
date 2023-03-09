### Strategy Design Pattern

It is used when we have multiple solution or
algorithms to solve a specific task and at runtime, client 
decides the specific implementation which
is to be used. (as per need)

Keep each implementation in a separate class.
Each such class is called strategy.
An object that used the strategy object is called
context object.

ex: Sorting a list of numbers
options: Bubble, Merge, Selection, Quick
Client chooses one.

Context has a strategy.

Client => Context => ConcreteStrategy

Q) When to use

1. Many related classes differ only in their behaviour.
    Strategy is used to configure a class with many 
    behaviours.
2. When we need different variants of an algorithm.
3. When an algo uses data that client should not know about.
4. Instead of conditionals in a class, move related conditional branches
    into their own Strategy class.

In Java
1. java.util.Comparator #compare()
2. javax.servlet.http.HttpServlet
3. javax.servlet.Find #doFilter()

### Decorator Design Pattern

Allows us to dynamically add new features to existing objects without
changing its structures by using abstract classes or interfaces
by composition to implement the wrapper.

Decorator class wraps the original class & provides
additional functionality with the same signature.
It is used to modify the functionality of an object at runtime.

Individual object gets the modified behaviour




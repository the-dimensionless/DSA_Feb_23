## Java Streams API

1. Intro to Streams
   1. Declarative
   2. Flexible
   3. Parallel
2. Observing the Streams
3. Stream Pipeline
   1. Source
   2. Intermediate Operations
   3. Terminal Operations
4. Streams are not Containers
5. Streams are Lazy
6. Methods In Streams
   1. Map
   2. Filter
   3. Reduce
   4. More
7. Primitive Streams
   1. IntStreams
   2. Long Stream
   3. Double Stream
8. Finite/Bounded Streams
9. Infinite Streams
10. FlatMap operation
11. Parallel Streams
    1. Stateful & Stateless ops
    2. Setting up parallelism


## 1. Intro to Streams

Streams are sequence of elements from a source that
supports data processing operations.

We need not write lengthy codes. Instead, use Stream API
to code in a declarative way.
1. The Stream takes the data from a source 
2. Do all the processing
3. Return the data into the container the user wants or just
consume the data

Streams are Declarative (concise & readable),
Flexible and can be parallelized
(to process large collections with great performance)
ex.  books.streams.parallel() or
books.parallelStream()

## 2. Observing the Stream

        //1.
        Stream<Book> stream = books.stream();

        //2.
        Stream<Book> HorrorBookStream = stream.filter((book) -> book.getGenre().equalsIgnoreCase("Horror"));

        //3.
        Stream<Book> popHrBooks = HorrorBookStream.filter((book) ->
                book.getRating() > 3);
        
        //4.
        List<Book> collect = popHrBooks.collect(Collectors.toList());

These can be simplified as
>List<Book> popularHorrorBooks = books.stream()
.filter((book) -> book.getGenre().equalsIgnoreCase("Horror"))
.filter((book) -> book.getRating() > 3)
.collect(Collectors.toList());

## 3. Stream Pipeline
 Pipeline => Sequence of operations
1. It has a Source (to generate stream)
2. Zero or More Intermediate Operations
3. Terminal Operations (produces side effect or Non Stream result)

## 4. Streams are not Data Containers

Stream is immutable and can be used only once.
Once operated upon, it cannot be reused (used only once).
A fancy iterator unlike a collection.

## 5. Methods in Stream API

filter() : functional equivalent of if
            takes in a predicate

Map(): Function mapper

Reduce(): 

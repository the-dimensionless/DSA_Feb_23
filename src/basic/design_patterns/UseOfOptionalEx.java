package basic.design_patterns;

import java.util.Optional;

public class UseOfOptionalEx {

    public static Optional<String> getName() {
        // return null; // Bad idea

        if (Math.random() > 0.5) {
            return Optional.of("Joe");
        }
        return Optional.empty();
    }

    public static void setName1(String name) {
        if (name == null) { // code smell
            // use default value of Joe
        }
        // use the given name
    }

    //tempting, but don't
    public static void setNameEx(Optional<String> name) {
        if (name.isPresent()) {
            // use the given name
        } else {
            // use the default value Joe
        }

        // A good design has empathy
    }

    // never use Optional<T> as a parameter to methods
    // if needed, use overloading instead
    // There is little reason to use Optional as a field
    public static void setName() {
        // use default when no args given
    }
    public static void setName(String name) {
        // use given name
    }

    public static void main(String[] args) {
        // null is code smell
        // Good code is like a storybook and not a puzzle
        var res = getName();
        System.out.println(res.orElse("not found"));

        // don't do this (will blow up if not present)
        System.out.println(res.get());
        // get does not reveal its intention

        // if at all need to use get, use orThrow
        System.out.println(res.orElseThrow());

        // When to use Optional
        // if a method will always have a single value as a result
        // please don't use Optional

        // if a method may or may not have a single value as a result
        // then use an Optional
        // if the result is a collection, then don't use Optional (use Empty)

    }


}

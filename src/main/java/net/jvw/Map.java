package net.jvw;

import io.vavr.collection.List;
import io.vavr.collection.Seq;
import io.vavr.control.Validation;

public class Map {

    public static Validation<Seq<ValidationError>, String> example1() {
        return invalid()
                .flatMap(s -> Validation.valid(s));
    }

    public static Validation<Seq<ValidationError>, String> example2() {
        return invalid()
                .map(s -> s);
    }


    private static Validation<Seq<ValidationError>, String> valid() {
        return Validation.valid("this is a valid String");
    }

    private static Validation<Seq<ValidationError>, String> invalid() {
        return Validation.invalid(List.of(new ValidationError("this is invalid")));
    }
}

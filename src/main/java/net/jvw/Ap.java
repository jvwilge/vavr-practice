package net.jvw;

import java.util.function.Function;

import io.vavr.collection.List;
import io.vavr.collection.Seq;
import io.vavr.control.Validation;

public class Ap {

    public static Validation<Seq<ValidationError>, Integer> example1() {
        return Validation.combine(valid1a(), valid1b())
                .ap((string1a, unused) -> {
                    // this is a bot of a contrived example, normally a lot of things would happen here
                    return valid2(string1a);
                })
                .mapError(seqs -> seqs.flatMap(Function.identity()))
                .fold(Validation::invalid, Function.identity());
    }

    public static Validation<Seq<ValidationError>, Integer> example2() {
        return Validation.combine(valid1a(), valid1b())
                .ap((string1a, unused) -> {
                    // this time we only return the values we'll use later and call valid2() there
                    return string1a;
                })
                .mapError(seqs -> seqs.flatMap(Function.identity()))
                .flatMap(s -> valid2(s));
    }

    private static Validation<Seq<ValidationError>, String> valid1a() {
        return Validation.valid("this is a valid String (a)");
    }

    private static Validation<Seq<ValidationError>, Void> valid1b() {
        return Validation.valid(null);
    }

    private static Validation<Seq<ValidationError>, Integer> valid2(String string) {
        if (string.length() == 5) {
            return Validation.invalid(List.of(new ValidationError("String is 5, that's not cool")));
        }
        return Validation.valid(string.length());
    }
}

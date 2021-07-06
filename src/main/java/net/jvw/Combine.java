package net.jvw;

import java.util.function.Function;

import io.vavr.collection.List;
import io.vavr.collection.Seq;
import io.vavr.control.Validation;

/**
 * This example is to show you that you don't have to create elaborate if-constructions to combine validations<br/>
 * This is 'parallel' validation, for nested validation use flatMap<br/>
 * <br/>
 * Note that each example is an improvement over the previous one
 */
public class Combine {

    /**
     * Note that in this example only one error message is returned, even if both validations fail.
     */
    public static Validation<Seq<ValidationError>, String> example1() {

        final Validation<Seq<ValidationError>, String> valid1a = invalid1a();
        final Validation<Seq<ValidationError>, String> valid1b = invalid1b();

        if (valid1a.isInvalid() || valid1b.isInvalid()) {
            if (valid1a.isInvalid()) {
                return valid1a;
            }
            return valid1b;
        }

        return Validation.valid("all is fine");
    }

    /**
     * Here both error messages are returned since both validations are invalid.
     * Note that we have to flatten the errors or else we would have a Seq of Seq<br/>
     * How many errors are printed?
     */
    public static Validation<Seq<ValidationError>, String> example2() {

        final Validation<Seq<ValidationError>, String> valid1a = invalid1a();
        final Validation<Seq<ValidationError>, String> valid1b = invalid1b();

        final Validation<Seq<ValidationError>, String> result =
                Validation.combine(valid1a, valid1b)
                        .ap((s1a, s1b) -> "all is fine")
                        .mapError(seqs -> seqs.flatMap(Function.identity()));

        return result;
    }

    /**
     * Is this result valid or invalid?
     */
    public static Validation<Seq<ValidationError>, String> example3() {

        final Validation<Seq<ValidationError>, String> valid1a = valid1a();
        final Validation<Seq<ValidationError>, String> valid1b = invalid1b();

        final Validation<Seq<ValidationError>, String> result =
                Validation.combine(valid1a, valid1b)
                        .ap((s1a, s1b) -> "all is fine")
                        .mapError(seqs -> seqs.flatMap(Function.identity()));

        return result;
    }


    private static Validation<Seq<ValidationError>, String> valid1a() {
        return Validation.valid("this is a valid String (a)");
    }

    private static Validation<Seq<ValidationError>, String> valid1b() {
        return Validation.valid("this is a valid String (b)");
    }

    private static Validation<Seq<ValidationError>, String> invalid1a() {
        return Validation.invalid(List.of(new ValidationError("this is invalid (a)")));
    }

    private static Validation<Seq<ValidationError>, String> invalid1b() {
        return Validation.invalid(List.of(new ValidationError("this is invalid (b)")));
    }
}

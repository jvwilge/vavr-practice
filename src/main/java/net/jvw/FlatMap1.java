package net.jvw;

import io.vavr.collection.List;
import io.vavr.collection.Seq;
import io.vavr.control.Validation;

/**
 * A flatmap can be confusing sometimes<br/>
 * <br/>
 * Note that each example is an improvement over the previous one
 */
public class FlatMap1 {


    public static Validation<Seq<ValidationError>, String> example1() {

        final Validation<Seq<ValidationError>, String> step1 = invalid();

        if (step1.isInvalid()) {
            return Validation.invalid(List.of(new ValidationError("this is also invalid")));
        }

        return step1
                .flatMap(validString -> {
                    return Validation.valid(validString + ". And this too.");
                });
    }

    /**
     * The <code>isInvalid</code> check is redundant here<br/>
     * if you want a different error message you can use <code>mapError</code>
     */
    public static Validation<Seq<ValidationError>, String> example2() {

        final Validation<Seq<ValidationError>, String> step1 = invalid();

        return step1
                .flatMap(validString -> {
                    return Validation.valid(validString + ". And this too.");
                })
                .mapError(validationErrors -> List.of(new ValidationError("this is also invalid")));
    }

    /**
     * Or maybe you weren't sure what would happen with the result of step1 if it is invalid?
     */
    public static Validation<Seq<ValidationError>, String> example3() {

        final Validation<Seq<ValidationError>, String> step1 = invalid();

        return step1
                .flatMap(validString -> {
                    return Validation.valid(validString + ". And this too.");
                });
    }

    /**
     * Or if step1 is valid, but the result after that is invalid?
     */
    public static Validation<Seq<ValidationError>, String> example4() {

        final Validation<Seq<ValidationError>, String> step1 = valid();

        return step1
                .flatMap(validString -> {
                    return Validation.invalid(List.of(new ValidationError("Nested error")));
                });
    }

    /**
     * This example shows you how NOT to use fold because flatMap is shorter and more readable
     */
    public static Validation<Seq<ValidationError>, String> example5() {

        final Validation<Seq<ValidationError>, String> step1 = valid();

        final Validation<Seq<ValidationError>, String> result =
                step1.fold(validationErrors -> Validation.invalid(validationErrors),
                        validString -> {
                            return Validation.invalid(List.of(new ValidationError("Nested error")));
                        });

        return result;
    }


    private static Validation<Seq<ValidationError>, String> valid() {
        return Validation.valid("this is a valid String");
    }

    private static Validation<Seq<ValidationError>, String> invalid() {
        return Validation.invalid(List.of(new ValidationError("this is invalid")));
    }


}
package net.jvw;

import io.vavr.collection.List;
import io.vavr.collection.Seq;
import io.vavr.control.Validation;

/**
 * Note that each example is an improvement over the previous one
 */
public class Bimap {

    public static Validation<Integer, String> example1() {

        final Validation<Seq<ValidationError>, String> valid1a = invalid();

        final Validation<Integer, String> result = valid1a
                .mapError(validationErrors -> {
                    return validationErrors.size();
                })
                .map(s -> {
                    return "valid: " + s;
                });
        return result;
    }

    /**
     * map+mapError can be combined in one step
     */
    public static Validation<Integer, String> example2() {

        final Validation<Seq<ValidationError>, String> valid1a = invalid();

        final Validation<Integer, String> result = valid1a
                .bimap(validationErrors -> {
                            return validationErrors.size();
                        },
                        s -> {
                            return "valid: " + s;
                        });
        return result;
    }

    private static Validation<Seq<ValidationError>, String> valid() {
        return Validation.valid("this is a valid String (a)");
    }

    private static Validation<Seq<ValidationError>, String> invalid() {
        return Validation.invalid(List.of(new ValidationError("this is invalid (b)")));
    }
}

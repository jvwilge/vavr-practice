package net.jvw;

import io.vavr.collection.List;
import io.vavr.collection.Seq;
import io.vavr.control.Validation;

/**
 * This example shows you how you can map errors/valid to a common type with <code>fold</code><br/>
 * <br/>
 * Note that each example is an improvement over the previous one
 */
public class Fold {

    public static String[] example1() {

        final Validation<Seq<ValidationError>, String> step1 = valid();

        final String[] result = step1.map(
                step1Valid -> {
                    return step1Valid.split(" ");
                })
                .getOrElseGet(validationErrors -> {
                    return validationErrors.map(validationError -> validationError.getMessage()).toJavaList().toArray(new String[]{});
                });

        return result;
    }

    /**
     * map+getOrElseGet can be combined into fold
     */
    public static String[] example2() {

        final Validation<Seq<ValidationError>, String> step1 = valid();

        final String[] result = step1.fold(validationErrors -> {
            return validationErrors.map(validationError -> validationError.getMessage()).toJavaList().toArray(new String[]{});
        }, step1Valid -> {
            return step1Valid.split(" ");
        });

        return result;
    }


    private static Validation<Seq<ValidationError>, String> valid() {
        return Validation.valid("this is a valid String");
    }

    private static Validation<Seq<ValidationError>, String> invalid1() {
        return Validation.invalid(List.of(new ValidationError("this is invalid")));
    }

}

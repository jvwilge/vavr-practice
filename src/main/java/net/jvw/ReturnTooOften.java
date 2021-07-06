package net.jvw;

import io.vavr.collection.List;
import io.vavr.collection.Seq;
import io.vavr.control.Validation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This example is to show you that you don't have to return that often.<br/>
 * <br/>
 *  Note that each example is an improvement over the previous one
 */
public class ReturnTooOften {

    private static final Logger LOG = LoggerFactory.getLogger(ReturnTooOften.class);

    /**
     * This is a bit of an artificial example, but here there are 2 levels of validation.
     */
    public static Validation<Seq<ValidationError>, String> example1() {

        final Validation<Seq<ValidationError>, String> step1 = valid();

        if (step1.isInvalid()) {
            return step1;
        }

        final Validation<Seq<ValidationError>, String> step2 = step1
                .flatMap(step1Result -> {
                    return valid2();
                });

        if (step2.isInvalid()) {
            return step2;
        }

        return step2;

    }

    /**
     * We can omit the invalid-checks since this is exactly where vavr will help you<br/>
     * Note that the 'inside' result is now invalid
     */
    public static Validation<Seq<ValidationError>, String> example2() {

        final Validation<Seq<ValidationError>, String> step1 = valid();
        final Validation<Seq<ValidationError>, String> step2 = step1
                .flatMap(step1Result -> {
                    LOG.debug("am I reachable?");
                    return invalid2();
                });

        return step2;

    }

    /**
     * Which error message is returned here? And is "am I reachable?" executed?
     */
    public static Validation<Seq<ValidationError>, String> example3() {

        final Validation<Seq<ValidationError>, String> step1 = invalid();
        final Validation<Seq<ValidationError>, String> step2 = step1
                .flatMap(step1Result -> {
                    LOG.debug("am I reachable?");
                    return invalid2();
                });

        return step2;

    }


    private static Validation<Seq<ValidationError>, String> valid() {
        return Validation.valid("this is a valid String");
    }

    private static Validation<Seq<ValidationError>, String> valid2() {
        return Validation.valid("this is a valid String too");
    }

    private static Validation<Seq<ValidationError>, String> invalid() {
        return Validation.invalid(List.of(new ValidationError("this is invalid")));
    }

    private static Validation<Seq<ValidationError>, String> invalid2() {
        return Validation.invalid(List.of(new ValidationError("this is invalid after validating")));
    }

}

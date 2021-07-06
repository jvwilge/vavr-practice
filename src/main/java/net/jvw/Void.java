package net.jvw;

import io.vavr.collection.Seq;
import io.vavr.control.Validation;

/**
 * Use Void in validations to ignore results<br/>
 * Nothing more than a shortcut here to hide an ugly null
 */
public class Void {

    /**
     * Shortcut for the ugly Validation.&lt;Void&gt;valid(null).
     */
    public static Validation<Seq<ValidationError>, java.lang.Void> validVoid() {
        return Validation.valid(null);
    }

}

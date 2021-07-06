package net.jvw;

import io.vavr.collection.Seq;
import io.vavr.control.Validation;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ReturnTooOftenTest {


    private static final Logger LOG = LoggerFactory.getLogger(ReturnTooOftenTest.class);

    @Test
    void example1() {
        final Validation<Seq<ValidationError>, String> result = ReturnTooOften.example1();
        LOG.debug("result: {}", result);
    }

    @Test
    void example2() {
        final Validation<Seq<ValidationError>, String> result = ReturnTooOften.example2();
        LOG.debug("result: {}", result);
    }

    @Test
    void example3() {
        final Validation<Seq<ValidationError>, String> result = ReturnTooOften.example3();
        LOG.debug("result: {}", result);
    }

}
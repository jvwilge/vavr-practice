package net.jvw;

import io.vavr.collection.Seq;
import io.vavr.control.Validation;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class FlatMap1Test {

    private static final Logger LOG = LoggerFactory.getLogger(FlatMap1Test.class);

    @Test
    void example1() {
        final Validation<Seq<ValidationError>, String> result = FlatMap1.example1();
        LOG.debug("result: {}", result);
    }

    @Test
    void example2() {
        final Validation<Seq<ValidationError>, String> result = FlatMap1.example2();
        LOG.debug("result: {}", result);
    }

    @Test
    void example3() {
        final Validation<Seq<ValidationError>, String> result = FlatMap1.example3();
        LOG.debug("result: {}", result);
    }

    @Test
    void example4() {
        final Validation<Seq<ValidationError>, String> result = FlatMap1.example4();
        LOG.debug("result: {}", result);
    }

    @Test
    void example5() {
        final Validation<Seq<ValidationError>, String> result = FlatMap1.example5();
        LOG.debug("result: {}", result);
    }
}
package net.jvw;

import io.vavr.collection.Seq;
import io.vavr.control.Validation;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class CombineTest {


    private static final Logger LOG = LoggerFactory.getLogger(CombineTest.class);

    @Test
    void example1() {
        final Validation<Seq<ValidationError>, String> result = Combine.example1();
        LOG.debug("result: {}", result);
    }

    @Test
    void example2() {
        final Validation<Seq<ValidationError>, String> result = Combine.example2();
        LOG.debug("result: {}", result);
    }

    @Test
    void example3() {
        final Validation<Seq<ValidationError>, String> result = Combine.example3();
        LOG.debug("result: {}", result);
    }


}
package net.jvw;

import io.vavr.collection.Seq;
import io.vavr.control.Validation;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class BimapTest {

    private static final Logger LOG = LoggerFactory.getLogger(BimapTest.class);

    @Test
    void example1() {
        final Validation<Integer, String> result = Bimap.example1();
        LOG.debug("result: {}", result);
    }

    @Test
    void example2() {
        final Validation<Integer, String> result = Bimap.example2();
        LOG.debug("result: {}", result);
    }


}
package net.jvw;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class FoldTest {

    private static final Logger LOG = LoggerFactory.getLogger(FoldTest.class);

    @Test
    void example1() {
        final String[] result = Fold.example1();
        Arrays.asList(result).forEach(s -> LOG.debug("result: {}", s));
    }

}
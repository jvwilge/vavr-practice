package net.jvw;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class SampleTest {

  private static final Logger LOG = LoggerFactory.getLogger(SampleTest.class);

  @DisplayName("test")
  @Test
  void test() {
    LOG.debug("debug");
    LOG.info("info");
    LOG.warn("warn");
    LOG.error("error");
  }
}
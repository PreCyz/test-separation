package com.gawa.integration;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.assertj.core.api.Assertions.assertThat;

@Category(UnitTest.class)
public class SomeTests {

    @Test
    public void contextLoads() {
        assertThat("dev").isEqualTo("dev");
    }

}

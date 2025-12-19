package com.github.docastest.samples;

import org.junit.jupiter.api.Test;
import com.github.docastest.doctesting.utils.NoTitle;

public class MyTestWithoutTitle {
    @Test
    @NoTitle
    public void my_method() {
        // my doc generation
    }
}


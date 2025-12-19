package com.github.docastest.samples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import com.github.docastest.doctesting.NotIncludeToDoc;
import com.github.docastest.doctesting.junitextension.ApprovalsExtension;
import com.github.docastest.doctesting.junitextension.SimpleApprovalsExtension;
import com.github.docastest.test_tools.OnlyRunProgrammatically;

/**
 * My comment for MyTestComment
 */
@NotIncludeToDoc
@OnlyRunProgrammatically
public class MyTestWithComment {
    @RegisterExtension
    static final ApprovalsExtension doc = new SimpleApprovalsExtension();

    /**
     * To describe a method, you can add a comment.
     * It will be added under title.
     */
    @Test
    public void test_A() {
    }

}

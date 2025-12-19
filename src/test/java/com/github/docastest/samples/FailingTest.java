package com.github.docastest.samples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import com.github.docastest.doctesting.NotIncludeToDoc;
import com.github.docastest.doctesting.junitextension.ApprovalsExtension;
import com.github.docastest.doctesting.junitextension.SimpleApprovalsExtension;
import com.github.docastest.test_tools.OnlyRunProgrammatically;

import static org.junit.jupiter.api.Assertions.fail;

@NotIncludeToDoc
@OnlyRunProgrammatically
public
// >>>FailingTest
class FailingTest {
    @RegisterExtension
    static final ApprovalsExtension doc = new SimpleApprovalsExtension();

    @Test
    public void failing_test() {
        doc.write("Some information before failure.", "", "");
        fail("Problem on the test, it fails.");
        doc.write("Information added after failure are not in the final document.", "");
    }
}
// <<<FailingTest

package com.github.docastest.samples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import com.github.docastest.doctesting.NotIncludeToDoc;
import com.github.docastest.doctesting.junitextension.ApprovalsExtension;
import com.github.docastest.doctesting.utils.ClassToDocument;
import com.github.docastest.doctesting.junitextension.SimpleApprovalsExtension;
import com.github.docastest.test_tools.OnlyRunProgrammatically;

/**
 * Description of the test class.
 */
@NotIncludeToDoc
@OnlyRunProgrammatically
@ClassToDocument(clazz = ClassUnderTest.class)
public class MyTestWithClassToDocument {
    @RegisterExtension
    static final ApprovalsExtension doc = new SimpleApprovalsExtension();

    @Test
    public void test_A() {
    }

}

package com.github.docastest.doctesting.writer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import com.github.docastest.doctesting.NotIncludeToDoc;
import com.github.docastest.doctesting.junitextension.ApprovalsExtension;
import com.github.docastest.doctesting.junitextension.SimpleApprovalsExtension;

/**
 * Class comment is added to description.
 */
@DisplayName("Title for the document")
@NotIncludeToDoc
class InMainDocTest {
    @RegisterExtension
    static ApprovalsExtension doc = new SimpleApprovalsExtension();

    @Test
    @DisplayName("Title for this test")
    public void testA() {
        doc.write("In my *test*");
    }

    @Test
    @DisplayName("Title for this test")
    public void testB() {
        doc.write("In my *test*");
    }
}

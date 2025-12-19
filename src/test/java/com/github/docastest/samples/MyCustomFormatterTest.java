package com.github.docastest.samples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import com.github.docastest.docformatter.asciidoc.AsciidocFormatter;
import com.github.docastest.doctesting.NotIncludeToDoc;
import com.github.docastest.doctesting.junitextension.ApprovalsExtension;
import com.github.docastest.doctesting.writer.DocWriter;

@NotIncludeToDoc
@com.github.docastest.test_tools.OnlyRunProgrammatically
public
// >>>MyCustomFormatterTest
class MyCustomFormatterTest {

    @RegisterExtension
    static final ApprovalsExtension doc = new ApprovalsExtension(
            new DocWriter(
                    new AsciidocFormatter() {
                        @Override
                        /// Add the word `Warning` before the message.
                        public String warning(String message) {
                            return super.warning("Warning: " + message);
                        }
                    })
    );

    @Test
    public void test_A() {
        doc.write(doc.getFormatter().warning("My custom warning."));
    }

}
// <<<MyCustomFormatterTest

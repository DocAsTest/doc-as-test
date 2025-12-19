package com.github.docastest.samples.htmlPageName;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import com.github.docastest.doctesting.NotIncludeToDoc;
import com.github.docastest.doctesting.junitextension.ApprovalsExtension;
import com.github.docastest.doctesting.junitextension.HtmlPageExtension;
import com.github.docastest.doctesting.junitextension.SimpleApprovalsExtension;
import com.github.docastest.doctesting.utils.DocPath;
import com.github.docastest.test_tools.OnlyRunProgrammatically;

import java.nio.file.Path;

@NotIncludeToDoc
@OnlyRunProgrammatically
@ExtendWith(HtmlNameTest.HtmlPageHeaderExtension.class)
public class HtmlNameTest {
    static class HtmlPageHeaderExtension extends HtmlPageExtension {
        @Override
        public Path getFilePath(Class<?> clazz) {
            return new DocPath(clazz).page().folder().resolve("index.adoc");
        }
    }

    @RegisterExtension
    static final ApprovalsExtension doc = new SimpleApprovalsExtension();

    @Test
    public void test_A() {
        doc.write("In my *test*");
    }

}

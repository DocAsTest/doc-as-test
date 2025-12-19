package com.github.docastest.samples.htmlPageHeader;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import com.github.docastest.doctesting.NotIncludeToDoc;
import com.github.docastest.doctesting.junitextension.ApprovalsExtension;
import com.github.docastest.doctesting.junitextension.HtmlPageExtension;
import com.github.docastest.doctesting.junitextension.SimpleApprovalsExtension;
import com.github.docastest.test_tools.OnlyRunProgrammatically;

@NotIncludeToDoc
@OnlyRunProgrammatically
@ExtendWith(HtmlHeaderTest.HtmlPageHeaderExtension.class)
public class HtmlHeaderTest {
    static class HtmlPageHeaderExtension extends HtmlPageExtension {
        @Override
        public String content(Class<?> clazz) {
            return String.join("\n",
                    ":toc: left",
                    ":nofooter:",
                    super.content(clazz));
        }
    }

    @RegisterExtension
    static final ApprovalsExtension doc = new SimpleApprovalsExtension();

    @Test
    public void test_A() {
        doc.write("In my *test*");
    }

}

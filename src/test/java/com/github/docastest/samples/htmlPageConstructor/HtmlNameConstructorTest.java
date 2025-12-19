package com.github.docastest.samples.htmlPageConstructor;

import org.junit.jupiter.api.Test;
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
public class HtmlNameConstructorTest {
    @RegisterExtension
    static final ApprovalsExtension doc = new SimpleApprovalsExtension();

    static Path path = new DocPath(HtmlNameConstructorTest.class).packagePath();
    @RegisterExtension
    static final HtmlPageExtension page = new HtmlPageExtension(path.resolve("index").toString());

    @Test
    public void test_A() {
        doc.write("In my *test*");
    }

}

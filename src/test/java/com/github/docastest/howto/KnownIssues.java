package com.github.docastest.howto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import com.github.docastest.docformatter.asciidoc.AsciidocFormatter;
import com.github.docastest.doctesting.junitextension.ApprovalsExtension;
import com.github.docastest.doctesting.junitextension.SimpleApprovalsExtension;
import com.github.docastest.doctesting.utils.DocPath;
import com.github.docastest.doctesting.utils.NoTitle;
import com.github.docastest.test_tools.IntermediateHtmlPage;

import java.nio.file.Path;

@ExtendWith(IntermediateHtmlPage.class)
public class KnownIssues {

    @RegisterExtension
    static ApprovalsExtension doc = new SimpleApprovalsExtension();

    private final AsciidocFormatter formatter = new AsciidocFormatter();

    @Test
    @NoTitle
    public void knownIssues() {
        final Path path = new DocPath("knownIssues").resource().from(this.getClass());

        doc.write(formatter.include(DocPath.toAsciiDoc(path), 0));
    }

}

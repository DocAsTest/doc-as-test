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
import java.nio.file.Paths;

@ExtendWith(IntermediateHtmlPage.class)
public class Tutorial {

    @RegisterExtension
    static ApprovalsExtension doc = new SimpleApprovalsExtension();

    private final AsciidocFormatter formatter = new AsciidocFormatter();

    @Test
    @NoTitle
    public void tutorial() {
        final DocPath docPath = new DocPath(Paths.get(""), "tutorial");
        final Path from = docPath.resource().from(new DocPath(this.getClass()).approved());

        doc.write(
                String.format("include::%s[]", DocPath.toAsciiDoc(new DocPath(InstallingLibrary.class).approved().from(this.getClass()))),
                String.format("include::%s[]", DocPath.toAsciiDoc(from))
        );
    }

}

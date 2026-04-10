package com.github.docastest.howto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import com.github.docastest.docformatter.asciidoc.AsciidocFormatter;
import com.github.docastest.docformatter.Formatter;
import com.github.docastest.doctesting.junitextension.ApprovalsExtension;
import com.github.docastest.doctesting.junitextension.SimpleApprovalsExtension;
import com.github.docastest.doctesting.utils.NoTitle;
import com.github.docastest.doctesting.writer.Options;

public class InstallingLibrary {

    @RegisterExtension
    static ApprovalsExtension doc = new SimpleApprovalsExtension();

    Formatter formatter = new AsciidocFormatter();

    public String build() {
        return formatter.paragraphSuite(
                new Options(formatter).withCode(),
                formatter.title(1, "Installing Documentation testing"),
                getContent()
        );
    }

    @Test
    @NoTitle
    public void Installing_documentation_testing() {
        doc.write(getContent());
    }

    protected String getContent() {
        final String dependency = String.join("\n",
                "        <dependency>",
                "            <groupId>com.github.docastest</groupId>",
                "            <artifactId>doc-as-test</artifactId>",
                "            <version>${doc-as-test.version}</version>",
                "            <scope>test</scope>",
                "        </dependency>");

        return "We use the library link:https://github.com/DocAsTest/doc-as-test[doc-as-test]\n" +
                "which provides what we need to get started.\n" +
                "For a complete description of how to use it go to the link:https://docastest.github.io/doc-as-test/[doc-as-test site]\n" +
                "\n" +
                "The library is not yet on a public repository.\n" +
                "To use it, you need to download and install it.\n" +
                "\n" +
                "You have to download `.jar` and `.pom` from\n" +
                "link:https://github.com/DocAsTest/doc-as-test/packages/2941171[last doc-as-test release]\n" +
                "\n" +
                "Run this maven command to install it:\n" +
                "----\n" +
                "mvn install:install-file -Dfile=<path-to-file>.jar -DpomFile=<path-to-pomfile>.pom\n" +
                "----\n" +
                "\n" +
                "\n" +
                "Then, you can add the dependency to your `pom.xml` to use it in your project" +
                "\n" +
                formatter.sourceCodeBuilder("xml")
                        .indent(0)
                        .source(dependency)
                        .build();
    }


}

package com.github.docastest.doctesting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import com.github.docastest.codeextraction.ClassFinder;
import com.github.docastest.codeextraction.CodePath;
import com.github.docastest.docformatter.Formatter;
import com.github.docastest.docformatter.asciidoc.AsciidocFormatter;
import com.github.docastest.doctesting.junitextension.ApprovalsExtension;
import com.github.docastest.doctesting.junitextension.ApprovalsExtensionTest;
import com.github.docastest.doctesting.junitextension.SimpleApprovalsExtension;
import com.github.docastest.doctesting.junitinheritance.ApprovalsBase;
import com.github.docastest.doctesting.utils.DocWriterTest;
import com.github.docastest.doctesting.utils.NoTitle;
import com.github.docastest.doctesting.writer.ClassDocumentation;
import com.github.docastest.doctesting.writer.Classes;
import com.github.docastest.doctesting.writer.DocWriter;
import com.github.docastest.printer.Printer;
import com.github.docastest.doctesting.utils.PrinterTest;
import com.github.docastest.printer.SvgGraph;
import com.github.docastest.doctesting.utils.SvgGraphTest;
import com.github.docastest.test_tools.IntermediateHtmlPage;

import java.lang.reflect.Method;
import java.nio.file.Path;
import java.util.List;

@ExtendWith(IntermediateHtmlPage.class)
public class DocTestingDocumentation {

    @RegisterExtension
    static ApprovalsExtension doc = new SimpleApprovalsExtension();

    protected final Formatter formatter = new AsciidocFormatter();
    private static final ClassFinder classFinder = new ClassFinder();

    @Test
    @NoTitle
    public void doc() {
        doc.write(build());
    }

    public String build() {
        return formatter.paragraphSuite(
                generalInformation(),
                includeClasses()
        );
    }

    protected String generalInformation() {
        return formatter.paragraphSuite(
                "This document describes usage of classes to create test used to generate documentation.",
                "* " + makeAnchor(ApprovalsExtensionTest.class, ApprovalsExtension.class) + ": JUnit extension to check document.",
                "* " + makeAnchor(DocWriterTest.class, DocWriter.class) + ": Store document before writting it.",
                "* " + makeAnchor(PrinterTest.class, Printer.class) + ": Utilities for result presentation.",
                "* " + makeAnchor(SvgGraphTest.class, SvgGraph.class) + ": Create a svg graph.");
    }

    private String makeAnchor(Class<?> clazzAnchor, Class<?> clazzNameToDisplay) {
        return String.format("<<%s,%s>>", doc.getDocWriter().titleId(clazzAnchor), clazzNameToDisplay.getSimpleName());
    }

    public String includeClasses() {
        final Path location = CodePath.toPath(DocTestingDocumentation.class.getPackage());
        return new Classes(formatter).includeClasses(location, getClassesToDocument(), 0);
    }

    public boolean toBeInclude(Class<?> clazz) {
        if (clazz == null) {
            return true;
        }
        if (clazz.getPackage().equals(ApprovalsBase.class.getPackage())
                || clazz.getPackage().equals(ClassDocumentation.class.getPackage())) {
            return false;
        }

        return !clazz.isAnnotationPresent(NotIncludeToDoc.class)
                && toBeInclude(clazz.getDeclaringClass());
    }

    public boolean toBeInclude(Method method) {
        return !method.isAnnotationPresent(NotIncludeToDoc.class)
                && toBeInclude(method.getDeclaringClass());
    }

    private List<Class<?>> getClassesToDocument() {
        final List<Class<?>> classes = classFinder.classesWithAnnotatedMethod(DocTestingDocumentation.class.getPackage(), Test.class, this::toBeInclude);
        classes.remove(this.getClass());
        return classes;
    }


}

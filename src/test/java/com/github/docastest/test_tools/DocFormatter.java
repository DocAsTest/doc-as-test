package com.github.docastest.test_tools;

import com.github.docastest.codeextraction.CodePath;
import com.github.docastest.codeextraction.MethodReference;
import com.github.docastest.docformatter.asciidoc.AsciidocFormatter;
import com.github.docastest.doctesting.utils.DocPath;
import com.github.docastest.doctesting.utils.OnePath;
import com.github.docastest.doctesting.writer.Classes;

import java.lang.reflect.Method;
import java.util.Arrays;

public class DocFormatter extends AsciidocFormatter {
    private final boolean generateHtmlPage;

    public DocFormatter() {
        this(false);
    }
    public DocFormatter(boolean generateHtmlPage) {
        this.generateHtmlPage = generateHtmlPage;
    }

    public String getInclude(Class aClass, int offset) {
        return new Classes(this).includeClasses(CodePath.toPath(aClass.getPackage()), Arrays.asList(aClass), offset).trim();
    }

    public <T> String getInclude(MethodReference.SerializableConsumer<T> methodToInclude, int offset) {
        final Method method = MethodReference.getMethod(methodToInclude);

        final OnePath approvedPath = new DocPath(method).approved();
        return include(approvedPath.from(new DocPath(this.getClass()).approved()).toString(), offset);
    }
//
//    public String linkToClass(Class<?> clazz) {
//        final String title = new ClassDocumentation(null).getTestClassTitle(clazz);
//
//        return linkToClass(clazz, title);
//    }
//
//    public String linkToClass(Class<?> clazz, String title) {
//        return linkTo(clazz, null, title);
//    }
//
//    public String linkToMethod(Method method, String title) {
//        final Class<?> clazz = new ClassFinder().getMainFileClass(method.getDeclaringClass());
//        return linkTo(clazz, HowTo.doc.getDocWriter().titleId(method), title);
//    }
//
//    public String linkTo(Class clazz, String anchor, String title) {
//        final DocPath docPath = new DocPath(clazz);
//        // TODO do we generate page here ? It's not really the role of link formatting.
//        generatePage(clazz);
//
//        final String address = DocPath.toAsciiDoc(Paths.get("{" + Config.DOC_PATH_TAG + "}").resolve(docPath.html().path()));
//        return linkToPage(address, anchor, title);
//    }
//
//    private void generatePage(Class<?> clazz) {
//        if (generateHtmlPage) {
//            new IntermediateHtmlPage().generate(clazz);
//        }
//    }
}

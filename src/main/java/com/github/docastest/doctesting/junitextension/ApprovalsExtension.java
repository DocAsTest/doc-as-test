package com.github.docastest.doctesting.junitextension;

import com.github.docastest.codeextraction.CodeExtractor;
import com.github.docastest.docformatter.Formatter;
import com.github.docastest.doctesting.utils.Config;
import com.github.docastest.doctesting.utils.PathProvider;
import com.github.docastest.doctesting.writer.DocWriter;

import java.nio.file.Path;

/**
 * JUnit5 extension that verify written document matches with approved one.
 *
 * It checks that everything written during test is identical to the approved content.
 */
public class ApprovalsExtension<T extends DocWriter<F>, F extends Formatter> extends ApprovalsDocExtension<T> {
    {
        CodeExtractor.init(Config.TEST_PATH, Config.SOURCE_PATH);
    }

    public static <T extends DocWriter<F>, F extends Formatter> ApprovalsExtension<T, F> build(T docWriter) {
        return new ApprovalsExtension<T, F>(docWriter);
    }

    private static final PathProvider pathBuidler = new PathProvider();

    public ApprovalsExtension(T docWriter) {
        super(docWriter);
    }

    public F getFormatter() {
        return getDocWriter().getFormatter();
    }

    public void write(String... texts) {
        this.getDocWriter().write(texts);
    }

    /**
     * Give path where docs are generated.
     *
     * @return
     */
    public Path getDocPath() {
        return pathBuidler.getProjectPath().resolve(Config.DOC_PATH);
    }

}

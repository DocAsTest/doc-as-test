package com.github.docastest.doctesting.writer;

import com.github.docastest.docformatter.Formatter;
import com.github.docastest.doctesting.utils.Config;
import com.github.docastest.doctesting.utils.DocPath;
import com.github.docastest.doctesting.utils.OnePath;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Classes {
    private final Formatter formatter;
    private final String suffix;

    public Classes(Formatter formatter) {
        this(formatter, ".approved.adoc");
    }

    public Classes(Formatter formatter, String suffix) {
        this.suffix = suffix;
        this.formatter = formatter;
    }

    public String includeClasses(Path location, List<Class<?>> classesToInclude) {
        return includeClasses(location, classesToInclude, 1);
    }

    public String includeClasses(Path location, List<Class<?>> classesToInclude, int offset) {
        return classesToInclude.stream()
                .map(c -> getRelativeFilePath(location, c))
                .map(path -> {
                    return formatter.include(path.toString(), offset).trim();
                })
                .collect(Collectors.joining("\n\n", "\n", "\n"));
    }

    private Path getRelativeFilePath(Path docPath, Class<?> clazz) {
        final OnePath approved = new DocPath(clazz).approved();
        return approved.from(Config.DOC_PATH.resolve(docPath));
    }
}

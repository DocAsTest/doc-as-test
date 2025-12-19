package com.github.docastest.doctesting.junitextension;

import com.github.docastest.docformatter.Formatter;
import com.github.docastest.doctesting.utils.Config;
import com.github.docastest.doctesting.writer.DocWriter;

public class SimpleApprovalsExtension extends ApprovalsExtension<DocWriter<Formatter>, Formatter> {

    public SimpleApprovalsExtension() {
        super(new DocWriter(Config.FORMATTER));
    }
}

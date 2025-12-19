package com.github.docastest.test_tools;

import com.github.docastest.doctesting.junitextension.SimpleApprovalsExtension;
import com.github.docastest.doctesting.utils.DocPath;

import java.io.File;

public class ProjectTestExtension extends SimpleApprovalsExtension {

    public void runTestAndWriteResultAsComment(Class<?> testClass) {
        final com.github.docastest.test_tools.TestRunnerFromTest.Results results = new com.github.docastest.test_tools.TestRunnerFromTest().runTestClass(testClass);
        String[] texts = new String[]{"", String.format("// Test result for %s: %s", testClass.getSimpleName(), results.sucess() ? "Success" : "Fails"), ""};
        write(texts);
    }

    public void removeNonApprovalFiles(DocPath docPath) {
        final File[] filesToDelete = docPath.page().path().getParent().toFile().listFiles(
                pathname -> pathname.isFile() && !pathname.getName().startsWith("_"));
        if (filesToDelete == null) return;

        for(File file: filesToDelete) {
            file.delete();
        }
    }
}

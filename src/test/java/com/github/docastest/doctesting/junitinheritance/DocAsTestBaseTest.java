package com.github.docastest.doctesting.junitinheritance;

import org.junit.jupiter.api.extension.RegisterExtension;
import com.github.docastest.doctesting.junitextension.ApprovalsExtension;
import com.github.docastest.doctesting.junitextension.SimpleApprovalsExtension;
import com.github.docastest.doctesting.utils.DocPath;

class DocAsTestBaseTest {

    @RegisterExtension
    static ApprovalsExtension extension = new SimpleApprovalsExtension();

    DocAsTestBase docAsTest = new DocAsTestBase() {
        @Override
        protected void approvalAfterTestSpecific(String content, DocPath docPath) throws Exception {
        }
    };

}
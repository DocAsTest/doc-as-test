// >>>OneTest
package com.github.docastest.samples.justone;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
// <<<OneTest
import com.github.docastest.doctesting.NotIncludeToDoc;
// >>>OneTest
import com.github.docastest.doctesting.junitextension.ApprovalsExtension;
import com.github.docastest.doctesting.junitextension.SimpleApprovalsExtension;
// <<<OneTest
import com.github.docastest.test_tools.OnlyRunProgrammatically;

@NotIncludeToDoc
@OnlyRunProgrammatically

// >>>OneTest
public class OneTest {
    @RegisterExtension
    static final ApprovalsExtension doc = new SimpleApprovalsExtension();

    @Test
    public void test_A() {
        doc.write("In my *test*");
    }

}
// <<<OneTest

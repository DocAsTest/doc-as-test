package com.github.docastest.samples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import com.github.docastest.doctesting.junitextension.ApprovalsExtension;
import com.github.docastest.doctesting.junitextension.SimpleApprovalsExtension;
import com.github.docastest.doctesting.utils.NoTitle;

public class MyTestWithoutTitleOnOneTest {
    @RegisterExtension
    static final ApprovalsExtension doc = new SimpleApprovalsExtension();

    @Test
    public void intro() {
        doc.write("First line");
    }

    @Test
    @NoTitle
    public void my_method() {
        doc.write("My content without title");
    }

    @Test
    public void conclusion() {
        doc.write("Last line");
    }
}


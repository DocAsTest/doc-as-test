package com.github.docastest.codeextraction;

import com.github.docastest.doctesting.NotIncludeToDoc;


// tag::ClassWithAnnotationBeforeComment[]

@NotIncludeToDoc
/**
 * Comment of the class.
 */
class ClassWithAnnotationBeforeComment {
    // ...
}
// end::ClassWithAnnotationBeforeComment[]
package org.jbehave.core.junit;

import org.jbehave.core.configuration.AnnotationBuilder;
import org.jbehave.core.embedder.Embedder;
import org.junit.runner.Runner;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

/**
 * A JUnit {@link Runner} that uses the {@link AnnotationBuilder} to 
 * create an embeddable test instance and to provide an {@link Embedder}
 * from annotations.
 */
public class AnnotatedEmbedder extends BlockJUnit4ClassRunner {

    public AnnotatedEmbedder(Class<?> testClass) throws InitializationError {
        super(testClass);
    }

    @Override
    public Object createTest() {
        return annotationBuilder().embeddableInstance();
    }

    public Embedder buildEmbedder() {
        return annotationBuilder().buildEmbedder();
    }

    protected AnnotationBuilder annotationBuilder() {
        return new AnnotationBuilder(testClass());
    }

    protected Class<?> testClass() {
        return getTestClass().getJavaClass();
    }

}

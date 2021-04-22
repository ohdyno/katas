package kata.gradle.starter;

import org.approvaltests.Approvals;
import org.approvaltests.reporters.ClipboardReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
    @UseReporter(ClipboardReporter.class)
    @Test
    void appHasAGreetingWithApprovalTests() {
        App classUnderTest = new App();
        Approvals.verify(classUnderTest.getGreeting());
    }

    @Test
    void appHasAGreetingWithAssertJ() {
        App classUnderTest = new App();
        assertThat(classUnderTest.getGreeting()).isEqualTo("Hello World!");
    }

    @Test
    void appHasAGreetingWithJUnitAssert() {
        App classUnderTest = new App();
        assertEquals("Hello World!", classUnderTest.getGreeting());
    }
}

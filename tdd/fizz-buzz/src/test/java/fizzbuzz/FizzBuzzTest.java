package fizzbuzz;

import org.approvaltests.Approvals;
import org.approvaltests.reporters.ClipboardReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzTest {
    private final FizzBuzz subject = new FizzBuzz();

    @UseReporter(ClipboardReporter.class)
    @Test
    void usingApprovalTests() {
        Approvals.verify(subject.act());
    }

    @Test
    void usingAssertJ() {
        assertThat(subject.act()).isEqualTo("Hello World!");
    }

    @Test
    void usingJUnitAssert() {
        assertEquals("Hello World!", subject.act());
    }
}

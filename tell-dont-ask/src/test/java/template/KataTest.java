package template;

import org.approvaltests.Approvals;
import org.approvaltests.reporters.ClipboardReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class KataTest {
    private final Kata subject = new Kata();

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

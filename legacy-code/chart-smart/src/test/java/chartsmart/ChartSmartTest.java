package chartsmart;

import org.approvaltests.reporters.ClipboardReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.assertEquals;

@EnabledOnOs(OS.MAC)
@UseReporter(ClipboardReporter.class)
class ChartSmartTest {
    @BeforeEach
    void setUp() {

    }

    @Test
    void testMainWindow() {
        MainWindow window = new MainWindow();
        AwtHeadlessApprovals.verify(window);
    }

    @Test
    void testBarChartWindow() {
        IndvDsp chartSmart = new IndvDsp();
        chartSmart.iniDS(406, "rpfll", true);
        AwtHeadlessApprovals.verify(chartSmart);
        assertEquals("Bar Chart - Single Mode", chartSmart.getTitle());
    }

    @Test
    void testPieChartWindow() {
        IndvDsp chartSmart = new IndvDsp();
        chartSmart.iniDS(323, "rpfll", true);
        AwtHeadlessApprovals.verify(chartSmart);
        assertEquals("Pie Chart - Single Mode", chartSmart.getTitle());
    }

    @Test
    void testBarChartSmallWindow() {
        IndvDsp chartSmart = new IndvDsp();
        chartSmart.iniDS(406, "shareddisplay", true);
        AwtHeadlessApprovals.verify(chartSmart);
        assertEquals("Bar Chart - Compare Mode", chartSmart.getTitle());
    }

    @Test
    void testPieChartSmallWindow() {
        IndvDsp chartSmart = new IndvDsp();
        chartSmart.iniDS(323, "shareddisplay", true);
        AwtHeadlessApprovals.verify(chartSmart);
        assertEquals("Pie Chart - Compare Mode", chartSmart.getTitle());
    }

}

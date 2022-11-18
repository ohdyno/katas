package chartsmart;

import org.approvaltests.awt.AwtApprovals;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

class AwtHeadlessApprovals {
    public static void verify(JComponent component) {
        final String headless = System.getProperty("java.awt.headless");
        System.setProperty("java.awt.headless", "true");

        AwtApprovals.verify(HeadlessRenderer.render(component));

        if (headless != null) {
            System.setProperty("java.awt.headless", headless);
        }
    }

    /**
     * Create an image of components not displayed on a GUI.
     * <p>
     * Behind the scenes the component will be given a
     * size and the component will be laid out. The default size will be the
     * preferred size of the component, although you can invoke the setSize()
     * method on the component before invoking a render(...) method. The
     * default functionality should work in most cases. However, the only
     * foolproof way to get an image to is make sure the component has been
     * added to a realized window with code something like the following:
     * <pre>{@code
     * JFrame frame = new JFrame();
     * frame.setContentPane( someComponent );
     * frame.pack();
     * HeadlessRenderer.render( someComponent );
     * }</pre>
     *
     * @see <a href="https://tips4java.wordpress.com/2008/10/13/screen-image/">Rob Camick's Original Implementation</a>
     */
    public static class HeadlessRenderer {

        /**
         * Create a BufferedImage for Swing components.
         * The entire component will be captured to an image.
         *
         * @param component Swing component to create image from
         * @return image the image for the given region
         */
        public static BufferedImage render(JComponent component) {
            sizeAndLayoutComponent(component);
            return renderToImage(component);
        }

        private static BufferedImage renderToImage(JComponent component) {
            Dimension d = component.getSize();
            BufferedImage image = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = image.createGraphics();
            component.print(g);
            g.dispose();
            return image;
        }

        /**
         * Make sure the component has a size and has been laid out.
         * It is a necessary check for components not added to a realized frame.
         *
         * @param component Swing component that needs to be sized and laid out.
         */
        private static void sizeAndLayoutComponent(JComponent component) {
            if (!component.isDisplayable()) {
                Dimension d = component.getSize();

                if (d.width == 0 || d.height == 0) {
                    d = component.getPreferredSize();
                    component.setSize(d);
                }

                layoutComponent(component);
            }
        }

        static void layoutComponent(Component component) {
            synchronized (component.getTreeLock()) {
                component.doLayout();

                if (component instanceof Container) {
                    for (Component child : ((Container) component).getComponents()) {
                        layoutComponent(child);
                    }
                }
            }
        }
    }

}

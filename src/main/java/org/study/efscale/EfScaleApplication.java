package org.study.efscale;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.swing.SwingUtilities;

@SpringBootApplication
public class EfScaleApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EfScaleApplication.class).bannerMode(Banner.Mode.OFF).headless(false).run(args);
        SwingUtilities.invokeLater(EfScaleView::new);

    }
}

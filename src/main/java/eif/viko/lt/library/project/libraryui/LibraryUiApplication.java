package eif.viko.lt.library.project.libraryui;

import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LibraryUiApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(LibraryUiApplication.class, args);
    }

}

package eif.viko.lt.library.project.libraryui.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "/home", layout = AppLayoutNavbar.class)
public class HomeView extends VerticalLayout {
    public HomeView() {
        add(new H1("Labas"));
    }
}

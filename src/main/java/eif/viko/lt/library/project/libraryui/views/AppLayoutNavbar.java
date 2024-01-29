package eif.viko.lt.library.project.libraryui.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.LumoUtility;

import java.util.HashMap;
import java.util.Map;

@Route("")
public class AppLayoutNavbar extends AppLayout {

    // Užtikriname, kad perduota klasė paveldės iš Component klasės
    Map<String, Class<? extends Component>> routes;


    public AppLayoutNavbar() {

        routes = new HashMap<>();
        routes.put("Home", HomeView.class);
        routes.put("Books", BooksView.class);

        H1 title = new H1("MyApp");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)")
                .set("left", "var(--lumo-space-l)").set("margin", "0")
                .set("position", "absolute");

        HorizontalLayout navigation = getNavigation();
        navigation.getElement();

        addToNavbar(title, navigation);
    }

    private HorizontalLayout getNavigation() {
        HorizontalLayout navigation = new HorizontalLayout();
        navigation.addClassNames(
                LumoUtility.JustifyContent.CENTER,
                LumoUtility.Gap.SMALL,
                LumoUtility.Height.MEDIUM,
                LumoUtility.Width.FULL
        );

        routes.forEach((route, view) -> navigation.add(createLink(route, view)));

        return navigation;
    }

    private RouterLink createLink(String viewName, Class<? extends Component> viewClass) {
        var link = new RouterLink(viewName, viewClass);
        link.addClassNames(
                LumoUtility.Display.FLEX,
                LumoUtility.AlignItems.CENTER,
                LumoUtility.Padding.Horizontal.MEDIUM,
                LumoUtility.TextColor.SECONDARY,
                LumoUtility.FontWeight.MEDIUM
        );

        link.getStyle().set("text-decoration", "none");


        // Highlight the active link
        link.setHighlightCondition(HighlightConditions.sameLocation());
        link.getElement().getThemeList().add("mytheme"); // Add "active" theme when highlighted


        return link;
    }

}


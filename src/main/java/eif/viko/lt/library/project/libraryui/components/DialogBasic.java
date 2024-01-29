package eif.viko.lt.library.project.libraryui.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import eif.viko.lt.library.project.libraryui.model.Book;

import java.util.function.Consumer;


public class DialogBasic {

    public DialogBasic() {
    }

    public Component createDialogLayout(Consumer<Book> saveAction, Dialog dialog) {
        TextField titleField = new TextField("Title");
        TextField authorField = new TextField("Author");
        Checkbox checkbox = new Checkbox("IsAvailable");

        Button saveButton = new Button("Save", e -> {
            Book newBook = new Book(null, titleField.getValue(), authorField.getValue(), checkbox.getValue());
            saveAction.accept(newBook);
        });

        Button cancel = new Button("Cancel", e-> dialog.close());

        VerticalLayout layout = new VerticalLayout(titleField, authorField, checkbox, new HorizontalLayout(saveButton, cancel));

        layout.setPadding(false);
        layout.setSpacing(false);
        layout.setAlignItems(FlexComponent.Alignment.STRETCH);
        layout.getStyle().set("width", "18rem").set("max-width", "100%");

        // Add other layout configurations if needed
        return layout;
    }
}

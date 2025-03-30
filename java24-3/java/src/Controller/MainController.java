package Controller;

import Model.XMLHandler;
import View.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {
    private MainFrame view;

    public MainController(MainFrame view) {
        this.view = view;
        this.view.setAddButtonListener(new AddButtonListener());
        this.view.setReadButtonListener(new ReadButtonListener());
    }

    class AddButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = view.getTagName();
            String value = view.getTagValue();
            XMLHandler.addElement(name, value);
        }
    }

    class ReadButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String content = XMLHandler.readXMLFile();
            view.setOutputText(content);
        }
    }
}

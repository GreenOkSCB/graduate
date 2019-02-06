package gui.panels.parsing;

import com.toedter.calendar.JDateChooser;
import controller.util.property.PropertyUtil;
import model.timeseries.Timeseries;
import org.jfree.ui.tabbedui.VerticalLayout;

import javax.swing.*;
import java.awt.*;

public class ParsingPanel extends JPanel {

    private Long step;
    private Timeseries timeseries;
    private TextField folderTF;

    public ParsingPanel() {
        this.setBorder(BorderFactory.createTitledBorder("ВЫБОРКА"));
        this.setLayout(new VerticalLayout());

        JPanel filePanel = new JPanel(new BorderLayout());
        folderTF = new TextField();
        folderTF.setText(PropertyUtil.getProperty("BASE_DIR"));
        filePanel.add(new Label("Расположение директории с данными"), BorderLayout.NORTH);
        filePanel.add(folderTF, BorderLayout.CENTER);
        JButton open = new JButton("Выбрать");
/* */
        filePanel.add(open, BorderLayout.EAST);
        this.add(filePanel);
        JPanel panel = new JPanel(new BorderLayout());

        final JTextField textField = new JTextField();
        textField.setText("RIM7");
        final JTextField stepTF = new JTextField();
        stepTF.setText("1");
        JPanel active = new JPanel(new VerticalLayout());
        active.add(new JLabel("Название актива: "));
        active.add(textField);
        active.add(new JLabel("Шаг выборки в секундах"));
        active.add(stepTF);
        panel.add(active, BorderLayout.WEST);

        JPanel timePanel = new JPanel(new VerticalLayout());
        JDateChooser start = new JDateChooser();
        JDateChooser end = new JDateChooser();
        timePanel.add(new JLabel("C: "));
        timePanel.add(start);
        timePanel.add(new JLabel("По: "));
        timePanel.add(end);
        timePanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        panel.add(timePanel, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        this.add(panel);
        JButton button = new JButton("ВЫБРАТЬ ДАННЫЕ");
/* */
        this.add(button);
        this.setVisible(true);
    }

    /* parse */

    /* addTable */

}

package gui.panels.parsing;

import com.toedter.calendar.JDateChooser;
import controller.util.property.PropertyUtil;
import gui.dialogs.LoadingDialog;
import org.jfree.ui.tabbedui.VerticalLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

public class ParsingPanel extends JPanel {

    private Date dateStart;
    private Date dateEnd;
    private String optionName;
    private Long step;
    private TextField folderTF;

    public ParsingPanel() {
        this.setBorder(BorderFactory.createTitledBorder("ВЫБОРКА"));  // рамка панели с заголовком
        this.setLayout(new VerticalLayout());

        JPanel filePanel = new JPanel(new BorderLayout()); // создаем поле для указания пути к данным
        folderTF = new TextField();
        folderTF.setText(PropertyUtil.getProperty("BASE_DIR"));   // указываем директорию, где находятся данные
        filePanel.add(new Label("Расположение директории с данными"), BorderLayout.NORTH);
        filePanel.add(folderTF, BorderLayout.CENTER);

        JButton open = new JButton("Выбрать");  // создаем кнопку Выбрать директорию расположения данных
        open.addActionListener(new ActionListener() {    // добавляем слушателя
            @Override
            public void actionPerformed(ActionEvent e) {  //  у кнопки есть обработка события
                JFileChooser chooser = new JFileChooser();  // контейнер с компонентами для выбора файла
                chooser.setAcceptAllFileFilterUsed(false);  // выключаем фильтр выбора файлов - All files
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);  // Метод определения выделяемых объектов - файлы, директории или файлы с директориями
                int rVal = chooser.showOpenDialog(null);  // диалоговое окно "открыть файл"
                if (rVal == JFileChooser.APPROVE_OPTION) {  // проверяем успешность открытия
                    folderTF.setText(chooser.getSelectedFile().getPath());
                }
            }
        });
        filePanel.add(open, BorderLayout.EAST);
        this.add(filePanel);

        JPanel panel = new JPanel(new BorderLayout());  // создаем поле с вводом имени актива, шагом выборки и временным промежутком
        final JTextField textField = new JTextField();
        textField.setText("RIM7");  // задаем название актива(наиболее часто употребляемого+подсказка пользователю)
        final JTextField stepTF = new JTextField();
        stepTF.setText("1");    // задаем шаг выборки(наиболее показательное время )

        JPanel active = new JPanel(new VerticalLayout());  // панель с вертикальным расположением полей названия актива и шага выборки
        active.add(new JLabel("Название актива: "));
        active.add(textField);
        active.add(new JLabel("Шаг выборки в секундах"));
        active.add(stepTF);
        panel.add(active, BorderLayout.WEST);

        JPanel timePanel = new JPanel(new VerticalLayout());  // панель с вертикальным расположением поля выбора временного промежутка
        final JDateChooser start = new JDateChooser();    // начальная дата
        final JDateChooser end = new JDateChooser();  // конечная дата
        timePanel.add(new JLabel("C: "));
        timePanel.add(start);
        timePanel.add(new JLabel("По: "));
        timePanel.add(end);
        timePanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0)); // добавляем разрыв от других полей
        panel.add(timePanel, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // добавляем разрыв от других полей
        this.add(panel);

        JButton button = new JButton("ВЫБРАТЬ ДАННЫЕ"); // создаем кнопку Выбрать данные
        button.addActionListener(new ActionListener() {     // добавляем слушателя
            @Override
            public void actionPerformed(ActionEvent e) {    // обработка действия
                final LoadingDialog dialog = new LoadingDialog("Загрузка файлов","");  // новое окно, загрузка
                SwingWorker<Void, Void> mySwingWorker = new SwingWorker<Void, Void>() { // для выполнения длительной задачи - загрузки данных
                    @Override
                    protected Void doInBackground(){    // doInBackground - выполняет работу в фоновом потоке
                        optionName = textField.getText(); // пишется какой актив задействован
                        dateStart = start.getDate();  // начальная
                        dateEnd = end.getDate();      // и конечная даты
                        step = Long.valueOf(stepTF.getText()) * 1000;
/*  */
                        return null;
                    }
                };
                mySwingWorker.addPropertyChangeListener(new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {   // если загрузка прошла успешно,
                        if (evt.getPropertyName().equals("state")) {
                            if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
                                dialog.dispose();                           // то окно загрузки закроется
                            }
                        }
                    }
                });
                mySwingWorker.execute();
                dialog.setVisible(true);
            }
        });
        this.add(button);
        this.setVisible(true);
    }

    /* parse */

    /* addTable */

}

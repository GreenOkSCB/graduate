import gui.HvolatilityGUI;

public class Main {
    public static void main(String[] args) {
        HvolatilityGUI application = new HvolatilityGUI();
        application.pack();     // подгоняет размер окна с учетом всех элементов
        application.setLocationRelativeTo(null);    // центрирует окно
        application.setVisible(true);   // делаем окно видимым(true), по умолчанию невидимо
    }
}

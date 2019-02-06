package gui;

import gui.panels.calculationVolatility.CalculationVolatilityPanel;
import gui.panels.parsing.ParsingPanel;

import javax.swing.*;
import java.awt.*;

public class HvolatilityGUI extends JFrame {
    public HvolatilityGUI()throws HeadlessException {
        super("Historical Volatility");     // заголовок
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // окно разворачивается во весь экран

        ParsingPanel parsingPanel = new ParsingPanel();
        CalculationVolatilityPanel volatilityPanel = new CalculationVolatilityPanel(parsingPanel);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, parsingPanel, volatilityPanel);  // разделяемая панель
        splitPane.setDividerLocation(400);      // расположение разделения
        this.add(splitPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // выходим и закрываем окно
    }
}

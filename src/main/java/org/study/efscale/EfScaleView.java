package org.study.efscale;

import org.apache.commons.lang3.StringUtils;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

class EfScaleView {

    private EfScaleValidator efScaleValidator = new EfScaleValidator();

    private static final int MAX_WIDTH = 500;

    EfScaleView() {

        JFrame container = new JFrame();
        container.setLayout(new BorderLayout());

        JPanel formPanel = new JPanel();
        formPanel.setVisible(true);
        formPanel.setPreferredSize(new Dimension(MAX_WIDTH, 35));
        formPanel.setLayout(new GridLayout(1, 3));

        JLabel formMessage = new JLabel(" please enter wind speed: ");

        JTextField formTextField = new JTextField();

        JButton formButton = new JButton("submit");

        formPanel.add(formMessage);
        formPanel.add(formTextField);
        formPanel.add(formButton);

        container.getContentPane().add(formPanel, BorderLayout.NORTH);

        JPanel errorPanel = new JPanel();
        errorPanel.setPreferredSize(new Dimension(MAX_WIDTH, 20));
        errorPanel.setVisible(true);
        errorPanel.setLayout(new GridLayout(1, 1));

        JLabel errorMessageLabel = new JLabel(" error message will go here");
        errorPanel.add(errorMessageLabel);

        container.getContentPane().add(errorPanel, BorderLayout.CENTER);
        ShapePanel[] testTriangle = new ShapePanel[1];
        testTriangle[0] = new ShapePanel(0);

        JPanel resultViewPanel = new JPanel();
        resultViewPanel.setPreferredSize(new Dimension(MAX_WIDTH, 100));
        resultViewPanel.setVisible(true);
        resultViewPanel.setLayout(new GridLayout(1, 1));

        container.getContentPane().add(resultViewPanel, BorderLayout.SOUTH);

        container.setVisible(true);
        container.setResizable(false);
        container.pack();
        container.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        formTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                errorMessageLabel.setText(StringUtils.EMPTY);
                resultViewPanel.remove(testTriangle[0]);
                resultViewPanel.updateUI();
            }

            @Override
            public void focusLost(FocusEvent e) {
                // do nothing
            }
        });

        formButton.addActionListener(e -> {
            String windGust = formTextField.getText();

            try {
                efScaleValidator.validateEfWindGust(windGust);
            } catch (EfScaleException efScaleException) {
                setErrorLabel(errorMessageLabel, efScaleException);
                return;
            }
            resultViewPanel.remove(testTriangle[0]);
            testTriangle[0] = new ShapePanel(EfScaleUtils.getEfRating(windGust));
            resultViewPanel.add(testTriangle[0]);
            resultViewPanel.updateUI();
        });
    }

    private void setErrorLabel(JLabel errorMessageLabel, EfScaleException efScaleException) {
        errorMessageLabel.setVisible(true);
        errorMessageLabel.setForeground(Color.RED);
        errorMessageLabel.setText(efScaleException.getMessage());
    }
}

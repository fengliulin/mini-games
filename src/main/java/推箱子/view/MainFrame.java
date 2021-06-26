package 推箱子.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MainFrame extends JFrame implements ActionListener, ItemListener {


    public MainFrame() throws HeadlessException {
        initFrame();
        Container contentPane = getContentPane();
    }

    private void initFrame() {
        super.setTitle("推箱子");
        setSize(720,720);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}

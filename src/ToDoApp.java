import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;



public class ToDoApp {
    private final ArrayList<String> taskList;
    private final ArrayList<JCheckBox> checkBoxList;
    private boolean toDelete;

    public ToDoApp() {
        this.toDelete = false;
        this.checkBoxList = new ArrayList<JCheckBox>();
        this.taskList = new ArrayList<String>();
        JFrame frame = new JFrame("To Do App");

        JPanel westPanel = new JPanel();
        westPanel.setPreferredSize(new Dimension(350, 600));
        westPanel.setLayout(new BorderLayout());
        JPanel eastPanel = new JPanel();

        JLabel projectsLabel = new JLabel("Reflection");
        projectsLabel.setHorizontalAlignment(SwingConstants.LEFT);
        projectsLabel.setFont(new Font("Serif", Font.BOLD, 35));
        projectsLabel.setForeground(Color.BLACK);
        westPanel.add(projectsLabel, BorderLayout.NORTH);

        JPanel westSouthPanel = new JPanel();
        westSouthPanel.setLayout(new FlowLayout());
        JButton emailButtonWest = new JButton("Email");
        JTextField enterTaskWest = new JTextField("Enter Email ", 10);
        enterTaskWest.setPreferredSize(new Dimension(10, 35));
        westSouthPanel.add(enterTaskWest);
        westSouthPanel.add(emailButtonWest);
        westPanel.add(westSouthPanel, BorderLayout.SOUTH);

        frame.add(westPanel, BorderLayout.WEST);

        JTextField enterTask = new JTextField("Add a Task ", 25);
        enterTask.setPreferredSize(new Dimension(25, 35));
        eastPanel.setLayout(new BorderLayout());
        eastPanel.setBackground(Color.WHITE);
        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.setLayout(new FlowLayout());

        enterTask.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    taskList.add(enterTask.getText());
                    enterTask.setText("");
                    System.out.println(taskList);

                    checkBoxList.add(new JCheckBox(taskList.get(taskList.size() - 1)));
                    checkBoxPanel.add(checkBoxList.get(checkBoxList.size()-1));
                    checkBoxPanel.setBackground(Color.WHITE);
                    eastPanel.add(checkBoxPanel, BorderLayout.CENTER);

                    SwingUtilities.updateComponentTreeUI(frame);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        JPanel eastSouthPanel = new JPanel();
        eastSouthPanel.setLayout(new FlowLayout());

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toDelete = true;
                for(int x = 0; x < checkBoxList.size(); x++) {
                    if (checkBoxList.get(x).isSelected() == true) {
                        checkBoxList.remove(x);
                        taskList.remove(x);
                        x = -1;

                    }

                }
                checkBoxPanel.removeAll();
                for (int i = 0; i < checkBoxList.size(); i++) {
                    checkBoxPanel.add(checkBoxList.get(i));
                }
                SwingUtilities.updateComponentTreeUI(frame);
            }
        });
        eastSouthPanel.add(deleteButton);
        eastSouthPanel.add(enterTask);
        eastSouthPanel.setBackground(Color.WHITE);
        eastPanel.add(eastSouthPanel, BorderLayout.SOUTH);

        JLabel tasksLabel = new JLabel("Tasks");
        tasksLabel.setHorizontalAlignment(SwingConstants.LEFT);
        tasksLabel.setFont(new Font("Serif", Font.BOLD, 35));
        tasksLabel.setForeground(Color.RED);
        eastPanel.add(tasksLabel, BorderLayout.NORTH);


        frame.add(eastPanel);
        frame.repaint();


        //4. Size the frame.
        frame.setSize(800, 600);
        frame.setResizable(true);


        //5. Show it.
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        ToDoApp newApp = new ToDoApp();
    }
}
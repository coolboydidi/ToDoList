import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class ToDoApp {
    private ArrayList<String> taskList;

    public ToDoApp() {
        this.taskList = new ArrayList<String>();
        JFrame frame = new JFrame("To Do App");

        JPanel westPanel = new JPanel();
        westPanel.setPreferredSize(new Dimension(350, 600));
        westPanel.setLayout(new BorderLayout());
        JPanel eastPanel = new JPanel();

        JLabel projectsLabel = new JLabel("Projects");
        projectsLabel.setHorizontalAlignment(SwingConstants.LEFT);
        projectsLabel.setFont(new Font("Serif", Font.BOLD, 35));
        projectsLabel.setForeground(Color.BLACK);
        JButton addProjectButton = new JButton("Add Project");
        westPanel.add(addProjectButton, BorderLayout.SOUTH);
        westPanel.add(projectsLabel, BorderLayout.NORTH);


        frame.add(westPanel, BorderLayout.WEST);

        JTextField enterTask = new JTextField("Add a Task ", 25 );
        enterTask.setPreferredSize(new Dimension(25, 35));
        eastPanel.setLayout(new BorderLayout());
        eastPanel.setBackground(Color.WHITE);
        enterTask.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == 10) {
                    taskList.add(enterTask.getText());
                    enterTask.setText("");
                    System.out.println(taskList);
                    // only working once -- fix this
                    JPanel checkBoxPanel = new JPanel();
                    checkBoxPanel.setLayout(new FlowLayout());
                    for(int i = 0 ; i < taskList.size(); i++) {
                        checkBoxPanel.add(new JCheckBox(taskList.get(i)));
                    }
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

        JButton emailButton = new JButton("Email");
        eastSouthPanel.add(emailButton);
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
        frame.setResizable(false);


        //5. Show it.
        frame.setVisible(true);
    }



    public static void main(String[] args) {
        ToDoApp newApp = new ToDoApp();
    }

}
import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;


public class ToDoApp {
    public ToDoApp() {
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

        JPanel eastSouthPanel = new JPanel();
        eastSouthPanel.setLayout(new FlowLayout());

        JButton emailButton = new JButton("Email");
        eastSouthPanel.add(emailButton);
        eastSouthPanel.add(enterTask);
        eastSouthPanel.setBackground(Color.WHITE);
        eastPanel.add(eastSouthPanel, BorderLayout.SOUTH);


        frame.add(eastPanel);



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
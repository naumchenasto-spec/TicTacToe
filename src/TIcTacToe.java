import javax.swing.*;
import java.awt.*;


public class TIcTacToe {


    private JFrame frame =  new JFrame();

    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();

    private JButton[][] buttons = new JButton[3][3];
    private JButton button1 = new JButton("New Game");

    TIcTacToe(){

        panel1.setBackground(Color.GRAY);


        panel2.setBackground(Color.GREEN);

        panel2.setLayout(new GridLayout(3,3));

        for(int row=0; row<3; row++){
            for(int col=0; col<3; col++){

                buttons[row][col] = new JButton("1");
                panel2.add(buttons[row][col]);
            }
        }

        panel3.setBackground(Color.RED);
        panel3.add(button1);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.BLACK);
        frame.setTitle("Tic Tac Toe");
        frame.setSize(800,800);

        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.CENTER);
        frame.add(panel3, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}

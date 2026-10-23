import javax.swing.*;
import java.awt.*;



public class TicTacToe {

    final private Font font = new Font("SansSerif", Font.BOLD, 160);
    final private Font font1 = new Font("SansSerif", Font.BOLD, 20);

    final private JFrame frame =  new JFrame();

    final private JPanel panel1 = new JPanel();
    final private JPanel panel2 = new JPanel();
    final private JPanel panel3 = new JPanel();

    final private JButton[][] buttons = new JButton[3][3];
    final private JButton button1 = new JButton("New Game");

    private String current_player = "X";
    private int isDrawn = 0;
    private int xWon = 0;
    private int oWon = 0;
    final private JLabel player1 = new JLabel("Player 1 (X):" + xWon);
    final private JLabel player2 = new JLabel("Player 2 (O):" + oWon);
    final private JLabel draw = new JLabel("Draw:" + isDrawn);

    private boolean gameOver = false;

    private String lastGameStarter = "X";

    TicTacToe(){

        panel1.setBackground(Color.BLACK);
        panel1.setLayout(new GridLayout(1,3));
        panel1.setPreferredSize(new Dimension(800, 100));

        player1.setForeground(Color.RED);
        player2.setForeground(Color.BLUE);
        draw.setForeground(Color.YELLOW);

        player1.setFont(font1);
        player2.setFont(font1);
        draw.setFont(font1);

        panel1.add(player1);
        panel1.add(player2);
        panel1.add(draw);

        panel2.setBackground(Color.LIGHT_GRAY);

        panel2.setLayout(new GridLayout(3,3));


        for(int row=0; row<3; row++){
            for(int col=0; col<3; col++){
                int r=  row;
                int c = col;

                buttons[row][col] = new JButton("");
                buttons[row][col].setFont(font);
                buttons[row][col].setBackground(Color.BLACK);
                panel2.add(buttons[row][col]);
                buttons[row][col].addActionListener(e -> handle_Clicks(r, c));
            }
        }

        panel3.setBackground(Color.BLACK);
        panel3.add(button1);
        button1.addActionListener(e -> {reset();});


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.BLACK);
        frame.setTitle("Tic Tac Toe");
        frame.setSize(800,800);

        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.CENTER);
        frame.add(panel3, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public void handle_Clicks(int row, int col){

        if(gameOver){
            return;
        }
        if(buttons[row][col].getText().isEmpty()) {
            buttons[row][col].setText(current_player);

            if (current_player.equals("X")) {
                current_player = "O";
                buttons[row][col].setBackground(Color.BLACK);
            } else {
                current_player = "X";
                buttons[row][col].setBackground(Color.BLACK);
            }

            if(checkWinner()){
                if(current_player.equals("O")){
                    colorBoard(Color.RED); //is RED because current_player switches immediately even if checkWinner is true!
                    xWon += 1;
                    player1.setText("Player 1 (X):" + xWon);
                    gameOver = true;

                } else{
                    colorBoard(Color.BLUE);
                    oWon += 1;
                    player2.setText("Player 2 (O):" + oWon);
                    gameOver = true;
                }
            }
            if(isTie()){
                colorBoard(Color.YELLOW);
                isDrawn += 1;
                draw.setText("Draw:" + isDrawn);
                gameOver = true;
            }
        }
    }

    private boolean checkWinner(){
        for(int row=0; row<3; row++){
            //horizontal
            if(buttons[row][0].getText().isEmpty()){
                continue;
            }

            if(buttons[row][0].getText().equals(buttons[row][1].getText()) &&
                    buttons[row][1].getText().equals(buttons[row][2].getText())){
                return true;
            }
        }

        for(int col=0; col<3; col++){
            //vertical
            if(buttons[0][col].getText().isEmpty()){
                continue;
            }
            if(buttons[0][col].getText().equals(buttons[1][col].getText()) &&
                    buttons[1][col].getText().equals(buttons[2][col].getText())){
                return true;
            }
        }

        //Diagonal
        if(buttons[0][0].getText().equals(buttons[1][1].getText()) &&
                buttons[1][1].getText().equals(buttons[2][2].getText())
                && !buttons[0][0].getText().isEmpty()){
            return true;
        }

        //opposite of diagonal
        if(buttons[0][2].getText().equals(buttons[1][1].getText()) &&
                buttons[1][1].getText().equals(buttons[2][0].getText())
                && !buttons[0][2].getText().isEmpty()){
            return true;
        }

        return false;
    }

    private boolean isTie(){

        for(int row=0; row<3; row++){
            for(int col=0; col<3; col++){
                if( buttons[row][col].getText().isEmpty()){
                    return false;
                }
            }
        }
        return true;
    }

    private void colorBoard(Color color) {

        for(int row=0; row<3; row++){
            for(int col=0; col<3; col++){
                buttons[row][col].setForeground(color);
            }
        }
    }

    private void reset(){

       gameOver = false;

       for(int row=0; row<3; row++){
           for(int col=0; col<3; col++){
               buttons[row][col].setText("");
           }
       }

       colorBoard(Color.GRAY);

     if(lastGameStarter.equals("X")){
         lastGameStarter = "O";
     } else{
         lastGameStarter = "X";
     }

     current_player = lastGameStarter;

    }
}


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame jFrame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel buttons_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;


    TicTacToe(){
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(800,800);
        jFrame.getContentPane();
        jFrame.setBackground(Color.black);
        jFrame.setLayout(new BorderLayout());
        jFrame.setVisible(true);

        textfield.setBackground(Color.gray);
        textfield.setForeground(Color.green);
        textfield.setFont(new Font("Ink Free", Font.BOLD, 50));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic Tac Toe");
        textfield.setOpaque(true);


        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);
        title_panel.add(textfield);
        jFrame.add(title_panel, BorderLayout.NORTH);

        buttons_panel.setLayout(new GridLayout(3,3));
        buttons_panel.setBackground(Color.cyan);

        for(int i=0;i<9;i++) {
            buttons[i] = new JButton();
            buttons_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        jFrame.add(buttons_panel);
        firstTurn();





    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0; i<9;i++){
            if(e.getSource()==buttons[i]){
                if (player1_turn){
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(Color.red);
                        buttons[i].setText("X");
                        player1_turn=false;
                        textfield.setText("O's Turn");
                        check();
                    }
                }
                else {
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(Color.yellow);
                        buttons[i].setText("O");
                        player1_turn=true;
                        textfield.setText("X's Turn");
                        check();
                    }

                }
            }
        }

    }

    public void firstTurn(){
        try{
            Thread.sleep(3000);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if(random.nextInt(2)==0){
            player1_turn= true;
            textfield.setText("X's Turn");

        }
        else {
            player1_turn = false;
            textfield.setText("O's Turn");
        }



    }

    public void check(){

        //For X

        if( (buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X")){
            xWins(0,1,2);
        }
        else if((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X")){
            xWins(3,4,5);
        }
        else if((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X")){
            xWins(6,7,8);
        }
        else if((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X")){
            xWins(0,3,6);
        }
        else if((buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X")){
            xWins(1,4,7);
        }
        else if ((buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X")){
            xWins(2,5,8);
        }
        else if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X")){
            xWins(0,4,8);
        }
        else if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X")){
            xWins(2,4,6);
        }

        //For O

        if( (buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O")){
            oWins(0,1,2);
        }
        else if((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O")){
            oWins(3,4,5);
        }
        else if((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O")){
            oWins(6,7,8);
        }
        else if((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O")){
            oWins(0,3,6);
        }
        else if((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O")){
            oWins(1,4,7);
        }
        else if ((buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O")){
            oWins(2,5,8);
        }
        else if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O")){
            oWins(0,4,8);
        }
        else if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O")){
            oWins(2,4,6);
        }

    }

    public void xWins(int a, int b, int c){
        buttons[a].setForeground(Color.green.darker());
        buttons[b].setForeground(Color.green.darker());
        buttons[c].setForeground(Color.green.darker());
        for (int i=0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("X Won!");

    }

    public void oWins(int a, int b, int c){
        buttons[a].setForeground(Color.green.darker());
        buttons[b].setForeground(Color.green.darker());
        buttons[c].setForeground(Color.green.darker());
        for (int i=0; i<9; i++){
            buttons[i].setEnabled(false);
        }

        textfield.setText("O Won!");
    }

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
    }
}

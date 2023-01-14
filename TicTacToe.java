// imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// tictactoe class
public class TicTacToe implements ActionListener{
    JFrame window = new JFrame("Tic-Tac-Toe");
    // create a Jpanel
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel reloadPanel =new JPanel();
    JPanel scorePanel = new JPanel();

    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    JButton reloadButton = new JButton("Reload");
    JButton closeButton = new JButton("Close");
    JLabel scoreLabelPlayerX = new JLabel();
    JLabel scoreLabelPlayerO = new JLabel();

    int PlayerXScore=0;
    int PlayerOScore=0;

    boolean playerXTurn;

    TicTacToe(){
        window.setSize(1000,800);
        window.getContentPane().setBackground(new Color(50,50,50));
        window.setLayout(new BorderLayout());
        window.setVisible(true);

        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0,0,1000,100);
        titlePanel.add(textfield);

        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(new Color(150,150,150));
        for(int i=0;i<9;i++){
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        reloadPanel.setLayout(new GridLayout(1,2));
        reloadPanel.setBackground(new Color(150,150,150));

        reloadButton.setBackground(new Color(0,0,255));
        reloadButton.setFocusable(false);
        reloadButton.addActionListener(this);

        closeButton.setBackground(new Color(255,0,0));
        closeButton.setFocusable(false);
        closeButton.addActionListener(this);

        reloadPanel.add(reloadButton);
        reloadPanel.add(closeButton);

        scorePanel.setLayout(new GridLayout(2,1));
        scorePanel.setBackground(new Color(255,255,0));

        scoreLabelPlayerX.setFont(new Font("MV Boli", Font.BOLD, 20));
        scoreLabelPlayerX.setText("Player X: "+PlayerXScore);

        scoreLabelPlayerO.setFont(new Font("MV Boli", Font.BOLD, 20));
        scoreLabelPlayerO.setText("Player O: "+PlayerOScore);

        scorePanel.add(scoreLabelPlayerX);
        scorePanel.add(scoreLabelPlayerO);

        window.add(titlePanel,BorderLayout.NORTH);
        window.add(buttonPanel);
        window.add(reloadPanel,BorderLayout.SOUTH);
        window.add(scorePanel,BorderLayout.EAST);
        // elements->panel->window
        firstTurn();
    }

    public void firstTurn(){
        try{
            Thread.sleep(15000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        if(Math.random()<0.5){
            playerXTurn=true;
            textfield.setText("X Turn");
        }else{
            playerXTurn=false;
            textfield.setText("O Turn");
        }
    }
    @Override
    public void actionPerformed(ActionEvent e){
        for(int i=0;i<9;i++){
            if(e.getSource()==buttons[i]){
                if(playerXTurn){
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0,255,0));
                        buttons[i].setText("X");
                        playerXTurn = false;
                        textfield.setText("O Turn");
                        textfield.setForeground(new Color(0,0,255));
                        check();
                    }
                }else{
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        playerXTurn = true;
                        textfield.setText("X Turn");
                        textfield.setForeground(new Color(0,255,0));
                        check();
                    }
                }
            }
        }
        if(e.getSource()==reloadButton){
            reload();
        }
        if(e.getSource()==closeButton){
            window.dispose();
        }
    }

    public void check(){
        // ---------------Hoizontal Conditions--------------
        if(
            buttons[0].getText()=="X" &&
            buttons[1].getText()=="X" &&
            buttons[2].getText()=="X" 
        ){
           xWins(0,1,2); 
        }
        if(
            buttons[3].getText()=="X" &&
            buttons[4].getText()=="X" &&
            buttons[5].getText()=="X" 
        ){
           xWins(3,4,5); 
        }
        if(
            buttons[6].getText()=="X" &&
            buttons[7].getText()=="X" &&
            buttons[8].getText()=="X" 
        ){
           xWins(6,7,8); 
        }
        // ---------------Vertical Conditions--------------
        if(
            buttons[0].getText()=="X" &&
            buttons[3].getText()=="X" &&
            buttons[6].getText()=="X" 
        ){
           xWins(0,3,6); 
        }
        if(
            buttons[1].getText()=="X" &&
            buttons[4].getText()=="X" &&
            buttons[7].getText()=="X" 
        ){
           xWins(1,4,7); 
        }
        if(
            buttons[2].getText()=="X" &&
            buttons[5].getText()=="X" &&
            buttons[8].getText()=="X" 
        ){
           xWins(2,5,8); 
        }
        // ---------------Diagonal Conditions--------------
        if(
            buttons[0].getText()=="X" &&
            buttons[4].getText()=="X" &&
            buttons[8].getText()=="X" 
        ){
           xWins(0,4,8); 
        }
        if(
            buttons[2].getText()=="X" &&
            buttons[4].getText()=="X" &&
            buttons[6].getText()=="X" 
        ){
           xWins(2,4,6);
        }

        if (
            (buttons[0].getText() == "O") &&
            (buttons[1].getText() == "O") &&
            (buttons[2].getText() == "O")
        ){
            oWins(0, 1, 2);
        }
        // create an if statement
        if (
            (buttons[3].getText() == "O") &&
            (buttons[4].getText() == "O") &&
            (buttons[5].getText() == "O")
        ) {
            oWins(3, 4, 5);
        }
        // create an if statement
        if (
            (buttons[6].getText() == "O") &&
            (buttons[7].getText() == "O") &&
            (buttons[8].getText() == "O")
        ) {
            oWins(6, 7, 8);
        }
        // create an if statement
        if (
            (buttons[0].getText() == "O") &&
            (buttons[3].getText() == "O") &&
            (buttons[6].getText() == "O")
        ) {
            oWins(0, 3, 6);
        }
        // create an if statement
        if (
            (buttons[1].getText() == "O") &&
            (buttons[4].getText() == "O") &&
            (buttons[7].getText() == "O")
        ) {
            oWins(1, 4, 7);
        }
        // create an if statement
        if (
            (buttons[2].getText() == "O") &&
            (buttons[5].getText() == "O") &&
            (buttons[8].getText() == "O")
        ) {
            oWins(2, 5, 8);
        }
        // create an if statement
        if (
            (buttons[0].getText() == "O") &&
            (buttons[4].getText() == "O") &&
            (buttons[8].getText() == "O")
        ) {
            oWins(0, 4, 8);
        }
        // create an if statement
        if (
            (buttons[2].getText() == "O") &&
            (buttons[4].getText() == "O") &&
            (buttons[6].getText() == "O")
        ) {
            oWins(2, 4, 6);
        }
    }

    public void xWins(int a,int b, int c){
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("X Wins");
        PlayerXScore++;
        scoreLabelPlayerX.setText("Player X: "+PlayerXScore);
    }
    public void oWins(int a,int b, int c){
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("O Wins");
        PlayerOScore++;
        scoreLabelPlayerO.setText("Player O: "+PlayerOScore);
    }

    public void reload(){
        for(int i=0;i<9;i++){
            buttons[i].setText("");
            buttons[i].setBackground(new Color(240,240,240));
            buttons[i].setEnabled(true);
        }
        firstTurn();
    }
}
package Chapter14.Ch12And14Bookwork.chomp;

/**
 * A board game program with someone
 * playing against the computer
 */

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.util.Scanner;

public class Chomp extends JFrame
{
  private ChompGame game;
  private JTextField display;
  private Player players[];
  private int currentPlayer;

  public Chomp()
  {
    Container c = getContentPane();

    display = new JTextField(20);
    display.setBackground(Color.YELLOW);
    display.setEditable(false);
    c.add(display, BorderLayout.NORTH);

    BoardPanel board = new BoardPanel();
    c.add(board, BorderLayout.CENTER);

    game = new ChompGame(board);
    System.out.print("Player 1 Name: ");
    Scanner scan=new Scanner(System.in);
    HumanPlayer human = new HumanPlayer(this, game, board,scan.nextLine());
    System.out.print("Player 2 Name: ");
    HumanPlayer human2=new HumanPlayer(this, game, board,scan.nextLine());
    scan.close();
    ComputerPlayer computer = new ComputerPlayer(this, game, board);
    computer.setStrategy(new Chomp4by7Strategy());

    players = new Player[3];
    players[0] = human;
    players[1] = human2;
    players[2]=computer;
    currentPlayer = 0;

    display.setText(" You go first, "+players[0].getName());
    players[currentPlayer].makeMove();
  }

  // Called by the player when its move is completed.
  public void hasMoved()
  {
    currentPlayer = (currentPlayer + 1) % 3;
    Player p = players[currentPlayer];
    if (game.isWon())
    {
      display.setText(p.getWinMessage());
    }
    else
    {
      display.setText(p.getPrompt());
      p.makeMove();
    }
  }

  public static void main(String[] args)
  {
    Chomp window = new Chomp();
    window.setTitle("Chomp");
    window.setBounds(200, 200, 300, 225);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setResizable(true);
    window.setVisible(true);
  }
}


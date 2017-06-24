/*Ishvaraus Davis
CS 0401
Assignment Three
Extra Credit: Menu option to end the game without saving scores and show score at any point*/
import java.util.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.awt.geom.*;
import javax.swing.JMenu;
import javax.swing.JMenuBar;	
import javax.swing.JMenuItem;




public class Assig4
{
	//instance variables
	private JFrame theWindow;
	private JPanel Hangman;
	private MyPanel drawPanel;
	private TopPanelType Buttons;
	private HangFigure f;
	private BottomPanelType Game;
	private JTextField theGuess;
	private ArrayList<HangPlayer> players;
	private JLabel label1, label2, label3, label4;
	private HangPlayer p;
	private int output = 0;
	private boolean newWordPlayed = false, control = false, gameControl = false;
	private Character loop;
	private StringBuilder guessedWords, guessedLetters;
	private String word;
	private int userPlayed;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem showScores, quickExit;

	
	public Assig4()
	{
		//Add items to the frame
		Hangman = new JPanel();
		Buttons = new TopPanelType();
		Game = new BottomPanelType();
		drawPanel = new MyPanel(150, 150);
		theWindow = new JFrame("Hangman Game");
		theWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theWindow.add(Buttons, BorderLayout.EAST);
		theWindow.add(Game, BorderLayout.CENTER);
		theWindow.add(drawPanel, BorderLayout.WEST);
		myMenu();
		theWindow.pack();
		theWindow.setVisible(true);
		f = new HangFigure(50,50,30);
	}
		
	
	class MyPanel extends JPanel
	{
		private int width, height;
		public MyPanel(int w, int h)
		{
			width = w;
			height = h;
		}

		public Dimension getPreferredSize()
		{
			return new Dimension(width, height);
		}

		
		public void paintComponent (Graphics g) 
		{
			super.paintComponent(g);         
			Graphics2D g2d = (Graphics2D) g; 
			if (f != null)		
				f.draw(g2d);	
								
		}
	}
	
	private class TopPanelType extends JPanel
	{
		//panel for Buttons
		private JButton button1, button2, button3;
		private boolean clicked = false, clicked1 = false, endGame = false;
		private String playerName, fileName;
		private WordServer server;
		private boolean quitGame = false;
		
		public TopPanelType()
		{
		setLayout(new GridLayout(3,1));
		button1 = new JButton("Start Game");
		button2 = new JButton("End Game");
		button3 = new JButton("New Word");
		
		button3.setEnabled(false);
		button2.setEnabled(false);
		
		buttonListener theListener = new buttonListener();
		button1.addActionListener(theListener);
		button2.addActionListener(theListener);
		button3.addActionListener(theListener);
		
		add(button1);
		add(button2);
		add(button3);
		
		}
		
			private class buttonListener implements ActionListener
			{
				
				public void actionPerformed(ActionEvent e)
				{
				if(e.getSource() == button1)
				{
					
					if(clicked == false)
					{
					button2.setEnabled(true);
					button1.setText("Next Player");
					JOptionPane.showMessageDialog(null, "Loading Players Completed");
					label1.setText("Ready for a Player");
					try
					{
					players = loadData();
					}
					catch(IOException a)
					{}
					clicked = true;
					}
					
					if(clicked == true)
					{
					playerName = JOptionPane.showInputDialog("What is your name?"); 
					
					endGame = false;
					
					p = new HangPlayer(playerName);
					
					userPlayed = p.equals(playerName, players);
					
						if(userPlayed == -1)
						{
						HangPlayer currentPlayer = new HangPlayer(playerName);
						players.add(currentPlayer);
						output = players.size() - 1;
						JOptionPane.showMessageDialog(null, "Welcome to The Game " + playerName + "!");
						}
						else
						{
						JOptionPane.showMessageDialog(null, "Welcome back " + playerName + "!");
						}
						
					label2.setText("Welcome to Hangman, " + playerName);
						
					fileName = JOptionPane.showInputDialog("Enter the new size");
					
					server = new WordServer();
					
					try
					{
					Scanner fScan = new Scanner(new FileInputStream(fileName));
					
					server.loadWords(fScan);
					}
					catch(IOException x)
					{}
					
					button2.setText("End Player");
					button3.setEnabled(true);
					drawPanel.setVisible(false);
					f = new HangFigure(50,50,30);

					button1.setEnabled(false);
					
					}
				}
				
				if(e.getSource() == button2)
				{
					
					if(endGame == true)
					{
					if(JOptionPane.showConfirmDialog(null, "Really End Program " + playerName, "choose one", JOptionPane.YES_NO_OPTION) == 1)
						{
						endGame = false;
						}
						else
						{
						JOptionPane.showMessageDialog(null, "Saving Player List");
						try
						{
						StringBuffer print = new StringBuffer();
						for(int q = 0; q < players.size(); q++)
						{
						print.append(players.get(q).toStringFile());	
						}

						FileWriter fwriter = new FileWriter("players.txt", false);
								
						PrintWriter outputFile = new PrintWriter(fwriter);
											
						outputFile.print(print.toString());
						
						outputFile.close();
						}
						catch(IOException B)
						{}
						System.exit(0);
						}
					}
					else
					{
					if(JOptionPane.showConfirmDialog(null, "Really Quit " + playerName, "choose one", JOptionPane.YES_NO_OPTION) == 1)
					{

					}
					else
					{
					endGame = true;
					
					if(control == false)
					{
					if(userPlayed == -1)
					{
					players.get(output).lost();
					}
					else
					{
					players.get(userPlayed).lost();
					}
					}
					
					if(userPlayed == -1)
					{
					JOptionPane.showMessageDialog(null, players.get(output));
					}
					else
					{
					JOptionPane.showMessageDialog(null, players.get(userPlayed));
					}
					
					button3.setEnabled(false);
					theGuess.setEditable(false);
					button2.setText("End Game");
					button1.setEnabled(true);
					newWordPlayed = false;
					guessedWords.setLength(0);

					guessedLetters.setLength(0);
					
					label4.setText(guessedLetters.toString());
					
					gameControl = true;
					}
					}
				
				}
				
				if(e.getSource() == button3)
				{
				label2.setText("");
				label1.setText("Game in Progress");
				
				if(newWordPlayed == false)
				{
				word = server.getNextWord();

				guessedWords = new StringBuilder(word.length());

				guessedLetters = new StringBuilder();
				
				for(int k = 0; k < word.length(); k++)
				{
				guessedWords.append("?");
				}
				
				label3.setText(guessedWords.toString());
				}
				if(newWordPlayed == true)
				{
				
				
				if(JOptionPane.showConfirmDialog(null, "Would you like a new word?", "choose one", JOptionPane.YES_NO_OPTION) == 1)
				{
				}
				else
				{
				drawPanel.setVisible(false);
				f = new HangFigure(50,50,30);

				word = server.getNextWord();
				
				if(control == false)
				{
				if(userPlayed == -1)
				{
				players.get(output).lost();
				}
				else
				{
				players.get(userPlayed).lost();
				}
				}
				guessedWords.setLength(0);

				guessedLetters.setLength(0);
				label4.setText(guessedLetters.toString());

				for(int k = 0; k < word.length(); k++)
				{
				guessedWords.append("?");
				}
				
				label3.setText(guessedWords.toString());
				}
				}
				newWordPlayed = true;
				theGuess.setEditable(true);
				gameControl = true;

				if(word.equals(""))
				{
				label1.setText("No more words in the file");
				theGuess.setEditable(false);
				button3.setEnabled(false);
				}
				}
				}
			}
			
	}
	
	private class BottomPanelType extends JPanel
	{
		//panel for labels
		private JLabel gameStatus, gameInfo, currentWord, yourGuesses, currentGuess;
		private boolean guessedCorrect = false;
		
		public BottomPanelType()
		{
		setLayout(new GridLayout(5,2));
		gameStatus = new JLabel("Game Status:");
		gameInfo = new JLabel("Game Info:");
		currentWord = new JLabel("Current Word:");
		yourGuesses = new JLabel("Your Guesses:");
		currentGuess = new JLabel("Current Guess:");
		theGuess = new JTextField(20);
		
		label1 = new JLabel("Game Not Started");
		label2 = new JLabel("Welcome to the Hangman Game");
		label3 = new JLabel("");
		label4 = new JLabel("");
	
		
		theGuess.setEditable(false);
		gameStatus.setHorizontalAlignment(SwingConstants.CENTER);
		gameInfo.setHorizontalAlignment(SwingConstants.CENTER);
		currentWord.setHorizontalAlignment(SwingConstants.CENTER);
		yourGuesses.setHorizontalAlignment(SwingConstants.CENTER);
		currentGuess.setHorizontalAlignment(SwingConstants.CENTER);
		//Try flow layout

		gameStatus.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 15));
		gameInfo.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 15));
		currentWord.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 15));
		yourGuesses.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 15));
		currentGuess.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 15));

		
		gameListener middleListener = new gameListener();
		theGuess.addActionListener(middleListener);
		
		add(gameStatus);
		add(label1);

		add(gameInfo);
		add(label2);

		add(currentWord);
		add(label3);

		add(yourGuesses);		
		add(label4);

		add(currentGuess);
		add(theGuess);
		
		}
		
			private class gameListener implements ActionListener
			{
				private int guesses = 0;
				
				public void actionPerformed(ActionEvent e)
				{
				if(e.getSource() == theGuess)
					{
					if(gameControl == true)
					{
					guesses = 0;
					}
					gameControl = false;
					
					
					control = false;
					boolean guessedWord = false;
					boolean setIt = false;
					loop = theGuess.getText().charAt(0);
					boolean stop = false;
					for(int r = 0; r < guessedLetters.length(); r++)
						{
						if(loop == guessedLetters.charAt(r))
						{
						stop = true;
						label2.setText("Letter " + loop + " was already guessed");
						setIt = true;
						}
						}
					
					if(stop == false)
					{
					guessedLetters.append(loop);
					}
					
						for(int j = 0; j < word.length(); j++)
						{
							if((loop == (word.charAt(j))))
							{
							guessedWords.setCharAt(j, loop);
							guessedWord = true;
							int check = 0;
							check++;
							if(setIt == false)
							{
							label2.setText("Good Job!");
							}
							}
						}
							
							if(guessedWord == false)
							{
							if(setIt == false)
							{
							label2.setText("Letter " + loop + " was not found");
							}
							guesses++;
							if(stop == false)
							{
							f.addChunk();
							drawPanel.repaint();
							}
							}
							label3.setText(guessedWords.toString());
							theGuess.setText("");
							label4.setText(guessedLetters.toString());
							
							if(guessedWords.toString().equalsIgnoreCase(word))
							{
							theGuess.setEditable(false);
							label2.setText("Good Job, you completed the word");
							guesses = 0;
							if(userPlayed == -1)
							{
							players.get(output).won();
							}
							else
							{
							players.get(userPlayed).won();
							}
							control = true;
							}
							if(guesses == 7)
							{

							theGuess.setEditable(false);
							label2.setText("Sorry! See word below");
							label3.setText(word);
							guesses = 0;
							if(userPlayed == -1)
							{
							players.get(output).lost();
							}
							else
							{
							players.get(userPlayed).lost();
							}
							control = true;
							}
							drawPanel.setVisible(true);
							}
				}
				
			}
	}
	
	//Extra Credit Menu
	private void myMenu()
	{
	menuBar = new JMenuBar();
	fileMenu = new JMenu("Options");
	menuBar.add(fileMenu);
	showScores = new JMenuItem("Show Scores");
	quickExit = new JMenuItem("Quick Exit");
	menuListener thisListener = new menuListener();
	showScores.addActionListener(thisListener);
	quickExit.addActionListener(thisListener);
	fileMenu.add(showScores);
	fileMenu.add(quickExit);
	theWindow.setJMenuBar(menuBar);
	}
		
	
		private class menuListener implements ActionListener
		{
		
			public void actionPerformed(ActionEvent e)
			{
			if(e.getSource() == quickExit)
			{
			System.exit(0);
			}
			else
			{
			if(userPlayed == -1)
				{
				JOptionPane.showMessageDialog(null, players.get(output));
				}
				else
				{
				JOptionPane.showMessageDialog(null, players.get(userPlayed));
				}
			}
			
			
			}
			
		}	

	
	
	
	public static void main(String[] args)
	{
	new Assig4();
	}
	//Loading Data
	private ArrayList<HangPlayer> loadData()throws IOException
	{
	ArrayList<HangPlayer> players = new ArrayList<HangPlayer>();
	
	File textFile = new File("players.txt");
			
	Scanner newFile = new Scanner(textFile);
	
	do
	{
	String j = newFile.next();
	int i = newFile.nextInt();
	int k = newFile.nextInt();
	
	HangPlayer newPlayer = new HangPlayer(j);
	newPlayer.wins(i);
	newPlayer.losses(k);
	int l = 0;
	
	players.add(l, newPlayer);
	l++;
	}while(newFile.hasNext());
	newFile.close();
	return players;
	}
}
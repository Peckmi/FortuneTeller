import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private JLabel titleLabel;
    private JTextArea fortuneArea;
    private JButton readButton;
    private JButton quitButton;
    private ArrayList<String> fortunes;
    private int lastFortuneIndex = -1;

    public FortuneTellerFrame() {
        super("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setResizable(false);
        setLocationRelativeTo(null);

        fortunes = new ArrayList<>();
        fortunes.add("You will find happiness.");
        fortunes.add("You will win the lottery soon.");
        fortunes.add("You will get promoted next week.");
        fortunes.add("You will take action in life.");
        fortunes.add("You will depart on a new adventure.");
        fortunes.add("You will no longer endure hardships.");
        fortunes.add("You will have a mediocre day");
        fortunes.add("You will find your soulmate soon.");
        fortunes.add("You will get free food this friday.");
        fortunes.add("You will eventually succeed in completing your goals.");
        fortunes.add("You will inevitably not succeed with your current mindset; Seek change.");
        fortunes.add("You will eventually grow.");

        titleLabel = new JLabel("Fortune Teller", JLabel.CENTER);
        titleLabel.setFont(new Font("Sans-serif", Font.BOLD, 48));
        ImageIcon icon = new ImageIcon("FortuneTeller.png");
        titleLabel.setIcon(icon);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);

        fortuneArea = new JTextArea();
        fortuneArea.setEditable(false);
        fortuneArea.setFont(new Font("Sans-serif", Font.PLAIN, 24));

        JScrollPane scrollPane = new JScrollPane(fortuneArea);

        readButton = new JButton("Read My Fortune!");
        readButton.setFont(new Font("Sans-serif", Font.BOLD, 24));
        readButton.addActionListener((ActionEvent e) -> {
            String fortune = getRandomFortune();
            fortuneArea.append(fortune + "\n");
        });

        quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Sans-serif", Font.BOLD, 24));
        quitButton.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        add(titleLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(readButton);
        buttonPanel.add(quitButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private String getRandomFortune() {
        int index = lastFortuneIndex;
        while (index == lastFortuneIndex) {
            index = new Random().nextInt(fortunes.size());
        }
        lastFortuneIndex = index;
        return fortunes.get(index);
    }
}
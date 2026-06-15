import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
    private JTextArea morseArea;
    private JTextArea resultArea;
    private JLabel statusLabel;

    private long pressStartTime = 0;
    private final int DOT_DASH_STANDARD = 300;

    private MorseTranslator translator = new MorseTranslator();

    public Main() {
        setTitle("스페이스 모스부호 번역기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(720, 500);
        setLocationRelativeTo(null);

        createMenu();

        Container c = getContentPane();
        c.setLayout(new BorderLayout(10, 10));

        JLabel guideLabel = new JLabel("입력 시작 버튼을 누른 뒤 스페이스바를 사용하세요. 짧게: 점(.) / 길게: 선(-)");
        guideLabel.setHorizontalAlignment(SwingConstants.CENTER);

        statusLabel = new JLabel("입력 시작 버튼을 눌러 주세요.");
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        topPanel.add(guideLabel);
        topPanel.add(statusLabel);

        morseArea = new JTextArea();
        morseArea.setFont(new Font("Monospaced", Font.BOLD, 28));
        morseArea.setEditable(false);
        morseArea.setLineWrap(true);

        resultArea = new JTextArea();
        resultArea.setFont(new Font("Dialog", Font.BOLD, 28));
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);

        JPanel morsePanel = new JPanel(new BorderLayout());
        morsePanel.setBorder(BorderFactory.createTitledBorder("입력된 모스부호"));
        morsePanel.add(new JScrollPane(morseArea), BorderLayout.CENTER);

        JPanel resultPanel = new JPanel(new BorderLayout());
        resultPanel.setBorder(BorderFactory.createTitledBorder("변환 결과"));
        resultPanel.add(new JScrollPane(resultArea), BorderLayout.CENTER);

        JPanel centerPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        centerPanel.add(morsePanel);
        centerPanel.add(resultPanel);

        JButton startButton = new JButton("입력 시작");
        JButton nextLetterButton = new JButton("다음 글자");
        JButton convertButton = new JButton("변환");
        JButton readButton = new JButton("읽기 효과");
        JButton deleteButton = new JButton("하나 지우기");
        JButton clearButton = new JButton("초기화");

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                morseArea.requestFocus();
                statusLabel.setText("입력 가능 상태입니다. 스페이스바를 눌러 주세요.");
            }
        });

        nextLetterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addNextLetter();
                morseArea.requestFocus();
            }
        });

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertMorse();
                morseArea.requestFocus();
            }
        });

        readButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showReadingEffect();
                morseArea.requestFocus();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteOne();
                morseArea.requestFocus();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearAll();
                morseArea.requestFocus();
            }
        });

        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 8, 8));
        buttonPanel.add(startButton);
        buttonPanel.add(nextLetterButton);
        buttonPanel.add(convertButton);
        buttonPanel.add(readButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);

        c.add(topPanel, BorderLayout.NORTH);
        c.add(centerPanel, BorderLayout.CENTER);
        c.add(buttonPanel, BorderLayout.SOUTH);

        setKeyInput();

        setVisible(true);
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem clearItem = new JMenuItem("Clear");
        JMenuItem exitItem = new JMenuItem("Exit");

        clearItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearAll();
            }
        });

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        fileMenu.add(clearItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        JMenu helpMenu = new JMenu("Help");
        JMenuItem tableItem = new JMenuItem("모스부호표");
        JMenuItem useItem = new JMenuItem("사용 방법");

        tableItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showMorseTableText();
            }
        });

        useItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showHowToUse();
            }
        });

        helpMenu.add(tableItem);
        helpMenu.add(useItem);

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);
    }

    private void setKeyInput() {
        morseArea.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE && pressStartTime == 0) {
                    pressStartTime = System.currentTimeMillis();
                    statusLabel.setText("스페이스바 입력 중...");
                }
            }

            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    long pressTime = System.currentTimeMillis() - pressStartTime;

                    if (pressTime < DOT_DASH_STANDARD) {
                        morseArea.append(".");
                        statusLabel.setText("점(.) 입력 - " + pressTime + "ms");
                    } else {
                        morseArea.append("-");
                        statusLabel.setText("선(-) 입력 - " + pressTime + "ms");
                    }

                    pressStartTime = 0;
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    addNextLetter();
                }
            }
        });
    }

    private void addNextLetter() {
        if (!morseArea.getText().endsWith(" ")) {
            morseArea.append(" ");
        }
        statusLabel.setText("다음 글자를 입력하세요.");
    }

    private void convertMorse() {
        String morse = morseArea.getText().trim();
        String result = translator.translateSentence(morse);
        resultArea.setText(result);
        statusLabel.setText("변환 완료");
    }

    private void showReadingEffect() {
        if (resultArea.getText().trim().length() == 0) {
            convertMorse();
        }

        final String text = resultArea.getText().trim();

        if (text.length() == 0) {
            statusLabel.setText("읽을 문장이 없습니다.");
            return;
        }

        Thread t = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < text.length(); i++) {
                    statusLabel.setText("읽는 중: " + text.charAt(i));
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        statusLabel.setText("읽기 효과 중단");
                    }
                }
                statusLabel.setText("읽기 효과 완료: " + text);
            }
        });

        t.start();
    }

    private void deleteOne() {
        String text = morseArea.getText();
        if (text.length() > 0) {
            morseArea.setText(text.substring(0, text.length() - 1));
            statusLabel.setText("마지막 입력 삭제");
        }
    }

    private void clearAll() {
        if (morseArea != null) morseArea.setText("");
        if (resultArea != null) resultArea.setText("");
        if (statusLabel != null) statusLabel.setText("초기화 완료");
    }

    private void showMorseTableText() {
        JTextArea tableArea = new JTextArea();
        tableArea.setEditable(false);
        tableArea.setFont(new Font("Monospaced", Font.PLAIN, 16));

        tableArea.setText(
                "A .-      B -...    C -.-.    D -..     E .\n"
              + "F ..-.    G --.     H ....    I ..      J .---\n"
              + "K -.-     L .-..    M --      N -.      O ---\n"
              + "P .--.    Q --.-    R .-.     S ...     T -\n"
              + "U ..-     V ...-    W .--     X -..-    Y -.--\n"
              + "Z --..\n\n"
              + "1 .----   2 ..---   3 ...--   4 ....-   5 .....\n"
              + "6 -....   7 --...   8 ---..   9 ----.   0 -----"
        );

        JFrame tableFrame = new JFrame("모스부호표");
        tableFrame.setSize(600, 350);
        tableFrame.setLocationRelativeTo(this);
        tableFrame.add(new JScrollPane(tableArea));
        tableFrame.setVisible(true);
    }

    private void showHowToUse() {
        JOptionPane.showMessageDialog(
                this,
                "1. 입력 시작 버튼을 누릅니다.\n"
                        + "2. 스페이스바를 짧게 누르면 점(.)입니다.\n"
                        + "3. 스페이스바를 길게 누르면 선(-)입니다.\n"
                        + "4. 다음 글자 버튼 또는 Enter 키로 글자를 구분합니다.\n"
                        + "5. 변환 버튼을 누르면 알파벳으로 변환됩니다.\n"
                        + "6. 읽기 효과 버튼을 누르면 글자가 순서대로 표시됩니다.",
                "사용 방법",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void main(String[] args) {
        new Main();
    }
}

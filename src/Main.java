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

        JLabel guideLabel = new JLabel("입력 시작     private JTextArea morseArea;\n" +
                "    private JTextArea resultArea;\n" +
                "    private JLabel statusLabel;\n" +
                "\n" +
                "    private long pressStartTime = 0;\n" +
                "    private final int DOT_DASH_STANDARD = 300;\n" +
                "\n" +
                "    private MorseTranslator translator = new MorseTranslator();\n" +
                "\n" +
                "    public Main() {\n" +
                "        setTitle(\"스페이스바 기반 모스부호 번역기\");\n" +
                "        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);\n" +
                "        setSize(720, 500);\n" +
                "        setLocationRelativeTo(null);\n" +
                "\n" +
                "        createMenu();\n" +
                "\n" +
                "        Container c = getContentPane();\n" +
                "        c.setLayout(new BorderLayout(10, 10));\n" +
                "\n" +
                "        JLabel guideLabel = new JLabel(\"입력 시작 버튼을 누른 뒤 스페이스바를 사용하세요. 짧게: 점(.) / 길게: 선(-)\");\n" +
                "        guideLabel.setHorizontalAlignment(SwingConstants.CENTER);\n" +
                "\n" +
                "        statusLabel = new JLabel(\"입력 시작 버튼을 눌러 주세요.\");\n" +
                "        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);\n" +
                "\n" +
                "        JPanel topPanel = new JPanel(new GridLayout(2, 1));\n" +
                "        topPanel.add(guideLabel);\n" +
                "        topPanel.add(statusLabel);\n" +
                "\n" +
                "        morseArea = new JTextArea();\n" +
                "        morseArea.setFont(new Font(\"Monospaced\", Font.BOLD, 28));\n" +
                "        morseArea.setEditable(false);\n" +
                "        morseArea.setLineWrap(true);\n" +
                "\n" +
                "        resultArea = new JTextArea();\n" +
                "        resultArea.setFont(new Font(\"Dialog\", Font.BOLD, 28));\n" +
                "        resultArea.setEditable(false);\n" +
                "        resultArea.setLineWrap(true);\n" +
                "\n" +
                "        JPanel morsePanel = new JPanel(new BorderLayout());\n" +
                "        morsePanel.setBorder(BorderFactory.createTitledBorder(\"입력된 모스부호\"));\n" +
                "        morsePanel.add(new JScrollPane(morseArea), BorderLayout.CENTER);\n" +
                "\n" +
                "        JPanel resultPanel = new JPanel(new BorderLayout());\n" +
                "        resultPanel.setBorder(BorderFactory.createTitledBorder(\"변환 결과\"));\n" +
                "        resultPanel.add(new JScrollPane(resultArea), BorderLayout.CENTER);\n" +
                "\n" +
                "        JPanel centerPanel = new JPanel(new GridLayout(2, 1, 10, 10));\n" +
                "        centerPanel.add(morsePanel);\n" +
                "        centerPanel.add(resultPanel);\n" +
                "\n" +
                "        JButton startButton = new JButton(\"입력 시작\");\n" +
                "        JButton nextLetterButton = new JButton(\"다음 글자\");\n" +
                "        JButton convertButton = new JButton(\"변환\");\n" +
                "        JButton readButton = new JButton(\"읽기 효과\");\n" +
                "        JButton deleteButton = new JButton(\"하나 지우기\");\n" +
                "        JButton clearButton = new JButton(\"초기화\");\n" +
                "\n" +
                "        startButton.addActionListener(new ActionListener() {\n" +
                "            public void actionPerformed(ActionEvent e) {\n" +
                "                morseArea.requestFocus();\n" +
                "                statusLabel.setText(\"입력 가능 상태입니다. 스페이스바를 눌러 주세요.\");\n" +
                "            }\n" +
                "        });\n" +
                "\n" +
                "        nextLetterButton.addActionListener(new ActionListener() {\n" +
                "            public void actionPerformed(ActionEvent e) {\n" +
                "                addNextLetter();\n" +
                "                morseArea.requestFocus();\n" +
                "            }\n" +
                "        });\n" +
                "\n" +
                "        convertButton.addActionListener(new ActionListener() {\n" +
                "            public void actionPerformed(ActionEvent e) {\n" +
                "                convertMorse();\n" +
                "                morseArea.requestFocus();\n" +
                "            }\n" +
                "        });\n" +
                "\n" +
                "        readButton.addActionListener(new ActionListener() {\n" +
                "            public void actionPerformed(ActionEvent e) {\n" +
                "                showReadingEffect();\n" +
                "                morseArea.requestFocus();\n" +
                "            }\n" +
                "        });\n" +
                "\n" +
                "        deleteButton.addActionListener(new ActionListener() {\n" +
                "            public void actionPerformed(ActionEvent e) {\n" +
                "                deleteOne();\n" +
                "                morseArea.requestFocus();\n" +
                "            }\n" +
                "        });\n" +
                "\n" +
                "        clearButton.addActionListener(new ActionListener() {\n" +
                "            public void actionPerformed(ActionEvent e) {\n" +
                "                clearAll();\n" +
                "                morseArea.requestFocus();\n" +
                "            }\n" +
                "        });\n" +
                "\n" +
                "        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 8, 8));\n" +
                "        buttonPanel.add(startButton);\n" +
                "        buttonPanel.add(nextLetterButton);\n" +
                "        buttonPanel.add(convertButton);\n" +
                "        buttonPanel.add(readButton);\n" +
                "        buttonPanel.add(deleteButton);\n" +
                "        buttonPanel.add(clearButton);\n" +
                "\n" +
                "        c.add(topPanel, BorderLayout.NORTH);\n" +
                "        c.add(centerPanel, BorderLayout.CENTER);\n" +
                "        c.add(buttonPanel, BorderLayout.SOUTH);\n" +
                "\n" +
                "        setKeyInput();\n" +
                "\n" +
                "        setVisible(true);\n" +
                "    }\n" +
                "\n" +
                "    private void createMenu() {\n" +
                "        JMenuBar menuBar = new JMenuBar();\n" +
                "\n" +
                "        JMenu fileMenu = new JMenu(\"File\");\n" +
                "        JMenuItem clearItem = new JMenuItem(\"Clear\");\n" +
                "        JMenuItem exitItem = new JMenuItem(\"Exit\");\n" +
                "\n" +
                "        clearItem.addActionListener(new ActionListener() {\n" +
                "            public void actionPerformed(ActionEvent e) {\n" +
                "                clearAll();\n" +
                "            }\n" +
                "        });\n" +
                "\n" +
                "        exitItem.addActionListener(new ActionListener() {\n" +
                "            public void actionPerformed(ActionEvent e) {\n" +
                "                System.exit(0);\n" +
                "            }\n" +
                "        });\n" +
                "\n" +
                "        fileMenu.add(clearItem);\n" +
                "        fileMenu.addSeparator();\n" +
                "        fileMenu.add(exitItem);\n" +
                "\n" +
                "        JMenu helpMenu = new JMenu(\"Help\");\n" +
                "        JMenuItem tableItem = new JMenuItem(\"모스부호표\");\n" +
                "        JMenuItem useItem = new JMenuItem(\"사용 방법\");\n" +
                "\n" +
                "        tableItem.addActionListener(new ActionListener() {\n" +
                "            public void actionPerformed(ActionEvent e) {\n" +
                "                showMorseTableText();\n" +
                "            }\n" +
                "        });\n" +
                "\n" +
                "        useItem.addActionListener(new ActionListener() {\n" +
                "            public void actionPerformed(ActionEvent e) {\n" +
                "                showHowToUse();\n" +
                "            }\n" +
                "        });\n" +
                "\n" +
                "        helpMenu.add(tableItem);\n" +
                "        helpMenu.add(useItem);\n" +
                "\n" +
                "        menuBar.add(fileMenu);\n" +
                "        menuBar.add(helpMenu);\n" +
                "\n" +
                "        setJMenuBar(menuBar);\n" +
                "    }\n" +
                "\n" +
                "    private void setKeyInput() {\n" +
                "        morseArea.addKeyListener(new KeyAdapter() {\n" +
                "            public void keyPressed(KeyEvent e) {\n" +
                "                if (e.getKeyCode() == KeyEvent.VK_SPACE && pressStartTime == 0) {\n" +
                "                    pressStartTime = System.currentTimeMillis();\n" +
                "                    statusLabel.setText(\"스페이스바 입력 중...\");\n" +
                "                }\n" +
                "            }\n" +
                "\n" +
                "            public void keyReleased(KeyEvent e) {\n" +
                "                if (e.getKeyCode() == KeyEvent.VK_SPACE) {\n" +
                "                    long pressTime = System.currentTimeMillis() - pressStartTime;\n" +
                "\n" +
                "                    if (pressTime < DOT_DASH_STANDARD) {\n" +
                "                        morseArea.append(\".\");\n" +
                "                        statusLabel.setText(\"점(.) 입력 - \" + pressTime + \"ms\");\n" +
                "                    } else {\n" +
                "                        morseArea.append(\"-\");\n" +
                "                        statusLabel.setText(\"선(-) 입력 - \" + pressTime + \"ms\");\n" +
                "                    }\n" +
                "\n" +
                "                    pressStartTime = 0;\n" +
                "                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {\n" +
                "                    addNextLetter();\n" +
                "                }\n" +
                "            }\n" +
                "        });\n" +
                "    }\n" +
                "\n" +
                "    private void addNextLetter() {\n" +
                "        if (!morseArea.getText().endsWith(\" \")) {\n" +
                "            morseArea.append(\" \");\n" +
                "        }\n" +
                "        statusLabel.setText(\"다음 글자를 입력하세요.\");\n" +
                "    }\n" +
                "\n" +
                "    private void convertMorse() {\n" +
                "        String morse = morseArea.getText().trim();\n" +
                "        String result = translator.translateSentence(morse);\n" +
                "        resultArea.setText(result);\n" +
                "        statusLabel.setText(\"변환 완료\");\n" +
                "    }\n" +
                "\n" +
                "    private void showReadingEffect() {\n" +
                "        if (resultArea.getText().trim().length() == 0) {\n" +
                "            convertMorse();\n" +
                "        }\n" +
                "\n" +
                "        final String text = resultArea.getText().trim();\n" +
                "\n" +
                "        if (text.length() == 0) {\n" +
                "            statusLabel.setText(\"읽을 문장이 없습니다.\");\n" +
                "            return;\n" +
                "        }\n" +
                "\n" +
                "        Thread t = new Thread(new Runnable() {\n" +
                "            public void run() {\n" +
                "                for (int i = 0; i < text.length(); i++) {\n" +
                "                    statusLabel.setText(\"읽는 중: \" + text.charAt(i));\n" +
                "                    try {\n" +
                "                        Thread.sleep(500);\n" +
                "                    } catch (InterruptedException e) {\n" +
                "                        statusLabel.setText(\"읽기 효과 중단\");\n" +
                "                    }\n" +
                "                }\n" +
                "                statusLabel.setText(\"읽기 효과 완료: \" + text);\n" +
                "            }\n" +
                "        });\n" +
                "\n" +
                "        t.start();\n" +
                "    }\n" +
                "\n" +
                "    private void deleteOne() {\n" +
                "        String text = morseArea.getText();\n" +
                "        if (text.length() > 0) {\n" +
                "            morseArea.setText(text.substring(0, text.length() - 1));\n" +
                "            statusLabel.setText(\"마지막 입력 삭제\");\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    private void clearAll() {\n" +
                "        if (morseArea != null) morseArea.setText(\"\");\n" +
                "        if (resultArea != null) resultArea.setText(\"\");\n" +
                "        if (statusLabel != null) statusLabel.setText(\"초기화 완료\");\n" +
                "    }\n" +
                "\n" +
                "    private void showMorseTableText() {\n" +
                "        JTextArea tableArea = new JTextArea();\n" +
                "        tableArea.setEditable(false);\n" +
                "        tableArea.setFont(new Font(\"Monospaced\", Font.PLAIN, 16));\n" +
                "\n" +
                "        tableArea.setText(\n" +
                "                \"A .-      B -...    C -.-.    D -..     E .\\n\"\n" +
                "              + \"F ..-.    G --.     H ....    I ..      J .---\\n\"\n" +
                "              + \"K -.-     L .-..    M --      N -.      O ---\\n\"\n" +
                "              + \"P .--.    Q --.-    R .-.     S ...     T -\\n\"\n" +
                "              + \"U ..-     V ...-    W .--     X -..-    Y -.--\\n\"\n" +
                "              + \"Z --..\\n\\n\"\n" +
                "              + \"1 .----   2 ..---   3 ...--   4 ....-   5 .....\\n\"\n" +
                "              + \"6 -....   7 --...   8 ---..   9 ----.   0 -----\"\n" +
                "        );\n" +
                "\n" +
                "        JFrame tableFrame = new JFrame(\"모스부호표\");\n" +
                "        tableFrame.setSize(600, 350);\n" +
                "        tableFrame.setLocationRelativeTo(this);\n" +
                "        tableFrame.add(new JScrollPane(tableArea));\n" +
                "        tableFrame.setVisible(true);\n" +
                "    }\n" +
                "\n" +
                "    private void showHowToUse() {\n" +
                "        JOptionPane.showMessageDialog(\n" +
                "                this,\n" +
                "                \"1. 입력 시작 버튼을 누릅니다.\\n\"\n" +
                "                        + \"2. 스페이스바를 짧게 누르면 점(.)입니다.\\n\"\n" +
                "                        + \"3. 스페이스바를 길게 누르면 선(-)입니다.\\n\"\n" +
                "                        + \"4. 다음 글자 버튼 또는 Enter 키로 글자를 구분합니다.\\n\"\n" +
                "                        + \"5. 변환 버튼을 누르면 알파벳으로 변환됩니다.\\n\"\n" +
                "                        + \"6. 읽기 효과 버튼을 누르면 글자가 순서대로 표시됩니다.\",\n" +
                "                \"사용 방법\",\n" +
                "                JOptionPane.INFORMATION_MESSAGE\n" +
                "        );\n" +
                "    }\n" +
                "\n" +
                "    public static void main(String[] args) {\n" +
                "        new Main();\n" +
                "    }\n버튼을 누른 뒤 스페이스바를 사용하세요. 짧게: 점(.) / 길게: 선(-)");
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

# morse_code(모스부호_번역기)

## 프로젝트 소개

이번 자바 프로그래밍 기말 프로젝트에서는 Java Swing을 이용하여 모스부호 번역기를 제작하였다.

프로젝트 주제를 고민하던 중 키보드의 스페이스바를 이용하여 모스부호를 입력하면 재미있을 것 같다는 생각이 들어 이 주제를 선택하게 되었다.

사용자는 스페이스바를 짧게 누르거나 길게 눌러 점(.)과 선(-)을 입력할 수 있으며, 입력된 모스부호를 알파벳과 숫자로 변환할 수 있다.

## 프로젝트 목표

이번 프로젝트를 통해 다음 내용을 직접 구현해 보는 것을 목표로 하였다.

\- Java Swing GUI 구성<br>
\- 버튼 이벤트 처리<br>
\- KeyListener를 이용한 키보드 입력 처리<br>
\- HashMap을 이용한 데이터 변환<br>
\- Thread 활용<br>
\- 수업에서 배운 내용 응용

## 사용한 수업 내용

### 11장 Swing 컴포넌트

프로그램 화면을 만들기 위해 다음 컴포넌트를 사용하였다.

\- JFrame<br>
\- JPanel<br>
\- JLabel<br>
\- JButton<br>
\- JTextArea<br>
\- JScrollPane

또한 BorderLayout과 GridLayout을 이용하여 화면을 배치하였다.
프로그램의 입력 영역, 결과 출력 영역, 버튼 영역을 각각 구분하여 사용자 인터페이스를 구성하였다.

### 13장 Thread

변환된 결과를 한 글자씩 순차적으로 보여주는 읽기 효과 기능을 구현하기 위해 Thread를 사용하였다.
Thread를 사용함으로써 프로그램이 멈추지 않고 동작할 수 있도록 구현하였다.

### 14장 메뉴와 Action 이벤트

프로그램 상단 메뉴를 만들기 위해 다음 내용을 사용하였다.

\- JMenuBar<br>
\- JMenu<br>
\- JMenuItem<br>
\- ActionListener

또한 버튼 클릭 이벤트와 메뉴 이벤트를 처리하기 위해 ActionListener를 활용하였다.

### 이벤트 처리 응용

프로젝트의 핵심 기능인 모스부호 입력은 이벤트 처리 개념을 응용하여 구현하였다.
KeyListener를 사용하여 사용자가 스페이스바를 누르는 순간과 떼는 순간을 감지하였고, 이를 통해 입력 패턴을 분석하여 점(.)과 선(-)을 구분하도록 구현하였다.
수업에서 배운 이벤트 처리 개념을 실제 프로그램 기능에 적용해 볼 수 있었다.

## 주요 기능

### 1. 스페이스바 입력

스페이스바를 이용하여 모스부호를 입력할 수 있다.

\- 짧게 누름: 점(.)<br>
\- 길게 누름: 선(-)

KeyListener를 이용하여 입력을 처리하였다.

### 2. 모스부호 변환

HashMap을 이용하여 모스부호를 문자로 변환하였다.

예시:

.-    -> A<br>
-...  -> B<br>
...   -> S<br>
---   -> O

입력된 모스부호를 분석하여 문자열로 변환한다.

### 3. 버튼 기능

프로그램에는 다음 버튼을 구현하였다.

\- 입력 시작<br>
\- 다음 글자<br>
\- 변환<br>
\- 읽기 효과<br>
\- 하나 지우기<br>
\- 초기화

각 버튼은 ActionListener를 이용하여 동작하도록 구현하였다.

### 4. 메뉴 기능

Help 메뉴를 이용하여 다음 기능을 구현하였다.

\- 모스부호표 보기<br>
\- 사용 방법 보기

### 5. 읽기 효과

Thread를 이용하여 변환된 문장을 한 글자씩 순차적으로 표시하도록 구현하였다.

## 실행 예시

### SOS

입력:

... --- ...

결과:

SOS

### HELLO

입력:

.... . .-.. .-.. ---

결과:

HELLO

## 구현하면서 어려웠던 점

처음에는 버튼만 만들면 쉽게 완성될 것이라고 생각했지만 실제로 구현해 보니 생각보다 어려운 부분이 많았다.

가장 어려웠던 부분은 모스부호 입력 기능이었다. 모스부호는 점(.)과 선(-)을 구분해야 하기 때문에 사용자의 입력을 어떤 방식으로 처리할지 고민하였다.

강의자료에서 배운 이벤트 처리 개념을 바탕으로 KeyListener를 활용하여 키보드 입력을 감지하도록 구현하였다.
특히 keyPressed와 keyReleased 이벤트가 각각 언제 발생하는지 이해하는 과정이 어려웠지만, 여러 번 테스트하면서 입력 과정을 구현할 수 있었다.

또한 버튼을 클릭한 이후 키보드 입력이 동작하지 않는 문제가 발생하기도 하였는데, 입력 영역의 포커스가 이동한다는 점을 알게 되었고 이를 수정하면서 Swing 이벤트 처리 방식에 대해 더 이해할 수 있었다.

HashMap을 이용한 모스부호 변환 역시 처음에는 조건문을 여러 개 사용하는 방식을 생각했지만, HashMap을 활용하면 보다 간단하게 구현할 수 있다는 점을 알게 되었다.

## 추가적으로 학습한 내용

이번 프로젝트는 강의자료에서 학습한 Swing 컴포넌트, Action 이벤트, Thread를 중심으로 구현하였다.

다만 프로젝트의 핵심 기능인 모스부호 입력을 구현하기 위해서는 강의자료에 포함되지 않은 일부 Java 기능에 대한 추가 학습이 필요하였다.
특히 다음 내용을 추가적으로 학습하여 프로젝트에 적용하였다.

\- KeyListener를 이용한 키보드 입력 처리<br>
\- KeyAdapter를 이용한 이벤트 구현<br>
\- KeyEvent를 이용한 특정 키 입력 감지<br>
\- requestFocus()를 이용한 입력 포커스 제어<br>
\- System.currentTimeMillis()를 이용한 이벤트 시점 확인

이러한 기능들은 Java 기본 라이브러리에서 제공하는 기능이며, 강의시간에 배운 이벤트 처리 개념을 실제 프로그램에 적용하는 과정에서 학습하게 되었다.

처음에는 버튼 이벤트 처리만 이해하고 있었지만 프로젝트를 진행하면서 키보드 입력 이벤트와 포커스 개념도 함께 공부할 수 있었고, 이를 통해 사용자 입력을 처리하는 프로그램의 동작 방식을 더 깊이 이해할 수 있었다.

## AI(LLM) 활용 내용

프로젝트는 강의자료를 중심으로 진행하였다.
하지만 강의자료만 읽고 바로 구현하기에는 어려운 부분이 있었기 때문에 ChatGPT를 참고하여 공부하였다.

특히 다음과 같은 내용을 질문하였다.

\- KeyListener는 어떻게 동작하는가?<br>
\- keyPressed와 keyReleased의 차이는 무엇인가?<br>
\- 스페이스바 입력은 어떤 방식으로 처리하는가?<br>
\- HashMap은 어떤 방식으로 사용하는가?<br>
\- ActionListener는 어떻게 연결하는가?<br>
\- Thread는 언제 사용하는가?<br>
\- Swing 화면은 어떻게 구성하는가?

ChatGPT를 통해 개념 설명과 간단한 예제를 참고하였고, 이를 바탕으로 직접 코드를 작성하고 수정하면서 프로젝트를 진행하였다.

처음에는 Swing 화면 구성도 익숙하지 않아 JLabel, JPanel, JTextArea의 배치 방법이나 사용자 안내 문구 작성 방법 등을 질문하며 학습하였다.
또한 프로젝트 진행 과정에서 발생한 오류와 구현상의 어려움을 해결하기 위해 ChatGPT를 활용하였으며, 최종적으로 프로그램의 기능 구성, 클래스 설계, 코드 작성, 테스트 과정은 직접 수행하였다.

ChatGPT는 프로젝트를 대신 작성하는 용도가 아니라 이해가 부족한 부분을 보완하기 위한 학습 도구로 활용하였다.

## 느낀 점

이번 프로젝트를 진행하면서 수업 시간에 배운 내용들이 실제 프로그램에서 어떻게 사용되는지 경험할 수 있었다.

특히 ActionListener, KeyListener, HashMap, Thread와 같은 내용을 직접 사용해 보면서 강의에서 배운 개념을 더 잘 이해할 수 있었다.

처음에는 어려웠던 부분도 많았지만 직접 오류를 수정하고 기능을 구현하면서 프로그래밍 실력이 조금 향상된 것 같다고 느꼈다.

또한 강의자료만으로 이해하기 어려운 부분은 ChatGPT를 활용하여 추가적으로 학습하면서 문제를 해결할 수 있었고, 이를 통해 새로운 내용을 스스로 학습하는 방법도 경험할 수 있었다.

기회가 된다면 이후에는 실제 음성 출력 기능이나 한글 변환 기능도 추가해 보고 싶다.

## 개발 환경

\- Java(v.25)<br>
\- IntelliJ IDEA<br>
\- Java Swing<br>

## 참고 자료

\- 자바 프로그래밍 강의자료 11장 Swing 컴포넌트<br>
\- 자바 프로그래밍 강의자료 13장 Thread<br>
\- 자바 프로그래밍 강의자료 14장 메뉴와 Action 이벤트<br>
\- 국제 모스부호 표<br>
\- ChatGPT(개념 학습 및 오류 해결 참고)<br>
\- GitHub 오픈소스 모스부호 번역기 예제(기능 구성 아이디어 참고): [https://github.com/SeunMatt/morsecodetranslator](https://github.com/SeunMatt/morsecodetranslator)<br>
\- GitHub Java Swing 모스부호 번역기 예제(Swing 화면 구성 방식 참고): [https://github.com/hariperisetla/Morsify](https://github.com/hariperisetla/Morsify)<br>
\- GitHub Java 모스부호 변환 예제(모스부호 변환 자료구조 참고): [https://github.com/nimshafernando/Morse-Code-Translator-with-Binary-Tree](https://github.com/nimshafernando/Morse-Code-Translator-with-Binary-Tree)<br>

---

# morse_code(Morse_Code_Translator)

## Project Introduction

For this Java Programming final project, I created a Morse code translator using Java Swing.

While considering project topics, I thought it would be interesting to input Morse code using the keyboard's spacebar, so I chose this topic.

Users can input dots (.) and dashes (-) by pressing the spacebar briefly or holding it down, and the input Morse code can be converted into alphabets and numbers.

## Project Goals

Through this project, the goal was to directly implement the following:

\- Java Swing GUI configuration<br>
\- Button event handling<br>
\- Keyboard input processing using KeyListener<br>
\- Data conversion using HashMap<br>
\- Thread utilization<br>
\- Application of concepts learned in class

## Class Content Used

### Chapter 11 Swing Components

The following components were used to create the program screen.

\- JFrame<br>
\- JPanel<br>
\- JLabel<br>
\- JButton<br>
\- JTextArea<br>
\- JScrollPane

Additionally, the screen layout was arranged using BorderLayout and GridLayout.
The user interface was constructed by separating the program's input area, result output area, and button area.

### Chapter 13 Thread

Threads were used to implement a reading effect function that displays the converted results one character at a time sequentially.
By using threads, the implementation was designed to ensure the program operates without freezing.

### Chapter 14 Menu and Action Events

The following was used to create the program's top menu.

\- JMenuBar<br>
\- JMenu<br>
\- JMenuItem<br>
\- ActionListener

Additionally, ActionListeners were utilized to handle button click events and menu events.

### Application of Event Handling

The core function of the project, Morse code input, was implemented by applying the concept of event handling.
Using a KeyListener, the moment the user presses and releases the spacebar was detected, and through this, the input pattern was analyzed to distinguish between the dot (.) and the dash (-).
I was able to apply the event handling concepts learned in class to actual program functions.

## Main Functions

### 1. Spacebar Input

Morse code can be entered using the spacebar.

\- Short press: Dot (.)<br>
\- Long press: Dash (-)

Input was processed using a KeyListener.

### 2. Morse Code Conversion

Morse code was converted into characters using a HashMap.

Example:

.-    -> A<br>
-...  -> B<br>
...   -> S<br>
---   -> O

The input Morse code is analyzed and converted into a string.

### 3. Button Function

The program implements the following buttons.

\- Start Input<br>
\- Next Character<br>
\- Convert<br>
\- Read Effect<br>
\- Clear One<br>
\- Reset

Each button is implemented to operate using an ActionListener.

### 4. Menu Function

The following functions are implemented using the Help menu.

\- View Morse Code Table<br>
\- View Usage Instructions

### 5. Read Effect

The program is implemented to display the converted sentence one character at a time sequentially using a Thread.

## Execution Example

### SOS

Input:

... --- ...

Result:

SOS

### HELLO

Input:

.... . .-.. .-.. ---

Result:

HELLO

## Difficulties Encountered During Implementation

Initially, I thought the project would be easily completed simply by creating buttons, but upon actual implementation, I found there were more difficult parts than I had anticipated.

The most challenging aspect was the Morse code input function. Since Morse code requires distinguishing between dots (.) and dashes (-), I spent time considering how to handle user input.

Based on the event handling concepts learned from the lecture materials, I implemented keyboard input detection using a KeyListener.
Understanding exactly when the keyPressed and keyReleased events occur was particularly difficult, but I was able to implement the input process after multiple tests.

Additionally, I encountered a problem where keyboard input did not work after clicking a button. I realized that the focus of the input area shifts, and fixing this allowed me to better understand Swing event handling methods.

Regarding Morse code conversion using a HashMap, I initially considered using multiple conditional statements, but I discovered that utilizing a HashMap allowed for a simpler implementation.

## Additional Learning

This project was implemented based on Swing components, Action events, and Threads, which were covered in the lecture materials.

However, to implement Morse code input, the core function of the project, additional learning was required regarding certain Java features not included in the lecture materials.
In particular, the following additional topics were learned and applied to the project:

\- Handling keyboard input using KeyListener<br>
\- Implementing events using KeyAdapter<br>
\- Detecting specific key inputs using KeyEvent<br>
\- Controlling input focus using requestFocus()<br>
\- Checking event timing using System.currentTimeMillis()

These features are provided by the basic Java library, and I learned them while applying the event handling concepts learned in class to an actual program.

Initially, I only understood button event handling, but as I proceeded with the project, I was able to study keyboard input events and focus concepts as well. Through this, I gained a deeper understanding of how programs that process user input operate.

## Application of AI (LLM)

The project was conducted based on the lecture materials.
However, since there were parts that were difficult to implement immediately just by reading the lecture materials, I studied by referring to ChatGPT.

In particular, I asked questions regarding the following topics:

\- How does KeyListener work?<br>
\- What is the difference between keyPressed and keyReleased?<br>
\- How is spacebar input handled?<br>
\- How is HashMap used?<br>
\- How is ActionListener connected?<br>
\- When is Thread used?<br>
\- How is a Swing screen structured?

I referred to conceptual explanations and simple examples through ChatGPT, and proceeded with the project by writing and modifying code based on this foundation.

Initially, I was unfamiliar with Swing screen structure, so I learned by asking questions about the placement of JLabels, JPanels, and JTextAreas, as well as how to write user guide messages.
I also utilized ChatGPT to resolve errors and implementation difficulties that arose during the project, and ultimately, I personally performed the program's functional configuration, class design, code writing, and testing processes.

I utilized ChatGPT not to write the project on my behalf, but as a learning tool to supplement areas where I lacked understanding.

## Reflections

Through this project, I was able to experience firsthand how the concepts learned in class are applied in actual programs.

In particular, directly using components such as ActionListener, KeyListener, HashMap, and Thread allowed me to better understand the concepts learned in the lectures.

Although there were many difficult parts at first, I felt that my programming skills improved slightly as I personally fixed errors and implemented features.

Furthermore, I was able to solve problems by using ChatGPT for additional study on parts that were difficult to understand solely from the lecture materials. Through this, I also experienced how to learn new content independently.

If given the opportunity, I would like to add features such as actual voice output or Korean text conversion in the future.

## Development Environment

\- Java(v.25)<br>
\- IntelliJ IDEA<br>
\- Java Swing<br>

## References

\- Java Programming Lecture Materials Chapter 11 Swing Components<br>
\- Java Programming Lecture Materials Chapter 13 Thread<br>
\- Java Programming Lecture Materials Chapter 14 Menu and Action Events<br>
\- International Morse Code Table<br>
\- ChatGPT (Reference for concept learning and troubleshooting)<br>
\- GitHub Open Source Morse Code Translator Example (Reference for feature configuration ideas): [https://github.com/SeunMatt/morsecodetranslator](https://github.com/SeunMatt/morsecodetranslator)<br>
\- GitHub Java Swing Morse Code Translator Example (Reference for Swing screen layout): [https://github.com/hariperisetla/Morsify](https://github.com/hariperisetla/Morsify)<br>
\- GitHub Java Morse Code Translator Example (Reference for Morse code conversion data structure): [https://github.com/nimshafernando/Morse-Code-Translator-with-Binary-Tree](https://github.com/nimshafernando/Morse-Code-Translator-with-Binary-Tree)<br>

# Tic-Tac-Toe

A two-player Tic-Tac-Toe game with a graphical interface, built in Java using Swing.

## Screenshot

![Game screenshot](../../Pictures/Screenshots/Screenshot%202026-10-25%20152050.png)

## Features

- 3×3 game board played by clicking squares
- Two players on the same computer: X and O take turns
- Automatic win detection (rows, columns and both diagonals) and draw detection
- The board changes color when a game ends: red if X wins, blue if O wins, yellow for a draw
- Scoreboard that keeps track of X wins, O wins and draws across games
- "New Game" button that clears the board while keeping the score
- The starting player alternates every game

## How to run

1. Install a JDK (version 17 or newer)
2. Clone the repository:
3. Open the project in IntelliJ IDEA (or another Java IDE)
4. Run `main.java`

## What I learned

- Building a GUI with Swing: `JFrame`, `JPanel`, `JButton`, `JLabel`
- Using layout managers (`BorderLayout`, `GridLayout`) instead of fixed positions
- Event-driven programming: reacting to clicks with `ActionListener` and lambdas
- Why lambdas can only use variables that are effectively final
- Keeping game state (whose turn it is, scores, game over) separate from the display
- Splitting logic into small methods with one job each (`checkWinner`, `isTie`, `reset`)

## Possible improvements

- Highlight only the winning line instead of the whole board
- A single-player mode against the computer
- Keep the score saved after the program closes
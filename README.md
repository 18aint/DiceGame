# Dice Game Project

## Overview
A Java-based console application that simulates a three-player dice game. Players take turns rolling two dice and strategically placing their scores in a scoring table. The game runs over eleven rounds, with players competing to achieve the highest cumulative score.

## Getting Started

### Prerequisites
- JDK 11 installed on your system
- NetBeans IDE 21 or later
- Basic understanding of console-based applications

### Installation
1. Clone/Download the Project:
   ```bash
   git clone [repository-url]
   ```
   Or download and extract the ZIP file

2. Open in NetBeans:
   - Launch NetBeans IDE
   - Go to File > Open Project
   - Navigate to the DiceGame directory
   - Select the project and click Open

3. Configure Java Platform:
   - Right-click on the project in NetBeans
   - Select Properties
   - Under Categories, select Libraries
   - Ensure Java Platform is set to JDK 11

4. First Run:
   - Clean and Build the project (Shift + F11)
   - Run the project (F6)
   - If successful, you'll see the game interface in the console

### Quick Start Guide
1. Start the game by running the project
2. For each player's turn:
   - The game will automatically roll two dice
   - View the total of your roll
   - Choose a column number (2-12) to place your score
   - Watch the score table update
3. Continue until all 11 rounds are complete
4. View the final results and winner announcement

### Troubleshooting Common Issues
- If the project won't build:
  - Verify Java 11 is correctly installed
  - Check NetBeans Ant configuration
  - Clean and rebuild the project
  
- If you see runtime errors:
  - Ensure all input is numerical
  - Verify column selections are between 2-12
  - Check that Java console is properly configured

## Game Rules

### Basic Gameplay
- 3 players take turns at the console
- 11 rounds of play
- Each player rolls 2 dice per turn
- Players must choose a column (2-12) to place their score
- Each column can only be used once per player
- When a column is complete, highest score wins that column's value
- Tied columns do not score points

### Scoring
- Column values range from 2 to 12
- Winner of each column receives points equal to the column number
- Players cannot override previously placed scores
- Final score is the sum of all won column values
- Highest total score wins the game

## Technical Requirements

### Development Environment
- Java 11
- NetBeans IDE
- Ant build system
- Console-based interface (text-only)

### Project Structure
```
DiceGame/
├── src/
│   └── dicegame/
│       └── Dicegame.java
├── build.xml
└── manifest.mf
```

## Setup Instructions

1. Open NetBeans IDE
2. Select File > Open Project
3. Navigate to the DiceGame directory
4. Ensure Java 11 is selected as the platform

## Building and Running

### Build
- Right-click project in NetBeans
- Select "Clean and Build"

### Run
- Right-click project in NetBeans
- Select "Run"
- Follow console prompts to play

## Game Interface

### Score Table Format
```
2 3 4 5 6 7 8 9 10 11 12 Scores
Player 1
Player 2
Player 3
```

### Input Requirements
- Players must enter column numbers between 2-12
- Invalid inputs will prompt for re-entry
- Each column can only be selected once per player

## Features

- Random dice rolling simulation
- Input validation
- Score tracking
- Column winner determination
- Tie detection
- Final score calculation
- Game analysis summary

## Error Handling

The game includes validation for:
- Invalid column selections
- Already used columns
- Out-of-range inputs
- Duplicate column selections

## Output Features

- Current game state display
- Turn-by-turn updates
- Score table visualization
- Final score summary
- Column-by-column analysis
- Winner announcement

## Development Notes

- Code includes comprehensive inline comments
- Modular design with separate methods for different game aspects
- Consistent formatting and Java naming conventions
- Clean console-based text formatting

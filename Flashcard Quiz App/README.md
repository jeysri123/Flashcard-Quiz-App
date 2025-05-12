# Flashcard Quiz App

A simple console-based Java application for creating and managing flashcards. This application allows users to create flashcards, view them, take quizzes, and save/load flashcards from a file.

## Features

- Add new flashcards with questions and answers
- View all stored flashcards
- Take quizzes with randomized questions
- Save flashcards to a file
- Load flashcards from a file
- Simple console-based interface

## How to Compile and Run

1. Make sure you have Java installed on your system
2. Compile the Java files:
   ```
   javac Flashcard.java FlashcardApp.java
   ```
3. Run the application:
   ```
   java FlashcardApp
   ```

## Usage

1. Choose options from the menu by entering the corresponding number
2. To add a flashcard:
   - Select option 1
   - Enter the question
   - Enter the answer
3. To view all flashcards:
   - Select option 2
4. To take a quiz:
   - Select option 3
   - Answer each question
   - See your score at the end
5. To save flashcards:
   - Select option 4
   - Flashcards will be saved to 'flashcards.txt'
6. To load flashcards:
   - Select option 5
   - Flashcards will be loaded from 'flashcards.txt'
7. To exit:
   - Select option 6

## File Format

Flashcards are saved in a simple text format where each flashcard takes up two lines:
- First line: Question
- Second line: Answer

## Requirements

- Java Runtime Environment (JRE) 8 or higher 
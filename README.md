# Project Title: Quiz Application Backend

## Overview
This project is a Quiz Application designed to test users on Indian General Knowledge. It allows users to:

1. Start quiz sessions.
2. Fetch random questions.
3. Submit answers.
4. View summaries of their quiz performance.

## Features
- **Random Question Generation**: Fetch questions randomly from the database based on the difficulty level.
- **Session-Based Quizzes**: Users can start a quiz session with a specified number of questions and difficulty level.
- **Answer Submission**: Evaluate performance based on submitted answers.
- **Quiz Summary**: Provide a detailed summary at the end of the quiz.

## Prerequisites

Before running the project, ensure you have the following installed:

- Java 11+
- Maven
- H2 Database (in-memory database for development)

## Installation



1. Set up database configuration:
   - Update `src/main/resources/application.properties` with the following:
     ```properties
     spring.datasource.url=jdbc:h2:mem:GK_Quiz_DB
     spring.datasource.driverClassName=org.h2.Driver
     spring.h2.console.enabled=true
     spring.jpa.hibernate.ddl-auto=update
     ```

## Usage

### Running the Application
Start the application using:
```bash
mvn spring-boot:run
```

The application will be available at: `http://localhost:8080`.

### API Endpoints

#### 1. **Start Quiz Session**
   - Endpoint: `POST /api/quiz/start`
   - Request Body (JSON):
     ```json
     {
       "userId": 1,
       "difficulty": "MEDIUM",
       "questionCount": 5
     }
     ```
   - Response (JSON):
     ```json
     {
       "sessionId": 1,
       "difficulty": "MEDIUM",
       "questionCount": 5
     }
     ```

#### 2. **Fetch Random Questions**
   - Endpoint: `GET /api/quiz/question?sessionId=1`
   - Response (JSON):
     ```json
     [
       {
         "id": 34,
         "text": "Who wrote the book 'India Wins Freedom'?",
         "optionA": "Jawaharlal Nehru",
         "optionB": "Maulana Abul Kalam Azad",
         "optionC": "Mahatma Gandhi",
         "optionD": "Sardar Patel"
       },
       {
         "id": 27,
         "text": "Which state in India is known as the 'Spice Garden'?",
         "optionA": "Tamil Nadu",
         "optionB": "Kerala",
         "optionC": "Karnataka",
         "optionD": "Andhra Pradesh"
       },
       {
         "id": 44,
         "text": "What is the official name of India as per the Constitution?",
         "optionA": "Hindustan",
         "optionB": "Republic of India",
         "optionC": "Bharat",
         "optionD": "Union of India"
       },
       {
         "id": 48,
         "text": "Who was the first woman Prime Minister of India?",
         "optionA": "Indira Gandhi",
         "optionB": "Sarojini Naidu",
         "optionC": "Pratibha Patil",
         "optionD": "Sushma Swaraj"
       },
       {
         "id": 26,
         "text": "Which Indian state is the largest producer of tea?",
         "optionA": "West Bengal",
         "optionB": "Kerala",
         "optionC": "Assam",
         "optionD": "Himachal Pradesh"
       }
     ]
     ```

#### 3. **Submit Answers**
   - Endpoint: `POST /api/quiz/submit`
   - Request Body (JSON):
     ```json
     {
       "sessionId": 1,
       "answers": {
         "34": "Maulana Abul Kalam Azad",
         "27": "",
         "44": "Republic of India",
         "48": "Sarojini Naidu",
         "26": "Assam"
       }
     }
     ```
   - Response (JSON):
     ```json
     {
       "correctAnswers": 3,
       "notAttempted": 1
     }
     ```

#### 4. **Get Quiz Summary**
   - Endpoint: `GET /api/quiz/summary?userId=1`
   - Response (JSON):
     ```json
     {
       "sessionId": 1,
       "totalQuestions": 5,
       "correctAnswers": 3,
       "notAttempted": 1,
       "score": 60,
       "remark": "Good"
     }
     ```

## Seed Data
The application preloads the following sample data into the database upon startup:

- **User**: `kartik`
- **Questions**: Indian general knowledge questions (capitals, history, geography, etc.).

## Project Structure
```
quiz_App/
|-- src/
|   |-- main/
|       |-- java/com/Quiz_App/quiz/App/
|       |       |-- controllers/
|       |       |-- services/
|       |       |-- models/
|       |       |-- enums/
|       |       |-- repository/
|       |       |-- dto
|       |       |-- exception/
|       |-- resources/
|           |-- application.properties
|-- pom.xml
|-- README.md
```

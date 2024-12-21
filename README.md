# Quiz_Backend

This project is a Quiz Application designed to test users on Indian General Knowledge. It allows users to start quiz sessions, fetch random questions, submit answers, and view summaries of their quiz performance.

Features:

Random Question Generation: Questions are fetched randomly from the database based on the difficulty level.
Session-Based Quizzes: Each user can start a quiz session with a specified number of questions and difficulty level.
Answer Submission: Users can submit their answers, and their performance is evaluated.
Quiz Summary: A detailed summary is provided at the end of the quiz.

Update the database configuration in src/main/resources/application.properties:
<br>
properties<br>
spring.datasource.url=jdbc:h2:mem:GK_Quiz_DB
spring.datasource.driverClassName=org.h2.Driver
spring.h2.console.enabled=true

The application will be available at: http://localhost:8080
API Endpoints
1. Start Quiz Session
POST /api/quiz/start

Request Body:

json
Copy code
{
  "userId": 1,
  "difficulty": "EASY",
  "questionCount": 10
}
Response:

json
Copy code
{
  "sessionId": 1,
  "difficulty": "EASY",
  "questionCount": 10
}
2. Fetch Random Questions
GET /api/quiz/question?sessionId=1

Response:

json
Copy code
[
  {
    "id": 101,
    "text": "What is the capital of India?",
    "optionA": "Mumbai",
    "optionB": "Delhi",
    "optionC": "Kolkata",
    "optionD": "Chennai"
  },
  {
    "id": 102,
    "text": "Who was the first President of India?",
    "optionA": "Rajendra Prasad",
    "optionB": "Jawaharlal Nehru",
    "optionC": "Sarvepalli Radhakrishnan",
    "optionD": "Indira Gandhi"
  }
  // end more question.......
]
3. Submit Answers
POST /api/quiz/submit

Request Body:

json
Copy code
{
  "sessionId": 1,
  "answers": {
    "101": "Delhi",
    "102": "Rajendra Prasad"
    .....
    till the 10 answer
  }
}
Response:

json
Copy code
{
  "correctAnswers": 10,
  "notAttempted": 0
}
4. Get Quiz Summary
GET /api/quiz/summary?userId=1

Response:

json
Copy code
{
  "sessionId": 1,
  "totalQuestions": 10,
  "correctAnswers": 8,
  "notAttempted": 2,
  "score": 80,
  "remark": "Excellent"
}
Seed Data
The application preloads the following sample data into the database upon startup:

User: kartik
Questions: Indian general knowledge questions like capitals, history, geography, etc.

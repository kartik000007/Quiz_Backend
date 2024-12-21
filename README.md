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
spring.datasource.url=jdbc:h2:mem:GK_Quiz_DB<br>
spring.datasource.driverClassName=org.h2.Driver<br>
spring.h2.console.enabled=true<br>
<br>
<br>
The application will be available at: http://localhost:8080<br>
<br>
API Endpoints<br>
<br>
1. Start Quiz Session<br>

POST /api/quiz/start<br>
<br>
Request Body:<br>
json<br>
{<br>
  "userId": 1,<br>
  "difficulty": "MEDIUM",<br>
  "questionCount": 5<br>
}<br>
Response:<br>
<br>
json<br>
<br>
{<br>
  "sessionId": 1,<br>
  "difficulty": "MEDIUM",<br>
  "questionCount": 5<br>
}<br>
2. Fetch Random Questions<br>
GET /api/quiz/question?sessionId=1<br>
Response:<br>
json<br>
[<br>
  {<br>
    "id": 34,<br>
    "text": "Who wrote the book 'India Wins Freedom'?",<br>
    "optionA": "Jawaharlal Nehru",<br>
    "optionB": "Maulana Abul Kalam Azad",<br>
    "optionC": "Mahatma Gandhi",<br>
    "optionD": "Sardar Patel"<br>
  },<br>
  {<br>
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
  },
]
3. Submit Answers
POST /api/quiz/submit

Request Body:

json
Copy code
{
  "sessionId": 1,
  "answers": {
    "34": "Maulana Abul Kalam Azad",
    "27": "",
    "44": "Republic of India",
    "48": "Sarojini Naidu",
    "26": "Assam",
    }
}
Response:
json

{
  "correctAnswers": 3,
  "notAttempted": 1
}
4. Get Quiz Summary
GET /api/quiz/summary?userId=1

Response:

json
Copy code
{
  "sessionId": 1,
  "totalQuestions": 5,
  "correctAnswers": 3,
  "notAttempted": 1,
  "score": 60,
  "remark": "Good"
}
Seed Data
The application preloads the following sample data into the database upon startup:

User: kartik
Questions: Indian general knowledge questions like capitals, history, geography, etc.

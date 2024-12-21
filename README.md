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
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>API Documentation</title>
</head>
<body>
    <h1>API Endpoints</h1>

    <h2>1. Start Quiz Session</h2>
    <p><strong>POST</strong> <code>/api/quiz/start</code></p>

    <h3>Request Body:</h3>
    <pre><code>
{
  "userId": 1,
  "difficulty": "MEDIUM",
  "questionCount": 5
}
    </code></pre>

    <h3>Response:</h3>
    <pre><code>
{
  "sessionId": 1,
  "difficulty": "MEDIUM",
  "questionCount": 5
}
    </code></pre>

    <h2>2. Fetch Random Questions</h2>
    <p><strong>GET</strong> <code>/api/quiz/question?sessionId=1</code></p>

    <h3>Response:</h3>
    <pre><code>
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
    </code></pre>

    <h2>3. Submit Answers</h2>
    <p><strong>POST</strong> <code>/api/quiz/submit</code></p>

    <h3>Request Body:</h3>
    <pre><code>
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
    </code></pre>

    <h3>Response:</h3>
    <pre><code>
{
  "correctAnswers": 3,
  "notAttempted": 1
}
    </code></pre>

    <h2>4. Get Quiz Summary</h2>
    <p><strong>GET</strong> <code>/api/quiz/summary?userId=1</code></p>

    <h3>Response:</h3>
    <pre><code>
{
  "sessionId": 1,
  "totalQuestions": 5,
  "correctAnswers": 3,
  "notAttempted": 1,
  "score": 60,
  "remark": "Good"
}
    </code></pre>

    <h2>Seed Data</h2>
    <p>The application preloads the following sample data into the database upon startup:</p>
    <ul>
        <li><strong>User</strong>: kartik</li>
        <li><strong>Questions</strong>: Indian general knowledge questions like capitals, history, geography, etc.</li>
    </ul>
</body>
</html>

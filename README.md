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
API Endpoints


Start Quiz Session<br>
POST /api/quiz/start
<br>
Request Body:<br>
json<br>
<br>{
<br>"userId": 1,
<br>"difficulty": "MEDIUM",
<br>"questionCount": 5
<br>}
<br>
<br>
Response:<br>
json<br>
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
"id": 27,<br>
"text": "Which state in India is known as the 'Spice Garden'?", <br>
"optionA": "Tamil Nadu", <br>
"optionB": "Kerala", <br>
"optionC": "Karnataka",<br>
"optionD": "Andhra Pradesh"<br>
},<br>
{ <br>
"id": 44,<br>
"text": "What is the official name of India as per the Constitution?",<br>
"optionA": "Hindustan",<br>
"optionB": "Republic of India",<br>
"optionC": "Bharat",<br>
"optionD": "Union of India" <br>
},<br>
{ "id": 48,<br>
"text": "Who was the first woman Prime Minister of India?",<br>
"optionA": "Indira Gandhi",<br>
"optionB": "Sarojini Naidu",<br>
"optionC": "Pratibha Patil",<br>
"optionD": "Sushma Swaraj"<br>

}, <br>
{ "id": 26, <br>
"text": "Which Indian state is the largest producer of tea?", <br>
"optionA": "West Bengal",<br>
"optionB": "Kerala",<br>
"optionC": "Assam", <br>
"optionD": "Himachal Pradesh" <br>
}<br>
] <br>
<br><br>
3. Submit Answers POST /api/quiz/submit<br>
Request Body:json <br>
{ <br>
"sessionId": 1,<br>
"answers":<br>
{ "34": "Maulana Abul Kalam Azad", <br>
"27": "",<br>
"44": "Republic of India",<br>
"48": "Sarojini Naidu", <br>
"26": "Assam", <br>
}<br>
}<br>
<br>
Response: json<br>
{ <br>
"correctAnswers": 3, <br>
"notAttempted": 1 <br>
}<br>
<br><br>
4. Get Quiz Summary GET /api/quiz/summary?userId=1<br>
<br>
Response:json <br>
{<br>
"sessionId": 1,<br>
"totalQuestions": 5,<br>
"correctAnswers": 3,<br>
"notAttempted": 1, <br>
"score": 60, <br>
"remark": "Good"<br> 
}<br>
<br>
Seed Data The application preloads the following sample data into the database upon startup:

User: kartik 

Questions: Indian general knowledge questions like capitals, history, geography, etc.

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
<br>
1.POST /api/quiz/start
<br><br>
Request Body:json <br>
<br>{<br>
 &ensp;&ensp;"userId": 1,<br>
 &ensp;&ensp;"difficulty": "MEDIUM",<br>
 &ensp;&ensp;"questionCount": 5
<br>}
<br>
<br>
Response:json<br>
{<br>
  &ensp;&ensp; "sessionId": 1,<br>
   &ensp;&ensp; "difficulty": "MEDIUM",<br>
   &ensp;&ensp; "questionCount": 5<br>
}<br>

2. Fetch Random Questions<br>
<br>
GET /api/quiz/question?sessionId=1<br>
Request Body:json <br>
[<br>
 &ensp;&ensp;{<br>
 &ensp;&ensp;"id": 34,<br>
 &ensp;&ensp;"text": "Who wrote the book 'India Wins Freedom'?",<br>
 &ensp;&ensp;"optionA": "Jawaharlal Nehru",<br>
 &ensp;&ensp;"optionB": "Maulana Abul Kalam Azad",<br>
 &ensp;&ensp;"optionC": "Mahatma Gandhi",<br>
 &ensp;&ensp;"optionD": "Sardar Patel"<br>
 &ensp;&ensp;},<br>
 &ensp;&ensp;{<br>
 &ensp;&ensp;"id": 27,<br>
&ensp;&ensp;"text": "Which state in India is known as the 'Spice Garden'?", <br>
&ensp;&ensp;"optionA": "Tamil Nadu", <br>
&ensp;&ensp;"optionB": "Kerala", <br>
&ensp;&ensp;"optionC": "Karnataka",<br>
&ensp;&ensp;"optionD": "Andhra Pradesh"<br>
&ensp;&ensp;},<br>
&ensp;&ensp;{ <br>
&ensp;&ensp;"id": 44,<br>
&ensp;&ensp;"text": "What is the official name of India as per the Constitution?",<br>
&ensp;&ensp;"optionA": "Hindustan",<br>
&ensp;&ensp;"optionB": "Republic of India",<br>
&ensp;&ensp;"optionC": "Bharat",<br>
&ensp;&ensp;"optionD": "Union of India" <br>
&ensp;&ensp;},<br>
&ensp;&ensp;{ "id": 48,<br>
&ensp;&ensp;"text": "Who was the first woman Prime Minister of India?",<br>
&ensp;&ensp;"optionA": "Indira Gandhi",<br>
&ensp;&ensp;"optionB": "Sarojini Naidu",<br>
&ensp;&ensp;"optionC": "Pratibha Patil",<br>
&ensp;&ensp;"optionD": "Sushma Swaraj"<br>

&ensp;&ensp;}, <br>
&ensp;&ensp;{ "id": 26, <br>
&ensp;&ensp;"text": "Which Indian state is the largest producer of tea?", <br>
&ensp;&ensp;"optionA": "West Bengal",<br>
&ensp;&ensp;"optionB": "Kerala",<br>
&ensp;&ensp;"optionC": "Assam", <br>
&ensp;&ensp;"optionD": "Himachal Pradesh" <br>
&ensp;&ensp;}<br>
] <br>
<br><br>
3. Submit Answers POST /api/quiz/submit<br>
Request Body:json <br>
{ <br>
&ensp;&ensp;"sessionId": 1,<br>
&ensp;&ensp;"answers":<br>
&ensp;&ensp;{<br>
&ensp;&ensp; "34": "Maulana Abul Kalam Azad", <br>
&ensp;&ensp;"27": "",<br>
&ensp;&ensp;"44": "Republic of India",<br>
&ensp;&ensp;"48": "Sarojini Naidu", <br>
&ensp;&ensp;"26": "Assam", <br>
&ensp;&ensp;}<br>
}<br>
<br>
Response: json<br>
{ <br>
&ensp;&ensp;"correctAnswers": 3, <br>
&ensp;&ensp;"notAttempted": 1 <br>
}<br>
<br><br>
4. Get Quiz Summary GET /api/quiz/summary?userId=1<br>
<br>
Response:json <br>
{<br>
&ensp;&ensp;"sessionId": 1,<br>
&ensp;&ensp;"totalQuestions": 5,<br>
&ensp;&ensp;"correctAnswers": 3,<br>
&ensp;&ensp;"notAttempted": 1, <br>
&ensp;&ensp;"score": 60, <br>
&ensp;&ensp;"remark": "Good"<br> 
}<br>
<br>
Seed Data The application preloads the following sample data into the database upon startup:

User: kartik 

Questions: Indian general knowledge questions like capitals, history, geography, etc.

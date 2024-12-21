package com.Quiz_App.quiz.App;

import com.Quiz_App.quiz.App.enums.Difficulty;
import com.Quiz_App.quiz.App.model.Question;
import com.Quiz_App.quiz.App.model.User;
import com.Quiz_App.quiz.App.repository.QuestionRepository;
import com.Quiz_App.quiz.App.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class QuizAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizAppApplication.class, args);
	}
	@Bean
	CommandLineRunner seedDatabase(QuestionRepository questionRepository, UserRepository userRepository) {
		return args -> {
			userRepository.save(new User("kartik"));

			questionRepository.saveAll(List.of(
					new Question("What is the capital of India?", "New Delhi", Difficulty.EASY, "Mumbai", "New Delhi", "Kolkata", "Chennai"),
					new Question("Who is known as the Father of the Nation?", "Mahatma Gandhi", Difficulty.EASY, "Mahatma Gandhi", "Jawaharlal Nehru", "Subhash Chandra Bose", "Bhagat Singh"),
					new Question("What is the national animal of India?", "Tiger", Difficulty.EASY, "Lion", "Elephant", "Tiger", "Peacock"),
					new Question("What is the national bird of India?", "Peacock", Difficulty.EASY, "Sparrow", "Peacock", "Pigeon", "Crow"),
					new Question("Which river is known as the Ganga of the South?", "Godavari", Difficulty.EASY, "Narmada", "Godavari", "Krishna", "Kaveri"),
					new Question("Which festival is known as the Festival of Lights?", "Diwali", Difficulty.EASY, "Holi", "Diwali", "Eid", "Pongal"),
					new Question("What is the national flower of India?", "Lotus", Difficulty.EASY, "Rose", "Lotus", "Sunflower", "Marigold"),
					new Question("What is the currency of India?", "Rupee", Difficulty.EASY, "Dollar", "Rupee", "Pound", "Euro"),
					new Question("Which sport is considered the national game of India?", "Hockey", Difficulty.EASY, "Cricket", "Hockey", "Kabaddi", "Football"),
					new Question("Who was the first Prime Minister of India?", "Jawaharlal Nehru", Difficulty.EASY, "Mahatma Gandhi", "Jawaharlal Nehru", "Sardar Patel", "Subhash Chandra Bose"),
					new Question("Which is the largest state in India by area?", "Rajasthan", Difficulty.EASY, "Maharashtra", "Rajasthan", "Uttar Pradesh", "Madhya Pradesh"),
					new Question("What is the national tree of India?", "Banyan", Difficulty.EASY, "Neem", "Banyan", "Mango", "Peepal"),
					new Question("Which river is the longest in India?", "Ganga", Difficulty.EASY, "Yamuna", "Ganga", "Brahmaputra", "Godavari"),
					new Question("Which Indian festival marks the arrival of spring?", "Holi", Difficulty.EASY, "Diwali", "Holi", "Makar Sankranti", "Navratri"),
					new Question("Which is the smallest state in India by area?", "Goa", Difficulty.EASY, "Sikkim", "Goa", "Tripura", "Mizoram"),
					new Question("What is the official language of India?", "Hindi", Difficulty.EASY, "Hindi", "English", "Tamil", "Bengali"),
					new Question("Who wrote the national anthem of India?", "Rabindranath Tagore", Difficulty.EASY, "Bankim Chandra Chatterjee", "Rabindranath Tagore", "Subhash Chandra Bose", "Jawaharlal Nehru"),
					new Question("What is the national fruit of India?", "Mango", Difficulty.EASY, "Apple", "Mango", "Banana", "Orange"),
					new Question("Which is the oldest mountain range in India?", "Aravalli", Difficulty.EASY, "Himalayas", "Vindhya", "Aravalli", "Satpura"),
					new Question("What is the full form of ISRO?", "Indian Space Research Organisation", Difficulty.EASY, "Indian Scientific Research Organisation", "Indian Space Research Organisation", "International Space Research Organisation", "Indian Satellite Research Organisation"),
					new Question("Who was the first President of India?", "Dr. Rajendra Prasad", Difficulty.EASY, "Jawaharlal Nehru", "Dr. Rajendra Prasad", "Dr. S. Radhakrishnan", "Subhash Chandra Bose"),
					new Question("Which Indian city is known as the 'City of Lakes'?", "Udaipur", Difficulty.EASY, "Jaipur", "Udaipur", "Bhopal", "Mumbai"),
					new Question("Which Indian city is called the 'Silicon Valley of India'?", "Bangalore", Difficulty.EASY, "Chennai", "Hyderabad", "Bangalore", "Pune"),
					new Question("Which monument is called the 'Symbol of Love'?", "Taj Mahal", Difficulty.EASY, "India Gate", "Taj Mahal", "Charminar", "Red Fort"),
					new Question("What is the national emblem of India?", "Lion Capital of Ashoka", Difficulty.EASY, "Tiger", "Lion Capital of Ashoka", "Peacock", "Elephant"),
                    new Question("Which is the largest desert in India?", "Ganges", Difficulty.EASY, "Nile", "Ganges", "Kalahari", "Sahara"),
                    new Question("Which is the largest city in India by population?", "Mumbai", Difficulty.EASY, "Delhi", "Mumbai", "Kolkata", "Chennai"),

					//medium Question
					new Question("Who wrote the book 'India Wins Freedom'?", "Maulana Abul Kalam Azad", Difficulty.MEDIUM, "Jawaharlal Nehru", "Maulana Abul Kalam Azad", "Mahatma Gandhi", "Sardar Patel"),
					new Question("Which state in India is known as the 'Spice Garden'?", "Kerala", Difficulty.MEDIUM, "Tamil Nadu", "Kerala", "Karnataka", "Andhra Pradesh"),
					new Question("What is the official name of India as per the Constitution?", "Republic of India", Difficulty.MEDIUM, "Hindustan", "Republic of India", "Bharat", "Union of India"),
					new Question("Who was the first woman Prime Minister of India?", "Indira Gandhi", Difficulty.MEDIUM, "Indira Gandhi", "Sarojini Naidu", "Pratibha Patil", "Sushma Swaraj"),
					new Question("Which Indian state is the largest producer of tea?", "Assam", Difficulty.MEDIUM, "West Bengal", "Kerala", "Assam", "Himachal Pradesh"),
					new Question("Which Indian city is called the 'City of Joy'?", "Kolkata", Difficulty.MEDIUM, "Mumbai", "Kolkata", "Delhi", "Chennai"),
					new Question("Who was the architect of the Indian Constitution?", "Dr. B.R. Ambedkar", Difficulty.MEDIUM, "Mahatma Gandhi", "Jawaharlal Nehru", "Dr. B.R. Ambedkar", "Sardar Patel"),
					new Question("Which state is known as the 'Land of Five Rivers'?", "Punjab", Difficulty.MEDIUM, "Haryana", "Punjab", "Rajasthan", "Uttar Pradesh"),
					new Question("Which Indian city is called the 'Golden City'?", "Jaisalmer", Difficulty.MEDIUM, "Amritsar", "Jaisalmer", "Jaipur", "Bikaner"),
					new Question("Which state in India has the highest literacy rate?", "Kerala", Difficulty.MEDIUM, "Tamil Nadu", "Kerala", "Karnataka", "Delhi"),
					new Question("Who is known as the 'Iron Man of India'?", "Sardar Vallabhbhai Patel", Difficulty.MEDIUM, "Mahatma Gandhi", "Sardar Vallabhbhai Patel", "Jawaharlal Nehru", "Subhash Chandra Bose"),
					new Question("Which is the largest freshwater lake in India?", "Wular Lake", Difficulty.MEDIUM, "Dal Lake", "Chilka Lake", "Wular Lake", "Pulicat Lake"),
					new Question("What is the name of the first satellite launched by India?", "Aryabhata", Difficulty.MEDIUM, "INSAT-1A", "Aryabhata", "Bhaskara-I", "Rohini"),
					new Question("Which city is known as the 'Manchester of India'?", "Ahmedabad", Difficulty.MEDIUM, "Mumbai", "Ahmedabad", "Chennai", "Surat"),
					new Question("Which is the only Indian state with three capitals?", "Andhra Pradesh", Difficulty.MEDIUM, "Jammu & Kashmir", "Andhra Pradesh", "Karnataka", "Telangana"),
					new Question("Which Indian state is famous for the 'Sundarbans'?", "West Bengal", Difficulty.MEDIUM, "Odisha", "West Bengal", "Andhra Pradesh", "Kerala"),
					new Question("What is the highest civilian award in India?", "Bharat Ratna", Difficulty.MEDIUM, "Padma Bhushan", "Bharat Ratna", "Padma Vibhushan", "Padma Shri"),
					new Question("What is the rank of India in terms of population?", "Second", Difficulty.MEDIUM, "First", "Second", "Third", "Fourth"),
					new Question("Which Mughal Emperor built the Red Fort in Delhi?", "Shah Jahan", Difficulty.MEDIUM, "Akbar", "Shah Jahan", "Aurangzeb", "Babur"),
					new Question("Who founded the Maurya Empire?", "Chandragupta Maurya", Difficulty.MEDIUM, "Ashoka", "Chandragupta Maurya", "Bindusara", "Chanakya"),
					new Question("What is the name of the Indian Parliament's upper house?", "Rajya Sabha", Difficulty.MEDIUM, "Lok Sabha", "Rajya Sabha", "Vidhan Sabha", "Gram Sabha"),
					new Question("Which Indian state is the largest producer of wheat?", "Uttar Pradesh", Difficulty.MEDIUM, "Punjab", "Uttar Pradesh", "Haryana", "Madhya Pradesh"),
					new Question("Which Indian city is known as the 'City of Pearls'?", "Hyderabad", Difficulty.MEDIUM, "Chennai", "Hyderabad", "Mumbai", "Kolkata"),
					new Question("Who was the first Indian to receive a Nobel Prize?", "Rabindranath Tagore", Difficulty.MEDIUM, "C.V. Raman", "Rabindranath Tagore", "Mother Teresa", "Amartya Sen"),
					new Question("What is the name of the Indian desert?", "Thar Desert", Difficulty.MEDIUM, "Sahara Desert", "Gobi Desert", "Thar Desert", "Kalahari Desert"),

					//hard Question asnwer
					new Question("Who was the last Governor-General of India?", "Chakravarti Rajagopalachari", Difficulty.HARD, "Lord Mountbatten", "Chakravarti Rajagopalachari", "Sardar Patel", "Dr. B.R. Ambedkar"),
					new Question("What is the term length of a member of the Rajya Sabha?", "6 years", Difficulty.HARD, "5 years", "6 years", "4 years", "7 years"),
					new Question("Which was the first Indian satellite to be placed in geostationary orbit?", "APPLE", Difficulty.HARD, "Rohini", "Aryabhata", "APPLE", "Bhaskara"),
					new Question("Which Indian mathematician is known as the 'Father of Geometry'?", "Baudhayana", Difficulty.HARD, "Aryabhata", "Baudhayana", "Brahmagupta", "Varahamihira"),
					new Question("Who was the first Indian to win an Oscar?", "Bhanu Athaiya", Difficulty.HARD, "Satyajit Ray", "Bhanu Athaiya", "A.R. Rahman", "Gulzar"),
					new Question("Which temple is known as the 'Black Pagoda'?", "Sun Temple, Konark", Difficulty.HARD, "Meenakshi Temple", "Sun Temple, Konark", "Brihadeshwara Temple", "Kailasa Temple"),
					new Question("Which Indian state is known for the Hornbill Festival?", "Nagaland", Difficulty.HARD, "Assam", "Nagaland", "Manipur", "Meghalaya"),
					new Question("Who composed the famous patriotic song 'Vande Mataram'?", "Bankim Chandra Chatterjee", Difficulty.HARD, "Rabindranath Tagore", "Bankim Chandra Chatterjee", "Subhash Chandra Bose", "Lala Lajpat Rai"),
					new Question("Who was the first Indian woman to climb Mount Everest?", "Bachendri Pal", Difficulty.HARD, "Santosh Yadav", "Bachendri Pal", "Malavath Purna", "Tenzing Norgay"),
					new Question("Which dynasty built the Khajuraho temples?", "Chandela dynasty", Difficulty.HARD, "Maurya dynasty", "Gupta dynasty", "Chola dynasty", "Chandela dynasty"),
					new Question("Who was the founder of the Gupta Empire?", "Chandragupta I", Difficulty.HARD, "Samudragupta", "Chandragupta I", "Skandagupta", "Chandragupta Maurya"),
					new Question("Which Mughal Emperor introduced the Din-i-Ilahi religion?", "Akbar", Difficulty.HARD, "Babur", "Aurangzeb", "Shah Jahan", "Akbar"),
					new Question("Which Indian scientist developed the missile 'Agni'?", "Dr. A.P.J. Abdul Kalam", Difficulty.HARD, "Vikram Sarabhai", "Homi Bhabha", "Dr. A.P.J. Abdul Kalam", "Satish Dhawan"),
					new Question("Which Indian classical dance form originated in Kerala?", "Kathakali", Difficulty.HARD, "Bharatanatyam", "Kathak", "Odissi", "Kathakali"),
					new Question("Which Indian state has the largest coal reserves?", "Jharkhand", Difficulty.HARD, "Odisha", "Chhattisgarh", "Jharkhand", "West Bengal"),
					new Question("Who founded the Indian National Army (INA)?", "Subhash Chandra Bose", Difficulty.HARD, "Bhagat Singh", "Mahatma Gandhi", "Jawaharlal Nehru", "Subhash Chandra Bose"),
					new Question("Which Indian ruler is known as 'Napoleon of India'?", "Samudragupta", Difficulty.HARD, "Ashoka", "Chandragupta Maurya", "Samudragupta", "Krishnadevaraya"),
					new Question("Which is the first state in India formed on a linguistic basis?", "Andhra Pradesh", Difficulty.HARD, "Maharashtra", "Andhra Pradesh", "Tamil Nadu", "Karnataka"),
					new Question("Which Indian city is known for its Chola bronze sculptures?", "Thanjavur", Difficulty.HARD, "Madurai", "Thanjavur", "Kanchipuram", "Chennai"),
					new Question("Who is known as the 'Frontier Gandhi'?", "Khan Abdul Ghaffar Khan", Difficulty.HARD, "Mahatma Gandhi", "Sardar Patel", "Khan Abdul Ghaffar Khan", "Bhagat Singh"),
					new Question("Which ancient Indian text deals with statecraft and economic policy?", "Arthashastra", Difficulty.HARD, "Manusmriti", "Ramayana", "Mahabharata", "Arthashastra"),
					new Question("Which is the largest tribal group in India?", "Gonds", Difficulty.HARD, "Santhals", "Gonds", "Bhils", "Oraons"),
					new Question("Who was the first Indian Governor of the Reserve Bank of India?", "C.D. Deshmukh", Difficulty.HARD, "C.D. Deshmukh", "R.N. Malhotra", "Manmohan Singh", "Bimal Jalan"),
					new Question("Which Indian port is the largest container port?", "Jawaharlal Nehru Port", Difficulty.HARD, "Kolkata Port", "Jawaharlal Nehru Port", "Chennai Port", "Cochin Port"),
					new Question("Who is the author of the book 'The Discovery of India'?", "Jawaharlal Nehru", Difficulty.HARD, "Mahatma Gandhi", "Rabindranath Tagore", "Jawaharlal Nehru", "Subhash Chandra Bose")

					));
		};
	}
}

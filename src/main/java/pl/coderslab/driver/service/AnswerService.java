package pl.coderslab.driver.service;

import org.springframework.stereotype.Service;
import pl.coderslab.driver.entity.Answer;
import pl.coderslab.driver.entity.Question;
import pl.coderslab.driver.entity.Quiz;
import pl.coderslab.driver.entity.Score;
import pl.coderslab.driver.repository.AdviceRepository;
import pl.coderslab.driver.repository.AnswerRepository;
import pl.coderslab.driver.repository.QuizRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerService {
    private final AdviceRepository adviceRepository;
    private final AnswerRepository answerRepository;
    private final QuizRepository quizRepository;

    public AnswerService(AdviceRepository adviceRepository, AnswerRepository answerRepository, QuizRepository quizRepository) {
        this.adviceRepository = adviceRepository;
        this.answerRepository = answerRepository;

        this.quizRepository = quizRepository;
    }

    public List<Answer> answersByQuiz(Quiz quiz) {
        Quiz quizBase = quizRepository.findById(quiz.getId()).get();
        List<Question> questions = quizBase.getQuestions();
        List<Answer> answers = new ArrayList<>();
        for (Question question : questions) {
            answers.addAll(question.getAnswers());
        }
        return answers;
    }

    public Score calculateScore(List<Answer> answers){
        int maxScore = 0;
        int score = 0;
        for (Answer answer : answers) {
            Answer toCheck = answerRepository.findById(answer.getId()).get();

            maxScore ++;
            if(toCheck.isCorrect()) {
                score ++;
            }

        }
        boolean passed;
        double pass = maxScore * 0.6;
        if(score >= pass) {
            passed = true;
        } else {
            passed =false;
        }
        return new Score(score,maxScore,passed);


    }

}

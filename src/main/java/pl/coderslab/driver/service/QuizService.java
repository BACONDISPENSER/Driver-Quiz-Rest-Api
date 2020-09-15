package pl.coderslab.driver.service;

import org.springframework.stereotype.Service;
import pl.coderslab.driver.entity.Advice;
import pl.coderslab.driver.entity.Quiz;
import pl.coderslab.driver.repository.AdviceRepository;
import pl.coderslab.driver.repository.QuizRepository;

@Service
public class QuizService {

    private final QuizRepository quizRepository;
    private final AdviceRepository adviceRepository;

    public QuizService(QuizRepository quizRepository, AdviceRepository adviceRepository) {
        this.quizRepository = quizRepository;
        this.adviceRepository = adviceRepository;
    }

    public Quiz getQuizByAdvice(Advice advice) {
        return quizRepository.findById(advice.getQuiz().getId()).get();
    }

}

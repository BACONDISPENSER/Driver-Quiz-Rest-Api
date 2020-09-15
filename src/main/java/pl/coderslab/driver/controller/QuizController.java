package pl.coderslab.driver.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.driver.entity.Advice;
import pl.coderslab.driver.entity.Quiz;
import pl.coderslab.driver.service.QuizService;

@Controller
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("/getQuiz")
    public Quiz getQuizByAdvice(Advice advice) {
        return quizService.getQuizByAdvice(advice);
    }

}

package pl.coderslab.driver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.driver.converter.AdviceConverter;
import pl.coderslab.driver.converter.AnswerConverter;
import pl.coderslab.driver.entity.*;
import pl.coderslab.driver.repository.AdviceRepository;
import pl.coderslab.driver.service.AnswerService;
import pl.coderslab.driver.entity.AnswerWrapper;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/advice")
public class AdviceController {

    private final AdviceRepository adviceRepository;
    private final AnswerService answerService;
    private final AdviceConverter adviceConverter;
    private final AnswerConverter answerConverter;

    public AdviceController(AdviceRepository adviceRepository, AnswerService answerService, AdviceConverter adviceConverter, AnswerConverter answerConverter) {
        this.adviceRepository = adviceRepository;
        this.answerService = answerService;
        this.adviceConverter = adviceConverter;

        this.answerConverter = answerConverter;
    }

    @GetMapping("/all")
    public List<AdviceDto> adviceList() {
        List<AdviceDto> converted = new ArrayList<>();
        for (Advice advice : adviceRepository.findAll()) {
            converted.add(adviceConverter.convertToDto(advice));
        }


        return converted;

    }



    @GetMapping("/topOfTheWeek")
    public Advice adviceTopOfTheWeek() {
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDateTime time = dateTime.with(DayOfWeek.MONDAY);


        List<Advice> advices = adviceRepository.findAllByCreatedGreaterThanEqualOrderByLikesDesc(time);
        return advices.get(0);
    }

    @PostMapping("/getQuizScore")
    public Score getQuizScore(List<AnswerDto> answers) {
        List<Answer> answerList = new ArrayList<>();
        for (AnswerDto answer : answers) {
            answerList.add(answerConverter.convertToEntity(answer));

        }

        return answerService.calculateScore(answerList);
    }
    @PostMapping("/getQuizScore2")
    public Score getQuizScore(AnswerWrapper wrapper) {
        List<Answer> answerList = new ArrayList<>();
        for (AnswerDto answer : wrapper.getAnswers()) {
            answerList.add(answerConverter.convertToEntity(answer));
        }
        return answerService.calculateScore(answerList);
    }
    @PostMapping("/test")
    public AnswerWrapper test(AnswerWrapper wrapper) {
        return wrapper;
    }


    /*@PostMapping("/quizScore")
    public Score quizScore(Quiz quiz) { // mozna przyjac Liste
        int maxScore = 0;
        int score = 0;

        List<Question> questionList = quiz.getQuestions();
        for (Question question : questionList) {
            for (Answer answer : question.getAnswers()) {
                maxScore ++;
                if(answer.isCorrect()) {
                    score ++;
                }

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
*/


}

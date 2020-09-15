package pl.coderslab.driver.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.driver.converter.AnswerConverter;
import pl.coderslab.driver.entity.Answer;
import pl.coderslab.driver.entity.AnswerDto;
import pl.coderslab.driver.entity.Quiz;
import pl.coderslab.driver.service.AnswerService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    private final AnswerService answerService;
    private final AnswerConverter answerConverter;

    public AnswerController(AnswerService answerService, AnswerConverter answerConverter) {
        this.answerService = answerService;
        this.answerConverter = answerConverter;
    }

    @PostMapping("/allByQuiz")
    public List<AnswerDto> answerDtoList(Quiz quiz) {
        List<AnswerDto> answersDtoToQuiz = new ArrayList<>();
        for (Answer answer : answerService.answersByQuiz(quiz)) {
            answersDtoToQuiz.add(answerConverter.convertToDto(answer));
        }
        return answersDtoToQuiz;

    }


}

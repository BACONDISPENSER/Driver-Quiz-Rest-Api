package pl.coderslab.driver.entity;

import pl.coderslab.driver.entity.AnswerDto;

import java.util.List;

public class AnswerWrapper {

    private List<AnswerDto> answers;

    public List<AnswerDto> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDto> answers) {
        this.answers = answers;
    }


}

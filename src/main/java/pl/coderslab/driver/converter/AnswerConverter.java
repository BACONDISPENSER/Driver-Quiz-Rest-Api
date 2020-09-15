package pl.coderslab.driver.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.coderslab.driver.entity.Advice;
import pl.coderslab.driver.entity.AdviceDto;
import pl.coderslab.driver.entity.Answer;
import pl.coderslab.driver.entity.AnswerDto;

@Service
public class AnswerConverter {

    private final ModelMapper modelMapper;

    public AnswerConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public AnswerDto convertToDto(Answer answer) {
        return modelMapper.map(answer, AnswerDto.class);
    }
    public Answer convertToEntity(AnswerDto answerDto) {
        return modelMapper.map(answerDto, Answer.class);
    }
}

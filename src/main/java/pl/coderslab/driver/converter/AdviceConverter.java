package pl.coderslab.driver.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import pl.coderslab.driver.entity.Advice;
import pl.coderslab.driver.entity.AdviceDto;

@Service
public class AdviceConverter {


    private final ModelMapper modelMapper;

    public AdviceConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public AdviceDto convertToDto(Advice advice) {
        return modelMapper.map(advice, AdviceDto.class);
    }
    public Advice convertToEntity(AdviceDto adviceDto) {
        return modelMapper.map(adviceDto, Advice.class);
    }
}
package pl.coderslab.driver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.driver.entity.Advice;
import pl.coderslab.driver.entity.TokenSearch;
import pl.coderslab.driver.repository.AdviceRepository;

import java.util.List;

@RestController
@RequestMapping("/sort")

public class SortController {

    private final AdviceRepository adviceRepository;


    public SortController(AdviceRepository adviceRepository) {
        this.adviceRepository = adviceRepository;
    }

    @PostMapping("/advice")
    public List<Advice> adviceSorting(TokenSearch search) {

String toSearch = search.getSortBy() + " " + search.getOrder();
        return adviceRepository.sortedAdvices(toSearch);
    }

    /*@GetMapping("/all/sort/created/desc")
    public List<Advice> adviceListSortByCreatedDesc() {
        return adviceRepository.adviceListSortedByCreatedDesc();
    }*/

    /*@GetMapping("/all/sort/created/asc")
    public List<Advice> adviceListSortByCreatedAsc() {
        return adviceRepository.adviceListSortedByCreatedAsc();
    }

    @GetMapping("/all/sort/likes/desc")
    public List<Advice> adviceListSortByLikesDesc() {
        return adviceRepository.adviceListSortedByLikesDesc();
    }

    @GetMapping("/all/sort/likes/asc")
    public List<Advice> adviceListSortByLikesAsc() {
        return adviceRepository.adviceListSortedByLikesAsc();
    }*/
}

package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/result")
public class WebController {

    private static final List<Integer> NUMBERS = List.of(10, 5, 3, 12, 6, 7, 5, 3);
    @GetMapping("/")
    public String getHome() {
        return "index";
    }


    @GetMapping("/findEven")
    public String findEven(Model model) {
        List<Integer> evenNumbers = NUMBERS.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        model.addAttribute("result", evenNumbers);
        return "result";
    }

    @GetMapping("/findGreaterThan5")
    public String findGreaterThan5(Model model) {
        List<Integer> greaterThan5 = NUMBERS.stream()
                .filter(n -> n > 5)
                .collect(Collectors.toList());
        model.addAttribute("result", greaterThan5);
        return "result";
    }

    @GetMapping("/findMax")
    public String findMax(Model model) {
        int max = NUMBERS.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
        model.addAttribute("result", max);
        return "result";
    }

    @GetMapping("/findMin")
    public String findMin(Model model) {
        int min = NUMBERS.stream()
                .mapToInt(Integer::intValue)
                .min()
                .orElse(0);
        model.addAttribute("result", min);
        return "result";
    }

    @GetMapping("/sum")
    public String sum(Model model) {
        int sum = NUMBERS.stream()
                .mapToInt(Integer::intValue)
                .sum();
        model.addAttribute("result", sum);
        return "result";
    }

    @GetMapping("/distinct")
    public String distinct(Model model) {
        List<Integer> distinctNumbers = NUMBERS.stream()
                .distinct()
                .collect(Collectors.toList());
        model.addAttribute("result", distinctNumbers);
        return "result";
    }

    @GetMapping("/first5")
    public String first5(Model model) {
        List<Integer> first5 = NUMBERS.stream()
                .limit(5)
                .collect(Collectors.toList());
        model.addAttribute("result", first5);
        return "result";
    }

    @GetMapping("/range")
    public String range(Model model) {
        List<Integer> range = NUMBERS.stream()
                .skip(2)
                .limit(3)
                .collect(Collectors.toList());
        model.addAttribute("result", range);
        return "result";
    }

    @GetMapping("/findFirstGreaterThan5")
    public String findFirstGreaterThan5(Model model) {
        Integer firstGreaterThan5 = NUMBERS.stream()
                .filter(n -> n > 5)
                .findFirst()
                .orElse(null);
        model.addAttribute("result", firstGreaterThan5);
        return "result";
    }
}
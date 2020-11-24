package com.maahi.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    CoronaVirusData coronaVirusData;

    @GetMapping("/")
    public String home(Model model) {
        List<Details> allStats = coronaVirusData.getAllStats();
        int morecases = coronaVirusData.getMaxx();
        String countrywithmorecases = coronaVirusData.getCountrycases();
        int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        model.addAttribute("details", allStats);
        model.addAttribute("totalReportedCases", totalReportedCases);
        model.addAttribute("morecases", morecases);
        model.addAttribute("countrywithmorecases", countrywithmorecases);
        return "home";
    }
}
package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping("/add/{operand1Str}/and/{operand2Str}")
    @ResponseBody
    public String add(@PathVariable String operand1Str, @PathVariable String operand2Str) {
        int operand1 = Integer.parseInt(operand1Str);
        int operand2 = Integer.parseInt(operand2Str);
        return operand1Str + " + " + operand2Str + " = " + Integer.toString(operand1 + operand2);
    }

    @GetMapping("/subtract/{subtrahendStr}/from/{minuendStr}")
    @ResponseBody
    public String subtract(@PathVariable String minuendStr, @PathVariable String subtrahendStr) {
        int minuend = Integer.parseInt(minuendStr);
        int subtrahend = Integer.parseInt(subtrahendStr);
        return minuendStr + " - " + subtrahendStr + " = " + Integer.toString(minuend - subtrahend);
    }

    @GetMapping("/multiply/{operand1Str}/and/{operand2Str}")
    @ResponseBody
    public String multiply(@PathVariable String operand1Str, @PathVariable String operand2Str) {
        double operand1 = Double.parseDouble(operand1Str);
        double operand2 = Double.parseDouble(operand2Str);
        return operand1Str + " x " + operand2Str + " = " + Double.toString(operand1 * operand2);
    }

    @GetMapping("/divide/{dividendStr}/by/{divisorStr}")
    @ResponseBody
    public String divide(@PathVariable String dividendStr, @PathVariable String divisorStr) {
        double dividend = Double.parseDouble(dividendStr);
        double divisor = Double.parseDouble(divisorStr);
        return dividendStr + " / " + divisorStr + " = " + Double.toString(dividend / divisor);
    }
}
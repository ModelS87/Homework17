package pro.sky.calculator1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.calculator1.Service.Calculator1Service;

@RestController
@RequestMapping("/calculator")

public class calculator1Controller {
    private final Calculator1Service calculator1Service;

    public Calculator1Controller(Calculator1Service calculator1Service) {
        this.calculator1Service=calculator1Service;
    }
    @GetMapping(path="/calculator")
    public String hello() {
        return "Добро пожаловать в калькулятор!";
    }
    @GetMapping("/plus")
    public String plus(@RequestParam(value = "num1", required = false) Integer a,
                       @RequestParam(value = "num2",required = false) Integer b) {
        return buildView(a,b,calculator1Service.plus(a ,b), "+");
    }
    @GetMapping("/minus")
    public String minus(@RequestParam(value = "num1", required = false) Integer a,
                       @RequestParam(value = "num2",required = false) Integer b) {
        return buildView(a,b,calculator1Service.plus(a ,b), "-");
    }
    @GetMapping("/multiply")
    public String multiply(@RequestParam(value = "num1", required = false) Integer a,
                       @RequestParam(value = "num2",required = false) Integer b) {
        return buildView(a,b,calculator1Service.plus(a ,b), "*");
    }
    @GetMapping("/divide")
    public String divide(@RequestParam(value = "num1", required = false) Integer a,
                       @RequestParam(value = "num2",required = false) Integer b) {
        return buildView(a,b,calculator1Service.plus(a ,b), "/");
    }
    private String buildView(Integer a,
                             Integer b,
                             Number result,
                             String operation){
        if (a == null || b == null){
            return "Не передан один из параметров!";
        }
        if ("/".equals(operation) && b == 0) {
            return "На ноль делить нельзя!";
        }
        Number result;
        switch (operation){
            case "-":
                result = calculator1Service.minus(a, b);
                break;
            case "*":
                result = calculator1Service.muliply(a, b);
                break;
            case "/":
                result = calculator1Service.divide(a, b);
            default:
                result = calculator1Service.plus(a, b);
        }
        return a + " " + operation + " " + result;
    }
}

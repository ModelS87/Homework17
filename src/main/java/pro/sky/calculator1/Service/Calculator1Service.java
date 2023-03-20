package pro.sky.calculator1.Service;

import org.springframework.stereotype.Service;

@Service
public class Calculator1Service {
    public int plus(int a, int b){
        return a + b;
    }
    public int minus(int a, int b){
        return a - b;
    }
    public int muliply(int a, int b){
        return a * b;
    }
    public double divide(int a, int b){
        return a / (double) b;
    }
}
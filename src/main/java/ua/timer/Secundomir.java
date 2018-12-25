package ua.timer;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;

public class Secundomir {
    public static void main(String[] args) throws IOException {
        List<String> s = new ArrayList<>();
        s.add("asd");
        s.add("s");
        s.add("zz");

        String[] strings = s.toArray(new String[0]);
        System.out.println(s.toArray().getClass().getSimpleName());
    }
}

import domain.BasicStudent;
import domain.Student;
import json.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JSONApp {
    public static void main(String[] args) {
        Json jYear = new JsonNumber(2);
        print(jYear); // 2

        Json jMarks = new JsonArray(new JsonNumber(3), new JsonNumber(4));
        print(jMarks); // [3, 4]

        JsonPair name = new JsonPair("name", new JsonString("Andrii"));
        JsonPair surname = new JsonPair("surname", new JsonString("Rodionov"));
        JsonPair marks = new JsonPair("marks", jMarks);
        JsonPair year = new JsonPair("year", jYear);
        JsonObject jsonObj = new JsonObject(name, surname, year, marks);
        print(jsonObj); // {'name': 'Andrii', 'surname': 'Rodionov', 'year': 2, 'marks': [3, 4]}

        print(jsonObj.projection("surname", "age", "year", "marks")); // {'surname': 'Rodionov', 'year': 2, 'marks': [3, 4]}

        BasicStudent basicStudent = new BasicStudent("Andrii", "Rodionov", 2);
        print(basicStudent.toJsonObject()); // {'name': 'Andrii', 'surname': 'Rodionov', 'year': 2}

    }

    private static void print(Json json) {
        System.out.println(json.toJson());
    }


    public static JsonObject sessionResult() {
        Json jYear = new JsonNumber(2);

        JsonPair name = new JsonPair("name", new JsonString("Andrii"));
        JsonPair surname = new JsonPair("surname", new JsonString("Rodionov"));
        JsonPair year = new JsonPair("year", jYear);

        JsonPair passed = new JsonPair("passed", new JsonBoolean(true));
        JsonPair notPassed = new JsonPair("passed", new JsonBoolean(false));

        JsonPair oop = new JsonPair("course", new JsonString("OOP"));
        JsonPair markThree = new JsonPair("mark", new JsonNumber(3));
        JsonObject oopCourse = new JsonObject(oop, markThree, passed);

        JsonPair english = new JsonPair("course", new JsonString("English"));
        JsonPair markFive = new JsonPair("mark", new JsonNumber(5));
        JsonObject englishCourse = new JsonObject(english, markFive, passed);

        JsonPair math = new JsonPair("course", new JsonString("Math"));
        JsonPair markTwo = new JsonPair("mark", new JsonNumber(2));
        JsonObject mathCourse = new JsonObject(math, markTwo, notPassed);

        Json jCourses = new JsonArray(oopCourse, englishCourse, mathCourse);

        JsonPair courses = new JsonPair("exams", jCourses);

        JsonObject session = new JsonObject(name, surname, year, courses);

        return session;
    }
}

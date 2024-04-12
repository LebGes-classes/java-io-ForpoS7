package InputOutput;

import Data.Student;
import Data.Subject;
import Data.Teacher;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Parser {
    private final String filePath;
    private Teacher [] teachers;
    private Student [] students;
    private Subject [] subjects;
    private int numberLines;
    public Parser (String filePath) {
        this.filePath = filePath;
    }
    private void setNumberLines () {
        try {
            FileInputStream inputStream = new FileInputStream(filePath);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            bufferedReader.readLine();
            while (bufferedReader.readLine() != null) {
                numberLines++;
            }
            teachers = new Teacher[numberLines];
            students = new Student[numberLines];
            subjects = new Subject[numberLines];
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void parse () {
        try {
            FileInputStream inputStream = new FileInputStream(filePath);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            Map<String, String> map = new HashMap<>();

            String line = bufferedReader.readLine();
            String [] strKeys = line.split(";");
            for (String key : strKeys) {
                map.put(key, " ");
            }

            setNumberLines();

            int count = 0;
            while ((line = bufferedReader.readLine()) != null) {
                String [] strVal = line.split(";");
                for (int i = 0; i < strKeys.length; i++) {
                    map.put(strKeys[i], strVal[i]);
                }
                teachers[count] = new Teacher(map.get("Teacher"));
                students[count] = new Student(map.get("Student"));
                subjects[count] = new Subject(map.get("Subject"));
                count++;
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Teacher[] getTeachers() {
        return teachers;
    }
    public Student[] getStudents() {
        return students;
    }
    public Subject[] getSubjects() {
        return subjects;
    }
}

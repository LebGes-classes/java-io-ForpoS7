package InputOutput;

import Data.Student;
import Data.Subject;
import Data.Teacher;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;

public class Writer {
    private final JSONObject jsonObject = new JSONObject();
    private final Teacher [] teachers;
    private final Student[] students;
    private final Subject[] subjects;

    public Writer(Teacher [] teachers, Student [] students, Subject [] subjects) {
        this.teachers = teachers;
        this.students = students;
        this.subjects = subjects;
    }

    public void write (String filePath) {
        int arraysLength = teachers.length;
        JSONArray arrTeachers = new JSONArray();
        JSONArray arrStudents = new JSONArray();
        JSONArray arrSubjects = new JSONArray();
        for (int i = 0; i < arraysLength; i++) {
            arrTeachers.put(teachers[i].getName());
            arrStudents.put(students[i].getName());
            arrSubjects.put(subjects[i].getName());
        }
        jsonObject.put("Teachers", arrTeachers);
        jsonObject.put("Students", arrStudents);
        jsonObject.put("Subjects", arrSubjects);
        try {
            File jsonFile = new File(filePath);
            FileOutputStream outputStream = new FileOutputStream(jsonFile);
            byte [] buffer = jsonObject.toString().getBytes();
            outputStream.write(buffer);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

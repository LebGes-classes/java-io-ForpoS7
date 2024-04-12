package org.example;

import InputOutput.Parser;
import InputOutput.Writer;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser("proga.csv");
        parser.parse();
        Writer writer = new Writer(parser.getTeachers(), parser.getStudents(), parser.getSubjects());
        writer.write("json.json");
    }
}

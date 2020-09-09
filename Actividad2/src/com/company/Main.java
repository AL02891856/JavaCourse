package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        System.out.println("Bievenidos");
        System.out.println("Registro de estudiante...");
        System.out.println("Nombre del estudiante: ");
        String name = s.nextLine();
        Student student = new Student(name);

        for (short i = 0; i < student.grades.length; i++) {
            System.out.println("Ingresar calificacion " + (i+1));
            while(!s.hasNextShort()){
                System.out.println("Calificacion incorrecta, intente de nuevo");
                s.next();
            }
            student.SetGrade(i, s.nextShort());
        }

        PrintResults(student);
    }

    private static void PrintResults(Student student) throws IOException {
        System.out.println(student.name);
        float score = student.GetScore();
        student.PrintAllGrades();
        System.out.println("Promedio: " + score);
        System.out.println("Calificacion: " + student.GetFinalScore(score));
        System.out.println("Presiona enter para salir...");
        System.in.read();
    }
}


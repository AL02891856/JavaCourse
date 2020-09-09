package com.company;

public class Student extends Person {

    short[] grades;

    public Student(String name) {
        super(name);
        this.grades = new short[5];
    }

    public String GetGrades() {
        StringBuilder gradesString = new StringBuilder();

        for (short grade : this.grades) {
            gradesString.append(grade);
        }

        return GetName().concat(gradesString.toString());
    }

    public void SetGrade(short index, short grade) {
        this.grades[index] = grade;
    }

    public void PrintAllGrades() {
        for (short i = 0; i < this.grades.length; i++) {
            System.out.println("Calificacion " + (i+1) + ":" + this.grades[i]);
        }
    }

    public float GetScore() {
        float score = 0f;

        for (short grade: this.grades) {
            score += grade;
        }

        return score/this.grades.length;
    }

    public String GetFinalScore(float score)  {
        if(score  <= 50){
            return "F";
        } else if (score <= 60) {
            return "E";
        } else if (score <= 70) {
            return "D";
        } else if (score <= 80) {
            return "C";
        } else if (score <= 90) {
            return "B";
        } else if (score <= 100) {
            return "A";
        } else {
            return "Promedio invalido, no se puede determinar la " +
                    "calificacion final...";
        }
    }
}

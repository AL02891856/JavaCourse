package com.company.models;

import com.company.util.Constants;

import java.io.*;
import java.util.HashMap;

public class Patient extends AbstractPerson{
    String gender;
    private String fileName = Constants.DATABASE_PATH + "patient.txt";
    private HashMap<String, String> patients = new HashMap<>();
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public Patient(String name, String gender) {
        super(name);
        this.gender = gender;
    }

    public Patient() { }

    public HashMap<String, String> getPatient() {
        return patients;
    }

    public void load() throws IOException {
        bufferedReader = new BufferedReader(new FileReader(fileName));

        String line;
        while((line = bufferedReader.readLine()) != null) {
            if(!line.contains(","))
                continue;

            String[] values = line.split(",");
            patients.put(values[0], values[1]);
        }

        bufferedReader.close();
    }

    public void save() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        patients.forEach((k,v) -> {
            stringBuilder.append(k + "," + v);
            stringBuilder.append(System.getProperty("line.separator"));
        });

        bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.close();
    }

    public void create() throws IOException {
        if(patients.containsKey(name)) {
            System.out.println("Paciente ya existe...");
            return;
        }

        patients.put(name, gender);
        save();
    }

}

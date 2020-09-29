package com.company.models;

import com.company.interfaces.IActions;
import com.company.util.Constants;

import java.io.*;
import java.util.HashMap;

public class Doctor extends AbstractPerson implements IActions {
    private String specialty;
    private String fileName = Constants.DATABASE_PATH + "doctor.txt";
    private HashMap<String, String> doctors = new HashMap<>();
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public Doctor(String name, String specialty) {
        super(name);
        this.specialty = specialty;
    }

    public Doctor() { }

    public void load() throws IOException {
        bufferedReader = new BufferedReader(new FileReader(fileName));

        String line;
        while((line = bufferedReader.readLine()) != null) {
            if(!line.contains(","))
                continue;

            String[] values = line.split(",");
            doctors.put(values[0], values[1]);
        }

        bufferedReader.close();
    }

    public void save() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        doctors.forEach((k,v) -> {
            stringBuilder.append(k + "," + v);
            stringBuilder.append(System.getProperty("line.separator"));
        });

        bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.close();
    }

    public void create() throws IOException {
        if(doctors.containsKey(name)) {
            System.out.println("Doctor ya existe...");
            return;
        }

        doctors.put(name, specialty);
        save();
    }

    public HashMap<String, String> getDoctors() {
        return doctors;
    }
}

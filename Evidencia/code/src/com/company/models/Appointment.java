package com.company.models;

import com.company.util.Constants;

import java.io.*;
import java.util.Date;
import java.util.HashMap;

public class Appointment {
    String idDoctor;
    String idPatient;
    String description;
    String date;
    private String fileName = Constants.DATABASE_PATH + "appointment.txt";
    private HashMap<String, String> appointments = new HashMap<>();
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public Appointment(String idDoctor, String idPatient, String description, String date) {
        this.idDoctor = idDoctor;
        this.idPatient = idPatient;
        this.description = description;
        this.date = date;
    }

    public Appointment() { }

    public void load() throws IOException {
        bufferedReader = new BufferedReader(new FileReader(fileName));

        String line;
        while((line = bufferedReader.readLine()) != null) {
            if(!line.contains(","))
                continue;

            String[] values = line.split(",");
            appointments.put(values[0], values[1]);
        }

        bufferedReader.close();
    }

    public void save() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        appointments.forEach((k,v) -> {
            stringBuilder.append(k + "," + v);
            stringBuilder.append(System.getProperty("line.separator"));
        });

        bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.close();
    }

    public void create() throws IOException {
        appointments.put(date, description+","+idDoctor+","+idPatient);
        save();
    }

    public boolean appointmentExits(String username, String password) {
        if(!appointments.containsKey(username))
            return false;
        else if (appointments.get(username).equals(password))
            return true;
        else
            return false;
    }
}

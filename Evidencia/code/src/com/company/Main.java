package com.company;

import com.company.models.*;
import com.company.util.Constants;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(System.in);
            Auth auth;
            String username;
            String password;
            boolean exit = false;

            init();
            do {
                System.out.println("Ingresar usuario: " );
                username = s.nextLine();
                System.out.println("Ingresar password: ");
                password = s.nextLine();
                auth = new Auth(username, password);
            } while(!auth.userExists());

            while(!exit){
                System.out.println("Bienvenidos, favor de seleccionar una opcion: \n" +
                        "1) Crear doctor\n" +
                        "2) Crear patient\n" +
                        "3) Crear cita\n" +
                        "4) Salir");
                String option = s.nextLine();

                switch (option) {
                    case "1":
                        System.out.println("Inserte el nombre del doctor: ");
                        String keyDoctor = s.nextLine();
                        System.out.println("Inserte la especialidad: ");
                        String valueDoctor = s.nextLine();
                        Doctor doctor = new Doctor(keyDoctor, valueDoctor);
                        doctor.load();
                        doctor.create();
                        break;
                    case "2":
                        System.out.println("Inserte el nombre del paciente: ");
                        String keyPatient = s.nextLine();
                        System.out.println("Inserte el sexo: ");
                        String valuePatient = s.nextLine();
                        Patient patient  = new Patient(keyPatient, valuePatient);
                        patient.load();
                        patient.create();
                        break;
                    case "3":
                        Appointment appointment = new Appointment();
                        System.out.println("Inserte la descripcion de la cita: ");
                        String desc = s.nextLine();
                        doctor = new Doctor();
                        patient = new Patient();
                        patient.load();
                        doctor.load();
                        String doctorName = "";
                        String patientName = "";
                        String valueCita = "";

                        do{
                            System.out.println("Inserte el doctor: ");
                            doctorName = s.nextLine();
                        } while (!doctor.getDoctors().containsKey(doctorName));

                        do{
                            System.out.println("Inserte el paciente: ");
                            patientName = s.nextLine();
                        } while (!patient.getPatient().containsKey(doctorName));

                        System.out.println("Inserte el horario: ");
                        String date = s.nextLine();
                        appointment  = new Appointment(doctorName, patientName, desc, date);
                        appointment.load();
                        appointment.create();
                        break;
                    case "4":
                        exit = true;
                        break;
                    default:
                        System.out.println("Opcion incorrecta, intente de nuevo...");
                        break;
                }
            }

        } catch (IOException ex) {
            System.out.println("Error: Hubo un problema al crear la base de datos." +
                    " Favor de contactar a su administrador");
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }

    private static void createUser() throws IOException {
        BufferedWriter bufferedWriter;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("admin,root123");
        stringBuilder.append(System.getProperty("line.separator"));

        bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\db\\user.txt"));
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.close();
    }

    private static void init() throws Exception {
        String[] tables = new String[] {"user.txt","patient.txt","doctor.txt", "appointment.txt"};

        for (String table:tables) {
            File file = new File(Constants.DATABASE_PATH + table);

            if(!file.exists()) {
                file.createNewFile();
            }
        }
        createUser();
    }
}

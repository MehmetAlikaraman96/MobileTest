package com.Thy;

import java.sql.*;

public class DataBase {
    public Connection connection = null;
    private static String kalkisYeri;
    private static String varisYeri;
    private static String namePassenger;
    private static String lastNamePassenger;



    public static String getKalkisYeri() {
        return kalkisYeri;
    }

    public static void setKalkisYeri(String kalkisYeri) {
        DataBase.kalkisYeri = kalkisYeri;
    }

    public static String getVarisYeri() {
        return varisYeri;
    }

    public static void setVarisYeri(String varisYeri) {
        DataBase.varisYeri = varisYeri;
    }

    public static String getNamePassenger() {
        return namePassenger;
    }

    public static void setNamePassenger(String namePassenger) {
        DataBase.namePassenger = namePassenger;
    }

    public static String getLastNamePassenger() {
        return lastNamePassenger;
    }

    public static void setLastNamePassenger(String lastNamePassenger) {
        DataBase.lastNamePassenger = lastNamePassenger;
    }


    public void connectToDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TurkHavaYollari", "root", "12345678");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void getDataFromTo() {
        connectToDatabase();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from UcusYonu");
            result.next();
            kalkisYeri=result.getString("Kalkıs");//saw
            varisYeri=(result.getString("Varıs"));//esb
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

  public void getPassengerInfo1() {
        connectToDatabase();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from Yolcular");
            result.next();
            setNamePassenger(result.getString("ad"));
            setLastNamePassenger((result.getString("soyad")));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getPassengerInfo2() {
        connectToDatabase();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from Yolcular where id=2");
            result.next();
            setNamePassenger(result.getString("ad"));
            setLastNamePassenger((result.getString("soyad")));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

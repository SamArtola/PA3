package Main;

import java.io.*;

import util.*;

import java.util.*;


public class Main {

    public static boolean Valid(String job, String name, String Student_ID, String Teacher_ID, String Phone) {
        int comma = 0;
        if (name.endsWith(",")||name.startsWith(",")) {
            System.out.println("Please enter a valid Name.");
            return false;
        }

        for (int h = 0; h < name.length(); h++) {
            if (name.charAt(h) == ',') {
                comma++;
            }
        }

        if (!Character.isUpperCase(name.charAt(0)) || !name.matches("[a-zA-Z]+")) {
            if (comma != 1) {//only one dot is allowed
                System.out.println("Last name must contain one ',' character separating the First and Last name !");
                return false;
            }
        }

        if ((job.equalsIgnoreCase("TA") && Student_ID.length() == 5 && Teacher_ID.length() == 5 && Phone.length() == 10)) {
            return !Teacher_ID.startsWith("0") && !Student_ID.startsWith("0") && !Phone.startsWith("0");
        }

        if ((job.equalsIgnoreCase("Teacher") && Student_ID.equals("0") && Teacher_ID.length() == 5 && Phone.length() == 10))
        {
            return !Teacher_ID.startsWith("0");
        }

        if (job.equalsIgnoreCase("Student") && Teacher_ID.equals("0") && Student_ID.length() == 5 && Phone.length() == 10){
            return !Student_ID.startsWith("0") && !Phone.startsWith("0");
        }

        return false;
    }

    public static void main(String[] args) throws IOException {

        PrintWriter file = new PrintWriter("Datastorage.csv");
        Scanner scan = new Scanner(System.in);
        ArrayList<CSVPrintable> data = new ArrayList<>();
        System.out.println("Please enter the amount of people to add: ");
        try {
            int count = scan.nextInt();
            scan.nextLine();
            if(count>=1){
            for (int i = 0; i < count; ) {
                System.out.print("""
                        Please enter the information in the following format:\s
                        Position FirstName,LastName StudentID TeacherID PhoneNumber
                        """);
                String in = scan.nextLine();
                String[] splits = in.split(" ");

                if (splits.length == 5) {
                    if (splits[0].equalsIgnoreCase("Student"))
                        if (Valid(splits[0], splits[1], splits[2], splits[3], splits[4])) {
                            data.add(new Student(splits[0], splits[1], splits[2], splits[3], Long.parseLong(splits[4])));
                            System.out.println("Information Successfully Added!!!!");
                            i++;

                        } else
                            System.out.println("Incorrect Input! Please try again!\n");
                    else if (splits[0].equalsIgnoreCase("Teacher"))
                        if (Valid(splits[0], splits[1], splits[2], splits[3], splits[4])) {
                            data.add(new Teacher(splits[0], splits[1], splits[2], splits[3], Integer.parseInt(splits[4].substring(splits[4].length() - 4))));
                            System.out.println("Information Successfully Added!!!!");
                            i++;
                        } else
                            System.out.println("Incorrect Input! Please try again!\n");
                    else if (splits[0].equalsIgnoreCase("TA"))
                        if (Valid(splits[0], splits[1], splits[2], splits[3], splits[4])) {
                            data.add(new TA(splits[0], splits[1], splits[2], splits[3], Long.parseLong(splits[4])));
                            System.out.println("Information Successfully Added!!!!");
                            i++;
                        } else
                            System.out.println("Incorrect Input! Please try again!\n");
                    else
                        System.out.println("Incorrect Input. Please enter one of the following positions: Teacher, Student, or TA");
                } else
                    System.out.println("Please enter the correct amount of data without any extra spaces.");
            }

            System.out.println(data.size());

            for (CSVPrintable arr : data) {
                arr.csvPrintln(file);
            }


        }} catch (Exception e) {
            System.out.println("Something went wrong.");
        }


    }
}


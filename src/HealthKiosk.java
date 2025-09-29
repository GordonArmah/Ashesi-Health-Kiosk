import javax.swing.*;
import java.util.Scanner;
import java.util.Random;

public class HealthKiosk {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        Random rand = new Random();

        System.out.print("Enter Your Service code(P/l/T/C)");
        String Service_Code = input.nextLine().toUpperCase();

        int metricResult = 0;
        double bmi = 0.0;



        switch (Service_Code) {
            case "P":
                System.out.print("Go to Pharmacy" );
                break;
            case "L":
                System.out.print("Go to Lab" );
                break;
            case "T":
                System.out.print("Go to Triage" );


                System.out.println("Choose a health metric:");
                System.out.println("1. BMI quick calculation");
                System.out.println("2. Dosage round-up");
                System.out.println("3. Simple trig helper");
                int choice=input.nextInt();



                if(choice==1) {
                    System.out.println("what is your weight in kilograms?");
                    double weight = input.nextDouble();
                    System.out.println("what is your height in meters?");
                    double height = input.nextDouble();

                    bmi = weight / (height * height);
                    double BMI_Rounded = Math.round(bmi * 10) / 10.0;
                    metricResult = (int) Math.round(bmi);

                    System.out.print("BMI: " + BMI_Rounded + " Category: ");

                    if (BMI_Rounded < 18.5) {
                        System.out.println("Underweight");
                    } else if (BMI_Rounded < 25.0) {
                        System.out.println("Normal");
                    } else if (BMI_Rounded < 30.0) {
                        System.out.println("Overweight");
                    } else {
                        System.out.println("Obese");
                    }

                }
                else if (choice==2) {
                    System.out.print("Enter required dosage (mg): ");
                    double dosage = input.nextDouble();

                    int tablets = (int) Math.ceil(dosage / 250.0);
                    metricResult = tablets;
                    System.out.println("Tablets required: " + tablets);

                }
                else if (choice==3) {
                    System.out.print("Please enter the angle in degrees: ");
                    double angleDeg = input.nextDouble();
                    double angleRad = Math.toRadians(angleDeg);

                    double sin_Value = Math.round(Math.sin(angleRad) * 1000) / 1000.0;
                    System.out.println("sin(" + angleDeg + ") = " + sin_Value);

                    double cos_Value = Math.round(Math.cos(angleRad) * 1000) / 1000.0;
                    System.out.println("cos(" + angleDeg + ") = " + cos_Value);

                    metricResult = (int) Math.round(Math.sin(angleRad) * 100);

                }
                else{
                    System.out.println("Invalid Choice");
                }


                break;
            case "C":
                System.out.print("Go to Counseling" );
                break;

            default:
                System.out.print("invalid service code");
                break;


        }
        char random_ch = (char) ('A' + rand.nextInt(26));

        StringBuilder digits = new StringBuilder();
        int count=0;
        while(count<4){
            count++;
            int num= rand.nextInt(7)+ 3;
            digits.append(num);

        }
        String StudentID = random_ch + digits.toString();

        System.out.println("Generated ID: " + StudentID);

        if (StudentID.length() != 5) {
            System.out.println("Invalid length.");
        }
        else if (!Character.isLetter(StudentID.charAt(0))) {
            System.out.println("Invalid: first char must be a letter.");
        }
        else if (!Character.isDigit(StudentID.charAt(1)) || !Character.isDigit(StudentID.charAt(2)) || !Character.isDigit(StudentID.charAt(3)) || !Character.isDigit(StudentID.charAt(4))) {
                System.out.println("Invalid: last 4 must be digits.");
        }
        else {
                System.out.println("ID OK");
            }
        input.nextLine();

        System.out.print("Enter your first name: ");
        String firstName = input.nextLine();

        char base = Character.toUpperCase(firstName.charAt(0));

        char shifted = (char) ('A' + (base - 'A' + 2) % 26);

        String lastTwo = StudentID.substring(StudentID.length() - 2);

        String finalCode = " " + shifted + lastTwo + "-" + metricResult;
        System.out.println("Display Code: " + finalCode);



        String summary;
        switch (Service_Code) {
            case "P":
                summary = "PHARMACY | ID=" + StudentID + " | Code=" + finalCode;
                break;

            case "L":
                summary = "LAB | ID=" + StudentID + " | Code=" + finalCode;
                break;

            case "T":
                summary = "TRIAGE | ID=" + StudentID + " | BMI=" + bmi + " | Code=" + finalCode;
                break;

            case "C":
                summary = "COUNSELING | ID=" + StudentID + " | Code=" + finalCode;
                break;

            default:
                summary = "UNKNOWN SERVICE | ID=" + StudentID + " | Code=" + finalCode;
        }
        System.out.println("Summary: " + summary);
    }
}














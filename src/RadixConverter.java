import java.util.Scanner;

public class RadixConverter {

     public static void main(String[] args){

        // Input number here
        Scanner typehere = new Scanner(System.in);

        System.out.print("Enter type of base: ");
        String type = typehere.next();

        // public variable for int number, and string for hexa incase may letters
        // gumawa muna ako dito para ma-access ng mga if statements
        Long number_inputed = 0L;
        String number_inputed_hex = "";

        boolean valid = true;


        // check muna kung hexa yung input para maka
        if ("Hexadecimal".equalsIgnoreCase(type)) {

            System.out.print("Enter a hexadecimal number: ");
            number_inputed_hex = typehere.next();

        } else {

            System.out.print("Enter a number: ");
            number_inputed = typehere.nextLong();

        }



        // checks if the inputed number is an integer value
        if (number_inputed instanceof Long || number_inputed_hex instanceof String && valid) {

            // checks the type of base (decimal, binary, octal, hexadecimal)
            if ("Binary".equalsIgnoreCase(type)) {

                // binary func (call the function here)
                ConvertBinary(number_inputed); // returns the inputed number as an argument

            } else if ("Decimal".equalsIgnoreCase(type)) {

                // decimal func (call the function here)
                ConvertDecimal(number_inputed); // returns the inputed number as an argument

            } else if ("Octal".equalsIgnoreCase(type)) {

                // octal func (call the function here)
                ConvertOctal(number_inputed); // returns the inputed number as an argument

            } else if ("Hexadecimal".equalsIgnoreCase(type)) {

                // hexa func (call the function here)
                ConvertHexadecimal(number_inputed, number_inputed_hex); // returns the inputed number as an argument

            } else {

                // checks if the inputed type is a one of the types of bases
                System.out.println("String entered is not a type.");

            }

        }

        // scanner/input closes
        typehere.close();

    }

    // Decimal converter function
    public static void ConvertDecimal(long number) {

        // variables for each 3 types
        // di na nag string.valueof at parseint dito kasi inaaccept na automatically na decimal yung int number argument
        String binary = Long.toBinaryString(number);
        String octal = Long.toOctalString(number);
        String hexa = Long.toHexString(number);

        System.out.println(number + " in binary is: " + binary);
        System.out.println(number + " in octal is: " + octal);
        System.out.println(number + " in hexadecimal is: " + hexa.toUpperCase());

    }

    // Binary converter function
    public static void ConvertBinary(long number) {

        // bool value for the for loop, set muna ng value para mapalitan later
        boolean valid = true;

        // for loop for checking if the input has only 0 and 1 numbers
        // (int_checker = number) is a temporary variable
        // (int_checker > 0) is to check if the input is above 0, to check numbers above 0
        // (int_checker /= 10) is to divide the input to 10, it removes the last digit
        // (int_checker % 10 > 1) gives back the remainder that was left on the previous division
        for (long int_checker = number; int_checker > 0; int_checker /= 10) {
            if (int_checker % 10 > 1) {
                valid = false;
                break; //break the loop kapag false
            }
        }

        // kapag invalid yung number, magpprint tas return na natin sa function para di tumuloy sa ibang code kasi error lang hehe
        if (!valid) {

            System.out.println("Invalid binary number");

            return;

        }

        // variables for each 3 types
        // need muna iconvert yung int number from decimal value
        int decimal_to_binary = Integer.parseInt(String.valueOf(number), 2);

        // (int decimal_to_binary) -- converts the string value of number to an int value
        // tas divide mo yung number sa 2, kasi walang built in na pagconvert to decimal

        String octal = Integer.toOctalString(decimal_to_binary);
        String hexa = Integer.toHexString(decimal_to_binary);

        System.out.println(number + " in decimal is: " + decimal_to_binary);
        System.out.println(number + " in octal is: " + octal);
        System.out.println(number + " in hexadecimal is: " + hexa.toUpperCase());

    }

    // Octal converter function
    public static void ConvertOctal(long number) {

        // bool value for the while loop, set muna ng value para mapalitan later
        boolean valid = true;

        // for loop for checking if the input has only 0-7 numbers
        // (int_checker = number) is a temporary variable
        // (int_checker > 0) is to check if the input is above 0, to check numbers above 0
        // (int_checker /= 10) is to divide the input to 10, it removes the last digit
        // (int_checker % 10 > 7) gives back the remainder that was left on the previous division
        for (long int_checker = number; int_checker > 0; int_checker /= 10) {
            if (int_checker % 10 > 7) {
                valid = false;
                break; //break the loop kapag false
            }
        }

        // kapag invalid yung number, magpprint tas return na natin sa function para di tumuloy sa ibang code kasi error lang hehe
        if (!valid) {

            System.out.println("Invalid octal number");

            return;

        }

        // variables for each 3 types
        // need muna iconvert yung int number from decimal value
        int decimal_to_octal = Integer.parseInt(String.valueOf(number), 8);

        // (int decimal_to_octal) -- converts the string value of number to an int value
        // tas divide mo yung number sa 8, dito di gagana yung built-in na function toOctalString kahit iconvert mo sa int yan, a-accept nya parin as deimal value hindi octal

        String binary = Integer.toBinaryString(decimal_to_octal);
        String hexa = Integer.toHexString(decimal_to_octal);

        System.out.println(number + " in binary is: " + binary);
        System.out.println(number + " in decimal is: " + decimal_to_octal);
        System.out.println(number + " in hexadecimal is: " + hexa.toUpperCase());

    }

    // Hexadecimal converter function
    public static void ConvertHexadecimal(long number, String number_w_letter) {


        // need muna iconvert yung int number from decimal value
        int decimal_to_hexa_w_letters = Integer.parseInt(number_w_letter, 16);

        int decimal_to_hexa = Integer.parseInt(String.valueOf(number), 16);


        // checks if the passed argument is an integer or a string
        // first if statement is int only, no letters/string
        if (number_w_letter == null) {

            // separate binary and octal variables, different argument kasi
            String binary = Integer.toBinaryString(decimal_to_hexa);
            String octal = Integer.toOctalString(decimal_to_hexa);

            System.out.println(number + " in binary is: " + binary);
            System.out.println(number + " in decimal is: " + decimal_to_hexa);
            System.out.println(number + " in octal is: " + octal.toUpperCase());


        // ito ang magrurun kapag string or with letters yung argument
        } else {

            // separate binary and octal variables, different argument kasi
            String binary = Integer.toBinaryString(decimal_to_hexa_w_letters);
            String octal = Integer.toOctalString(decimal_to_hexa_w_letters);

            System.out.println(number_w_letter + " in binary is: " + binary);
            System.out.println(number_w_letter + " in decimal is: " + decimal_to_hexa_w_letters);
            System.out.println(number_w_letter + " in octal is: " + octal.toUpperCase());


        }

    }

}

import java.util.Scanner;

public class stringCalculator {

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);

        //testing with user input
        String numbers = s.nextLine();
        if (numbers.length() >= 3 && numbers.substring(0,2).equals("//")){
            numbers += "\n" + s.nextLine();
        }

        System.out.println(numbers + " = " + add(numbers));
        
        s.close();

    }

    /**
     * Add method will take a string of numbers, separated by a delimiter and
     * add them together, and return the result. default delimiter to use is a comma
     * if need to use a custom delimiter, format would be
     *  //[delimiter]\n[number][delimiter][number]...
     *  may use multiple characters, or multiple delimiters.
     *  cannot handle negative numbers
     * @param numbers String of numbers to add
     * @return int result of numbers. 0 if empty String passed in
     */
    public static int add(String numbers) throws Exception
    {
        //setting default result to 0
        int result = 0;
        //setting default delimiter to ,
        String delimiter = ",";
        //setting empty negative string
        String negative = "";

        //checking if the input is using a custom delimiter
        if(numbers.length() > 3 && numbers.substring(0,2).equals("//"))
        {
            //setting the custom delimiter, can be multiple characters
            delimiter = numbers.substring(2,numbers.indexOf("\n"));

            //if the delimiter contains a , (comma)
            if (delimiter.contains(","))
            {
                //setting multiple delimiters separated by a comma
                //delimiters can be multiple characters
                String[] delimiters = delimiter.split(",");
                delimiter = "";

                //looping through the array of delimiters to create a string
                for (String del : delimiters)
                {
                    //tacking on | as an or in the regex string
                    delimiter += del + "|";
                }

                //removing the extra | from the end of the string
                delimiter = delimiter.substring(0, delimiter.length()-1).trim();

            }

            //changing string of numbers to just contain the numbers
            numbers = numbers.substring(numbers.indexOf("\n")+1);
        }

        //if the String passed through isn't empty
        if (!numbers.equals(""))
        {
            //creating an array of the numbers
            String[] numbersArray = numbers.split(delimiter);

            //looping through the array
            for ( String numberString : numbersArray )
            {
                //parsing the number to an int, trimming to ignore any new lines
                int number = Integer.parseInt(numberString.trim());

                //if the number is negative, add it to the string of negative numbers
                if(number < 0)
                {
                    negative += number + " ";
                }
                //if the number is 100 or less, add it to the result
                else if(number <= 1000)
                {
                    result += number;
                }

            }
        }

        //if there are any negative numbers, throw an exception
        if (!negative.equals(""))
        {
            throw new Exception("Negatives not allowed. " + negative);
        }

        //return the result of the numbers
        return result;
    }
}

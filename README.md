# java-quotes

Java Quotes is a proof of concept json to java parser utilizing Gson and the single responsibility principal. Reading from the native json file, it will return 
a random quote from a variety of individuals such as Tove Jansson, Miguel Ruiz, Patrick Ness, Dante Aligheri, and Paulo Coelho -- among other notables. It will also accept external json files.   

## Installation 

    Git Clone the repo onto your local enviornment from your command line/terminal, ensuring that you have JDK 1.8 and Gradle installed.
    
    ex: git clone https://github.com/MerrybyPractice/java-quotes.git 
        
## Dependencies 

    This app makes enstenive use of Gson, a google  produced library that allows Java to parse json files. 
    
    To ensure Gson is properly installed, either open the repository in the IntelliJ IDE or, if you prefer a different 
    IDE, run ./gradlew build at the root of your project from the command line. 
    
## Run the App from a CLI 

    Once the App is fully cloned and all dependencies loaded in, use ./gradlew run from root of the program in your command line.  
    
## renderQuotes class 

The renderQuotes class has three methods, as follows: 

### main(String[] args) 

   In the main method, the file path is accessed, and the two following method's are called. 
   
   The exception thrown by parseQuotes is handled. 

### parseQuotes(Path quotesPath) throws IOException 

    parseQuotes takes in the file path to the json file, and feeds it through a buffered reader. Going one line at a time, 
    it draws out the entire file and feeds it into the Gson parser - returning the file as a fully parsed Array formatted as 
    quotes. 

### shuffleQuotes(Quotes[] quotesToShuffle)

    Like the name indicates, ShuffleQuotes takes in the formatted array of quotes and generates a random number based on its length. 
    Then, it prints the formatted quote at that index to the terminal. 

## Quotes class 

Quotes has the following public properties: 

   :closed_book: String[] tags
   
   :orange_book: String author
   
   :green_book: String likes
   
   :blue_book: String text 

These properties feed into the toString method, which overloads Java's prepackaged toString to return a formatted quote.
 

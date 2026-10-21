public class stringFn {
    public static String StringCompression(String str){
        StringBuilder su = new StringBuilder("");
        for(int i=0;i<str.length();i++){
            su.append(str.charAt(i));
            Integer count = 1;
            while(i+1<str.length() && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            if(count>1){
                su.append(Integer.toString(count));
            }
        }
        return su.toString();
    }


    public static String convertFirstCapital(String str){
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==' ' && i<str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
            else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
    public static String substring(String str,int si, int ei){
        String substr = "";
        for(int i=si;i<ei;i++){
            substr += str.charAt(i);
        }
        return substr;
    }
    public static void main(String[] args) {
        String s1 = "Tony";
        String s2 = "Tony";
        String s3 = new String("Tony");

        if(s1==s2){
            System.out.println("Equal strings");
        }
        else{
            System.out.println("not equal");
        }

        if(s1==s3){
            System.out.println("Equal strings");
        }
        else{
            System.out.println("not equal");
        }

        // we cannot use == to compare the values stored in the strings as they compare if they are the same objects of the string class rather than comparing the value (same memory location)

        //when we declare a new string without use new keyword and the smae value it does not create a new object but refers to the same string as declared earlier, to make new object we have to use new keyword

        //TO COMPARE VALUES WE USE .equals() method which returns a boolean value

        System.out.println("Comparing using .equals");
        if(s1.equals(s2)){
            System.out.println("equals");
        }
        if(s1.equals(s3)){
            System.out.println("equals also");
        }


        //substrings --> made of adjacent chars of a string
        // not adjacent --> called subsequence

        String str = "Hello World";
        System.out.println(substring(str, 2, 5));

        //THERE IS A BUILT IN FN IN JAVA TO GET SUBSTR --> .substring()

        System.out.println(str.substring(2,5));


        //QS -> FOR A GIVEN SET OF STRING, PRINT THE LARGEST STRING --> LEXICOGRAPHICALLY --> means in alphabatic order ex aaabd > aaabc
        // TO ACHIEVE THIS WE USE .compareTo() function which returns an integer as output

        String su1 = "aabd";
        String su2 = "aabc";
        System.out.println(su1.compareTo(su2)); //upper and lower case are treated differently and this functions works by comparing each letter
        // 0 -> equal
        // <0 -> su1<su2
        // >0 -> su1 > su2

        //.comparetoIgnoreCase -> capital and small are treated as equal

        String fruits[] = {"apple","mango","banana"};
        String largest = fruits[0];
        for(int i=1;i<fruits.length;i++){
            if(largest.compareTo(fruits[i])<0){
                largest = fruits[i];
            }
        }
        System.out.println(largest);
        //TC of this is O(x*N) where x is the length of largest string in array and N is the size of the array


        ///Strings in memomory
        String u1 = "Tom";
        String u2 = "Tom";
        String u3 = new String("Tom");

        //interning -> when a string is present in the string pool/intern pool of the heap and when a new variable with the same string value is creteated it does not create a new string in the pool but it refers to the same old one, this is called interning -->they point to the same address

        // variables are in stack and string pool is in the heao (stack and heap are two types of memory)
        // whereas if you use new keyword it will create a new string in the pool with the same value --> reference different
        
        // drawbacks of strings --> for ex if you use a for loop to add char to a existing string --> then it keeps creating new string again and again with the same and the varibles refers to the new string now --> lot of ram is used and time complexity is almost o(n^2) as it copies a part of the string to the string to add new and time complexity to copy is proportional to the size of the string ----> refer to lecture 11 day 13 string  -> due to this reason we use string builder data type

        //string builder --> mutable(dont need to create new strings again and again)

        StringBuilder sb = new StringBuilder("");//initialed with empty string
        for(char ch='a';ch<='z';ch++){
            sb.append(ch);
        }//TC of this is O(26) where is String data type it would be O(26*n)
        System.out.println(sb);
        System.out.println(sb.length());
        //any programs with strings can be made with stringbuilder also
        sb.toString(); // this fucntion changes any data type object to string --> ex applicable with Integer but not with int,similalrly char no but Character yes

        System.out.println(convertFirstCapital("Hi i am, shredded"));


        //compress
        String io = "aaabbdddddef";
        System.out.println(StringCompression(io));

    }
}

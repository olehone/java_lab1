//Завдання No 3.
//        Реалізувати метод validateEmail(final String email), який приймає рядок і
//        повертає true, якщо рядок є валідною емейл адресою, та false - якщо ні. Не
//        використовувати regex.
public class Task3 {
    public static boolean validateEmail(final String email, final String forbiddenChars){
        if(email == null) // А якщо стрінги пуста, але не null?
            return false;
        final int addressSignIndex = email.indexOf("@"); // "@" всі такі штуки нащивається magic string. Винеси, як class level var and use link to it.
        final int dotIndex = email.indexOf("."); // + те саме що вище
        if(dotIndex<addressSignIndex||addressSignIndex<1||dotIndex==email.length()-1) // це операція в if окремий метод 
            return false;
        final String beforeAddressSing = email.substring(0, addressSignIndex); 
        final String betweenAddressAndDot = email.substring(addressSignIndex+1, dotIndex);
        final String afterDot = email.substring(dotIndex+1);

        //============================== // шо це таке ? Нафіга ? 
        if(isBadString(beforeAddressSing, forbiddenChars))  // Може просто зробити return !isBadString і все ? 
            return false; //
        if(isBadString(betweenAddressAndDot, forbiddenChars)) //
            return false; //
        return ! isBadString(afterDot, forbiddenChars); // 
    }
    public static boolean isBadString(final String chekedString, final String forbiddenChars){
        if(chekedString==null) // 
            return true;
        if(forbiddenChars ==null)
            return false;
        for(int i = 0; i < chekedString.length(); i++)
        {
            for(int j = 0; j < forbiddenChars.length(); j++)
            {
                if(chekedString.charAt(i)==forbiddenChars.charAt(j))
                    return true;
            }
        }
        return false;
    }

}

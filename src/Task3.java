//Завдання No 3.
//        Реалізувати метод validateEmail(final String email), який приймає рядок і
//        повертає true, якщо рядок є валідною емейл адресою, та false - якщо ні. Не
//        використовувати regex.
public class Task3 {
    public static boolean validateByCriteriaAndForbiddenChars(final String checkedString, final String delimiterChars, final String forbiddenChars, final boolean mustCheckCharsBeforeFirstDelimiter, final boolean mustCheckCharsAfterLastDelimiter, final int minCharsBetweenDelimiterCount, final int maxCharsBetweenDelimiterCount) {
        if (checkedString == null || checkedString.length() < minCharsBetweenDelimiterCount)
            return false;
        //if no delimiters, check only by forbidden chars
        if (delimiterChars.length() < 1)
            return !isStringHasForbiddenChars(checkedString, forbiddenChars);


        if (mustCheckCharsBeforeFirstDelimiter) {
            final int firstDelimiterIndex = checkedString.indexOf(delimiterChars.charAt(0));
            if (firstDelimiterIndex == -1)
                return false;
            final String charsBeforeFirstDelimiter = checkedString.substring(0, firstDelimiterIndex);
            //only in bad result return false
            if (isStringHasForbiddenChars(charsBeforeFirstDelimiter, forbiddenChars) || isStringHasBadLength(charsBeforeFirstDelimiter, minCharsBetweenDelimiterCount, maxCharsBetweenDelimiterCount)) {
                return false;
            }
        }
        if (mustCheckCharsAfterLastDelimiter) {
            final int lastDelimiterIndex = checkedString.indexOf(delimiterChars.charAt(delimiterChars.length() - 1));
            if (lastDelimiterIndex == -1)
                return false;
            final String charsAfterLastDelimiter = checkedString.substring(lastDelimiterIndex + 1);
            //only in bad result return false
            if (isStringHasForbiddenChars(charsAfterLastDelimiter, forbiddenChars) || isStringHasBadLength(charsAfterLastDelimiter, minCharsBetweenDelimiterCount, maxCharsBetweenDelimiterCount)) {
                return false;
            }
        }
        // if there is only one delimiter, we simply return true
        // otherwise we check the lines between the delimiters in a loop
        if (delimiterChars.length() == 1)
            return true;

        // take a temporary string
        // cut the part between two delimiter characters from it
        // check
        // cut the temporary string without this part
        String currentCheckedString;
        String tmpString = checkedString;
        for (int i = 1; i < delimiterChars.length(); i++) {
            final int firstIndex = tmpString.indexOf(delimiterChars.charAt(i - 1));
            final int secondIndex = tmpString.indexOf(delimiterChars.charAt(i));
            if (isBadIndexes(firstIndex, secondIndex))
                return false;
            currentCheckedString = tmpString.substring(firstIndex + 1, secondIndex);
            //only in bad result return false
            if (isStringHasForbiddenChars(currentCheckedString, forbiddenChars) || isStringHasBadLength(currentCheckedString, minCharsBetweenDelimiterCount, maxCharsBetweenDelimiterCount)) {
                return false;
            }
            tmpString = tmpString.substring(secondIndex + 1);
        }

        //if all checks complete
        return true;
    }

    public static boolean validateByCriteriaAndAllowedChars(final String checkedString, final String delimiterChars, final String allowedChars, final boolean mustCheckCharsBeforeFirstDelimiter, final boolean mustCheckCharsAfterLastDelimiter, final int minCharsBetweenDelimiterCount, final int maxCharsBetweenDelimiterCount) {
        if (checkedString == null || checkedString.length() < minCharsBetweenDelimiterCount)
            return false;
        //if no delimiters, check only by forbidden chars
        if (delimiterChars.length() < 1)
            return isStringHasOnlyAllowedChars(checkedString, allowedChars);

        if (mustCheckCharsBeforeFirstDelimiter) {
            final int firstDelimiterIndex = checkedString.indexOf(delimiterChars.charAt(0));
            if (firstDelimiterIndex == -1)
                return false;
            final String charsBeforeFirstDelimiter = checkedString.substring(0, firstDelimiterIndex);
            //only in bad result return false
            if (!isStringHasOnlyAllowedChars(charsBeforeFirstDelimiter, allowedChars) || isStringHasBadLength(charsBeforeFirstDelimiter, minCharsBetweenDelimiterCount, maxCharsBetweenDelimiterCount)) {
                return false;
            }
        }

        if (mustCheckCharsAfterLastDelimiter) {
            final int lastDelimiterIndex = checkedString.indexOf(delimiterChars.charAt(delimiterChars.length() - 1));
            if (lastDelimiterIndex == -1)
                return false;
            final String charsAfterLastDelimiter = checkedString.substring(lastDelimiterIndex + 1);
            //only in bad result return false
            if (!isStringHasOnlyAllowedChars(charsAfterLastDelimiter, allowedChars) || isStringHasBadLength(charsAfterLastDelimiter, minCharsBetweenDelimiterCount, maxCharsBetweenDelimiterCount)) {
                return false;
            }
        }
        // if there is only one delimiter, we simply return true
        // otherwise we check the lines between the delimiters in a loop
        if (delimiterChars.length() == 1)
            return true;

        // take a temporary string
        // cut the part between two delimiter characters from it
        // check
        // cut the temporary string without this part
        String currentCheckedString;
        String tmpString = checkedString;
        for (int i = 1; i < delimiterChars.length(); i++) {
            final int firstIndex = tmpString.indexOf(delimiterChars.charAt(i - 1));
            final int secondIndex = tmpString.indexOf(delimiterChars.charAt(i));
            if (isBadIndexes(firstIndex, secondIndex))
                return false;
            currentCheckedString = tmpString.substring(firstIndex + 1, secondIndex);
            //only in bad result return false
            if (!isStringHasOnlyAllowedChars(currentCheckedString, allowedChars) || isStringHasBadLength(currentCheckedString, minCharsBetweenDelimiterCount, maxCharsBetweenDelimiterCount)) {
                return false;
            }
            tmpString = tmpString.substring(secondIndex + 1);
        }

        //if all checks complete
        return true;
    }

    public static boolean validatePhoneNumber(final String phoneNumber) {
        final String numbers = "0123456789";
        if(phoneNumber.charAt(0)!='+')
            return false;
        return validateByCriteriaAndAllowedChars(phoneNumber, "+", numbers, false, true,12,12 );
    }

    public static boolean validateEmail(final String email) {
        final String forbiddenChars = "!@#$%^&*()_+?><\"'|{}[]`/*-+. ,";
        final int minCountOfCharBetweenDelimiterChars = 1;
        final int maxCountOfCharBetweenDelimiterChars = 15;
        return validateByCriteriaAndForbiddenChars(email, "@.", forbiddenChars, true, true, minCountOfCharBetweenDelimiterChars, maxCountOfCharBetweenDelimiterChars);
    }

    public static boolean isBadIndexes(final int firstIndex, final int secondIndex) {
        if (firstIndex > secondIndex)
            return true;
        if (firstIndex == -1)
            return true;
        if (secondIndex == -1)
            return true;
        return false;
    }

    public static boolean isStringHasBadLength(final String chekedString, final int minCharCount, final int maxCharCount) {
        return chekedString.length() > maxCharCount || chekedString.length() < minCharCount;
    }

    public static boolean isStringHasForbiddenChars(final String chekedString, final String forbiddenChars) {
        if (chekedString == null)
            return true;
        if (forbiddenChars == null)
            return false;
        for (int i = 0; i < chekedString.length(); i++) {
            for (int j = 0; j < forbiddenChars.length(); j++) {
                if (chekedString.charAt(i) == forbiddenChars.charAt(j))
                    return true;
            }
        }
        return false;
    }

    public static boolean isStringHasOnlyAllowedChars(final String chekedString, final String allowedChars) {
        if (chekedString == null)
            return false;
        if (allowedChars == null)
            return false;
        boolean isBadChar;
        for (int i = 0; i < chekedString.length(); i++) {
            isBadChar = true;
            for (int j = 0; j < allowedChars.length(); j++) {
                if (chekedString.charAt(i) == allowedChars.charAt(j)) {
                    isBadChar = false;
                    break;
                }
            }
            if (isBadChar) {
                return false;
            }

        }
        return true;
    }

}

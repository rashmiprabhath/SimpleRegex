package it.supunrashmi.simpleregx;

public class SimpleRegX {

    private static final char STRING_WILDCARD = '*';
    private static final char CHARACTER_WILDCARD = '?';

    public boolean isAMatch( String pattern, String string )
    {
        boolean[][] matchArray = new boolean[pattern.length()][string.length()];
        populateMatchArray(pattern, string, 0, 0, matchArray);
        return matchArray[pattern.length()-1][string.length()-1];
    }

    public void populateMatchArray( String pattern, String string, int patternIndex, int stringIndex, boolean[][] matchArray){
        if (patternIndex < pattern.length() && stringIndex < string.length()){
            if ( pattern.charAt(patternIndex) == STRING_WILDCARD ){
                matchArray[patternIndex][stringIndex] = true;
                populateMatchArray(pattern, string, patternIndex, stringIndex+1, matchArray);
                populateMatchArray(pattern, string, patternIndex+1, stringIndex, matchArray);

            }else if( pattern.charAt(patternIndex) == CHARACTER_WILDCARD ){
                matchArray[patternIndex][stringIndex] = true;
                populateMatchArray(pattern, string, patternIndex+1, stringIndex+1, matchArray);
            }else if (pattern.charAt(patternIndex) == string.charAt(stringIndex))
            {
                matchArray[patternIndex][stringIndex] = true;
                populateMatchArray(pattern, string, patternIndex+1, stringIndex+1, matchArray);
            }
        }
    }
}

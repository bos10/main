package seedu.address.model.person;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.commons.core.index.Index;

/**
 * Represents a Cell's coordinate object in the map.
 * Guarantees: immutable; is valid as declared in {@link #isValidCoordinate(String)}
 */
public class Coordinate {

    private static final String SPECIAL_CHARACTERS = "!#$%&'*+/=?`{|}~^.-";
    public static final String MESSAGE_CONSTRAINTS = "Coordinates should be of the format row-column "
            + "and adhere to the following constraints:\n"
            + "1. The row should only contain alphabetical characters, excluding "
            + "the parentheses, (" + SPECIAL_CHARACTERS + "). "
            + "The alphabetical characters must be between [a-j] inclusive and be in lowercase.\n"
            + "2. This is followed by a column number. "
            + "The column number must be between [1-10] inclusive.\n";

    // alphanumeric and special characters
    private static final String ROW_PART_REGEX = "^[a-j]{1}";
    private static final String COL_PART_REGEX = "(10|[1-9])$";

    public static final String VALIDATION_REGEX = ROW_PART_REGEX + COL_PART_REGEX;

    public final String value;
<<<<<<< HEAD
    public final Index rowValue;
    public final Index colValue;
=======
    public final String row;
    public final String col;
>>>>>>> b07c42eff41dcf6420d95a98a13f78eae165e71e

    /**
     * Constructs an {@code Coordinate}.
     *
     * @param coordinate A valid coordinate.
     */
    public Coordinate(String coordinate) {
        requireNonNull(coordinate);
        checkArgument(isValidCoordinate(coordinate), MESSAGE_CONSTRAINTS);
        value = coordinate;

        // use regex to extract alphabetical row and numeric col
        Pattern rowRegex = Pattern.compile(ROW_PART_REGEX);
        Pattern colRegex = Pattern.compile(COL_PART_REGEX);

        Matcher rowMatch = rowRegex.matcher(value);
        Matcher colMatch = colRegex.matcher(value);

<<<<<<< HEAD
        String row = rowMatch.group(0);
        String col = colMatch.group(0);

        int rowNum = convertAlphabetToNumber(row);
        int colNum = Integer.parseInt(col);

        this.rowValue = Index.fromZeroBased(rowNum);
        this.colValue = Index.fromZeroBased(colNum);
    }

    /**
     * Converts a string alphabet to its numerical equivalent.
     *
     * @param alphabet
     * @return integer offset from 'a', zero-based
     */
    private int convertAlphabetToNumber(String alphabet) {
        char alphabetChar = alphabet.charAt(0);
        return alphabetChar - 'a';
    }

    /**
     * Returns Index for rowNum
     */
    public Index getRowValue() {
        return this.rowValue;
    }

    /**
     * Return Index for colNum
     */
    public Index getColValue() {
        return this.colValue;
=======
        this.row = rowMatch.group(0);
        this.col = colMatch.group(0);

>>>>>>> b07c42eff41dcf6420d95a98a13f78eae165e71e
    }

    /**
     * Returns if a given string is a valid coordinate.
     */
    public static boolean isValidCoordinate(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Coordinate // instanceof handles nulls
                && value.equals(((Coordinate) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}

package data.info;

import SMExceptions.naming_exceptions.*;
import cryptography.Cryptography;
import data.Student;
import utilities.StringUtilities;

abstract public class Info extends StringUtilities {

    /**
     * An Array to Store The Information.
     *
     * It is basically an Array of Boxed characters which stores all the
     * Characters of the NameBuilder in Boxed form.
     */
    private CharSequence sequence;

    /**
     * A variable to store Encryption key.
     *
     * This key is used for encryption and decryption of NameBuilder.
     */
    private final long E_KEY = 1234567890L;


    /**
     * Default Constructor for NameBuilder.
     */
    Info() {
        sequence = "Unknown";
    }

    /**
     *
     * The work of this method is to store the NameBuilder after Validation.
     *
     * @param chars contains the validated NameBuilder.
     *
     * @throws NumberAndSymbolsFoundException if the Entered NameBuilder contains both number and symbols.
     * @throws SymbolsFoundException if the Entered NameBuilder contains one or more symbols.
     * @throws NothingFoundException if the entered NameBuilder is Null or Empty.
     * @throws NumbersFoundException if the Entered NameBuilder contains one or more numbers.
     * @throws IllegalUseOfPunctuation if the Entered NameBuilder contains wrong punctuation techniques.
     */
    public void set(CharSequence chars) throws WrongInputException {
        if(validate(chars))
            this.sequence = Cryptography.encrypt(chars, E_KEY);
    }

    /**
     *
     * The work of this method is to Validate the NameBuilder entered by user.
     *
     * @param chars contains the value to be validated.
     *
     * @return true, only if the @param chars is completely validated.
     *
     * @throws NumberAndSymbolsFoundException if the Entered NameBuilder contains both number and symbols.
     * @throws SymbolsFoundException if the Entered NameBuilder contains one or more symbols.
     * @throws NothingFoundException if the entered NameBuilder is Null or Empty.
     * @throws NumbersFoundException if the Entered NameBuilder contains one or more numbers.
     * @throws IllegalUseOfPunctuation if the Entered NameBuilder contains wrong punctuation techniques.
     */
    abstract protected boolean validate(CharSequence chars) throws WrongInputException;

    /**
     *
     * The work of this method is to return the assigned/stored NameBuilder in decrypted(original/readable) form.
     *
     * @return this.sequence (after converting it to String.)
     * @throws NullPointerException if there is no NameBuilder assigned.
     */
    public String get() throws NullPointerException {
        return Cryptography.decrypt(sequence, E_KEY);
    }

    /**
     *
     * The work of this method is to return sequence in Encrypted form.
     *
     * @return sequence, in Encrypted form.
     */
    public final String getEncrypted() {
        return this.sequence.toString();
    }

    public void generate(Student stu) {
    }
}

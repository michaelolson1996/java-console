import java.util.ArrayList;
import java.util.List;

public class Encryptor {
    private Type encryptionType;
    private String message;
    private String key;
    private int shiftCount;
    private int keyCount = 0;
    private String[][] cipherArr;
    private String encryptedMessage = "";
    private String keyString = "";

    // reconstruct code to get the arrays from class as opposed to main function //

//    public String[][] getCipherArr() {
//        return cipherArr;
//    }
//
//    public void setCipherArr(String[][] cipherArr) {
//        this.cipherArr = cipherArr;
//    }
//
//    public String getEncryptedMessage() {
//        return encryptedMessage;
//    }
//
//    public void setEncryptedMessage(String encryptedMessage) {
//        this.encryptedMessage = encryptedMessage;
//    }


    public Encryptor() {}

    public Encryptor(Type encryptionType, String message, String key) {
        setEncryptionType(encryptionType);
        setMessage(message);
        setKey(key);
    }

    public Encryptor(Type encryptionType, String message, int shiftCount) {
        setEncryptionType(encryptionType);
        setMessage(message);
        setShiftCount(shiftCount);
    }

    public Type getEncryptionType() {
        return encryptionType;
    }

    public void setEncryptionType(Type encryptionType) {
        this.encryptionType = encryptionType;
    }

//    public String getMessage() { return message; }

    public void setMessage(String message) {
        this.message = message;
    }

//    public String getKey() { return key; }

    public void setKey(String key) {
        this.key = key;
    }

//    public int getShiftCount() { return shiftCount; }

    public void setShiftCount(int shiftCount) { this.shiftCount = shiftCount; }

    public void generateCaesarEncryption(String[][] cipherArr) {
        int reducedShiftCount = this.shiftCount % 26;
        if (reducedShiftCount == 0) {
            this.encryptedMessage = message;
        } else {
            for (char ch : this.message.toCharArray()) {
                if (String.valueOf(ch).toLowerCase().matches("[a-z]")) {
                    for (int j = 0; j < cipherArr.length; j++) {
                        if (cipherArr[j][0].equals(String.valueOf(ch))) {
                            int reduceShift = (j + reducedShiftCount) % 26;
                            this.encryptedMessage += cipherArr[reduceShift][0];
                        } else {
                            continue;
                        }
                    }
                } else {
                    this.encryptedMessage += String.valueOf(ch);
                }
            }
        }
    }

    public void generateViginereEncryption(String[][] cipherArr) {
        int messageLength = this.message.length();
        int keyLength = this.key.length();
        List messageIndex = new ArrayList();
        int keyLengthCount = 0;

        for (int i = 0; i < messageLength; i++) {
            if (i % keyLength == 0 || i == 0)
                keyLengthCount = 0;
            else
                keyLengthCount += 1;
            this.keyString += String.valueOf(this.key.charAt(keyLengthCount));
        }

        for (char ch: this.message.toCharArray()) {
            if (String.valueOf(ch).toLowerCase().matches("[a-z]")) {
                for (int j = 0; j < cipherArr[0].length; j++) {
                    if (String.valueOf(ch).toLowerCase().equals(cipherArr[0][j])) {
                        for (int i = 0; i < cipherArr[0].length; i++) {
                            if (String.valueOf(this.keyString.charAt(this.keyCount))
                                    .toLowerCase()
                                    .equals(cipherArr[i][0]))
                                this.encryptedMessage += cipherArr[i][j];
                        }
                    }
                }
            } else
                this.encryptedMessage += ch;
            this.keyCount += 1;
        }
    }

    @Override
    public String toString() {
        if (this.encryptionType == Type.CAESAR)
            return "Encryption Type: " + this.encryptionType + "\nLetters Shifted: " + this.shiftCount + "\nMessage: " + this.message + "\nEncrypted Message: " + this.encryptedMessage + "\n";
        else if (this.encryptionType == Type.VIGINERE)
            return "\nEncryption Type : " + this.encryptionType + "\nKey : " + this.key + "\nMessage : " + this.message + "\nEncrypted Word : " + this.encryptedMessage;
        else
            return "message: " + this.message + "\nEncryption Type: " + this.encryptionType + "\nKey: " + this.key + "\n";
    }
}
public class Strings {
    private char[] str;
    private int SIZE = 10;
    private int top = 0;

    public Strings() {
        this.str = new char[this.SIZE];
    }
    
    public Strings(String s) {
        if(s == null) {
            this.str = new char[this.SIZE];
            return;
        }

        this.SIZE = s.length() + 1;
        this.str = new char[this.SIZE];

        for (; this.top < s.length(); this.top++) {
            this.str[this.top] = s.charAt(this.top);
        }
    }

    public void append(String s) {
        if(s == null) {
            return;
        }

        for(int i = 0; i < s.length(); i++, top++) {
            if(this.top >= this.SIZE) {
                this.reallocateSize();
            }
            this.str[this.top] = s.charAt(i);
        }
    }

    public int get(int index) throws StringIndexOutOfBoundsException {
        if(index > this.top || index < 0) {
            throw new StringIndexOutOfBoundsException();
        }
        return this.str[index];
    }

    public char[] toCharArray() {
        char[] charArray = new char[this.top];
        for(int i = 0; i < this.top; i++) {
            charArray[i] = this.str[i];
        }
        return charArray;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < this.top; i++) {
            builder.append(this.str[i]);
        }
        return builder.toString();
    }

    private void reallocateSize() {
        this.SIZE *= 2;

        char[] temp = this.str;
        
        try {
            this.str = new char[this.SIZE];
        } catch (OutOfMemoryError e) {
            throw new OutOfMemoryError("Cannot add more element");
        }
        int prevTop = top;
        this.top = 0;

        // Copy elements from previous array into this new increased size array
        for (; this.top < prevTop; this.top++) {
            this.str[this.top] = temp[this.top];
        };
    }
}
public class Verem {

    private String string;

    public Verem(String string){
        this.string = string;
    }

    public int hossz() {
        return this.string.length();
    }

    public boolean uresE() {
        return this.string.isEmpty();
    }

    public String kivetel() {
        if(this.uresE()) {
            return null;
        }
        String utolso = Character.toString(this.string.charAt(this.string.length() - 1));
        this.string = this.string.substring(0, this.string.length() - 1);

        return utolso;
    }

    public void hozzatesz(String karakter) {
        this.string = this.string.concat(karakter);
    }

    public Verem say() {
        System.out.println(this.string);
        return this;
    }

}

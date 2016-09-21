public class Ellenorzo {

    private Verem verem;
    private Verem seged;

    public Ellenorzo(Verem verem) {
        this.verem = verem;
        this.seged = new Verem("");
    }

    public boolean helyesE() {
        if(this.verem.uresE()) {
            return true;
        }
        int eredetiHossz = this.verem.hossz();
        for (int i = 0; i < eredetiHossz; i++) {
            String utolso = this.verem.kivetel();
            if (utolso.equals(")")) {
                this.seged.hozzatesz(utolso);
            } else if (utolso.equals("(")) {
                if (this.seged.uresE()) {
                    return false;
                }

                String kivetelUtolso = this.seged.kivetel();

                if (!kivetelUtolso.equals(")") && utolso.equals("(")) {
                    this.seged.hozzatesz(kivetelUtolso);
                }

            }
        }
        return this.verem.uresE() && this.seged.uresE();
    }

}
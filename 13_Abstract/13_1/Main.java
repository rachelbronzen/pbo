public class Main {
    public static void main(String[] args) {
        MakhlukHidup manusia = new Manusia();
        MakhlukHidup hewan = new Hewan();
        MakhlukHidup tumbuhan = new Tumbuhan();

        manusia.info();
        manusia.ciri();

        System.out.println();

        hewan.info();
        hewan.ciri();
        System.out.println();

        tumbuhan.info();
        tumbuhan.ciri();
    }
}

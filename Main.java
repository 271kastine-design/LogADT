public class Main
{
    public static void main(String[] args)
    {
        ArrayLog<String> log = new ArrayLog<>("Demo");
        log.add("First entry");
        System.out.println(log);
    }
}

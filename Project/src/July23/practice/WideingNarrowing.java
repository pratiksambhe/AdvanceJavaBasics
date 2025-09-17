package July23.practice;

public class WideingNarrowing {
    //Widening
    //byte->short->char->int->long->float->double
    byte a=10;
    short b=a;
    //char exception

    //narrowing
    //double->float->long->int->char->short->byte
    char a1='a';
    short b1=(short) a;
}

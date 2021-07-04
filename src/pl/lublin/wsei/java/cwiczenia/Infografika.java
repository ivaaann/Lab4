package pl.lublin.wsei.java.cwiczenia;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Infografika
{

    String tytul;
    String Szerokosc;
    String Wysokosc;
    String adresGrafiki;
    String adresMiniaturki;
    String adresStrony;

    public Infografika(String text)
    {

        Pattern pat = Pattern.compile("<title><!\\[CDATA\\[(.*)\\]\\]");
        Matcher m = pat.matcher(text);

        if (m.find())
            tytul = m.group(1);
        else
            tytul = "";


        pat = Pattern.compile("<link>(.*)</link>");
        m = pat.matcher(text);

        if (m.find())
            adresStrony = m.group(1);
        else
            adresStrony = "";


        pat = Pattern.compile("height=\"(.*)\"/");
        m = pat.matcher(text);

        if (m.find())
            Wysokosc = m.group(1);
        else
            Wysokosc = "";



        pat = Pattern.compile("width=\"(.*)\" height");
        m = pat.matcher(text);

        if (m.find())
            Szerokosc = m.group(1);
        else
            Szerokosc = "";


        // <media:content url="(.*)" t"
        pat = Pattern.compile("<media:content url=\"(.*)\" t");
        m = pat.matcher(text);

        if (m.find())
            adresGrafiki = m.group(1);
        else
            adresGrafiki = "";


        // <media:thumbnail url="(.*)"
        pat = Pattern.compile("<media:thumbnail url=\"(.*)\"");
        m = pat.matcher(text);

        if (m.find())
            adresMiniaturki = m.group(1);
        else
            adresMiniaturki = "";


    }


    public void print()
    {
        System.out.print("\nInfografika: ");
        System.out.print("\n\tTytul: " + tytul);
        System.out.print("\n\tAdres strony: " + adresStrony);
        System.out.print("\n\tAdres grafiki: " + adresGrafiki);
        System.out.print("\n\tAdres miniaturki: " + adresMiniaturki);
        System.out.print("\n\tRozmiary: " + Szerokosc + "x" + Wysokosc);
    }
}

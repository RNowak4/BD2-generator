import encje.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Generator {
    private List<Adres> adresy = new ArrayList<>();
    private List<Dyrektor> dyrektorzy = new ArrayList<>();
    private List<Kierownik> kierownicy = new ArrayList<>();
    private List<Szeregowy> szeregowi = new ArrayList<>();
    private List<Marka> marki = new ArrayList<>();
    private List<KategoriaPojazdu> kategoriePojazdu = new ArrayList<>();
    private List<Wypozyczalnia> wypozyczalnie = new ArrayList<>();
    private List<Serwis> serwisy = new ArrayList<>();
    private List<Magazyn> magazyny = new ArrayList<>();
    private List<Samochod> samochody = new ArrayList<>();
    private List<TypZgloszenia> typyZgloszen = new ArrayList<>();
    private List<Zgloszenie> zgloszenia = new ArrayList<>();
    private List<Czynnosc> czynnosci = new ArrayList<>();
    private List<KontoPracownika> kontaPraciwnikow = new ArrayList<>();
    private List<KlientIndywidualny> klienciIndywidualni = new ArrayList<>();
    private List<KlientInstytucjonalny> klienciInstytucjonalni = new ArrayList<>();
    private List<KontoKlienta> kontaKlientow = new ArrayList<>();

    private static String[] miasta = {"Warszawa", "Poznan", "Gdansk", "Rzeszow", "Krakow"};
    private static String[] poczt = {"11-111", "22-222", "33-333", "44-444", "55-555"};
    private static String[] ulice = {"kwiatowa", "mostowa", "mszczonowsa", "krolewska", "palacowa"};

    public void generate() {
        generateAddresses(3500);
        generateWorkers(0, 1000);
        generujPlacowki(0, 1001, 150);
        generujMarki();
        generujKategoriePojazdu();
        generujSamochody();
        generujCzynnosci(1500);
        generujTypZgloszenia();
        generujZgloszenia(1500);
        generujMaterialy(3000);
        generujKontaPracownikow();
        generujKlientow(150, 2000, 0);
        generujKontaKlientow();
    }

    private List<Adres> generateAddresses(final int max) {
        int counter = 0;

        int i = 0;
        for (String miasto : miasta) {
            for (String ulica : ulice) {
                for (int j = 0; j < 150; j++) {
                    Adres adres = new Adres();
                    adres.setMiasto(miasto);
                    adres.setUlica(ulica);
                    adres.setNrDomu("" + j + 1);
                    adres.setKodPocztowy(poczt[i]);

                    adresy.add(adres);
                    if (++counter >= max)
                        return adresy;
                }
            }
            ++i;
        }

        return adresy;
    }

    private static String[] names = {"Radek", "Wojtek", "Asia", "Piotrek", "Daniel", "Kasia", "Ewelina", "Marek", "Weronika", "Adam", "Emmanuel", "Wiktor"};
    private static String[] surnames = {"Nowak", "Przechodzen", "Wojcieszonek", "Ganicz", "Szymanski", "Wieckowski", "Daszczuk", "Musial", "Niemusial"};

    private void generateWorkers(final int startAddress, final int stopAddress) {
        final int totalNum = stopAddress - startAddress;
        String pesel = "11111122556";

        int counter = 0;
        for (int i = 0; i < 1; i++) {
            for (String name : names) {
                for (String surname : surnames) {
                    pesel = "" + (Long.valueOf(pesel) + 1);

                    Dyrektor dyrektor = new Dyrektor();
                    dyrektor.setImie(name);
                    dyrektor.setNazwisko(surname);
                    dyrektor.setPesel(pesel);
                    dyrektor.setAdres(adresy.get(startAddress + counter));

                    dyrektorzy.add(dyrektor);
                    counter++;
                    if (counter >= totalNum)
                        return;
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            for (String name : names) {
                for (String surname : surnames) {
                    pesel = "" + (Long.valueOf(pesel) + 1);

                    Kierownik kierownik = new Kierownik();
                    kierownik.setImie(name);
                    kierownik.setNazwisko(surname);
                    kierownik.setPesel(pesel);
                    kierownik.setAdres(adresy.get(startAddress + counter));

                    kierownicy.add(kierownik);
                    counter++;
                    if (counter >= totalNum)
                        return;
                }
            }
        }

        for (int i = 0; i < 7; i++) {
            for (String name : names) {
                for (String surname : surnames) {
                    pesel = "" + (Long.valueOf(pesel) + 1);

                    Szeregowy szeregowy = new Szeregowy();
                    szeregowy.setImie(name);
                    szeregowy.setNazwisko(surname);
                    szeregowy.setPesel(pesel);
                    szeregowy.setAdres(adresy.get(startAddress + counter));

                    szeregowi.add(szeregowy);
                    counter++;
                    if (counter >= totalNum)
                        return;
                }
            }
        }
    }

    private void generujPlacowki(final int startPrac, final int startAdres, final int wypNum) {
        int i = 0;
        for (int j = 0; j < dyrektorzy.size(); j++, i++) {
            Wypozyczalnia wypozyczalnia = new Wypozyczalnia();
            wypozyczalnia.setAdres(adresy.get(startAdres + i));
            wypozyczalnia.setPracownik(szeregowi.get(startPrac + i));
            wypozyczalnia.setDyrektor(dyrektorzy.get(startPrac + i));

            wypozyczalnie.add(wypozyczalnia);
        }

        for (int j = 0; j < wypNum / 2; j++, i++) {
            Magazyn magazyn = new Magazyn();
            magazyn.setAdres(adresy.get(startAdres + i));
            magazyn.setPracownik(kierownicy.get(startPrac + i));
            magazyn.setWypozyczalnia(wypozyczalnie.get(j));

            magazyny.add(magazyn);
        }

        for (int j = wypNum / 2 + 1; j < wypozyczalnie.size(); j++, i++) {
            Serwis serwis = new Serwis();
            serwis.setAdres(adresy.get(startAdres + i));
            serwis.setPracownik(kierownicy.get(startPrac + i));
            serwis.setWypozyczalnia(wypozyczalnie.get(j));

            serwisy.add(serwis);
        }
    }

    private static String[] markiNazwy = {"Audi", "Mustang", "Toyota", "Suzuki", "Maserati", "Volkswagen", "Honda", "Nissan"};

    private void generujMarki() {
        for (String marka : markiNazwy) {
            Marka newMarka = new Marka();
            newMarka.setNazwa(marka);

            marki.add(newMarka);
        }
    }

    private static String[] kategorie = {"Turystyczne", "Sportowe", "Sportowo-Turystyczne", "Offroad"};

    private void generujKategoriePojazdu() {
        for (String KategoriaPojazdu : kategorie) {
            encje.KategoriaPojazdu kategoriaPojazdu = new KategoriaPojazdu();
            kategoriaPojazdu.setNazwa(KategoriaPojazdu);

            kategoriePojazdu.add(kategoriaPojazdu);
        }
    }

    private static String[] kolory = {"zielony", "niebieski", "czerwony", "czarny", "zolty", "rozowy", "ciemny niebieski", "blekitny"};
    private static String[] modele = {"Model_1", "model_2", "model_3"};

    private void generujSamochody() {
        Random random = new Random();
        for (Marka marka : marki) {
            for (KategoriaPojazdu kategoriaPojazdu : kategoriePojazdu) {
                for (Wypozyczalnia wypozyczalnia : wypozyczalnie) {
                    for (String kolor : kolory) {
                        for (String model : modele) {

                            Samochod samochod = new Samochod();
                            samochod.setKolor(kolor);
                            samochod.setWypozyczalnia(wypozyczalnia);
                            samochod.setKategoriaPojazdu(kategoriaPojazdu);
                            samochod.setMarka(marka);
                            samochod.setModel(model);
                            samochod.setPrzebieg("" + Math.abs(random.nextLong() % 300000));
                            samochod.setRokProdukcji("" + Math.abs(random.nextLong() % 25) + 1990);

                            samochody.add(samochod);
                        }
                    }
                }
            }
        }
    }

    private static String[] typyZgloszenStr = {"zgloszenie_1", "zgloszenie_2", "zgloszenie_3", "zgloszenie_4"};

    private void generujTypZgloszenia() {
        for (String nazwaZgloszenia : typyZgloszenStr) {
            TypZgloszenia zgloszenie = new TypZgloszenia();
            zgloszenie.setNazwa(nazwaZgloszenia);

            typyZgloszen.add(zgloszenie);
        }
    }

    private void generujZgloszenia(final int max) {
        int counter = 0;

        for (Samochod samochod : samochody) {
            for (TypZgloszenia typZgloszenia : typyZgloszen) {
                Zgloszenie zgloszenie = new Zgloszenie();
                zgloszenie.setCzyPoJezdzieProbnej(false);
                zgloszenie.setOpisStanuSamochodu("Opis stanu samochodu...");
                zgloszenie.setParametrySamochodu("Parametry...");
                zgloszenie.setPriorytet(1);
                zgloszenie.setStanCzystosci(1);
                zgloszenie.setSamochod(samochod);
                zgloszenie.setTypZgloszenia(typZgloszenia);

                zgloszenia.add(zgloszenie);
                ++counter;
                if (counter >= max)
                    return;
            }
        }
    }

    private void generujCzynnosci(final int max) {
        Date date = new Date();

        int counter = 0;
        for (Szeregowy szeregowy : szeregowi) {
            for (Zgloszenie zgloszenie : zgloszenia) {
                Czynnosc czynnosc = new Czynnosc();
                czynnosc.setDate(date);
                czynnosc.setDescription("Opis Czynnosci");
                czynnosc.setPracownik(szeregowy);
                czynnosc.setZgloszenie(zgloszenie);

                czynnosci.add(czynnosc);
                if (++counter >= max)
                    return;
            }
        }
    }

    private void generujMaterialy(final int max) {
        int counter = 0;

        for (Szeregowy szeregowy : szeregowi) {
            for (Czynnosc czynnosc : czynnosci) {
                for (Magazyn magazyn : magazyny) {
                    Material material = new Material();
                    material.setCzyDoOdbioru(true);
                    material.setCzynnosc(czynnosc);
                    material.setNazwa("Nazwa Materialu");
                    material.setPlacowka(magazyn);
                    material.setPracownik(szeregowy);

                    magazyny.add(magazyn);
                    if (++counter >= max)
                        return;

                }
            }
        }
    }

    private void generujKontaPracownikow() {
        final String login = "pracownik";
        final Date date = new Date();

        int counter = 0;
        for (Dyrektor dyrektor : dyrektorzy) {
            KontoPracownika kontoPracownika = new KontoPracownika();
            kontoPracownika.setPracownik(dyrektor);
            kontoPracownika.setIdUprawnien(1);
            kontoPracownika.setLogin(login + " " + counter++);
            kontoPracownika.setDataZmianyHasla(date);

            kontaPraciwnikow.add(kontoPracownika);
        }

        for (Kierownik kierownik : kierownicy) {
            KontoPracownika kontoPracownika = new KontoPracownika();
            kontoPracownika.setPracownik(kierownik);
            kontoPracownika.setIdUprawnien(2);
            kontoPracownika.setLogin(login + " " + counter++);
            kontoPracownika.setDataZmianyHasla(date);

            kontaPraciwnikow.add(kontoPracownika);
        }

        for (Szeregowy kiszeregowyrownik : szeregowi) {
            KontoPracownika kontoPracownika = new KontoPracownika();
            kontoPracownika.setPracownik(kiszeregowyrownik);
            kontoPracownika.setIdUprawnien(3);
            kontoPracownika.setLogin(login + " " + counter++);
            kontoPracownika.setDataZmianyHasla(date);

            kontaPraciwnikow.add(kontoPracownika);
        }
    }

    private void generujKlientow(final int maxInstyt, final int maxInd, final int startAdres) {
        int counter = 0;

        final String nazwaInstytucji = "Nazwa instytucji";
        long NIP = 0;
        for (Szeregowy szeregowy : szeregowi) {
            KlientInstytucjonalny klientInstytucjonalny = new KlientInstytucjonalny();
            klientInstytucjonalny.setNazwa(nazwaInstytucji + " " + NIP);
            klientInstytucjonalny.setNIP("" + NIP++);
            klientInstytucjonalny.setOpiekun(szeregowy);
            klientInstytucjonalny.setAdres(adresy.get((startAdres + counter++)));
            klienciInstytucjonalni.add(klientInstytucjonalny);

            if (counter >= maxInstyt)
                break;
        }

        while (true) {
            for (String name : names) {
                for (String surname : surnames) {
                    KlientIndywidualny klientIndywidualny = new KlientIndywidualny();
                    klientIndywidualny.setAdres(adresy.get(startAdres + counter++));
                    klientIndywidualny.setImie(name);
                    klientIndywidualny.setNazwisko(surname);
                    klienciIndywidualni.add(klientIndywidualny);

                    if ((counter - maxInstyt) >= maxInd)
                        return;
                }
            }
        }
    }

    private void generujKontaKlientow() {
        final String login = "Login";

        int counter = 0;
        for (KlientIndywidualny klientIndywidualny : klienciIndywidualni) {
            KontoKlienta kontoKlienta = new KontoKlienta();
            kontoKlienta.setLogin(login + " " + counter++);
        }

        for (KlientInstytucjonalny klientInstytucjonalny : klienciInstytucjonalni) {
            KontoKlienta kontoKlienta = new KontoKlienta();
            kontoKlienta.setLogin(login + " " + counter++);
        }
    }
}

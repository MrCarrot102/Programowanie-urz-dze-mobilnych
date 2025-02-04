package com.example.pum_lista2;

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
//Fragment to komponent interfejsu użytkownika w Androidzie, który reprezentuje część interfejsu aplikacji. Fragment działa jako część Activity i pozwala na tworzenie bardziej elastycznego, dynamicznego interfejsu. Można je dodawać, usuwać lub zastępować w obrębie Activity podczas działania aplikacji, co ułatwia obsługę różnych układów dla różnych urządzeń (np. telefonów i tabletów) oraz możliwość wielokrotnego używania tych samych elementów interfejsu w różnych częściach aplikacji.
//
//W Androidzie fragmenty mogą być używane do:
//
//    Zarządzania złożonym interfejsem, gdzie każda część ekranu to osobny fragment.
//    Ułatwienia nawigacji między różnymi sekcjami aplikacji.
//    Obsługi dynamicznych zmian w interfejsie, np. na różnych rozdzielczościach i orientacjach ekranów.
//
//6 głównych metod w cyklu życia fragmentu:
//
//Fragment ma wiele metod cyklu życia, które pozwalają na kontrolowanie jego zachowania i stanu. Sześć z najważniejszych to:
//3 "konstruktory":
//
//    onAttach(Context context) – wywoływane, gdy fragment zostaje powiązany z aktywnością, do której należy. To dobry moment na wykonanie wstępnych ustawień.
//
//    onCreate(Bundle savedInstanceState) – wywoływane zaraz po dołączeniu fragmentu do aktywności. W tej metodzie można inicjalizować zmienne czy pobierać dane, które będą potrzebne dla fragmentu.
//
//    onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) – wywoływane przy tworzeniu widoku fragmentu. Tu generuje się układ fragmentu, używając obiektu inflater, który przekształca XML layout w drzewo widoków.
//
//3 "destruktory":
//
//    onPause() – wywoływane, gdy fragment traci aktywność, na przykład gdy przechodzi w tło. Tu można zapisać dane lub wstrzymać procesy, które nie muszą działać, gdy użytkownik nie widzi fragmentu.
//
//    onDestroyView() – wywoływane przed zniszczeniem widoku fragmentu, na przykład przy zmianie orientacji ekranu. Tu zwalniamy zasoby związane z widokiem (np. ustawienie binding na null).
//
//    onDetach() – wywoływane, gdy fragment zostaje odłączony od aktywności. Można w tym miejscu zwolnić wszystkie zasoby lub odłączyć obserwatorów, aby uniknąć wycieków pamięci.
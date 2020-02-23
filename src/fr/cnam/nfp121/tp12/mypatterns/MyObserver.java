package fr.cnam.nfp121.tp12.mypatterns;


public interface MyObserver {

    void update(Object observable);
    void destroy();

}

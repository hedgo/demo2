package com.example.demo2.domain.new_java.sealed;

public non-sealed class MP3File extends AudioFile {
    //gdy ta klasa dzidzczy po klasie sealed to sama musi byc: final(nikt nie dziedizczy), sealed(trzeba dopisac premit), non-sealed(kazdy moze dziedziczyc)
    public void mojaFunkcja() {
    }
}

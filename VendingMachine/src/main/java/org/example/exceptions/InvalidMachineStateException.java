package org.example.exceptions;

public class InvalidMachineStateException extends RuntimeException{
    public InvalidMachineStateException(){
        super("Invalid Machine State. Please come again later!");
    }
}

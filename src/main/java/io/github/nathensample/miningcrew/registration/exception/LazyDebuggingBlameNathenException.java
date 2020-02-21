package io.github.nathensample.miningcrew.registration.exception;

public class LazyDebuggingBlameNathenException extends RuntimeException
{
    public LazyDebuggingBlameNathenException()
    {
        super();
    }

    public LazyDebuggingBlameNathenException(Exception e)
    {
        super(e);
    }
}

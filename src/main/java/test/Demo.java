package test;

import java.util.*;
import java.util.stream.Stream;

public class Demo implements Swati
{
	public void close() throws java.io.IOException{
		System.out.println("sdfvs");
	}
}
interface Swati
{
	public void close() throws java.io.IOException;
}
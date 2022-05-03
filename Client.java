import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.io.*;
public class Client 
{
	public static void main(String args[]) throws UnknownHostException, IOException
	{
		int number,sonuc;
		boolean correctness=true;
		Scanner sc=new Scanner(System.in);
		Socket s = new Socket("localhost",7985);
		Scanner sc1= new Scanner (s.getInputStream());
		InputStreamReader inppp = new InputStreamReader(s.getInputStream());
		BufferedReader bf = new BufferedReader(inppp);
		String sayi = bf.readLine();
		while(correctness)
		{
			System.out.println("1-10 arasinda bir sayi giriniz.");
			number = sc.nextInt();
			
			PrintWriter pout = new PrintWriter(s.getOutputStream(),true);
			pout.println(number);
		
			InputStream in=s.getInputStream(); 
			BufferedReader bin = new BufferedReader(new InputStreamReader(in));
			sonuc=Integer.parseInt( bin.readLine());
			if(sonuc==1)
			{
				System.out.println("Dogru"); correctness= false; 
			} 
			else if(sonuc==2)
			{
				System.out.println("Yukselt!");
			}
			else if(sonuc==3)
			{
				System.out.println("Dusur!");
			} 
			if(sonuc==4)
			{
				System.out.println("Yanlis- Olmasi gereken rakam : "+ sayi ); correctness=false;
			}
		}
		s.close();
	}
}
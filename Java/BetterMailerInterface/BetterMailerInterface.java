// import java.util.*;
import java.util.function.Consumer;


class MailerRegular {

	public void from(String addr){System.out.println(addr);}
	public void to(String addr){System.out.println(addr);}
	public void title(String title){System.out.println(title);}
	public void body(String body){System.out.println(body);}
	public void send(){System.out.println("...sending...");}
}

class MailerV2 {
	public MailerV2 from(String addr){System.out.println(addr); return this;}
	public MailerV2 to(String addr){System.out.println(addr); return this;}
	public MailerV2 title(String title){System.out.println(title); return this;}
	public MailerV2 body(String body){System.out.println(body); return this;}
	public void send(){System.out.println("...sending...");}
}

class MailerV3 {

	private MailerV3(){}
	public MailerV3 from(String addr){System.out.println(addr); return this;}
	public MailerV3 to(String addr){System.out.println(addr); return this;}
	public MailerV3 title(String title){System.out.println(title); return this;}
	public MailerV3 body(String body){System.out.println(body); return this;}
	public static void send(Consumer<MailerV3> block){
		// The creator of the class can modify how send should manage mailer instance, 
		// ex: whether to make a new instance every time or use an object pool
		MailerV3 mailer = new MailerV3();

		block.accept(mailer);
		System.out.println("...sending...");
	}
}



class Main{

	private static final String FROM = "receiver@email.com";
	private static final String TO = "me@email.com";
	private static final String TITLE = "My Title";
	private static final String BODY = "My Body";

	public static void main(String[] args) {
		runMailerRegular();
		
		runMailerV2();

		runMailerV3();


	}

	//Bloated code / can't tell whether mailer
	// should be static or an instance
	private static void runMailerRegular() {
		System.out.println("Using MailerRegular");
		MailerRegular mailer = new MailerRegular();
		mailer.to(TO);
		mailer.from(FROM);
		mailer.title(TITLE);
		mailer.body(BODY);
		mailer.send();
		System.out.println("-------------------------------");
	}

	//Code has been cleaned up and is composable, 
	//but still can't tell whether to make mailer static or an instance
	private static void runMailerV2() {
		System.out.println("Using MailerV2");
		MailerV2 mailer = new MailerV2();
		mailer.to(TO)
			.from(FROM)
			.title(TITLE)
			.body(BODY)
			.send();

		System.out.println("-------------------------------");
	}


	//Code is clean and the programmer can use this class simply
	private static void runMailerV3() {
		System.out.println("Using MailerV3");
		MailerV3.send(mailer -> 
			mailer.to(TO)
			.from(FROM)
			.title(TITLE)
			.body(BODY));

		System.out.println("-------------------------------");
	}
}
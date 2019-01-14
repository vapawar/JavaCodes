package dbz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class EntityManagerDemo implements CommandLineRunner {

	@Autowired
	private PlayerService playerService;

	public static void main(String[] args) {
		SpringApplication.run(EntityManagerDemo.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Player p0 = new Player();
		p0.setId(123456890);
		p0.setName("vpawar");
		p0.setLocation("INDIA");

		Player p1 = new Player();
		p1.setId(12345600);
		p1.setName("Ronaldo");
		p1.setLocation("Europe");

		Player p2 = new Player();
		p2.setId(12345689);
		p2.setName("Messi");
		p2.setLocation("Europe");
		
		Player px = new Player();
		px.setId(12342842);
		px.setName("test");
		px.setLocation("data");

		try {
			playerService.savePlayerDetails(p0);
			playerService.savePlayerDetails(p1);
			playerService.savePlayerDetails(p2);
			playerService.savePlayerDetails(px);
		} catch (Exception ex) {
			System.out.println("1---------------------------------" + ex.getMessage());
		}
		try {
			Player p3 = playerService.getPlayerDetails(123456890);
			System.out.println("Get: " + p3.toString());
		} catch (Exception e) {
			System.out.println("2---------------------------------" + e.getMessage());
		}
		try {
			playerService.deletePlayerDetails(12345600);
			System.out.println("Deleted");
		} catch (Exception e) {
			System.out.println("3---------------------------------" + e.getMessage());
		}
		try {
			Player p4 = playerService.getPlayerDetails(12345600);
			if (p4 == null)
				System.out.println("Data not found");
			else
				System.out.println("p4: " + p4.toString());
		} catch (Exception e) {
			System.out.println("4................" + e.getMessage());
		}
		try {
			List<Player> data = playerService.getAllPlayerDetails();
			for (Player player : data) {
				System.out.println("PlayerDetails: " + player.toString());
			}
		} catch (Exception e) {
			System.out.println("5.........................." + e.getMessage());
		}
	}
}

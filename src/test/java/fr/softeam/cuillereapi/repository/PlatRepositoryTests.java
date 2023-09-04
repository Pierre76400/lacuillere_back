package fr.softeam.cuillereapi.repository;


import fr.softeam.cuillereapi.CuillereApiApplication;
import fr.softeam.cuillereapi.model.CategoriePlat;
import fr.softeam.cuillereapi.model.Plat;
import fr.softeam.cuillereapi.model.Restaurant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = CuillereApiApplication.class)
class PlatRepositoryTests {
	@Autowired
	private PlatRepository platRepository;

	@Autowired
	private CategoriePlatRepository categoriePlatRepository;
	@Autowired
	private RestaurantRepository restaurantRepository;

	//FIXME mettre l'annotation pour que cette méthode soit chargé à chaque fois
	void setup(){
		Restaurant laPuce=new Restaurant();
		laPuce.setAdresse("12 rue Ernest Renan");
		laPuce.setNom("La Puce");
		laPuce.setVegetarien("Non");
		restaurantRepository.save(laPuce);

		Restaurant leRipailleur=new Restaurant();
		leRipailleur.setAdresse("3 rue Emile Cordon");
		leRipailleur.setNom("Le Ripailleur");
		leRipailleur.setVegetarien("Non");
		restaurantRepository.save(leRipailleur);

		CategoriePlat cpPrincipal=new CategoriePlat();
		cpPrincipal.setCode("CP");
		cpPrincipal.setLibelle("Plat principal");
		categoriePlatRepository.save(cpPrincipal);

		CategoriePlat cpEntree=new CategoriePlat();
		cpEntree.setCode("EN");
		cpEntree.setLibelle("Entrée");
		categoriePlatRepository.save(cpEntree);

		Plat boeuf=new Plat();
		boeuf.setLibelle("Boeuf bourguignon");
		boeuf.setCategoriePlat(cpPrincipal);
		boeuf.setPrix(10.5d);
		boeuf.setRestaurant(laPuce);

		Plat steak=new Plat();
		steak.setLibelle("Steak frite");
		steak.setCategoriePlat(cpPrincipal);
		steak.setPrix(12.5d);
		steak.setRestaurant(laPuce);


		Plat oeuf=new Plat();
		oeuf.setLibelle("Oeuf mayo");
		oeuf.setCategoriePlat(cpEntree);
		oeuf.setPrix(2.5d);
		oeuf.setRestaurant(leRipailleur);

		platRepository.save(boeuf);
		platRepository.save(steak);
		platRepository.save(oeuf);

	}

	@Test
	void findAll() {
		setup();
		assertEquals(3,platRepository.findAll().size());
	}


	@Test
	void findByIdRestaurant() {
		setup();

		assertEquals(3,platRepository.findByRestaurantId(1l).size());
	}

}
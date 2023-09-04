package fr.softeam.cuillereapi;

import fr.softeam.cuillereapi.api.AvisDto;
import fr.softeam.cuillereapi.api.PlatDto;
import fr.softeam.cuillereapi.api.RestaurantDto;
import fr.softeam.cuillereapi.model.Avis;
import fr.softeam.cuillereapi.model.Plat;
import fr.softeam.cuillereapi.model.Restaurant;

public class ConvertUtil {


	public static  RestaurantDto restaurantEntityToDto(Restaurant r) {
		RestaurantDto dto=new RestaurantDto();
		dto.setId(r.getId());
		dto.setNom(r.getNom());
		dto.setAdresse(r.getAdresse());
		dto.setVegetarien(r.getVegetarien().equals("OUI")?true:false);

		return dto;
	}

	public static PlatDto platEntityToDto(Plat p) {
		PlatDto dto = new PlatDto();

		dto.setCategoriePlat(p.getCategoriePlat().getCode());
		dto.setLibelleCategoriePlat(p.getCategoriePlat().getLibelle());
		dto.setLibelle(p.getLibelle());
		dto.setPrix(p.getPrix());

		return dto;
	}

	public static AvisDto avisEntityToDto(Avis avis){
		AvisDto dto=new AvisDto();

		dto.setAuteur(avis.getAuteur());
		dto.setCommentaire(avis.getCommentaire());
		dto.setNote(avis.getNote());

		return dto;
	}
}

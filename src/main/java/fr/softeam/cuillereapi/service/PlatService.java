package fr.softeam.cuillereapi.service;

import fr.softeam.cuillereapi.ConvertUtil;
import fr.softeam.cuillereapi.api.PlatDto;
import fr.softeam.cuillereapi.api.RestaurantDetailDto;
import fr.softeam.cuillereapi.model.Restaurant;
import fr.softeam.cuillereapi.repository.PlatRepository;
import fr.softeam.cuillereapi.repository.RestaurantCustomRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatService {

	private PlatRepository repository;

	public PlatService(PlatRepository repository) {
		this.repository = repository;
	}

	public List<PlatDto> getPlats(Long idRestaurant) {
		return repository.findByRestaurantId(idRestaurant).stream().map(ConvertUtil::platEntityToDto).collect(Collectors.toList());
	}

	public PlatDto getPlat(Long idPlat) {
		return ConvertUtil.platEntityToDto(repository.findById(idPlat).get());
	}

	public List<PlatDto> getAll() {
		List<PlatDto> list = new ArrayList<>();
		repository.findAll().iterator().forEachRemaining(p->list.add(ConvertUtil.platEntityToDto(p)));
		return list;
	}
}

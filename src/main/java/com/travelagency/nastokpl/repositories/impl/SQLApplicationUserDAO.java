package com.travelagency.nastokpl.repositories.impl;

import com.travelagency.nastokpl.auth.ApplicationUserDAO;
import com.travelagency.nastokpl.models.ApplicationUserEntity;
import com.travelagency.nastokpl.models.ApplicationUserRole;
import com.travelagency.nastokpl.repositories.ApplicationUserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository("H2")
public class SQLApplicationUserDAO implements ApplicationUserDAO {
	private final ApplicationUserRepository applicationUserRepository;

	public SQLApplicationUserDAO(ApplicationUserRepository applicationUserRepository){
		this.applicationUserRepository = applicationUserRepository;
	}

	@Override
	public Optional<ApplicationUserEntity> selectApplicationUserByUsername(String username){
		return getApplicationUser().stream()
				.filter(applicationUser -> applicationUser.getUsername().equals(username))
				.findFirst();
	}

	// Pobieranie użytkowników, którzy są w bazie danych na starcie - Trzeba linia 33 returna oblec tak , że cały stream potrzebuje mapowania Application User na applicationIUSerEntity za find first this.mapModel.to Entity

	private List<ApplicationUserEntity> getApplicationUser(){
		return applicationUserRepository.findAll().stream()
				.map(this::mapEntityToModel)
				.collect(Collectors.toList());
	}

	private ApplicationUserEntity mapEntityToModel(ApplicationUserEntity entity){
		return new ApplicationUserEntity(
				entity.getUsername(),
				entity.getPassword(),
				entity.getAuthorities().stream()
						.map(authority -> new ApplicationUserRole().setRoleName(authority.getAuthority()))
						.collect(Collectors.toSet()),
				entity.isAccountNonExpired(),
				entity.isAccountNonLocked(),
				entity.isCredentialsNonExpired(),
				entity.isEnabled()
		);
	}
}

package com.travelagency.nastokpl.dto;

import com.travelagency.nastokpl.models.ApplicationUserEntity;
import com.travelagency.nastokpl.models.Authority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationUserEntityDTO {
	private String username;
	private String password;
	private Authority authority;

	public ApplicationUserEntity toEntity(){
		ApplicationUserEntity user = new ApplicationUserEntity();
		user.setUsername(this.username);
		if (this.username != null){
			user.setAuthorities(Authority.valueOf(this.authority.name()));
		}
		return user;
	}
	// code
}

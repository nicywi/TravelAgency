package com.travelagency.nastokpl.dto;

import com.travelagency.nastokpl.models.ApplicationUserEntity;
import com.travelagency.nastokpl.models.ApplicationUserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationUserEntityDTO {
	private String username;
	private String password;
	private ApplicationUserRole authority;

//	public ApplicationUserEntity toEntity(){
//		ApplicationUserEntity user = new ApplicationUserEntity();
//		user.setUsername(this.username);
//
//		if (this.username != null){
//			user.setAuthorities(ApplicationUserRole.valueOf(this.authority.name()));
//		}
//		return user;
//	}

}

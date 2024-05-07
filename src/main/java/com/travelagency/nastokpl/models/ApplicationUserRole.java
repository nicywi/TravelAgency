package com.travelagency.nastokpl.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "authorities")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public final class ApplicationUserRole extends EntityMappedSuperclass implements GrantedAuthority {
    public ApplicationUserRole setRoleName(String name) {
        this.setName(name);
        return this;
    }

    @Override
    public String getAuthority() {
        return this.getName();
    }
}

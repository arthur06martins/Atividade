package CrudPi.workDoorCrud.Services.Dto.Empresa.Auth;


import CrudPi.workDoorCrud.domain.empresa.Empresa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
public class EmpresaDetalhesDto implements UserDetails {
    private String nomeEmpresa;
    private String emailEmpresa;
    private String senhaEmpresa;



    public EmpresaDetalhesDto(Empresa empresa) {
        this.nomeEmpresa = nomeEmpresa;
        this.emailEmpresa = emailEmpresa;
        this.senhaEmpresa = senhaEmpresa;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return senhaEmpresa;
    }

    @Override
    public String getUsername() {
        return emailEmpresa;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
